package com.example.demo.ebook.model.customEBook;

import javax.persistence.*;

import com.example.demo.ebook.model.buyer.Buyer;
import com.example.demo.ebook.model.chapter.Chapter;

@Entity
public class CustomEBook {
	@Id
	@GeneratedValue
	private int id;
	private double price;
	@ManyToOne
	private Chapter chapter;
	@ManyToOne
	private Buyer buyer;
	int sequence;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Chapter getChapter() {
		return chapter;
	}
	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
}
