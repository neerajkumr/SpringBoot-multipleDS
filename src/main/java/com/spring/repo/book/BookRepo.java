package com.spring.repo.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.book.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{

}
