package com.example.demo.ebook.controller.customEBook;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.example.demo.ebook.model.chapter.Chapter;
import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.customEBook.CustomEBook;
import com.example.demo.ebook.service.customEBook.EbookService;

@Controller
public class EbookController {
	
	@Autowired
	EbookService service;

/*	@RequestMapping(value = "/showEbookContent", method = RequestMethod.POST)
	public String ShowContent(ModelMap map,HttpSession session,@RequestParam("chapters")List<Chapter>chapters,@RequestParam("ebookid")ebookid)
	{
		if(session.getAttribute("id")==null) {
			return "redirect:loginBuyerPublisher";
		}
		Buyer buyer=(Buyer) session.getAttribute("buyer");
		CustomEbook result=service.customizeContent(buyer,chapters,ebookid);
		map.addAttribute("result","custom ebook created with id "+result.getEbookId());
		return "successRegistration";
	}*/
	@RequestMapping(value = "/searchResult", method = RequestMethod.POST)
	public String searchResult(@RequestParam("keywords") String keywords,ModelMap map)
	{
		List<Book> books = service.getBooks(keywords);
		List<Chapter> chapters = service.getChapters(keywords);
		if(books!=null)
			map.addAttribute("books",books);
		if(chapters!=null)
			map.addAttribute("chapters", chapters);
		return "searchResult";
	}
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCart(@RequestParam("bookIdList") List<Integer> bookIdList,
										@RequestParam("chapterIdList") List<Integer> chapterIdList,
										ModelMap map,HttpSession session) {
		Buyer buyer = (Buyer) session.getAttribute("buyer");
		int save = service.saveEBook(chapterIdList, buyer);
		map.addAttribute("booksId",bookIdList);
		map.addAttribute("chaptersId",chapterIdList);
		return "cart";
	}
	
}
