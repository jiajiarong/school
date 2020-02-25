package com.rt.ecps.dao;

import java.util.List;
import java.util.Map;

import com.rt.ecps.model.User;
import com.rt.ecps.util.Page;

public interface UserDao {
	
	
	public List<User> getUserList(Page page);
	public Integer getUserAllCount(Map<String,String> map);
	public void saveUser(User user);
	public User getUserById(String userId);
	public void editSaveUser(User user);
	public void deleteUser(String userId);
	
	public void saveUserToSchool(Map<String,String> map);
	public void deleteSchoolUserByUserId(String userId);
	
	public void saveUserToRole(Map<String,String> map);
	public void deleteUserToRoleByUserId(String userId);
	public User getUserByLogin(Map<String,String> map);
}
