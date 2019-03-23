package com.example.demo.ebook.controller.def;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	
	@RequestMapping("/")
	public String test() {
		return "index";
	}
	
	@RequestMapping("regBuyer")
	public String regBuyer() {
		return "regBuyer";
	}
	
	@RequestMapping("regPublisher")
	public String regPublisher() {
		return "regPublisher";
	}
	
	@RequestMapping("loginPub")
	public String LoginPublisher(ModelMap map, HttpSession session) {
		if(session.getAttribute("id")!=null) {
			return "redirect:pubHome";
		}
		map.addAttribute("error","");
		return "publisherLogin";
	}
	
	@RequestMapping("pubHome")
	public String publisherHome(ModelMap map, HttpSession session) {
		if(session.getAttribute("id")==null) {
			return "redirect:loginPub";
		}
		else {
			return "publisherHome";
		}
	}
	
	
}
