package com.exemple.demo.service;

import java.util.List;

import com.example.demo.entity.Role;
import com.example.demo.idao.IDao;
import com.example.demo.repository.RoleRepository;

public class RoleService implements IDao<Role> {
	RoleRepository rolerepository;

	@Override
	public void save(Role o) {
		// TODO Auto-generated method stub
		rolerepository.save(o);

	}

	@Override
	public void delete(Role o) {
		// TODO Auto-generated method stub
		rolerepository.delete(o);

	}

	@Override
	public void update(Role o) {
		// TODO Auto-generated method stub
		rolerepository.save(o);

	}



	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return rolerepository.findAll();
	}

	@Override
	public Role FindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
