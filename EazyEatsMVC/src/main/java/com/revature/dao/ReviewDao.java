package com.revature.dao;

import java.util.List;

import com.revature.models.Review;

public interface ReviewDao {
	
	public List<Review> getReviews();
	public Review getReviewById(int id);
	public int createReview(Review r, Integer userId, Integer restaurantId);
	public void updateReview(Review r);
	public void deleteReviewById(int id);
	public List<Review> getReviewsByUserId(Integer id);
	public List<Review> getReviewsByRestaurantId(Integer id);
	public List<Review> getReviewsByNeedsReview();

}
