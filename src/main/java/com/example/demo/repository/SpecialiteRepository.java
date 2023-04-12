package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Specialite;



public interface SpecialiteRepository extends JpaRepository<Specialite, Integer> {

	List<Specialite> findAll();
	Specialite findById(int id);


}
