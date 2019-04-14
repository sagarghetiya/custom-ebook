package com.example.demo.ebook.model.payment;
import javax.persistence.*;
@Entity
public class Payment {
	@Id
	@GeneratedValue
	private int id;
	private String buyer_addr;
	private int buyerid;
	private boolean hardCopy;
	private double price;
	private String payment_method;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBuyer_addr() {
		return buyer_addr;
	}
	public void setBuyer_addr(String buyer_addr) {
		this.buyer_addr = buyer_addr;
	}
	public int getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}
	
	public boolean isHardCopy() {
		return hardCopy;
	}
	public void setHardCopy(boolean hardCopy) {
		this.hardCopy = hardCopy;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	
	
}
