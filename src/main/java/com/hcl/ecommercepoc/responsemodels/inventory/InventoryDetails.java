package com.hcl.ecommercepoc.responsemodels.inventory;

public class InventoryDetails {
	
	
	@Override
	public String toString() {
		return "InventoryDetails [id=" + id + ", productID=" + productID + ", quantity=" + quantity + "]";
	}

	private Integer id;

	private String productID;
	
	private Integer quantity;

	public Integer getId() {
	return id;
	}

	public void setId(Integer id) {
	this.id = id;
	}

	public String getProductID() {
	return productID;
	}

	public void setProductID(String productID) {
	this.productID = productID;
	}

	public Integer getQuantity() {
	return quantity;
	}

	public void setQuantity(Integer quantity) {
	this.quantity = quantity;
	}

}
