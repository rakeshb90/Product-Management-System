package com.example.rest1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest1.dao.ProductDao;
import com.example.rest1.entity.Product;
import com.example.rest1.service.ProductService;

@RestController
public class MyController {
	@Autowired
	ProductService productService;
	@GetMapping("/")
	public String home() {
		return "Welcome User";
	}
	@GetMapping(value="/products")
	public ResponseEntity< List<Product>> getAll(){
		List<Product> products=productService.getAllProduct();
		if(products.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	@PostMapping(value="/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
		try {
		productService.saveProduct(newProduct);
		return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/products")
	public ResponseEntity<String> updateProduct(@RequestBody Product prod) {
		Product product=productService.getProduct(prod.getId());
		if(product!=null){
		productService.updateProduct(prod);
		return new ResponseEntity("Product is updatated",HttpStatus.OK);
		}
		else{
			return new ResponseEntity("API not able to update",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id")int id) {
		try {
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product is deleted",HttpStatus.NO_CONTENT);
		}
		catch(Exception e) {
			return new ResponseEntity<>("API not able to delete",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
      
}
