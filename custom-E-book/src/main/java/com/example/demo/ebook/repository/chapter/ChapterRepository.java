package com.example.demo.ebook.repository.chapter;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.chapter.Chapter;

public interface ChapterRepository extends CrudRepository<Chapter, Integer> {
	List<Chapter> findByKeywordsContaining(String keyword);

}
