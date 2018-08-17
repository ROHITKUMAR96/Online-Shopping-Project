package net.rch.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.rch.shoppingbackend.dao.CategoryDAO;
import net.rch.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.rch.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Laptop");
	 * category.setDescription("HP is one of the good product in laptop");
	 * category.setImageURL("HP_Laptop.png");
	 * 
	 * assertEquals("Successfully added a category inside the table",true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("Successfully fetched a category inside the table"
	 * ,"Television",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * category.setName("TV" );
	 * assertEquals("Successfully updated a single category inside the table"
	 * ,true,categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * assertEquals("Successfully deleted a single category inside the table"
	 * ,true,categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully fetched the list of category inside the table"
	 * ,3,categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {

		category = new Category();

		// Add Operation
		//category.setId(1);
		category.setName("Laptop");
		
		category.setDescription("HP is one of the good product in laptop");
		category.setImageURL("HP_Laptop.png");
		category.setActive(1);
		

		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));

		//category.setId(2);
		category.setName("Telivision");
		
		category.setDescription("Sony is one of the good product in telivision");
		category.setImageURL("TV.png");
		category.setActive(1);

		assertEquals("Successfully added a category inside the table", true, categoryDAO.add(category));

		// fetching and update the category
		category = categoryDAO.get(2);

		category.setName("TV");
		assertEquals("Successfully updated a single category inside the table", true, categoryDAO.update(category));

		// delete the category
		assertEquals("Successfully deleted a single category inside the table", true, categoryDAO.delete(category));

		// List of category
		assertEquals("Successfully fetched the list of category inside the table", true, categoryDAO.list().size());

	}
	
	public static void destroy() {
		
		
	}

}
