package com.example.demo.ebook.repository.book;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.book.Book;
import java.lang.String;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer>{
	List<Book> findByKeywords(String keywords);

}
