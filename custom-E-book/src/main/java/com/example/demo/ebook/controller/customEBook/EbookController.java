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
		List<CustomEBook> list=service.showContent(buyer);
		map.addAttribute("ebooks",list);
		map.addAttribute("error", "");
		map.addAttribute("size", list.size());
		return "Cart";
	}
	@RequestMapping(value = "/deletechapter/{id}")
	public String DeleteContent(@PathVariable(value="id") int id)
	{
		service.deleteChapter(id);
		return "Cart";
	}
	/*@RequestMapping(value = "/validateContent")
	public String validateContent(ModelMap map,HttpSession session,@RequestParam("ebookid")List<Integer>ebookid,@RequestParam("sequence")List<Integer>sequence)
	{	List<Integer>duplicate=new ArrayList<Integer>();
		for(int i=0;i<ebookid.size();i++)
		{
			duplicate.add(ebookid.get(i));List<CustomEBook> findByBuyerAndChapter(Buyer buyer,Chapter chapter);
		}
		for (int i = 0; i < duplicate.size(); i++) {
		    if (duplicate.get(Math.abs(duplicate.get(i))) > 0) {
		      duplicate.set(Math.abs(duplicate.get(i)), -1 * duplicate.get(Math.abs(duplicate.get(i))));
		    } else {
		    	System.out.println("*************failed**********");
		    	map.addAttribute("error", "Selected particular sequence more than once");
		      return "redirect:showEbookContent";
		    }
		}
		System.out.println("*************accepted**********");
		return "redirect:saveEbookContent";
	}*/
	
	@RequestMapping(value = "/saveEbookContent")
	public String SaveContent(ModelMap map,HttpSession session,@RequestParam("ebookid")List<Integer>ebookid,@RequestParam("sequence")List<Integer>sequence)
	{	System.out.println("*************saving**********");
	
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
		return "successRegistration";
		
		
	}
}