package com.ilp.entity;
import java.util.*;
public abstract class Product {

	private String productCode;
	private String productName;
	private ArrayList<Services> serviceList=new ArrayList<Services>();
	
	

	public Product(String productCode, String productName, ArrayList<Services> productList) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.serviceList = productList;
	}

	public String getProductCode() {
		return productCode;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ArrayList<Services> getProductList() {
		return serviceList;
	}
	public void setProductList(ArrayList<Services> productList) {
		this.serviceList = productList;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productList=" +serviceList
				+ ", getProductCode()=" + getProductCode() + ", getProductName()=" + getProductName()
				+ ", getProductList()=" + getProductList() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
