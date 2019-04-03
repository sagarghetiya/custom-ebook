package com.example.demo.ebook.service.customEBook;
import java.util.*;
import com.example.demo.ebook.model.chapter.Chapter;
import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.customEBook.CustomEBook;
public interface EbookService {
	List<CustomEBook> showContent(Buyer buyer);
	void deleteChapter(int id);
	int updateEbook(List<Integer>ebookid,List<Integer>sequence);
	 void deleteContentAfterSave(Buyer buyer);
}
