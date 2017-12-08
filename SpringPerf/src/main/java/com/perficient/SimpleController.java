package com.perficient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimpleController {

	@RequestMapping(value="/livepitchcompleted", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView mymethod(@RequestBody String livePitchHappenedStr, @RequestHeader("hmac") String hmac){
		System.out.println("Welcome to Perficient");
		System.out.println("Received a live pitch happened event"+livePitchHappenedStr);
		return new ModelAndView("/WEB-INF/jsp/nousepage.jsp", "message", livePitchHappenedStr);
	}
}
