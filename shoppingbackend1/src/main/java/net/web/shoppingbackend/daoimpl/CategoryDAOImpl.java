package net.web.shoppingbackend.daoimpl;

import java.util.List;

import javax.swing.plaf.SliderUI;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.web.shoppingbackend.dao.CategoryDAO;
import net.web.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	
	/* This the dependency injection of sessionFactory created in HibernateConfig.java class*/
	@Autowired
	private SessionFactory sessionFactory;
	/*private static List<Category> categories = new ArrayList<Category>();
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
	}*/
	
	@Override
	public List<Category> list() {
		/*Using criteria*/
		//return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
		
		/*Using Query */
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	//Getting Single category based on ID
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		
		/*for(Category cat : categories){
			if(cat.getId() == id){
				return cat;
			}
		}*/
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try{
			//Add the category to the DB table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(Category category) {
		try{
			category.setActive(false);
		sessionFactory.getCurrentSession().update(category);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean hardDelete(Category category) {
		try{
		sessionFactory.getCurrentSession().delete(category);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
}
