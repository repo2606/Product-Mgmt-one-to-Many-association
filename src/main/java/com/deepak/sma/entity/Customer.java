package com.deepak.sma.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long customerId;
	
	private String firstName;
	
	private String lastName;
	
	
	private String email;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.PERSIST},
			fetch = FetchType.LAZY) 
	@JoinColumn(name="product_id")    
	private Product theproducts;
	
	
	
	
	public Customer() {
		
		
	}

	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Product getTheproducts() {
		return theproducts;
	}

	public void setTheproducts(Product theproducts) {
		this.theproducts = theproducts;
	}
	
	
	

}


