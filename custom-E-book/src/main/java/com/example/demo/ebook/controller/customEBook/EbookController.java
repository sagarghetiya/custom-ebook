package com.example.demo.ebook.controller.customEBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.chapter.Chapter;
import com.example.demo.ebook.model.customEBook.CustomEBook;
import com.example.demo.ebook.service.customEBook.EbookService;
import com.example.demo.ebook.service.customEBook.SendEmail;

@Controller
public class EbookController {
	
	@Autowired
	EbookService service;

	@RequestMapping(value = "/showEbookContent")
	public String ShowContent(ModelMap map,HttpSession session)
	{
		if(session.getAttribute("id")==null) {
			return "redirect:loginBuyerPublisher";
		}
		Buyer buyer=(Buyer) session.getAttribute("buyer");
		if(buyer==null)
			return "redirect:loginBuyerPublisher";
		List<CustomEBook> list=service.showContent(buyer);
		map.addAttribute("ebooks",list);
		map.addAttribute("error", "");
		map.addAttribute("size", list.size());
		return "Cart";
	}
	@RequestMapping(value = "/deletechapter/{id}")
	public String DeleteContent(@PathVariable(value="id") int id,HttpSession session)
	{if(session.getAttribute("id")==null) {
		return "redirect:loginBuyerPublisher";
	}
	Buyer buyer=(Buyer) session.getAttribute("buyer");
	if(buyer==null)
		return "redirect:loginBuyerPublisher";
		service.deleteChapter(id);
		return "Cart";
	}
	
	@RequestMapping(value = "/saveEbookContent")
	public String SaveContent(ModelMap map,HttpSession session,@RequestParam("ebookid")List<Integer>ebookid,@RequestParam("sequence")List<Integer>sequence)
	{
		if (session.getAttribute("id") == null) {
			return "redirect:loginBuyerPublisher";
		}
		Buyer buyer = (Buyer) session.getAttribute("buyer");
		if (buyer == null)
			return "redirect:loginBuyerPublisher";
			//to check whether dropdown contains duplicate values
			List<Integer>duplicate=new ArrayList<Integer>();
			for(int i=0;i<sequence.size();i++)
			{
				duplicate.add(sequence.get(i));
			}
			Collections.sort(duplicate);
			for (int i = 0; i < duplicate.size()-1; i++) {
			   if(duplicate.get(i).equals(duplicate.get(i+1)))
			   {map.addAttribute("error", "Selected particular sequence more than once");
		      return "redirect:showEbookContent";
		    }
			}
		int i=service.updateEbook(ebookid,sequence);
		if(i==1)
			map.addAttribute("result", "successfully added");
		else
			map.addAttribute("result", "failed");
		return "redirect:showEbookContent";
		
		
	}
	@RequestMapping(value ="/payment")
	public String Payment(HttpSession session,ModelMap map)
	{
		if (session.getAttribute("id") == null) {
			return "redirect:loginBuyerPublisher";
		}
		Buyer buyer = (Buyer) session.getAttribute("buyer");
		if (buyer == null)
			return "redirect:loginBuyerPublisher";
		List<CustomEBook> list=service.showContent(buyer);
		double total=0;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getChapter()==null)
				total+=list.get(i).getBook().getPrice();
			else
				total+=list.get(i).getChapter().getPrice();
		}
		map.addAttribute("price", total);
		return "Payment";
	}
	@RequestMapping(value ="/buy")
	public String Buy(ModelMap map,HttpSession session,@RequestParam("price")String price)
	{
		if (session.getAttribute("id") == null) {
			return "redirect:loginBuyerPublisher";
		}
		Buyer buyer = (Buyer) session.getAttribute("buyer");
		if (buyer == null)
			return "redirect:loginBuyerPublisher";
		String filename="/home/samridhi/mid.pdf";
		//List<CustomEBook> list=service.showContent(buyer);
		SendEmail s=new SendEmail(price,filename);
		service.deleteContentAfterSave(buyer);
		map.addAttribute("result", "sent!");
		return "successRegistration";
	}
}