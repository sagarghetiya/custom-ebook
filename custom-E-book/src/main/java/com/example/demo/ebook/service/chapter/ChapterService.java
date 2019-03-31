package com.example.demo.ebook.service.chapter;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.ebook.model.book.Book;

@Service
public interface ChapterService {
	int saveChapters(ArrayList<String> names, ArrayList<String> keywords, ArrayList<String> Description,
			ArrayList<Integer> price, ArrayList<Integer> startPage, ArrayList<Integer> endPage, Book book) throws IOException;
	String cutPdf(int startPage, int endPage, String source, String dest, boolean flag) throws IOException;
}
