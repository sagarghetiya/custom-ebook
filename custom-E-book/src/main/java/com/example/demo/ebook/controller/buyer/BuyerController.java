package com.example.demo.ebook.controller.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.service.buyer.BuyerService;

@Controller
public class BuyerController {
	
	@Autowired
	BuyerService service;
	
	@RequestMapping(value = "/registerBuyer", method = RequestMethod.POST)
	public String test(@ModelAttribute("buyer") Buyer buyer, ModelMap map) {
		int result = service.registerBuyer(buyer);
		map.addAttribute("result", "user created with id "+result);
		return "successRegistration";
	}
}
