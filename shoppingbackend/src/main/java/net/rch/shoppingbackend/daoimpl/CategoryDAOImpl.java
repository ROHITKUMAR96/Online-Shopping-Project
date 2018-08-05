package net.rch.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.rch.shoppingbackend.dao.CategoryDAO;
import net.rch.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	// Static list of category for testing purpose only

	private static List<Category> categories = new ArrayList<>();

	//Use static block because of as soon as CategoryDAOImpl class has created and below categories items will be initialise.
	
	static {
		Category category = new Category();

		// Adding first category
		category.setId(1);
		category.setName("Laptop");
		category.setDescription("HP is one of the good product in laptop");
		category.setImageURL("HP_Laptop.png");

		categories.add(category);

		category = new Category();

		// Adding second category
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Moto  rola is the good product in Mobile");
		category.setImageURL("M_Mobile.png");

		categories.add(category);

		category = new Category();

		// Adding third category
		category.setId(3);
		category.setName("Book");
		category.setDescription("Gita is the good devotional book in books");
		category.setImageURL("Gita.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		
		return categories;
	}

	@Override
	public Category get(int id) {
		
		//Enhanced ForEach loop
		for(Category category : categories){
			if(category.getId() == id) return category;
		}
		
		return null;
	}

}
