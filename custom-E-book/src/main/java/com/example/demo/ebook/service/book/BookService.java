package com.example.demo.ebook.service.book;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.publisher.Publisher;

public interface BookService {
	Book registerBook(Book book,Publisher publisher);
	String saveBook(MultipartFile file, Book book, int publisherId) throws IOException;
	List<Book> getPublisherBooks(Publisher publisher);
	Book getBookById(int id);
	void update(Book book);
	int getNoOfPages(String location) throws IOException;
}
