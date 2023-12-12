package com.controller;

import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.ProductDao;
import com.model.Product;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home( Model model) {
		List<Product> products = productDao.getProducts();
		model.addAttribute("products",products );
		
		return "index";
	}
	
	@RequestMapping("/addproducts")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add product");
		return "addProductForm";
	}
	
	@RequestMapping(path = "/handle-form",method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request) {
		this.productDao.createProduct(product);
		System.out.println(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/delete/{pid}")
	public RedirectView deleteProduct(@PathVariable("pid") int pid, HttpServletRequest request) {
		this.productDao.deleteproduct(pid);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	@RequestMapping("/update/{pid}")
	public String updateHandler(@PathVariable("pid") int pid,Model model) {
		Product product = this.productDao.getProduct(pid);
		model.addAttribute("p", product);
		return "updateform";
	}
	


}
