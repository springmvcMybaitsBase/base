package com.mana.angularJs;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/angularJs")
@Slf4j
public class AngularJsController {
	
	@RequestMapping("/show")
	public String show(HttpServletRequest request,ModelMap model){
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("password", request.getParameter("password"));
		model.addAttribute("email", request.getParameter("email"));
		return "pages/angularJs/show";
	}
}
