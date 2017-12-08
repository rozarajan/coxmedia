package com.perficient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {

	@RequestMapping("/tocontoller")
	public ModelAndView mymethod(){
		System.out.println("Welcome to Perficient");
		return new ModelAndView("/WEB-INF/jsp/nousepage.jsp");
	}
}
