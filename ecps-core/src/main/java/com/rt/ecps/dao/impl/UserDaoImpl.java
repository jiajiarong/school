package com.rt.ecps.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.rt.ecps.dao.UserDao;
import com.rt.ecps.model.User;
import com.rt.ecps.util.Page;
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	private String ns="com.rt.ecps.mapper.UserMapper.";
	
	public List<User> getUserList(Page page) {
		List<User> UserList = this.getSqlSession().selectList(ns+"selectUserListAll",page);
		
		
		return UserList;
	}

	public void saveUser(User user) {
		this.getSqlSession().insert(ns+"insert",user);
		
	}

	public User getUserById(String userId) {
		
		return this.getSqlSession().selectOne(ns+"selectByPrimaryKey",userId);
	}

	public void editSaveUser(User user) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert(ns+"updateByPrimaryKeySelective",user);
	}

	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete(ns+"deleteByPrimaryKey",userId);
	}

	public Integer getUserAllCount(Map<String,String> map) {
		// TODO Auto-generated method stubselectUserAllCount
		return this.getSqlSession().selectOne(ns+"selectUserAllCount",map);
	}

	public void saveUserToSchool(Map<String, String> map) {
		this.getSqlSession().insert(ns+"insertUserToSchool",map);
	}

	public void deleteSchoolUserByUserId(String userId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete(ns+"deleteSchoolUserByUserId",userId);
	}

	public void saveUserToRole(Map<String, String> map) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert(ns+"insertUserToRole",map);
	}

	public void deleteUserToRoleByUserId(String userId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete(ns+"deleteUserToRoleByUserId",userId);
	}

	public User getUserByLogin(Map<String, String> map) {
		// TODO Auto-generated method stub
		 return this.getSqlSession().selectOne(ns+"getUserByLogin",map);
	}

}
