package com.niit.samazon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.samazon.dao.IProductDao;
import com.niit.samazon.model.Product;
 

 
@Service("productService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class ProductService implements IProductService {
	
	@Autowired
	private IProductDao iprodcutDao;
	
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=false)
	public void addProduct(Product productBean) {
		 iprodcutDao.addProduct(productBean);  
	}
	
	
	public List<Product> getAllProduct(){
		
		return iprodcutDao.getAllProduct();
	}


	public Product getProduct(int pid) {
		// TODO Auto-generated method stub
		return iprodcutDao.getProduct(pid);
	}


	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub
		iprodcutDao.deleteProduct(pid);
	}

}
