package com.hcl.ecommercepoc.responsemodels.inventory;

import java.util.List;

public class AllInventoryModel {
	
	
	@Override
	public String toString() {
		return "AllInventoryModel [dataArray=" + dataArray + ", message=" + message + ", status=" + status
				+ ", statusCode=" + statusCode + "]";
	}

	private List<InventoryDetails> dataArray = null;

	private String message;

	private Boolean status;
	
	private Integer statusCode;

	public List<InventoryDetails> getDataArray() {
	return dataArray;
	}

	public void setDataArray(List<InventoryDetails> dataArray) {
	this.dataArray = dataArray;
	}

	public String getMessage() {
	return message;
	}

	public void setMessage(String message) {
	this.message = message;
	}

	public Boolean getStatus() {
	return status;
	}

	public void setStatus(Boolean status) {
	this.status = status;
	}

	public Integer getStatusCode() {
	return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
	}

}
