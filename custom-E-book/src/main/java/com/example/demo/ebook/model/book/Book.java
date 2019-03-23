package com.example.demo.ebook.model.book;

import javax.persistence.*;

import com.example.demo.ebook.model.buyer.Buyer; 

@Entity
public class Book {

	@Id
	@GeneratedValue
	private int id;
	private String isbn;
	private String bookName;
	@ManyToOne
	private Buyer buyer;
	private int noOfChapters;
	private int totalNoOfPages;
	private double price;
	private String bookLoc;
	
	public Book() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public int getNoOfChapters() {
		return noOfChapters;
	}

	public void setNoOfChapters(int noOfChapters) {
		this.noOfChapters = noOfChapters;
	}

	public int getTotalNoOfPages() {
		return totalNoOfPages;
	}

	public void setTotalNoOfPages(int totalNoOfPages) {
		this.totalNoOfPages = totalNoOfPages;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookLoc() {
		return bookLoc;
	}

	public void setBookLoc(String bookLoc) {
		this.bookLoc = bookLoc;
	}
	
	
}
