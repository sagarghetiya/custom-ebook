package com.example.demo.ebook.service.book;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.publisher.Publisher;

public interface BookService {
	int registerBook(Book book,Publisher publisher);

}
