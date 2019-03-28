package com.example.demo.ebook.controller.chapter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.ebook.model.book.Book;

@Controller
public class ChapterController {
	
	@RequestMapping("/configureChapters")
	String configureChapters(ModelMap map,HttpSession session) {
		Book book = (Book)session.getAttribute("book");
		session.removeAttribute("book");
		int numOfChapters = book.getNoOfChapters();
		int totalPages = book.getTotalNoOfPages();
		String bookName = book.getBookName();
		int id = book.getId();
		map.addAttribute("id", id);
		map.addAttribute("bookName", bookName);
		map.addAttribute("numOfChapters", numOfChapters);
		map.addAttribute("totalPages", totalPages);
		return "configChapters";
	}
	
	
}
