package com.exemple.demo.service;

import java.util.List;

import com.example.demo.entity.Serie;
import com.example.demo.idao.IDao;
import com.example.demo.repository.SerieRepository;

public class SerieService implements IDao<Serie>{
SerieRepository serieRepository;
	@Override
	public void save(Serie o) {
		serieRepository.save(o);
		
	}

	@Override
	public void delete(Serie o) {
		serieRepository.delete(o);
		
	}

	@Override
	public void update(Serie o) {
		serieRepository.save(o);
		
	}

	@Override
	public Serie FindById(int id) {
		// TODO Auto-generated method stub
		return serieRepository.findById(id);
	}

	@Override
	public List<Serie> findAll() {
		// TODO Auto-generated method stub
		return serieRepository.findAll();
	}

}
