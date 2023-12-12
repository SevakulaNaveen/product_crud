package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.model.Product;

@Repository
public class ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	// Create Product
	@Transactional
	public void createProduct(Product product) {
		this.hibernateTemplate.saveOrUpdate(product);
	}
	
	// get all products
	public List<Product> getProducts(){
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	@Transactional
	//delete single product
	public void deleteproduct(int pid) {
		Product p = this.hibernateTemplate.get(Product.class, pid);
		this.hibernateTemplate.delete(p);
	}
	
	// get single product
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);
	}
	

}
