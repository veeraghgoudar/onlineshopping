package net.web.onlineshopping1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.web.onlineshopping1.exception.ProductNotFoundException;
import net.web.shoppingbackend.dao.CategoryDAO;
import net.web.shoppingbackend.dao.ProductDAO;
import net.web.shoppingbackend.dto.Category;
import net.web.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO	productDAO;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Online shopping");
		//Passing the list of categories
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - Debug");
		
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	/*Method to load all the products and based on category*/
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAllProducts(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All Products");
		//Passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	/*Methods to load all the products based on category id*/
	@RequestMapping(value = {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id")int id){
		
		Category category = null;
		
		category = categoryDAO.get(id);
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title",category.getName());
		//Passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
	
	/* Viewing a single product */
	@RequestMapping(value = {"/show/{productId}/product"})
	public ModelAndView showSingleProduct(@PathVariable("productId")int productId) throws ProductNotFoundException{
		
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(productId);
		
		if(product == null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews()+1);
		
		//Updating the view count
		productDAO.update(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		
		return mv;
	}
	
/*	@RequestMapping(value = {"/test"})
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting){
		if(greeting == null){
			greeting = "user";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome "+greeting );
		return mv;
	}
	
	@RequestMapping(value = {"/test/{greeting}"})
	public ModelAndView test(@PathVariable("greeting")String greeting){
		if(greeting == null){
			greeting = "user";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome "+greeting );
		return mv;
	}*/
	

}
