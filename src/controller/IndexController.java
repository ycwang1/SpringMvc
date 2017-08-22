package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController{
	//	À¹½ØÒ³Ãæ
	@RequestMapping("/index")
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		ModelAndView ma=new ModelAndView("index");
		ma.addObject("message","hello springmvc");
		return ma;
	}
	//Ìø×ª
	@RequestMapping("jump")
	public ModelAndView jump(){
		ModelAndView ma = new ModelAndView("redirect:/index");
		ma.addObject("message","hello springmvc");
		return ma;
	}
	@RequestMapping("check")
	public ModelAndView check(HttpSession session){
		ModelAndView ma = new ModelAndView("check");
		Integer i=(Integer) session.getAttribute("count");
		if(i==null){
			i=0;
		}else{
			i++;
		}
		session.setAttribute("count", i);
		ma.addObject("session", session);
		return ma;
	}
	@RequestMapping("clear")
	public ModelAndView clear(HttpSession session){
		ModelAndView ma = new ModelAndView("redirect:/check");
//		Integer i=(Integer) session.getAttribute("count");
//		if(i==null){
//			i=0;
//		}else{
//			i++;
//		}
//		session.setAttribute("count", i);
		session.removeAttribute("count");
		ma.addObject("session", session);
		return ma;
	}

}
