package com.rt.ecps.util;

import java.util.List;

/**
 * 分页类
 * @author java
 *
 */
public class Page {
	
	/**
	 * 当前页码  （已知）
	 */
	private Integer pageNo = 1;
	
	/**
	 * 每页记录数（已知）
	 */
	private Integer pageSize = 5;
	
	/**
	 * 指定的查询条件下的总记录数
	 */
	private Integer totalCount = 0;
	
	/**
	 * 指定的查询条件下的总页数
	 */
	private Integer totalPage = 1;
	
	/**
	 * 查询的开始行号
	 */
	private Integer startNum = 0;
	
	/**
	 * 查询的结束行号
	 */
	private Integer endNum = 0;
	
	/**
	 * 查询的结果集
	 */
	private List<?> list;
	
	
	
	
	private String userId;
	private String roleId;
	private String schoolId;
	
	private String loginName;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * totalCount		pageSize 	 totalPage
	 *     0				10			1
	 * 	   100				10			10
	 * 		92				10			10	
	 * @return
	 */
	public Integer getTotalPage() {
		totalPage = totalCount/pageSize;
		if(totalCount == 0 || totalCount%pageSize != 0){
			totalPage++;
		}
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getStartNum() {
		return (pageNo - 1) * pageSize;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getEndNum() {
		return pageNo * pageSize + 1;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
	
	
	
	

}
