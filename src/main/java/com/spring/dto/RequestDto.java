package com.spring.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.entity.book.Book;
import com.spring.entity.user.User;

public class RequestDto {

	@Autowired
	private User user;
	@Autowired
	private Book book;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
