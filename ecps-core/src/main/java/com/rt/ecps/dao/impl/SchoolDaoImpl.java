package com.rt.ecps.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.rt.ecps.dao.SchoolDao;
import com.rt.ecps.model.School;
import com.rt.ecps.model.User;
import com.rt.ecps.util.Page;
@Repository
public class SchoolDaoImpl extends SqlSessionDaoSupport implements SchoolDao {
	private String ns="com.rt.ecps.mapper.SchoolMapper.";
	public List<School> getSchoolList(Page page) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(ns+"selectSchoolListAll",page);
	}
	public Integer getSchoolAllCount() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(ns+"selectSchoolAllCount");
	}
	public void saveSchool(School school) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert(ns+"insert",school);
	}
	public School getSchoolById(String schoolId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(ns+"selectByPrimaryKey",schoolId);
	}
	public void editSaveSchool(School school) {
		this.getSqlSession().insert(ns+"updateByPrimaryKeySelective",school);
		
	}
	public void deleteSchool(String schoolId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete(ns+"deleteByPrimaryKey",schoolId);
	}
	public List<School> getSchoolListAll() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(ns+"selectSchoolListAllToRole");
	}
	public List<School> getSchoolListAllByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(ns+"selectSchoolListAllByRoleId",roleId);
	}
	public List<School> getSchoolListAllByUserId(String UserId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(ns+"selectSchoolListAllByUserId",UserId);
	}
	
}
