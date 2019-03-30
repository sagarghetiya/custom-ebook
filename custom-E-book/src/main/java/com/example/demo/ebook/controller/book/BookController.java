package com.example.demo.ebook.controller.book;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.publisher.Publisher;
import com.example.demo.ebook.service.book.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService service;
	
	@RequestMapping(value = "/registerBook", method = RequestMethod.POST)
	public String registerPublisher(@RequestParam("file") MultipartFile file, @ModelAttribute("book") Book book, ModelMap map,HttpSession session) throws IOException {
		if(session.getAttribute("id")==null) {
			return "redirect:loginBuyerPublisher";
		}
		Publisher publisher=(Publisher) session.getAttribute("publisher");
		Book result = service.registerBook(book,publisher);
		map.addAttribute("result", "book created with id "+result.getId());
		service.saveBook(file, result, publisher.getId());
		map.addAttribute("book",result);
		return "successBookRegistration";
	}
	
	@RequestMapping("pubHome")
	public String publisherHome(ModelMap map, HttpSession session) {
		if (session.getAttribute("id") == null || session.getAttribute("publisher")==null) {
			return "redirect:loginBuyerPublisher";
		} else {
			Publisher publisher =(Publisher) session.getAttribute("publisher");
			List<Book> publisherBooks = service.getPublisherBooks(publisher);
			System.out.println(publisherBooks.get(0).getBookName());
			map.addAttribute("publisherBooks", publisherBooks);
			return "publisherHome";
		}
		
	}
	@RequestMapping("confChapters")
	public String confChapters(@RequestParam("id") int id, ModelMap map, HttpSession session) {
		if (session.getAttribute("id") == null || session.getAttribute("publisher")==null) {
			return "redirect:loginBuyerPublisher";
		}
		else {
			Book book = service.getBookById(id);
			session.setAttribute("book", book);
			return "configChapters";
		}
		
	}

}
