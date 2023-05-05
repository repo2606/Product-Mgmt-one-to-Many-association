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
			fetch = FetchType.LAZY) // e LAZYager//
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


/*   
 * 
 * Theory
 * 
 * ManyCustomer mapped to single product
 * customer -Many  -owning side
 * 
 * Products - one _ Inverse side
 * 
 * owning side (Customer) should have -Join columns specified ie foreign key which connects to product table
 * 
 * Inverse side(products)- should have mappedby (which includes the field that has annotated with JoinColumn
 * otherwise mappedBy should contain field of owning class(Customer) which has foreign key "product_id "that connects the 
 * product table
 * 
 * Cascade - whatever changes applied to parent associated child will undergo those changes
 * REMOVE: when parent (product) is removed , its child(employees associated with product is also removed)
 * PERSIST:when parent(product) is saved in DB associated employees will also saved
 * REFRESH:when parent(product) is REFRESHED in DB associated employees will also refreshed
 * MERGE: when parent(eg productA is merged with other productsB),  then associated child of productA is also merged with productB.
 * DETACH: detach list of customers from its parent (product)
 * 
 * Avoid using ALL- because it includes all the above , in this project we dont want ot have REMOVE, ie when parent is deleted, its associated child 
 * should not be deleted.
 * 
 * LAZY:  Recommended- if parent is quered in DB its associated child is not loaded from DB, only parent is loaded from DB
 * EAGER: performance wise  it is down , if parent is queried in DB , its associated child is also loaded along with parent
 * 
 * Its recommenended to use cascade in Child side or (owning class) because many cutsomer are asociated with one product, if a product
 * is deleted then child has to react based upon the cascading rules.
 * */
