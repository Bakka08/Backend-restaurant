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

import com.example.demo.entity.Specialite;
import com.example.demo.repository.SpecialiteRepository;

@RestController
@RequestMapping("/api/sepecialite")
public class SpecialiteController {

	@Autowired
	private SpecialiteRepository specialiteRepository;

	@GetMapping("/all")
	public List<Specialite> getAllSpecialities() {
		return specialiteRepository.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Specialite> getSpecialiteById(@PathVariable(value = "id") int specialiteId) {
		Specialite specialite = specialiteRepository.findById(specialiteId);
		if (specialite == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(specialite);
	}

	@PostMapping("/save")
	public Specialite createSpecialite(@RequestBody Specialite specialite) {
		return specialiteRepository.save(specialite);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Specialite> updateSpecialite(@PathVariable(value = "id") int specialiteId,
			@RequestBody Specialite specialiteDetails) {
		Specialite specialite = specialiteRepository.findById(specialiteId);
		if (specialite == null) {
			return ResponseEntity.notFound().build();
		}
		specialite.setNom(specialiteDetails.getNom());

		Specialite updatedSpecialite = specialiteRepository.save(specialite);
		return ResponseEntity.ok(updatedSpecialite);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Specialite> deleteSpecialite(@PathVariable(value = "id") int specialiteId) {
		Specialite specialite = specialiteRepository.findById(specialiteId);
		if (specialite == null) {
			return ResponseEntity.notFound().build();
		}
		specialiteRepository.delete(specialite);
		return ResponseEntity.ok().build();
	}

}