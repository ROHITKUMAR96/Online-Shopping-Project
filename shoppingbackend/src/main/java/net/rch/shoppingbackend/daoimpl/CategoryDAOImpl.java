package net.rch.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.rch.shoppingbackend.dao.CategoryDAO;
import net.rch.shoppingbackend.dto.Category;

@Repository("categoryDAO")
//@Transactional(readOnly = true, noRollbackFor = Exception.class)
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * // Static list of category for testing purpose only
	 * 
	 * private static List<Category> categories = new ArrayList<>();
	 * 
	 * // Use static block because of as soon as CategoryDAOImpl class has
	 * created // and below categories items will be initialise.
	 * 
	 * static { Category category = new Category();
	 * 
	 * // Adding first category category.setId(1); category.setName("Laptop");
	 * category.setDescription("HP is one of the good product in laptop");
	 * category.setImageURL("HP_Laptop.png");
	 * 
	 * categories.add(category);
	 * 
	 * category = new Category();
	 * 
	 * // Adding second category category.setId(2); category.setName("Mobile");
	 * category.setDescription("Moto  rola is the good product in Mobile");
	 * category.setImageURL("M_Mobile.png");
	 * 
	 * categories.add(category);
	 * 
	 * category = new Category();
	 * 
	 * // Adding third category category.setId(3); category.setName("Book");
	 * category.setDescription("Gita is the good devotional book in books");
	 * category.setImageURL("Gita.png");
	 * 
	 * categories.add(category);
	 * 
	 * }
	 */

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		query.setParameter("active", 1);

		return query.getResultList();
		// return categories;
	}

	/* Getting single category based on id */

	@Override
	public Category get(int id) {

		/*
		 * // Enhanced ForEach loop for (Category category : categories) { if
		 * (category.getId() == id) return category; }
		 */

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	// Below method should run within a transaction context
	@Override
	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	// Updating a single category
	@Override
	public boolean update(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(0);

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
