package com.simpleprogrammer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class User {
	private Integer userid;
    private String username;
    private String password;
    private Boolean isLoggedIn;
   // @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
   // @OneToMany(mappedBy="product")
	private Set<Product> stockDailyRecords = new HashSet<Product>(
			0);
    
    public Set<Product> getStockDailyRecords() {
		return stockDailyRecords;
	}
	public void setStockDailyRecords(Set<Product> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}
	public Integer getUserid() {
		return userid;
	}
	
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}
	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
    
}
