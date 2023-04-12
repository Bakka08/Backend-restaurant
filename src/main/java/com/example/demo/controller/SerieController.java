package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Serie;
import com.example.demo.repository.SerieRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping("/api/serie")
public class SerieController {

	@Autowired
	private SerieRepository serieRepository;

	@GetMapping("/all")
	public List<Serie> getAllSeries() {
		return serieRepository.findAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Serie> getSerieById(@PathVariable(value = "id") int serieId) {
		Serie serie = serieRepository.findById(serieId);
		if (serie == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(serie);
	}

	@PostMapping("/save")
	public Serie createSerie(@RequestBody Serie serie) {
		return serieRepository.save(serie);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Serie> updateSerie(@PathVariable(value = "id") int serieId,
			@RequestBody Serie serieDetails) {
		Serie serie = serieRepository.findById(serieId);
		if (serie == null) {
			return ResponseEntity.notFound().build();
		}
		serie.setNom(serieDetails.getNom());


		Serie updatedSerie = serieRepository.save(serie);
		return ResponseEntity.ok(updatedSerie);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Serie> deleteSerie(@PathVariable(value = "id") int serieId) {
		Serie serie = serieRepository.findById(serieId);
		if (serie == null) {
			return ResponseEntity.notFound().build();
		}
		serieRepository.delete(serie);
		return ResponseEntity.ok().build();
	}

}

