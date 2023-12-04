package com.example.jersey_todo.payload;

public class BookDto {
	
	private int id;
	private String name;
	private String category;
	private int price;
	private String author;
	private int year;
	
	public BookDto() {
		
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

	public BookDto(int id, String name, String category, int price, String author, int year) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.author = author;
		this.year = year;
	}

	@Override
	public String toString() {
		return "BookDto{" +
				"id=" + id +
				", name='" + name + '\'' +
				", category='" + category + '\'' +
				", price=" + price +
				", author='" + author + '\'' +
				", year=" + year +
				'}';
	}
}
