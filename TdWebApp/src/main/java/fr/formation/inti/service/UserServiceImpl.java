package fr.formation.inti.service;

import java.util.List;

import fr.formation.inti.dao.UserDaoImpl;
import fr.formation.inti.entity.User;

public class UserServiceImpl implements UserService{
	
	UserDaoImpl dao;
	
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}

	@Override
	public User findById(Integer id) {
		dao.beginTransaction();
		User c = dao.findById(id);
		dao.commit(true);
		return c;
	}

	@Override
	public List<User> findAll() {
		dao.beginTransaction();
		List<User> list = dao.findAll();
		dao.commit(true);
		return list;
	}

	@Override
	public Integer save(User c) {
		dao.beginTransaction();
		User user = dao.save(c);
		
		dao.commit(true);
		return user.getUserId();
	}

	@Override
	public void delete(User entiy) {
		dao.beginTransaction();
		dao.delete(entiy);
		dao.commit(true);
		
	}

	@Override
	public void deleteById(Integer id) {
		dao.beginTransaction();
		dao.deleteById(id);
		dao.commit(true);
		
	}

	@Override
	public User findByEmail(String email) {
		
			dao.beginTransaction();
			User c = dao.findbyEmail(email);
			dao.commit(true);
			return c;
		}

	@Override
	public void update(User c) {
		dao.beginTransaction();
		dao.update(c);
		dao.commit(true);
	}
	}

	
