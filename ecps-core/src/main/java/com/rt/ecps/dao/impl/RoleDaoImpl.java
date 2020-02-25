package com.rt.ecps.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.rt.ecps.dao.RoleDao;
import com.rt.ecps.model.Role;
import com.rt.ecps.util.Page;
@Repository
public class RoleDaoImpl extends SqlSessionDaoSupport implements RoleDao {
	private String ns="com.rt.ecps.mapper.RoleMapper.";
	public List<Role> getRoleList(Page page) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(ns+"selectRoleListAll",page);
	}

	public Integer getRoleAllCount(Map<String,String> map) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(ns+"selectRoleAllCount",map);
	}

	public void saveRole(Role role) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert(ns+"insert",role);
	}

	public Role getRoleById(String roleId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(ns+"selectByPrimaryKey",roleId);
	}

	public void editSaveRole(Role role) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert(ns+"updateByPrimaryKeySelective",role);
	}

	public void deleteRole(String roleId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete(ns+"deleteByPrimaryKey",roleId);
	}

	public void saveRoleToSchool(Map<String, String> map) {
		// TODO Auto-generated method stub
		this.getSqlSession().insert(ns+"insertRoleToSchool",map);
	}

	public void deleteSchoolRoleByRoleId(String roleId) {
		// TODO Auto-generated method stub
		this.getSqlSession().delete(ns+"deleteSchoolRoleByRoleId",roleId);
	}

	public List<Role> getRoleListByUserId(String userId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(ns+"selectRoleListAllByUserId",userId);
	}

	public List<Role> getRoleListByOnlyUserId(String userId) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList(ns+"selectRoleListAllByOnlyUserId",userId);
	}

}
