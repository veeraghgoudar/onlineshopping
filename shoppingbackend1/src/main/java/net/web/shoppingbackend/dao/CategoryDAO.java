package net.web.shoppingbackend.dao;

import java.util.List;

import net.web.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
	
}
