package net.rch.shoppingbackend.dao;

import java.util.List;

import net.rch.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	//Use list for connecting backend project to frontend projects
	List<Category> list();
	Category get(int id);
 
}
