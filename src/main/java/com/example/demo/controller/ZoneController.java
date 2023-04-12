package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {
	
	@Autowired
	private ZoneRepository zoneRepository;
	
	@GetMapping("/all")
	public List<Zone> getAllZones() {
		List<Zone> zones = zoneRepository.findAll();
		return zones;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Zone> getZoneById(@PathVariable("id") int id) {
		Zone zone = zoneRepository.findById(id);
		if (zone == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(zone, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Zone> createZone(@RequestBody Zone zone) {
		Zone savedZone = zoneRepository.save(zone);
		return new ResponseEntity<>(savedZone, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Zone> updateZone(@PathVariable("id") int id, @RequestBody Zone zone) {
		Zone existingZone = zoneRepository.findById(id);
		if (existingZone == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		existingZone.setNom(zone.getNom());
		existingZone.setVille(zone.getVille());
		Zone updatedZone = zoneRepository.save(existingZone);
		return new ResponseEntity<>(updatedZone, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteZone(@PathVariable("id") int id) {
		Zone existingZone = zoneRepository.findById(id);
		if (existingZone == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		zoneRepository.delete(existingZone);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
