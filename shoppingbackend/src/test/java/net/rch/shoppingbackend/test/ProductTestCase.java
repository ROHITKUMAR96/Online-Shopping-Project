package net.rch.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.rch.shoppingbackend.dao.ProductDAO;
import net.rch.shoppingbackend.dto.Product;

public class ProductTestCase {
	
		private static AnnotationConfigApplicationContext context;

		private static ProductDAO productDAO;

		private Product product;

		@BeforeClass
		public static void init() {

			context = new AnnotationConfigApplicationContext();
			context.scan("net.rch.shoppingbackend");
			context.refresh();
			productDAO = (ProductDAO) context.getBean("productDAO");
		}
		
		@Test
		public void testCRUDProduct() {

			//Create Operation
			product = new Product();
			
			product.setName("Mi");
			product.setBrand("Redmi");
			product.setDescription("Mi Note 5 Pro is good mobile");
			product.setUnitPrice(17000);
			product.setActive(1);
			product.setCategoryId(3);
			product.setSupplierId(3);
			assertEquals("Something went wrong while inserting a new product!", true, productDAO.add(product));

			//reading and updating the category
			product = productDAO.get(2);
			product.setName("Motrola");
			assertEquals("Something went wrong while updating the existing product!", true, productDAO.update(product));

			
			// delete the category
			assertEquals("Something went wrong while deleting the existing product!", true, productDAO.delete(product));

			
			// List of category
			assertEquals("Something went wrong while listing the existing product!", 6, productDAO.list().size());

		}
		
	}

