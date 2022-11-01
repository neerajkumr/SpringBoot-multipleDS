package com.spring.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.RequestDto;
import com.spring.entity.book.Book;
import com.spring.entity.user.User;
import com.spring.repo.book.BookRepo;
import com.spring.repo.user.UserRepo;

@RestController
@ComponentScan(basePackages = "com.spring")
public class ControllerClass {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private BookRepo bookRepo;

	@PostMapping
	public RequestDto addData2DB(@RequestBody RequestDto req) {
		userRepo.saveAll(
				Stream.of(new User(req.getUser().getId(), req.getUser().getUserName())).collect(Collectors.toList()));
		bookRepo.saveAll(
				Stream.of(new Book(req.getBook().getId(), req.getBook().getName())).collect(Collectors.toList()));
		return req;
	}

	@GetMapping("/getUsers")
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/getBooks")
	public List<Book> getBooks() {
		return bookRepo.findAll();
	}

	@PutMapping("user/{id}")
	public User update(@PathVariable int id, @RequestBody User user) {
		Optional<User> op = userRepo.findById(id);
		if (op.isPresent()) {
			userRepo.save(user);
		}
		return user;
	}

}
