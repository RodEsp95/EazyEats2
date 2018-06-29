package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Review;
import com.revature.util.HibernateUtil;

public class ReviewDaoImpl implements ReviewDao{

	@Override
	public List<Review> getReviews() {
		Session s = HibernateUtil.getSession();
		List<Review> reviews = s.createQuery("from Review").list();
		s.close();
		return reviews;
	}

	@Override
	public Review getReviewById(int id) {
		Session s = HibernateUtil.getSession();
		Review foundReview = (Review) s.get(Review.class, id);
		s.close();
		return foundReview;
	}

	@Override
	public int createReview(Review r) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int created = (int) s.save(r);
		tx.commit();
		s.close();
		return created;
	}

	@Override
	public void updateReview(Review r) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(r);
		tx.commit();
		s.close();
		
	}

	@Override
	public void deleteReviewById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Review current = (Review) s.get(Review.class, id);
		if(current != null) {
			s.delete(current);
		}
		tx.commit();
		s.close();
		
	}

}
