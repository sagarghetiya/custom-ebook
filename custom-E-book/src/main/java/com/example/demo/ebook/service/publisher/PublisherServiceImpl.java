package com.example.demo.ebook.service.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ebook.model.publisher.Publisher;
import com.example.demo.ebook.repository.publisher.PublisherRepository;
@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	PublisherRepository repository;
	@Override
	public int registerPublisher(Publisher publisher) {
		Publisher save = repository.save(publisher);
		return save.getId();
	}

}
