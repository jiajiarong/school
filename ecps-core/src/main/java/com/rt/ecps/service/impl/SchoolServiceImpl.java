package com.rt.ecps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.ecps.dao.SchoolDao;
import com.rt.ecps.model.School;
import com.rt.ecps.service.SchoolService;
import com.rt.ecps.util.Page;
@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolDao schoolDao;

	public List<School> getSchoolList(Page page) {
		// TODO Auto-generated method stub
		return schoolDao.getSchoolList(page);
	}

	public Integer getSchoolAllCount() {
		// TODO Auto-generated method stub
		return schoolDao.getSchoolAllCount();
	}

	public void saveSchool(School school) {
		// TODO Auto-generated method stub
		schoolDao.saveSchool(school);
	}

	public School getSchoolById(String schoolId) {
		// TODO Auto-generated method stub
		return schoolDao.getSchoolById(schoolId);
	}

	public void editSaveSchool(School school) {
		// TODO Auto-generated method stub
		schoolDao.editSaveSchool(school);
	}

	public void deleteSchool(String schoolId) {
		// TODO Auto-generated method stub
		schoolDao.deleteSchool(schoolId);
	}

	public List<School> getSchoolListAll() {
		// TODO Auto-generated method stub
		return schoolDao.getSchoolListAll();
	}

	public List<School> getSchoolListAllByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return schoolDao.getSchoolListAllByRoleId(roleId);
	}

	public List<School> getSchoolListAllByUserId(String UserId) {
		// TODO Auto-generated method stub
		return schoolDao.getSchoolListAllByUserId(UserId);
	}

}
