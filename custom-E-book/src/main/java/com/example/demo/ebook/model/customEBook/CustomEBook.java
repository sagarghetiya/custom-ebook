package com.example.demo.ebook.model.customEBook;

import javax.persistence.*;

@Entity
public class CustomEBook {
	@Id
	@GeneratedValue
	private int id;
	private double price;

}
