package net.web.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.web.shoppingbackend.dao.CategoryDAO;
import net.web.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<Category>();
	
	static{
		
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Description for Television");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Description for Mobile");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Description for Laptop");
		category.setImageURL("CAT_3.png");
		
		categories.add(category);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		
		for(Category cat : categories){
			if(cat.getId() == id){
				return cat;
			}
		}
		return null;
	}

}
