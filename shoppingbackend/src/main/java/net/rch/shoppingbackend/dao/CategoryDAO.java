package net.rch.shoppingbackend.dao;

import java.util.List;

import net.rch.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	//Use list for connecting backend project to frontend project
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
 
}
