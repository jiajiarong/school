package com.rt.ecps.service;

import java.util.List;

import com.rt.ecps.model.School;
import com.rt.ecps.util.Page;

public interface SchoolService {
	public List<School> getSchoolList(Page page);
	public List<School> getSchoolListAll();
	public Integer getSchoolAllCount();
	public void saveSchool(School school);
	public School getSchoolById(String schoolId);
	public void editSaveSchool(School school);
	public void deleteSchool(String schoolId);
	public List<School> getSchoolListAllByRoleId(String roleId);
	
	public List<School> getSchoolListAllByUserId(String UserId);
}
