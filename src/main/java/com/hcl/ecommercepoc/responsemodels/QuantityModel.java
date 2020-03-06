package com.hcl.ecommercepoc.responsemodels;


/*
 *  ResponseModel for getting response for User 
 */

/**
 * @author MadhuriC
 *  ResponseModel for getting response for User 
 *
 */
public class QuantityModel {
	
	
	private int id;
	private int quantity;
	private String productID;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public String getProductID() {
		return productID;
	}



	public void setProductID(String productID) {
		this.productID = productID;
	}

}
