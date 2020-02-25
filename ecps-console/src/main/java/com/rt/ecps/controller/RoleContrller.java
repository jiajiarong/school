package com.rt.ecps.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.ecps.model.Role;
import com.rt.ecps.model.School;
import com.rt.ecps.model.User;
import com.rt.ecps.service.RoleService;
import com.rt.ecps.service.SchoolService;
import com.rt.ecps.util.DateUtil;
import com.rt.ecps.util.Page;

@Controller
@RequestMapping("/role")
public class RoleContrller {

	@Autowired
	private SchoolService schoolService;
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/listRole.do")
	public String toList(Model model,Page page,HttpSession session) {
User userA=(User) session.getAttribute("user");
		
		String userId=userA.getUserId();
		String loginName=userA.getLoginName();
		
		if(page.getPageNo()==null||page.getPageNo()<=1){
			page=new Page();
			Map<String, String> map=new HashMap<String, String>();
			map.put("loginName", loginName);
			map.put("userId", userId);
			Integer allCount = roleService.getRoleAllCount(map);
			page.setTotalCount(allCount);
		}
		
		page.setUserId(userId);
		page.setLoginName(loginName);
		List<Role> roleList = roleService.getRoleList(page);
		model.addAttribute("roleList", roleList);
		model.addAttribute("page", page);
		return  "role/list";
	}
	
	
	@RequestMapping("/addRole.do")
	public String addRole(Model model) {
		List<School> schoolListAll = schoolService.getSchoolListAll();
		model.addAttribute("schoolListAll", schoolListAll);
		return  "role/create";
	}
	
	
	@RequestMapping("/saveRole.do")
	public String saveRole(Role role,String schoolId,HttpSession session) {
		
		DateUtil dateUtil=new DateUtil();
		Date date=new Date(); 
		String creatDate = dateUtil.dateToString(date);
		String updateDate="";
		String roleId=dateUtil.getUserId();
		role.setCreateTime(creatDate);
		role.setUpdateTime(updateDate);
		role.setRoleId(roleId);
		roleService.saveRole(role);
		String[] split=null;
		if(schoolId.length()>15){
			 split = schoolId.split(",");
			 for (int i=0;i<split.length;i++) {
					Map<String, String> map=new HashMap<String, String>();
					map.put("schoolId", split[i]);
					map.put("roleId", roleId);
					roleService.saveRoleToSchool(map);
				}
			 
		}else{
			Map<String, String> map=new HashMap<String, String>();
			map.put("schoolId", schoolId);
			map.put("roleId", roleId);
			roleService.saveRoleToSchool(map);
		}
		
		
		
		return  "redirect:listRole.do";
	}
	
	@RequestMapping("/editRole.do")
	public String editRole(Model model,String roleId) {
		Role roleOne = roleService.getRoleById(roleId);
		List<School> schoolListAll = schoolService.getSchoolListAll();
		List<School> schoolListAllByRoleId = schoolService.getSchoolListAllByRoleId(roleId);
		
		
		model.addAttribute("schoolListAll", schoolListAll);
		model.addAttribute("schoolListById", schoolListAllByRoleId);
		model.addAttribute("roleOne",roleOne);
		return  "role/edit";
	}
	
	
	@RequestMapping("/editSaveRole.do")
	public String editSaveRole(Role role,String schoolId) {
		
		DateUtil dateUtil=new DateUtil();
		Date date=new Date(); 
		String updateDate = dateUtil.dateToString(date);
		
		role.setUpdateTime(updateDate);
		roleService.editSaveRole(role);
		String roleId=role.getRoleId();
		String[] split=null;
		if(schoolId==null||schoolId==""){
			
		}else{
			roleService.deleteSchoolRoleByRoleId(roleId);
			if(schoolId.length()>15){
				 split = schoolId.split(",");
				 for (int i=0;i<split.length;i++) {
						Map<String, String> map=new HashMap<String, String>();
						map.put("schoolId", split[i]);
						map.put("roleId", roleId);
						roleService.saveRoleToSchool(map);
					}
				 
			}else{
				Map<String, String> map=new HashMap<String, String>();
				map.put("schoolId", schoolId);
				map.put("roleId", roleId);
				roleService.saveRoleToSchool(map);
			}
		}
		
		return  "redirect:listRole.do";
	}
	
	
	@RequestMapping("/deleteRole.do")
	public void deleteRole(String roleId, PrintWriter out) {
		String result = "yes";
		roleService.deleteRole(roleId);
		
		out.print(result);
	}
}
