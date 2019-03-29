package com.example.demo.ebook.service.customEBook;
import java.util.*;
import com.example.demo.ebook.model.chapter.Chapter;
import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.customEBook.CustomEBook;
import com.fasterxml.jackson.core.io.SegmentedStringWriter;
public interface EbookService {
	//String customizeContent(Buyer buyer,List<Chapter>chapters,int ebookid);
	List<Book> getBooks(String keywords);
	List<Chapter> getChapters(String keywords);
	int saveEBook(List<Chapter> chapters,Buyer buyer);
}
