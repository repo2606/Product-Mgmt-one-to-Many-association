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










 
