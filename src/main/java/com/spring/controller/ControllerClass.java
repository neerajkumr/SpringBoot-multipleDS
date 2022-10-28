package com.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.book.Book;
import com.spring.entity.user.User;
import com.spring.repo.book.BookRepo;
import com.spring.repo.user.UserRepo;

@RestController
@ComponentScan(basePackages="com.spring")
public class ControllerClass {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BookRepo bookRepo;

	@PostConstruct
	public void addData2DB() {
		userRepo.saveAll(Stream.of(new User(744, "John"), new User(455, "Pitter"), new User(233,"sayed")).collect(Collectors.toList()));
		bookRepo.saveAll(
				Stream.of(new Book(111, "Core Java"), new Book(222, "Spring Boot")).collect(Collectors.toList()));
	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return bookRepo.findAll();
	}

}
