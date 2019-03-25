package com.example.demo.ebook.service.buyer;

import com.example.demo.ebook.model.buyer.Buyer;

public interface BuyerService {
	int registerBuyer(Buyer buyer);
	Buyer validateBuyer(String loginId, String password);
}
