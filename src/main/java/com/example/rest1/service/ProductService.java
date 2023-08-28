package com.example.rest1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest1.dao.ProductDao;
import com.example.rest1.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductDao productDao;
	public List<Product> getAllProduct(){
		List<Product> products=new ArrayList<Product>();
		productDao.findAll().forEach(product->products.add(product));
		return products;
	}
	public Product getProduct(int id) {
		return productDao.getById(id);
	}
	public void saveProduct(Product prod) {
		productDao.save(prod);
	}
	public void updateProduct(Product prod) {
		productDao.saveAndFlush(prod);
	}
   public void deleteProduct(int id) {
	   productDao.deleteById(id);
   }
}
