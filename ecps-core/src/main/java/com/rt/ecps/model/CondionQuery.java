package com.rt.ecps.model;

public class CondionQuery {
	
	
	private Short auditStatus;
	
	private Short showStatus;
	
	private Long brandId;
	
	private String itemName;
	
	private Integer pageNo;
	
	private Integer startNum;
	
	private Integer endNum;

	public Short getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Short auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Short getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Short showStatus) {
		this.showStatus = showStatus;
	}

	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getEndNum() {
		return endNum;
	}

	public void setEndNum(Integer endNum) {
		this.endNum = endNum;
	}
}
