package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	Restaurant findById(int id);

	@Query("SELECT r FROM Restaurant r WHERE r.zone.id = :zoneId")
	List<Restaurant> findByZone(@Param("zoneId") int zoneId);

	@Query("SELECT r FROM Restaurant r JOIN r.zone z JOIN r.serie s WHERE z.id = :zone AND s.id = :serie")
	List<Restaurant> findByZoneAndSerie(int zone, int  serie);

	@Query("SELECT r FROM Restaurant r WHERE r.nom = :nom AND r.adresse = :adresse AND r.description = :description ")
	Restaurant findByNomAndAdresseAndDescriptionAndLatitudeAndLongitude(@Param("nom") String nom, @Param("adresse") String adresse, @Param("description") String description);


}
