package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pojo.Product;

@Controller
public class ProductController {
	@RequestMapping("/addProduct")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView ma = new ModelAndView("product");
		Product product = new Product();
		product.setId(1);
		product.setName("p1");
		product.setPrice(34.4f);
		ma.addObject("product", product);
		return ma;
	} 
	@RequestMapping("/addProducts")
	public ModelAndView addProduct(HttpServletRequest request, HttpServletResponse arg1){
		ModelAndView ma = new ModelAndView("product");
		String name =(String)request.getParameter("name");
		Float price = Float.valueOf(request.getParameter("price"));
		Product product = new Product();
		product.setId(1);
		product.setName(name);
		product.setPrice(price);
		ma.addObject("product", product);
		return ma;
	} 
	
}
