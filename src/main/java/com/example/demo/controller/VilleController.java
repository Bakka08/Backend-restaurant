package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Restaurant;
import com.example.demo.entity.Specialite;
import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.repository.VilleRepository;
import com.example.demo.repository.ZoneRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/villes")
public class VilleController {
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private ZoneRepository zoneRepository;

	@GetMapping("/all")
	public List<Ville> getAllVilles() {
		return villeRepository.findAll();
	}

	@GetMapping("/{nomVille}/zones")
	public List<Zone> getZonesForVille(@PathVariable String nomVille) {
		Ville ville = villeRepository.findByNom(nomVille);
		return ville.getZones();
	}

	@GetMapping("/{ville}/zones/{zone}/restaurants")
	public List<Restaurant> getRestaurantsByZone(@PathVariable("ville") String villeNom,
			@PathVariable("zone") String zoneNom) {
		Ville ville = villeRepository.findByNom(villeNom);
		Zone zone = zoneRepository.findByNomAndVilleNom(zoneNom, ville.getNom());
		return zone.getRestaurants();
	}

	@GetMapping("/{ville}/zones/{zone}/restaurants/specialite={specialite}")
	public List<Restaurant> getRestaurantsBySpecialite(@PathVariable String ville, @PathVariable String zone,
			@PathVariable String specialite) {
		Ville v = villeRepository.findByNom(ville);
		Zone z = zoneRepository.findByNomAndVilleNom(zone, v.getNom());
		List<Restaurant> restaurants = z.getRestaurants();
		List<Restaurant> filteredRestaurants = new ArrayList<>();
		for (Restaurant r : restaurants) {
			for (Specialite s : r.getSpecialite()) {
				if (s.getNom().equals(specialite)) {
					filteredRestaurants.add(r);
					break;
				}
			}

		}
		return filteredRestaurants;
	}

	@GetMapping("/{ville}/zones/{zone}/restaurants/serie={serie}")
	public List<Restaurant> getRestaurantsBySerie(@PathVariable String ville, @PathVariable String zone,
			@PathVariable String serie) {
		Ville v = villeRepository.findByNom(ville);
		Zone z = zoneRepository.findByNomAndVilleNom(zone, v.getNom());
		List<Restaurant> restaurants = z.getRestaurants();
		List<Restaurant> filteredRestaurants = new ArrayList<>();
		for (Restaurant r : restaurants) {

			if (r.getSerie().getNom().equals(serie)) {
				filteredRestaurants.add(r);

			}

		}
		return filteredRestaurants;
	}

	@GetMapping("/{ville}/zones/{zone}/restaurants/{id}")
	public List<Restaurant> getRestaurantsByZoneAndId(@PathVariable String ville, @PathVariable String zone,
			@PathVariable int id) {
		Ville v = villeRepository.findByNom(ville);
		Zone z = zoneRepository.findByNomAndVilleNom(zone, v.getNom());
		List<Restaurant> restaurants = z.getRestaurants();
		List<Restaurant> filteredRestaurants = new ArrayList<>();
		for (Restaurant r : restaurants) {

			if (r.getId() == id) {
				filteredRestaurants.add(r);

			}

		}
		return filteredRestaurants;
	}
	
	@GetMapping("/{ville}/zones/{zone}/restaurants/specialite={specialite}/serie={serie}")
	public List<Restaurant> getRestaurantsBySpecialiteAndSerie(@PathVariable String ville, @PathVariable String zone,
			@PathVariable String specialite,@PathVariable String serie) {
		Ville v = villeRepository.findByNom(ville);
		Zone z = zoneRepository.findByNomAndVilleNom(zone, v.getNom());
		List<Restaurant> restaurants = z.getRestaurants();
		List<Restaurant> filteredRestaurants = new ArrayList<>();
		for (Restaurant r : restaurants) {
			for (Specialite s : r.getSpecialite()) {
				if (s.getNom().equals(specialite)) {
					if(r.getSerie().getNom().equals(serie)) {
						filteredRestaurants.add(r);
					}
					
					break; 
				}
			}

		}
		return filteredRestaurants;
	}
	
	
	   @PostMapping("/save")
	    public ResponseEntity<Ville> createVille(@RequestBody Ville ville) {
	        Ville savedVille = villeRepository.save(ville);
	        return ResponseEntity.created(URI.create("/villes/" + savedVille.getId())).body(savedVille);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Ville> updateVille(@PathVariable int id, @RequestBody Ville ville) {
	        Ville existingVille = villeRepository.findById(id);
	        if (existingVille != null) {
	            ville.setId(id);
	            Ville updatedVille = villeRepository.save(ville);
	            return ResponseEntity.ok(updatedVille);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteVille(@PathVariable int id) {
	        Ville existingVille = villeRepository.findById(id);
	        if (existingVille != null) {
	            villeRepository.delete(existingVille);
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<Ville> getVilleById(@PathVariable int id) {
	        Ville ville = villeRepository.findById(id);
	        if (ville != null) {
	            return ResponseEntity.ok(ville);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}

