package com.example.demo.ebook.repository.chapter;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.chapter.Chapter;
import com.example.demo.ebook.model.book.Book;
import java.util.List;

public interface ChapterRepository extends CrudRepository<Chapter, Integer> {
	
	List<Chapter> findByBookOrderById(Book book);

}
