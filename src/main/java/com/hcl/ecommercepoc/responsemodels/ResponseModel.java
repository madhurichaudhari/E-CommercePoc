package com.hcl.ecommercepoc.responsemodels;


/*
 *  ResponseModel for getting response for User 
 */

/**
 * @author MadhuriC
 *  ResponseModel for getting response for User 
 *
 */
public class ResponseModel {
	
	private Boolean status;
	private String message;
	private Object data;
	private int errorCode;

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
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @param status
	 * @param message
	 * @param data
	 * @param errorCode
	 */
	public ResponseModel(Boolean status, String message, Object data, int errorCode) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.errorCode = errorCode;
	}
	
	
	
	
	
	

}
