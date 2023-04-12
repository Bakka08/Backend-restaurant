package com.exemple.demo.service;

import java.util.List;

import com.example.demo.entity.Photo;
import com.example.demo.idao.IDao;
import com.example.demo.repository.PhotoRepository;

public class PhotoService implements IDao<Photo> {
	PhotoRepository photoRepository;

	@Override
	public void save(Photo o) {
		// TODO Auto-generated method stub
		photoRepository.save(o);

	}

	@Override
	public void delete(Photo o) {
		// TODO Auto-generated method stub
		photoRepository.delete(o);

	}

	@Override
	public void update(Photo o) {
		// TODO Auto-generated method stub
		photoRepository.save(o);

	}

	@Override
	public Photo FindById(int id) {
		// TODO Auto-generated method stub
		return photoRepository.findById(id);
	}

	@Override
	public List<Photo> findAll() {
		// TODO Auto-generated method stub
		return photoRepository.findAll();
	}

}
