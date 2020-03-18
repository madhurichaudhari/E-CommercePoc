package com.hcl.ecommercepoc.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author MadhuriC
 *
 */
@Document(collection = "Catalog_tbl")
public class Catalog {

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
	

	private String createdDate;
	private String updatedDate;



	/**
	 * @param id
	 * @param productName
	 */
	public Catalog(String id, String productName) {
		this.productId=id;
		this.productName=productName;		
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
	public Catalog() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return  productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return productPrice
	 */
	public String getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 */
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return productCategoryId
	 */
	

	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	

}