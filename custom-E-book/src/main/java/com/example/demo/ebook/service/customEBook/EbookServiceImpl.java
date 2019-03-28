package com.example.demo.ebook.service.customEBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.chapter.Chapter;
import com.example.demo.ebook.model.customEBook.CustomEBook;
import com.example.demo.ebook.repository.customEBook.EbookRepository;

@Service
public class EbookServiceImpl implements EbookService{
	@Autowired
	EbookRepository repository;

	@Override
	public List<CustomEBook> showContent(Buyer buyer)
	{
		List<CustomEBook> ebooks=repository.findByBuyer(buyer);
		return ebooks;	
	}
}
