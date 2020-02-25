package com.rt.ecps.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.ecps.model.Role;
import com.rt.ecps.model.School;
import com.rt.ecps.model.User;
import com.rt.ecps.service.RoleService;
import com.rt.ecps.service.SchoolService;
import com.rt.ecps.service.UserService;
import com.rt.ecps.util.DateUtil;
import com.rt.ecps.util.Page;



@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private RoleService roleService;
	@RequestMapping("/toIndex.do")
	public String toIndex(HttpSession session) {
		return  "user/index";
	}
	
	
	
	@RequestMapping("/userlist.do")
	public String toUserList(Model model,Page page,HttpSession session) {
		
		User userA=(User) session.getAttribute("user");
		
		String userId=userA.getUserId();
		String loginName=userA.getLoginName();
		if(page.getPageNo()==null||page.getPageNo()<=1){
			page=new Page();
			Map<String, String> map=new HashMap<String, String>();
			map.put("loginName", loginName);
			map.put("userId", userId);
			Integer userAllCount = userService.getUserAllCount(map);
			page.setTotalCount(userAllCount);
		}
		
		page.setUserId(userId);
		page.setLoginName(loginName);
		List<User> userList = userService.getUserList(page);
		model.addAttribute("userList", userList);
		model.addAttribute("page", page);
		return  "user/list";
	}
	
	@RequestMapping("/addUser.do")
	public String addUser(Model model,HttpSession session) {
		User user = (User) session.getAttribute("user");
		String userId=user.getUserId();
		
		List<School> schoolListAllByUserId = schoolService.getSchoolListAllByUserId(userId);
		List<Role> roleListByUserId = roleService.getRoleListByUserId(userId);
		
		model.addAttribute("schoolListAllByUserId", schoolListAllByUserId);
		model.addAttribute("roleListByUserId", roleListByUserId);
		
		
		return  "user/create";
	}
	
	
	
	@RequestMapping("/saveUser.do")
	public String saveUser(User user,String schoolId,String roleId,HttpSession session) {
		Md5PasswordEncoder md5=new Md5PasswordEncoder();
		String encodePassword = md5.encodePassword(user.getPassword(), null);
		user.setPassword(encodePassword);
		DateUtil dateUtil=new DateUtil();
		Date date=new Date(); 
		String creatDate = dateUtil.dateToString(date);
		String updateDate="";
		String userId=dateUtil.getUserId();
		user.setCreateTime(creatDate);
		user.setUpdateTime(updateDate);
		user.setUserId(userId);
		String[] split=null;
		String[] split2=null;
		if(schoolId.length()>15){
			 split = schoolId.split(",");
			 for (int i=0;i<split.length;i++) {
					Map<String, String> map=new HashMap<String, String>();
					map.put("schoolId", split[i]);
					map.put("userId", userId);
					userService.saveUserToSchool(map);
				}
			 
		}else{
			Map<String, String> map=new HashMap<String, String>();
			map.put("schoolId", schoolId);
			map.put("userId", userId);
			userService.saveUserToSchool(map);
		}
		
		if(roleId.length()>15){
			 split2 = roleId.split(",");
			 for (int i=0;i<split2.length;i++) {
					Map<String, String> map=new HashMap<String, String>();
					map.put("roleId", split2[i]);
					map.put("userId", userId);
					userService.saveUserToRole(map);
				}
			 
		}else{
			Map<String, String> map=new HashMap<String, String>();
			map.put("roleId", roleId);
			map.put("userId", userId);
			userService.saveUserToRole(map);
		}
		userService.saveUser(user);
	
		return  "redirect:userlist.do";
	}
	
	
	@RequestMapping("/editUser.do")
	public String editUser(Model model,String userId,HttpSession session) {
		User user = userService.getUserById(userId);
		List<School> schoolListAll = schoolService.getSchoolListAll();
		
		List<School> schoolListAllByUserId = schoolService.getSchoolListAllByUserId(userId);
		List<Role> roleListByUserId = roleService.getRoleListByUserId(userId);
		
		List<Role> roleListByOnlyUserId = roleService.getRoleListByOnlyUserId(userId);
		model.addAttribute("roleListByOnlyUserId", roleListByOnlyUserId);
		model.addAttribute("roleListByUserId", roleListByUserId);
		model.addAttribute("schoolListAllByUserId", schoolListAllByUserId);
		model.addAttribute("schoolListAll", schoolListAll);
		model.addAttribute("userOne",user);
		return  "user/edit";
	}
	
	@RequestMapping("/editSaveUser.do")
	public String editSaveUser(User user,String schoolId,String roleId) {
		
		DateUtil dateUtil=new DateUtil();
		Date date=new Date(); 
		String updateDate = dateUtil.dateToString(date);
		
		user.setUpdateTime(updateDate);
		String userId=user.getUserId();
		String[] split=null;
		String[] split2=null;
		if(schoolId==null||schoolId==""){
			
		}else{
			userService.deleteSchoolUserByUserId(userId);
			if(schoolId.length()>15){
				 split = schoolId.split(",");
				 for (int i=0;i<split.length;i++) {
						Map<String, String> map=new HashMap<String, String>();
						map.put("schoolId", split[i]);
						map.put("userId", userId);
						userService.saveUserToSchool(map);
					}
				 
			}else{
				Map<String, String> map=new HashMap<String, String>();
				map.put("schoolId", schoolId);
				map.put("userId", userId);
				userService.saveUserToSchool(map);
			}
		
		}
		
		if(roleId==null||roleId==""){
			
		}else{
			userService.deleteUserToRoleByUserId(userId);
			if(roleId.length()>15){
				 split2 = roleId.split(",");
				 for (int i=0;i<split2.length;i++) {
						Map<String, String> map=new HashMap<String, String>();
						map.put("roleId", split2[i]);
						map.put("userId", userId);
						userService.saveUserToRole(map);
					}
				 
			}else{
				Map<String, String> map=new HashMap<String, String>();
				map.put("roleId", roleId);
				map.put("userId", userId);
				userService.saveUserToRole(map);
			}
		}
		userService.editSaveUser(user);
	
		return  "redirect:userlist.do";
	}
	
	
	@RequestMapping("/deleteUser.do")
	public void vaidBrandName(String userId, PrintWriter out) {
		String result = "yes";
		userService.deleteUser(userId);
		
		out.print(result);
	}
	
	
	
}
