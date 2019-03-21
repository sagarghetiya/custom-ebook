package com.example.demo.ebook.repository.buyer;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ebook.model.buyer.Buyer;

public interface BuyerRepository extends CrudRepository<Buyer, Integer> {

}
