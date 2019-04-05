package com.example.demo.ebook.service.buyer;

import java.util.List;

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
		// return dao.registerBuyer(buyer);
		Buyer save = repository.save(buyer);
		return save.getId();
	}

	@Override
	public Buyer validateBuyer(String loginId, String password) {
		List<Buyer> buyers = repository.findByLoginId(loginId);
		if (buyers.size() == 0) {
			return null;
		} else {

			Buyer buyer = buyers.get(0);
			if (buyer.getPassword().equals(password)) {
				return buyer;
			} else {
				return null;
			}
		}
	}
}
