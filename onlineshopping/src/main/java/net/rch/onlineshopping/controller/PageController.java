package net.rch.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.rch.shoppingbackend.dao.CategoryDAO;
import net.rch.shoppingbackend.dto.Category;

//Helper Controller and annotated with Controller annotation
@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	// Take request from based on url
	@RequestMapping(value = { "/", "/home", "/index" })
	// Handled by below method
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");

		// Passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	/* Methods to load all the products and based on category */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// Passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	} 

	/* Methods to load all the products and based on category */
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch single category
		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title",category.getName());

		// Passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		//passing the single object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	@RequestMapping(value = "/offerZone")
	public ModelAndView offerZone() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Offer Zone");
		mv.addObject("userClickOfferZone", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContactUs", true);
		return mv;
	}

	/*
	 * Below code for only demonestration purpose, so, not required in this
	 * project //Using @RequestParam for Query String(?) and passing greeting
	 * 
	 * @RequestMapping(value = "/test") public ModelAndView
	 * test(@RequestParam(value="greeting", required=false)String greeting){
	 * if(greeting==null){ greeting = "Hello there"; } ModelAndView mv=new
	 * ModelAndView("page"); mv.addObject("greeting", greeting); return mv; }
	 * 
	 * //Using @RequestPath to keep url clean. So greeting will became part of
	 * url itself //{} indicates that this path, the value for this particular
	 * variable greeting is dynamic //Here, we are easily accessing that value
	 * from path, In this project, we required the product id, product name from
	 * the path, so use @PathVariable
	 * 
	 * @RequestMapping(value = "/test/{greeting}") public ModelAndView
	 * test(@PathVariable("greeting")String greeting){ if(greeting==null){
	 * greeting = "Hello there"; } ModelAndView mv=new ModelAndView("page");
	 * mv.addObject("greeting", greeting); return mv; }
	 */
}
