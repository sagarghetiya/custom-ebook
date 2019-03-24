package com.example.demo.ebook.controller.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.publisher.Publisher;
import com.example.demo.ebook.service.book.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookservice;
	
	@RequestMapping(value = "/registerBook", method = RequestMethod.POST)
	public String registerPublisher(@ModelAttribute("book") Book book, ModelMap map,HttpServletRequest request) {
		
		Publisher publisher=(Publisher) request.getSession(false).getAttribute("publisher");
		int result = bookservice.registerBook(book,publisher);
		map.addAttribute("result", "user created with id "+result);
		return "successRegistration";
	}
//	public String registerBook(ModelMap map) {
//		Publisher publisher = new Publisher();
//		publisher.setId(3);
//		publisher.setEmail("abc@f.com");
//		publisher.setLoginId("abc");
//		publisher.setName("shrey");
//		publisher.setPassword("temp");
//		Book book = new Book();
//		//book.setId(1);
//		book.setBookName("DM");
//		book.setPublisher(publisher);
//		book.setIsbn("abc123");
//		book.setNoOfChapters(10);
//		book.setTotalNoOfPages(450);
//		book.setPrice(420);
//		book.setBookLoc("/home/desktop");
//		int result = bookservice.registerBook(book);
//		map.addAttribute("result", "user created with id "+result);
//		return "successRegistration";
	//}
	
	

}
