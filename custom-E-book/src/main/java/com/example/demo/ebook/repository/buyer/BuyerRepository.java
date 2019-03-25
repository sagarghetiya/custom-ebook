package com.example.demo.ebook.repository.buyer;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.buyer.Buyer;
import java.lang.String;
import java.util.List;

public interface BuyerRepository extends CrudRepository<Buyer, Integer> {
	List<Buyer> findByLoginId(String loginid);
}
