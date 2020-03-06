package com.hcl.ecommercepoc.responsemodels;


/*
 *  ResponseModel for getting response for User 
 */

/**
 * @author MadhuriC
 *  ResponseModel for getting response for User 
 *
 */
public class InventoryModel {
	
	
	
	
	
	//{"data":{"id":17,"productID":"202","quantity":2},"message":"success","status":true,"statusCode":200}

	
	
	
	
	
	private Boolean status;
	private String message;
	private QuantityModel data;
	public QuantityModel getQuantityModel() {
		return data;
	}

	public void setQuantityModel(QuantityModel data) {
		this.data = data;
	}

	private int statusCode;

	/**
	 * @return
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	

	/**
	 * @return
	 */
	

	/**
	 * @param status
	 * @param message
	 * @param data
	 * @param errorCode
	 */
	public InventoryModel(Boolean status, String message, QuantityModel data, int statusCode) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.statusCode = statusCode;
	}
	
	
	
	
	
	

}
