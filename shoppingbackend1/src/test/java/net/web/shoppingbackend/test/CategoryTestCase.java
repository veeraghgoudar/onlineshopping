package net.web.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.web.shoppingbackend.dao.CategoryDAO;
import net.web.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.web.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

/*	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Storage");
		category.setDescription("Description for Storage");
		category.setImageURL("CAT_3.png");
		assertEquals("Successfully inserted a new category into a table", true, categoryDAO.add(category));

	}

	@Test
	public void testGetCategory() {
		category = categoryDAO.get(2);
		assertEquals("Successfully got a single  category from a table", "Mobile", category.getName());
	}

	@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(2);
		System.out.println("OLD DESCRIPTION--------------" + category.getDescription());
		category.setDescription("Added new description for mobile take2");
		categoryDAO.update(category);
		category = categoryDAO.get(2);
		System.out.println("New DESCRIPTION--------------" + category.getDescription());
		assertEquals("Successfully updated a single  category from a table", "Added new description for mobile take2",
				category.getDescription());
	}

	@Test
	public void testDeleteCategory() {
		List<Category> categoryList = categoryDAO.list();

		for (Category category : categoryList) {
			if (category.getName() == "Storage") {
				System.out
				.println("Category Name--------------" + category.getName() + "  with id :" + category.getId());
				System.out.println("Is active Flag for ID :" + category.getId() + " is :" + category.isActive());
				categoryDAO.delete(category);
				assertEquals("Successfully DELETED a single  category from a table", false, category.isActive());
			}
		}
	}*/

	@Test
	public void testHardDeleteCategory() {
		List<Category> categoryList = categoryDAO.list();
		System.out.println("VEERAGH SIZE :"+categoryList.size());
		for (Category category : categoryList) {
			if (category.getName().equals("Storage")) {
				System.out.println("VEERAGH SIZE :"+category.getName());
				System.out
				.println("Category Name--------------" + category.getName() + "  with id :" + category.getId());
				System.out.println("OLD DESCRIPTION--------------" + category.getDescription());
				assertEquals("Successfully DELETED a single  category from a table", true,
						categoryDAO.hardDelete(category));
			}
		}
	}
	

/*	@Test
	public void testListCategory() {
		List<Category> categoryList = categoryDAO.list();
		assertEquals("Successfully DELETED a single  category from a table", 2,
				categoryList.size());
		
	}*/
}
