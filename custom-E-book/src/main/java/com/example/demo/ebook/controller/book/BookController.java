package com.example.demo.ebook.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.service.book.BookService;

public class BookController {
	
	@Autowired
	BookService bookservice;
	
	@RequestMapping(value = "/registerBook", method = RequestMethod.POST)
	public String registerBuyer(@ModelAttribute("book") Book book, ModelMap map) {
		int result = bookservice.registerBook(book);
		//map.addAttribute("result", "user created with id "+result);
		return "successRegistration";
	}
	
	

}
