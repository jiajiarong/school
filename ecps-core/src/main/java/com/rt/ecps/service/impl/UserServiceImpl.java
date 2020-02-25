package com.rt.ecps.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.ecps.dao.UserDao;
import com.rt.ecps.model.User;
import com.rt.ecps.service.UserService;
import com.rt.ecps.util.Page;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> getUserList(Page page) {
		List<User> userList = userDao.getUserList(page);
		return userList;
	}

	public void saveUser(User user) {
		userDao.saveUser(user);
		
	}

	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		return userDao.getUserById(userId);
	}

	public void editSaveUser(User user) {
		// TODO Auto-generated method stub
		userDao.editSaveUser(user);
	}

	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		userDao.deleteUser(userId);
	}

	public Integer getUserAllCount(Map<String,String> map) {
		// TODO Auto-generated method stub
		return userDao.getUserAllCount(map);
	}

	public void saveUserToSchool(Map<String, String> map) {
		// TODO Auto-generated method stub
		userDao.saveUserToSchool(map);
	}

	public void deleteSchoolUserByUserId(String userId) {
		// TODO Auto-generated method stub
		userDao.deleteSchoolUserByUserId(userId);
	}

	public void saveUserToRole(Map<String, String> map) {
		// TODO Auto-generated method stub
		userDao.saveUserToRole(map);
	}

	public void deleteUserToRoleByUserId(String userId) {
		// TODO Auto-generated method stub
		userDao.deleteUserToRoleByUserId(userId);
	}

	public User getUserByLogin(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userDao.getUserByLogin(map);
	}

}
