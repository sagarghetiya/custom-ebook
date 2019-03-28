package com.example.demo.ebook.repository.customEBook;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.book.Book;

public interface EbookRepository extends CrudRepository<Book, Integer>{
//List<CustomEBook> findByBuyer
}
