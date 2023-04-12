package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@GetMapping("/all")
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable(value = "id") int restaurantId) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId);
		if (restaurant == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(restaurant);
	}

	@PostMapping("/save")
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(value = "id") int restaurantId,
			@RequestBody Restaurant restaurantDetails) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId);
		if (restaurant == null) {
			return ResponseEntity.notFound().build();
		}
		restaurant.setNom(restaurantDetails.getNom());
		restaurant.setAdresse(restaurantDetails.getAdresse());
		restaurant.setDescription(restaurantDetails.getDescription());
		restaurant.setLatitude(restaurantDetails.getLatitude());
		restaurant.setLongitude(restaurantDetails.getLongitude());
		restaurant.setHourOpened(restaurantDetails.getHourOpened());
		restaurant.setHourClosed(restaurantDetails.getHourClosed());
		restaurant.setZone(restaurantDetails.getZone());
		restaurant.setSerie(restaurantDetails.getSerie());
		restaurant.setPhotos(restaurantDetails.getPhotos());
		restaurant.setSpecialite(restaurantDetails.getSpecialite());
		

		Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
		return ResponseEntity.ok(updatedRestaurant);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable(value = "id") int restaurantId) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId);
		if (restaurant == null) {
			return ResponseEntity.notFound().build();
		}
		restaurantRepository.delete(restaurant);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{nom}/{adresse}/{description}")
	public ResponseEntity<Restaurant> getRestaurantByDetails(@PathVariable String nom,
	                                                          @PathVariable String adresse,
	                                                          @PathVariable String description
	                                                         ) {
	    Restaurant restaurant = restaurantRepository.findByNomAndAdresseAndDescriptionAndLatitudeAndLongitude(
	        nom, adresse, description);
	    if (restaurant == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(restaurant);
	}


}
