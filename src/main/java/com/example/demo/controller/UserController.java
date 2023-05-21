package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Restaurant;
import com.example.demo.entity.User;
import com.example.demo.repository.RestaurantRepository;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User user = userRepository.findById(id);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User newUser) {
		User user = userRepository.findById(id);
		if (user != null) {
			user.setNom(newUser.getNom());
			user.setEmail(newUser.getEmail());
			userRepository.save(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		User user = userRepository.findById(id);
		if (user != null) {
			userRepository.delete(user);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{email}/{password}")
	public User getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		User user = userRepository.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}

	@PutMapping("/addrestau/{id}/{rid}")
	public ResponseEntity<User> addrestau(@PathVariable int id, @PathVariable int rid) {
		User user = userRepository.findById(id);
		Restaurant restaurant = restaurantRepository.findById(rid);
		user.setRestaurant(restaurant);
		userRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	
	

	@GetMapping("/findrestau/{id}")
	public int  findrestau(@PathVariable int id) {
	    User user = userRepository.findById(id);
	    if (user != null && user.getRestaurant() != null) {
	        return 1;
	    } else {
	        return 0;
	    }
	}
	
	@GetMapping("/findrestauu/{id}")
	public Restaurant  findrestau2(@PathVariable int id) {
	    User user = userRepository.findById(id);
	    if (user != null && user.getRestaurant() != null) {
	        return user.getRestaurant();
	    } else {
	        return null;
	    }
	}

}
