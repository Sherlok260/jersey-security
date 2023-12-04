package com.example.jersey_todo.tables;

import java.util.Date;

public class Book {
	
	private int id;
	private String name;
	private String category;
	private int price;
	private String author;
	private int year;
	private Date created;

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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Book(int id, String name, String category, int price, String author, int year, Date created) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.author = author;
		this.year = year;
		this.created = created;
	}
	public Book() {
	
	}
	
}
