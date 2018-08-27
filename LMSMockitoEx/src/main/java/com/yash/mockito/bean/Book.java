package com.yash.mockito.bean;

import java.util.Date;
import java.util.List;

public class Book {
	private Long id;
	private String ISBN;
	private String name;
	private String publisher;
	private List<String> authors;
	private Date publicationDates;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public Date getPublicationDates() {
		return publicationDates;
	}
	public void setPublicationDates(Date publicationDates) {
		this.publicationDates = publicationDates;
	}
}
