package com.example.demo.ebook.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.publisher.Publisher;
import com.example.demo.ebook.repository.book.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository repository;
	@Override
	public int registerBook(Book book,Publisher publisher) {
		book.setPublisher(publisher);
		Book save = repository.save(book);
		return save.getId();
	}

}
