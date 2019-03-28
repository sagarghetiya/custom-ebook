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
import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.customEBook.CustomEBook;
import com.example.demo.ebook.service.customEBook.EbookService;

@Controller
public class EbookController {
	
/*	@Autowired
	EbookService service;

	@RequestMapping(value = "/showEbookContent", method = RequestMethod.POST)
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
}
