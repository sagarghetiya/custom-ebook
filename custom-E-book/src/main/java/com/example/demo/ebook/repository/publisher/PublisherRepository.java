package com.example.demo.ebook.repository.publisher;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.publisher.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
	
}
