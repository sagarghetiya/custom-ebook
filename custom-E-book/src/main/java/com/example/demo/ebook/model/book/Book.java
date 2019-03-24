package com.example.demo.ebook.model.book;

import javax.persistence.*;

import com.example.demo.ebook.model.publisher.Publisher; 

@Entity
public class Book {

	@Id
	@GeneratedValue
	private int id;
	private String isbn;
	private String bookName;
	@ManyToOne
	private Publisher publisher;
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

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
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
