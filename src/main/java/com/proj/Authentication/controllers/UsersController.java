package com.proj.Authentication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.proj.Authentication.models.User;
import com.proj.Authentication.repositories.UserRepository;

@RestController
@RequestMapping("/api/v/user")
public class UsersController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> list() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User get(@PathVariable("id") long id) {
		return userRepository.getById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody User user) {
		userRepository.save(user);
	}

	@PutMapping("/{id}")
	public User update(@RequestBody User newUser, @PathVariable("id") long id) {
		return userRepository.findById(id)
		.map(user -> {
			user.setId(newUser.getId());
			user.setUsername(newUser.getUsername());
			user.setPassword(newUser.getPassword());
			user.setRole(newUser.getRole());
			return userRepository.save(newUser);
		})
		.orElseGet(() -> {
			newUser.setId(id);
			return userRepository.save(newUser);
		});
	}

	@DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        userRepository.deleteById(id);
    }
}
