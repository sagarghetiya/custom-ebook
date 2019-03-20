package com.example.demo.ebook.def.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	
	@RequestMapping("/")
	public String test() {
		return "index";
	}
}
