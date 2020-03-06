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

	private Boolean status;
	private String message;
	private QuantityModel data;
	private int statusCode;
	
	
	/*
	 * { "data": { "id": 17, "productID": "202", "quantity": 2 }, "message":
	 * "success", "status": true, "statusCode": 200
	 */
	
	
	
	
	
	public QuantityModel getQuantityModel() {
		return data;
	}

	public void setQuantityModel(QuantityModel data) {
		this.data = data;
	}

	

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


}
