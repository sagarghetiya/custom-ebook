package com.example.demo.ebook.controller.def;

import org.springframework.stereotype.Controller;
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
}
