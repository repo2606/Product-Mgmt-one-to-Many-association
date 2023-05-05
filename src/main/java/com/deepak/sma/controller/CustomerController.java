package com.deepak.sma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deepak.sma.dao.CustomerRepository;
import com.deepak.sma.entity.Customer;


  

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	
	@Autowired
	CustomerRepository custRepo;
	
	
	@GetMapping
	public String displayCustomers(Model model) {
		
		
		List<Customer> custom =  custRepo.findAll();
		
		model.addAttribute("customers", custom);
		
		return "customer/list-customer";
	}
	
	
	@GetMapping("/new")
	public String displayCustomerForm(Model model) {
		
		Customer aCustomer = new Customer();
		
		model.addAttribute("customer", aCustomer );
		
		return "customer/new-customer";
		
	}
	
	
	@PostMapping("/save")
	public String createCustomer(Customer customer, Model model) {
		
		custRepo.save(customer);
		
		return"redirect:/customers/new";
		
	}
	
	

}
