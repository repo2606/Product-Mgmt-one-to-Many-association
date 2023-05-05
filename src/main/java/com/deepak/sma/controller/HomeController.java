package com.deepak.sma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deepak.sma.dao.CustomerRepository;
import com.deepak.sma.dao.ProductRepository;
import com.deepak.sma.entity.Customer;
import com.deepak.sma.entity.Product;

@Controller
public class HomeController {
	
	@Autowired
	ProductRepository prodRepo;
	
	@Autowired
	CustomerRepository custRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		
		List<Product>  products =  prodRepo.findAll();
		
		model.addAttribute("productList",products);
		
	 List<Customer> customers = custRepo.findAll();
		
     model.addAttribute("customerList",customers);
		
		return"main/home";
		
		
		
	}
	
	

}
