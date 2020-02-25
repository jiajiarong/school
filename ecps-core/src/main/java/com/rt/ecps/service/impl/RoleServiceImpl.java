package com.rt.ecps.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.ecps.dao.RoleDao;
import com.rt.ecps.model.Role;
import com.rt.ecps.service.RoleService;
import com.rt.ecps.util.Page;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public List<Role> getRoleList(Page page) {
		// TODO Auto-generated method stub
		return roleDao.getRoleList(page);
	}

	public Integer getRoleAllCount(Map<String,String> map) {
		// TODO Auto-generated method stub
		return roleDao.getRoleAllCount(map);
	}

	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.saveRole(role);
	}

	public Role getRoleById(String roleId) {
		// TODO Auto-generated method stub
		return roleDao.getRoleById(roleId);
	}

	public void editSaveRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.editSaveRole(role);
	}

	public void deleteRole(String roleId) {
		// TODO Auto-generated method stub
		roleDao.deleteRole(roleId);
	}

	public void saveRoleToSchool(Map<String, String> map) {
		// TODO Auto-generated method stub
		roleDao.saveRoleToSchool(map);
	}

	public void deleteSchoolRoleByRoleId(String roleId) {
		// TODO Auto-generated method stub
		roleDao.deleteSchoolRoleByRoleId(roleId);
	}

	public List<Role> getRoleListByUserId(String userId) {
		// TODO Auto-generated method stub
		return roleDao.getRoleListByUserId(userId);
	}

	public List<Role> getRoleListByOnlyUserId(String userId) {
		// TODO Auto-generated method stub
		return roleDao.getRoleListByOnlyUserId(userId);
	}

}
