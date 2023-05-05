package com.deepak.sma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.deepak.sma.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
        
	    @Override
        List<Product> findAll();            


} 
