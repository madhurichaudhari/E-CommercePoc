package com.hcl.ecommercepoc.entities;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author MadhuriC
 *
 */
@Document(collection = "Catalog_tbl")
public class CatalogEntity {

	@Id
	private String productId;
	@NotNull
	@Size(max = 140)
	private String productName;
	@NotNull()
	@Size(max = 140)
	private String productDescription;
	private String productPrice;
	//@NotBlank(message = "Quantity is mandatory")
	
	private Integer quantity;
	@NotNull
	@Size(max = 140)
	private String productCategoryId;

	private String createdDate;
	private String updatedDate;

	/*
	 * private ProductCategoryEntity productCategory;
	 * 
	 * public ProductCategoryEntity getProductCategoryEntity() { return
	 * productCategory; } public void setProductCategoryEntity(ProductCategoryEntity
	 * productCategoryEntity) { this.productCategory = productCategoryEntity; }
	 */

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	

}
