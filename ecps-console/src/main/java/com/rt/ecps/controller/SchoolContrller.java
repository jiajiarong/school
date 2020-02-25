package com.rt.ecps.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.ecps.model.School;
import com.rt.ecps.model.User;
import com.rt.ecps.service.SchoolService;
import com.rt.ecps.util.DateUtil;
import com.rt.ecps.util.Page;

@Controller
@RequestMapping("/school")
public class SchoolContrller {
	@Autowired
	private SchoolService schoolService;

	@RequestMapping("/listSchool.do")
	public String toList(Model model,Page page) {
		if(page.getPageNo()==null||page.getPageNo()<=1){
			page=new Page();
			Integer allCount = schoolService.getSchoolAllCount();
			page.setTotalCount(allCount);
		}
		
		
		List<School> schoolList = schoolService.getSchoolList(page);
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("page", page);
		return  "school/list";
	}
	
	
	@RequestMapping("/addSchool.do")
	public String addSchool() {
		
		return  "school/create";
	}
	
	
	@RequestMapping("/saveSchool.do")
	public String saveSchool(School school,HttpSession session) {
		
		DateUtil dateUtil=new DateUtil();
		Date date=new Date(); 
		String creatDate = dateUtil.dateToString(date);
		String updateDate="";
		String schoolId=dateUtil.getUserId();
		school.setCreateTime(creatDate);
		school.setUpdateTime(updateDate);
		school.setSchoolId(schoolId);
		schoolService.saveSchool(school);
	
		return  "redirect:listSchool.do";
	}
	
	@RequestMapping("/editSchool.do")
	public String editSchool(Model model,String schoolId) {
		School schoolOne = schoolService.getSchoolById(schoolId);
		
		model.addAttribute("schoolOne",schoolOne);
		return  "school/edit";
	}
	
	
	@RequestMapping("/editSaveSchool.do")
	public String editSaveSchool(School school) {
		
		DateUtil dateUtil=new DateUtil();
		Date date=new Date(); 
		String updateDate = dateUtil.dateToString(date);
		
		school.setUpdateTime(updateDate);
		schoolService.editSaveSchool(school);
		
	
		return  "redirect:listSchool.do";
	}
	
	
	@RequestMapping("/deleteSchool.do")
	public void deleteSchool(String schoolId, PrintWriter out) {
		String result = "yes";
		schoolService.deleteSchool(schoolId);
		
		out.print(result);
	}
}
