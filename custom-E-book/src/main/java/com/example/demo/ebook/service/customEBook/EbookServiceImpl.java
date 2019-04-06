package com.example.demo.ebook.service.customEBook;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;
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
	EbookRepository repository;
	@Autowired
	BookRepository book_repository;
	@Autowired
	ChapterRepository chap_repository;
	@Autowired
	EbookRepository ebook_repository;
	// CustomEBook ebook;
	// Chapter chapter;

	@Override
	public List<CustomEBook> showContent(Buyer buyer)
	{
		List<CustomEBook> ebooks=repository.findByBuyerOrderBySequence(buyer);
		return ebooks;	
	}
	@Override
	public void deleteChapter(int id)
	{
		List<CustomEBook> ebooks=repository.findById(id);
		CustomEBook ebook=ebooks.get(0);
		repository.delete(ebook);
	}
	@Override
	public int updateEbook(List<Integer>ebookid,List<Integer>sequence)
	{ 	int i;
		for( i=0;i<ebookid.size();i++)
		{
			int id=((Integer)ebookid.get(i)).intValue();
			int seq=((Integer)sequence.get(i)).intValue();
			List<CustomEBook> ebooks=repository.findById(id);
			CustomEBook b=(CustomEBook)ebooks.get(0);
			b.setSequence(seq);
			repository.save(b);
		}
		if(i==ebookid.size())
			return 1;
		else return 0;
	}
	@Override
	public void deleteContentAfterSave(Buyer buyer)
	{
		List<CustomEBook> ebooks=repository.findByBuyerOrderBySequence(buyer);
		for(int i=0;i<ebooks.size();i++)
		{
			CustomEBook ebook=ebooks.get(i);
			repository.delete(ebook);
		}
	}
	public List<Book> getBooks(String keywords) {
		String[] keywordList = keywords.split(" ");
		List<Book> books = new ArrayList<>();
		Set<Book> books_set = new LinkedHashSet<>();
		for (String keyword : keywordList) {
			List<Book> books_temp = book_repository.findByKeywordsContaining(keyword);
			if (books_temp != null)
				books_set.addAll(books_temp);
		}
		books.addAll(books_set);
		if (books.size() == 0)
			return null;
		else
			return books;
	}

	@Override
	public List<Chapter> getChapters(String keywords) {
		String[] keywordList = keywords.split(" ");
		List<Chapter> chapters = new ArrayList<>();
		Set<Chapter> chapters_set = new LinkedHashSet<>();
		for (String keyword : keywordList) {
			List<Chapter> chapters_temp = chap_repository.findByKeywordsContaining(keyword);
			if (chapters_temp != null)
				chapters_set.addAll(chapters_temp);
		}
		chapters.addAll(chapters_set);
		if (chapters.size() == 0)
			return null;
		else
			return chapters;
	}

	@Override
	public int saveEBook(List<Integer> books_id, List<Integer> chapters_id, Buyer buyer) {
		int sequence = 1;
		if (books_id != null) {
			List<Book> books = book_repository.findByIdIn(books_id);
			for (Book book : books) {
				CustomEBook eBook = new CustomEBook();
				eBook.setBuyer(buyer);
				eBook.setBook(book);
				eBook.setSequence(sequence);
				sequence++;
				ebook_repository.save(eBook);
			}
		}
		if (chapters_id != null) {
			List<Chapter> chapters = chap_repository.findByIdIn(chapters_id);
			for (Chapter chapter : chapters) {
				CustomEBook eBook = new CustomEBook();
				eBook.setBuyer(buyer);
				eBook.setChapter(chapter);
				eBook.setSequence(sequence);
				sequence++;
				ebook_repository.save(eBook);
			}
		}
		return 0;
	}
	@Override
	public int generateHTMLFromPDF(String filename) throws IOException {
		PDDocument pdf = PDDocument.load(new File(filename));
	    Writer output = new PrintWriter("src/output/pdf.html", "utf-8");
	    try {
			new PDFDomTree().writeText(pdf, output);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	    output.close();
		return 0;
	}

	/*
	 * @Override public String customizeContent(Buyer
	 * buyer,List<Chapter>chapters,int ebookid) {
	 * 
	 * 
	 * return "ebook content updated"; }
	 */

}
