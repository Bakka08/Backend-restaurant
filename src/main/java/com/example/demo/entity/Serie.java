package com.example.demo.entity;





import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    
     @JsonIgnore
    @OneToMany (mappedBy = "serie", fetch = FetchType.EAGER)
    private List<Restaurant> restaurants;
    
    
    public Serie() {
    }

    
	public Serie(String nom) {
		
		this.nom = nom;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Restaurant> getRestaurants() {
		return restaurants;
	}


	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}






}

