package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private String description;
	private double latitude;
	private double longitude;
	private String hourOpened;
	private String hourClosed;
	
	@ManyToOne
	private Zone zone;

	@ManyToOne
	private Serie serie;
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
	private List<Photo> photos;
	@JsonIgnore
	@ManyToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
	private List<Specialite> specialite;
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
	private List<User> user;

	public Restaurant() {

	}

	public Restaurant(String nom, String adresse, String description, double latitude, double longitude,
			String hourOpened, String hourClosed, Zone zone, Serie serie) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.hourOpened = hourOpened;
		this.hourClosed = hourClosed;
		this.zone = zone;
		this.serie = serie;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getHourOpened() {
		return hourOpened;
	}

	public void setHourOpened(String hourOpened) {
		this.hourOpened = hourOpened;
	}

	public String getHourClosed() {
		return hourClosed;
	}

	public void setHourClosed(String hourClosed) {
		this.hourClosed = hourClosed;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public List<Specialite> getSpecialite() {
		return specialite;
	}

	public void setSpecialite(List<Specialite> specialites) {
		this.specialite = specialites;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

}
