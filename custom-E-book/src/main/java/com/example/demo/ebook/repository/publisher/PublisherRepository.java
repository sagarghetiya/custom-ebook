package com.example.demo.ebook.repository.publisher;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.publisher.Publisher;
import java.lang.String;
import java.util.List;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {

	List<Publisher> findByLoginId(String loginid);
}
