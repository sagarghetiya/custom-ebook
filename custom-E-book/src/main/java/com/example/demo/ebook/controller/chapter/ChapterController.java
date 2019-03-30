package com.example.demo.ebook.controller.chapter;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.service.chapter.ChapterService;

@Controller
public class ChapterController {
	
	@Autowired
	ChapterService service;
//	@RequestMapping("/configureChapters")
//	String configureChapters(ModelMap map,HttpSession session) {
//		Book book = (Book)session.getAttribute("book");
//		session.removeAttribute("book");
//		map.addAttribute("book", book);
//		return "configChapters";
//	}
//	
	@RequestMapping("/saveChapters")
	String saveChapters(@RequestParam Map<String, String> params, ModelMap map,HttpSession session) {
		System.out.println(params.get("name_1"));
		Book book = (Book)session.getAttribute("book");
		ArrayList<String> chapNames = new ArrayList<String>();
		ArrayList<String> chapKeywords = new ArrayList<String>();
		ArrayList<String> chapDescription = new ArrayList<String>();
		ArrayList<Integer> chapPrice = new ArrayList<Integer>();
		ArrayList<Integer> chapStartPage = new ArrayList<Integer>();
		ArrayList<Integer> chapEndPage = new ArrayList<Integer>();
		for(int i=1;i<=book.getNoOfChapters();i++) {
			chapNames.add(params.get("name_"+i));
			chapKeywords.add(params.get("keywords_"+i));
			chapDescription.add(params.get("description_"+i));
			chapPrice.add(Integer.parseInt(params.get("price_"+i)));
			chapStartPage.add(Integer.parseInt(params.get("start_page_"+i)));
			chapEndPage.add(Integer.parseInt(params.get("end_page_"+i)));
		}
		System.out.println(params.size());
		System.out.println(chapNames);
		System.out.println(chapDescription);
		System.out.println(chapKeywords);
		System.out.println(chapPrice);
		System.out.println(chapStartPage);
		System.out.println(chapEndPage);
		service.saveChapters(chapNames, chapKeywords, chapDescription, chapPrice, chapStartPage, chapEndPage, book);
		return "redirect:pubHome";
	}
	
}
