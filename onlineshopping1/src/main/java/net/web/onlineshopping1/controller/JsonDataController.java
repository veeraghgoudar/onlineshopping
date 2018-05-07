package net.web.onlineshopping1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.web.shoppingbackend.dao.ProductDAO;
import net.web.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	// DI of ProductDAO
	@Autowired
	private ProductDAO productDAO;
	
	/*	
	 * Instead of returning Model and view here we have added Response body. 
	 * The response could be of any type like text or a json.
	 * In this case we json is returned as it gets some json convertors which are mentione on POM.xml file
	*/
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		try{
		return productDAO.listActiveProducts();
		}
		catch(Exception e){
			e.printStackTrace();
			return productDAO.listActiveProducts();
		}
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id)
	{
		return productDAO.listActiveProductsByCategory(id);
	}
	
	
	
	
}
