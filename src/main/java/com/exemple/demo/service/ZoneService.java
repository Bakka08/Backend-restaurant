package com.exemple.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Zone;
import com.example.demo.idao.IDao;

import com.example.demo.repository.ZoneRepository;

public class ZoneService implements IDao<Zone> {

	@Autowired
	private ZoneRepository zoneRepository;

	@Override
	public void save(Zone o) {
		zoneRepository.save(o);

	}

	@Override
	public void delete(Zone o) {
		zoneRepository.delete(o);
	}

	@Override
	public void update(Zone o) {
		zoneRepository.save(o);
	}

	@Override
	public Zone FindById(int id) {
		return zoneRepository.findById(id);
	}

	@Override
	public List<Zone> findAll() {
		return zoneRepository.findAll();
	}

}