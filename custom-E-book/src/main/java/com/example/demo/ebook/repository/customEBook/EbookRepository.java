package com.example.demo.ebook.repository.customEBook;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.customEBook.CustomEBook;

public interface EbookRepository extends CrudRepository<CustomEBook, Integer>{
//List<CustomEBook> findByBuyer
}
