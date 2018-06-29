package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.revature.models.Users;
import com.revature.util.HibernateUtil;

public class UsersDaoImpl implements UsersDao{

	@Override
	public List<Users> getUsers() {
		Session s = HibernateUtil.getSession();
		List<Users> users = s.createQuery("from Users").list();
		s.close();
		return users;
	}

	@Override
	public Users getUserById(int id) {
		Session s = HibernateUtil.getSession();
		Users foundUser = (Users) s.get(Users.class, id);
		s.close();
		return foundUser;
	}

	@Override
	public int createUser(Users user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int created = (int) s.save(user);
		tx.commit();
		s.close();
		return created;
	}

	@Override
	public void updateUser(Users user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(user);
		tx.commit();
		s.close();
	}

	@Override
	public void deleteUserById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Users current = (Users) s.get(Users.class, id);
		if(current != null) {
			s.delete(current);
		}
		tx.commit();
		s.close();
	}
	
	

}
