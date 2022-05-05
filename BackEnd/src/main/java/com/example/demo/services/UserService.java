package com.example.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entities.Complaints;
import com.example.demo.entities.User;

public interface UserService {

	public User addUser(User user);

	public User updateUser(User user);

	public void deleteUser(Long id);

	public List<User> getAll();

	public User findById( Long id);

}
