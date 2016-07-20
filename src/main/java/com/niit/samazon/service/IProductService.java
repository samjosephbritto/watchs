package com.niit.samazon.service;

import java.util.List;

import com.niit.samazon.model.Product;

public interface IProductService {
	public void addProduct(Product product);
	public List<Product> getAllProduct();
	public Product getProduct(int pid);
	public void deleteProduct(int pid);
}
