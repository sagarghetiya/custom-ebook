package com.example.demo.ebook.service.chapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ebook.model.book.Book;
import com.example.demo.ebook.model.chapter.Chapter;
import com.example.demo.ebook.repository.chapter.ChapterRepository;

@Service
public class ChapterServiceImpl implements ChapterService {
	@Autowired
	ChapterRepository repository;

	@Override
	public int saveChapters(ArrayList<String> names, ArrayList<String> keywords, ArrayList<String> description,
			ArrayList<Integer> price, ArrayList<Integer> startPage, ArrayList<Integer> endPage, Book book) {
		System.out.println(names);
		System.out.println(keywords);
		System.out.println(description);
		System.out.println(startPage);
		System.out.println(endPage);
		System.out.println(price);
		return 0;
	}

	@Override
	public Chapter getChapterById(int id) {
		Optional<Chapter> chapter = repository.findById(id);
		return chapter.get();
	}

	@Override
	public List<Chapter> getChapterByBookId(Book book) {
		List<Chapter> chapters = repository.findByBook(book);
		return chapters;
	}
}
