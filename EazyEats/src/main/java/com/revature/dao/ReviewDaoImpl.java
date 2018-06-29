package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Review;
import com.revature.util.HibernateUtil;

@Repository
public class ReviewDaoImpl implements ReviewDao{

	@Autowired
	SessionFactory sf;
	
	@Transactional
	public List<Review> getReviews() {
		Session s = sf.getCurrentSession();
		List<Review> reviews = s.createQuery("from Review").list();
		//s.close();
		return reviews;
	}

	@Transactional
	public Review getReviewById(int id) {
		Session s = sf.getCurrentSession();
		Review foundReview = (Review) s.get(Review.class, id);
		//s.close();
		return foundReview;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public int createReview(Review r) {
		Session s = sf.getCurrentSession();
		//Transaction tx = s.beginTransaction();
		int created = (int) s.save(r);
		//tx.commit();
		//s.close();
		return created;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void updateReview(Review r) {
		Session s = sf.getCurrentSession();
		//Transaction tx = s.beginTransaction();
		s.update(r);
		//tx.commit();
		//s.close();
		
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteReviewById(int id) {
		Session s = sf.getCurrentSession();
		//Transaction tx = s.beginTransaction();
		Review current = (Review) s.get(Review.class, id);
		if(current != null) {
			s.delete(current);
		}
		//tx.commit();
		//s.close();
		
	}

}
