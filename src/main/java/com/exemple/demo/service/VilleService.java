package com.exemple.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Ville;
import com.example.demo.idao.IDao;

import com.example.demo.repository.VilleRepository;

public class VilleService implements IDao<Ville> {

	@Autowired
	private VilleRepository villeRepository;

	@Override
	public void save(Ville o) {
		villeRepository.save(o);

	}

	@Override
	public void delete(Ville o) {
		villeRepository.delete(o);
	}

	@Override
	public void update(Ville o) {
		villeRepository.save(o);
	}

	@Override
	public Ville FindById(int id) {
		return villeRepository.findById(id);
	}

	@Override
	public List<Ville> findAll() {
		return villeRepository.findAll();
	}

}