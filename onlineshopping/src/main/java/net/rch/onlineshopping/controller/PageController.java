package net.rch.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Helper Controller and annotated with Controller annotation
@Controller
public class PageController {

	// Take request from based on url
	@RequestMapping(value = { "/", "/home", "/index" })
	// Handled by below method
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = { "/listProducts" })
	public ModelAndView listProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "View Products");
		mv.addObject("userClickListProducts",true);
		return mv;
	}
	
	@RequestMapping(value = { "/offerZone" })
	public ModelAndView offerZone() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Offer Zone");
		mv.addObject("userClickOfferZone",true);
		return mv;
	}
	
	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContactUs",true);
		return mv;
	}
	
	
	/*Below code for only demonestration purpose, so, not required in this project
	 * //Using @RequestParam for Query String(?) and passing greeting
	@RequestMapping(value = "/test")
	public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting){
		if(greeting==null){
			greeting = "Hello there";
		}
		ModelAndView mv=new ModelAndView("page");
				mv.addObject("greeting", greeting);
				return mv;
	}
	
	//Using @RequestPath to keep url clean. So greeting will became part of url itself
	//{} indicates that this path, the  value for this particular variable greeting is dynamic
	//Here, we are easily accessing that value from path, In this project, we required the product id, product name from the path, so use @PathVariable
	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting){
		if(greeting==null){
			greeting = "Hello there";
		}
		ModelAndView mv=new ModelAndView("page");
				mv.addObject("greeting", greeting);
				return mv;
	}*/
}
