package com.simpleprogrammer;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Product {
	private int productId;
	private String Name;
	private Date Date;
	private String Description;
	private int Quantity;
	private int Price;
//	@ManyToOne
	//@JoinColumn(name="userid")
    private int userid;
    
    public Product(){
    	
    }
	public Product(String Name, Date Date, String Description, int Quantity, int Price) {
		this.Name = Name;
		this.Date = Date;
		this.Description = Description;
		this.Quantity = Quantity;
		this.Price = Price;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
//	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "userid", nullable = false)
	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}*/
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

}
