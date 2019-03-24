package com.example.demo.ebook.repository.book;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.book.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

}
