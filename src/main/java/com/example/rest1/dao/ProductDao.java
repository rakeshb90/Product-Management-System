package com.example.rest1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rest1.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

}
