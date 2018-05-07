package net.web.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.web.shoppingbackend.dao.ProductDAO;
import net.web.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	/* This the dependency injection of sessionFactory created in HibernateConfig.java class*/
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<Product> list() {
		/*Using Query */
		String selectActiveCategory = "FROM Product";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		return query.getResultList();
	}

	@Override
	public Product get(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Product product) {
		try{
			//Add the Product to the DB table
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		try{
			product.setActive(false);
		sessionFactory.getCurrentSession().update(product);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveCategory = "FROM Product WHERE active = :activeParam";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("activeParam", true);
		try{
		return query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
			return query.getResultList();
		}
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveCategory = "FROM Product WHERE active = :activeParam AND categoryId = :categoryParam";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("activeParam", true);
		query.setParameter("categoryParam", categoryId);
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

}
