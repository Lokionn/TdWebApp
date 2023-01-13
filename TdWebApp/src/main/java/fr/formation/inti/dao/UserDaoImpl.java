package fr.formation.inti.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

import fr.formation.inti.entity.User;

public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao{

	@Override
	public User findbyEmail(String email) {
		String hql = "from User where email = :email";
		Query query = session.createQuery(hql);
		query.setParameter("email", email);
		User user = (User) query.uniqueResult();
		return user;
	}
	
//	public static void main(String[] args) {
//		UserDaoImpl dao  = new UserDaoImpl();
//		dao.beginTransaction();
//		User user = dao.findbyEmail("premiereadress@gmail.com");
//		System.out.println(user);
//		dao.commit(false);
//	}

	
}
