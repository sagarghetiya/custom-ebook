package com.example.demo.ebook.service.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.repository.buyer.BuyerRepository;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	BuyerRepository repository;
	@Override
	public int registerBuyer(Buyer buyer) {
		//return dao.registerBuyer(buyer);
		Buyer save = repository.save(buyer);
		return save.getId();
	}
}
