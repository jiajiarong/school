package com.rt.ecps.dao;

import java.util.List;
import java.util.Map;

import com.rt.ecps.model.Role;
import com.rt.ecps.util.Page;

public interface RoleDao {
	public List<Role> getRoleList(Page page);
	public Integer getRoleAllCount(Map<String,String> map);
	public void saveRole(Role role);
	public void saveRoleToSchool(Map<String,String> map);
	public Role getRoleById(String roleId); 
	public void editSaveRole(Role role);
	public void deleteRole(String roleId);
	public void deleteSchoolRoleByRoleId(String roleId);
	public List<Role> getRoleListByUserId(String userId);
	public List<Role> getRoleListByOnlyUserId(String userId);
}
