package com.exemple.demo.service;

import java.util.List;

import com.example.demo.entity.Specialite;
import com.example.demo.idao.IDao;
import com.example.demo.repository.SpecialiteRepository;

public class SpecialiteService implements IDao<Specialite> {
	SpecialiteRepository specialiteRepository;

	@Override
	public void save(Specialite o) {
		specialiteRepository.save(o);

	}

	@Override
	public void delete(Specialite o) {
		specialiteRepository.delete(o);

	}

	@Override
	public void update(Specialite o) {
		specialiteRepository.save(o);

	}

	@Override
	public Specialite FindById(int id) {

		return specialiteRepository.findById(id);
	}

	@Override
	public List<Specialite> findAll() {

		return specialiteRepository.findAll();
	}

}
