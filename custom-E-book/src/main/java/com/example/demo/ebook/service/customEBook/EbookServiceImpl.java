package com.example.demo.ebook.service.customEBook;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.chapter.Chapter;
import com.example.demo.ebook.model.customEBook.CustomEBook;
import com.example.demo.ebook.repository.book.BookRepository;
import com.example.demo.ebook.repository.chapter.ChapterRepository;
import com.example.demo.ebook.repository.customEBook.EbookRepository;

@Service
public class EbookServiceImpl implements EbookService{
	@Autowired
	BookRepository repository;
	ChapterRepository chap_repository;
	EbookRepository ebook_repository;
	//CustomEBook ebook;
	//Chapter chapter;

	@Override
	public List<Book> getBooks(String keywords) {
		String[] keywordList = keywords.split(" ");
		List<Book> books = new ArrayList<>();
		Set<Book> books_set = new LinkedHashSet<>();
		for(String keyword:keywordList)
		{
			List<Book> books_temp = repository.findByKeywordsContaining(keyword);
			if(books_temp!=null)
				books_set.addAll(books_temp);			
		}
		books.addAll(books_set);
		if(books.size()==0)
			return null;
		else
			return books;
	}

	@Override
	public List<Chapter> getChapters(String keywords) {
		String[] keywordList = keywords.split(" ");
		List<Chapter> chapters = new ArrayList<>();
		for(String keyword:keywordList)
		{
			List<Chapter> chapters_temp = chap_repository.findByKeywordsContaining(keyword);
			chapters.addAll(chapters_temp);	
		}
		if(chapters.size()==0)
			return null;
		else
			return chapters;
	}

	@Override
	public int saveEBook(List<Chapter> chapters,Buyer buyer) {
		int sequence=0;
			for(Chapter chapter:chapters)
			{
				CustomEBook eBook = new CustomEBook();
				eBook.setBuyer(buyer);
				eBook.setChapter(chapter);
				eBook.setPrice(0);
				eBook.setSequence(sequence);
				sequence++;
				ebook_repository.save(eBook);
			}
		return 0;
	}

/*	@Override
	public String customizeContent(Buyer buyer,List<Chapter>chapters,int ebookid)
	{
		
		
		return "ebook content updated";
	}*/
	
}
