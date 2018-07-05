package com.revature.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.revature.models.Restaurant;
import com.revature.models.Review;
import com.revature.models.Users;
import com.revature.util.HibernateUtil;

@Repository
public class ReviewDaoImpl implements ReviewDao{

	//@Autowired
	//SessionFactory sf;
	
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
	public int createReview(Review r, Integer userId, Integer restaurantId) {
		Session s = HibernateUtil.getSession();
		UsersDaoImpl ud = new UsersDaoImpl();
		Users u1 = ud.getUserById(userId);
		r.setUser(u1);
		r.setRestaurantId(restaurantId);
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
	
	@Override
	public List<Review> getReviewsByUserId(Integer id){
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Review.class);
		//Where clause
		c.add(Restrictions.eq("user.id", id));
		//Had an issue with duplicate rows returning
		//Added this ResultTransformer to resolve that issue
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		List<Review> userReviews = c.list();
		s.close();
		return userReviews;
	}
	
	@Override
	public List<Review> getReviewsByRestaurantId(Integer id){
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Review.class);
		c.add(Restrictions.eq("restaurantId", id));
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Review> restaurantReviews = c.list();
		s.close();
		return restaurantReviews;
	}
	
	@Override
	public List<Review> getReviewsByNeedsReview(){
		Session s = HibernateUtil.getSession();
		Criteria c = s.createCriteria(Review.class);
		c.add(Restrictions.eq("needsReview", true));
		c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Review> needReviews = c.list();
		return needReviews;
	}
	

}
