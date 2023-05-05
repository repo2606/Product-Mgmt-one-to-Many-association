package com.deepak.sma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.deepak.sma.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer , Long>{
	
	
	 @Override
	 List<Customer> findAll();

}
