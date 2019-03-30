package com.example.demo.ebook.repository.customEBook;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.chapter.Chapter;
import com.example.demo.ebook.model.customEBook.CustomEBook;

public interface EbookRepository extends CrudRepository<CustomEBook, Integer>{
List<CustomEBook> findByBuyerOrderBySequence(Buyer buyer);
List<CustomEBook> findByBuyerAndChapter(Buyer buyer,Chapter chapter);
List<CustomEBook> findById(int id);
}
