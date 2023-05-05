package com.deepak.sma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deepak.sma.dao.CustomerRepository;
import com.deepak.sma.dao.ProductRepository;
import com.deepak.sma.entity.Customer;
import com.deepak.sma.entity.Product;



@Controller
@RequestMapping("/products")
public class ProductController {
	
	
	@Autowired
	ProductRepository proRepo;
	
	@Autowired
	CustomerRepository custRepo;
	
	
	@GetMapping
	public String displayProduct(Model model) {
		
		List<Product> prod = proRepo.findAll();
		model.addAttribute("products",prod );
		
		return "products/list-products";
	}
	
	@GetMapping("/new")
	public String displayProductForm(Model model) {
		
	Product aProduct = new Product();
				
    model.addAttribute("product", aProduct);
    
    List<Customer> customerlist = custRepo.findAll();
    model.addAttribute("allCustomer",customerlist);
				
    return "products/new-product";
		 
		

	}
	
	@PostMapping("/save")
	public String createProduct(Product product , @RequestParam List<Long> customer, Model model) {
		
		proRepo.save(product);
		
		Iterable<Customer>  chosenCustomer = custRepo.findAllById(customer);
		
		for(Customer cust: chosenCustomer) {
			
			cust.setTheproducts(product);
			
			custRepo.save(cust);
		}
		
		
		// redirect is to prevent duplicate entry
		return"redirect:/products/new";
		
		
		
	}

}










 /*Theory:
  * 
  * Model: use to exchange  data between view and controller (bind data between java code and html code , Model is used)
  * h2- rutime, test db, default url: 
jdbc:h2:mem:testdb


theory: @PostMapping("/save")
  * 
  * 1.@RequestParam List<Long> customer,
  *  as we pass customerId as part of url request , 
  * Ids are numbers , depending upon no of customer we selected eg 3, there will be 3 customerid 
  *   so we use List<long> to hold no of  3 ids and 
  * we use "customer" as ref name (List<Long> customer) because query parameter also has same name
  * so now  List<Long> customer will holds no of ids that were passed
  * 
  * 		Iterable<Customer>  chosenCustomer = custRepo.findAllById(customer);// based upon ID customer objects is retrieved in DB
  * and those group of customer objects are iterated one by one
  * 
  * cust.setTheproducts(product); // for each customer object we set the products so that now association netween customer and product table is formed
  * 
  * 	custRepo.save(cust);// finally we save the customer which has product associated with it in database
  * */
 