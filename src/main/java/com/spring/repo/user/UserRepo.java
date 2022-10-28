package com.spring.repo.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.user.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
