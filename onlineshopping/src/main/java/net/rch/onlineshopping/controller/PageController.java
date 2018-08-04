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
		mv.addObject("greeting", "welcome to spring web mvc");
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
