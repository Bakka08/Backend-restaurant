package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.demo.entity.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {

	Zone findById(int id);

	Zone findByNom(String nomZone);
	
	@Query("SELECT z FROM Zone z WHERE z.nom = :nom AND z.ville.nom = :villeNom")
	Zone findByNomAndVilleNom(@Param("nom") String nom, @Param("villeNom") String villeNom);

}

