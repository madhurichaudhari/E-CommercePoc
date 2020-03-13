package com.hcl.ecommercepoc.responsemodels;


/*
 *  ResponseModel for getting response for User 
 */

/**
 * @author MadhuriC
 *  ResponseModel for getting response for User 
 *
 */
public class ApiResponseModel {
	
	private Boolean status;
	private String message;
	private Object data;
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
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
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return
	 */


	/**
	 * @param status
	 * @param message
	 * @param data
	 * @param statusCode
	 */
	public ApiResponseModel(Boolean status, String message, Object data, int statusCode) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.statusCode = statusCode;
	}
	
	
	
	
	
	

}
