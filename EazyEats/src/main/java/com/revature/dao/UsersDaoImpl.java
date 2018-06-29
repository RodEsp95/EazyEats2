package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Users;
import com.revature.util.HibernateUtil;

@Repository
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional
	public List<Users> getUsers() {
		Session s = sf.getCurrentSession();
		List<Users> users = s.createQuery("from Users").list();
		return users;
	}

	@Override
	@Transactional
	public Users getUserById(int id) {
		Session s = sf.getCurrentSession();
		Users foundUser = (Users) s.get(Users.class, id);
		//s.close();
		return foundUser;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int createUser(Users user) {
		Session s = sf.getCurrentSession();
		//Transaction tx = s.beginTransaction();
		//int created = (int) s.save(user);
		s.save(user);
		//tx.commit();
		//s.close();
		return 0;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateUser(Users user) {
		Session s = sf.getCurrentSession();
		//Transaction tx = s.beginTransaction();
		s.update(user);
		//tx.commit();
		//s.close();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteUserById(int id) {
		Session s = HibernateUtil.getSession();
		//Transaction tx = s.beginTransaction();
		Users current = (Users) s.get(Users.class, id);
		if(current != null) {
			s.delete(current);
		}
		//tx.commit();
		//s.close();
	}
	
	

}
