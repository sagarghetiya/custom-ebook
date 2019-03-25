package com.example.demo.ebook.model.publisher;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Publisher implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String loginId;
	private String email;
	private String password;

	public Publisher() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", loginId=" + loginId + ", email=" + email + ", password="
				+ password + "]";
	}

}
