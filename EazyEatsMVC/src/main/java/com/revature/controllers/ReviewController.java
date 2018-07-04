package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.dao.ReviewDaoImpl;
import com.revature.exceptions.ReviewNotFoundException;
import com.revature.models.Review;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewDaoImpl rdi;
	
	//call with: URL/reviews
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/reviews")
	@ResponseBody
	public List<Review> getReviews(){
		return rdi.getReviews();
	}
	
	//call with: URL/reviews/{id} where id is from the ID column in REVIEW
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/reviews/{id}")
	@ResponseBody
	public Review getReviewById(@PathVariable("id") int id) {
		Review r = rdi.getReviewById(id);
		if(r == null) {
			throw new ReviewNotFoundException();
		}
		return r;
	}
	
	/**
	 * TODO
	 * need to resolve this with the frontend
	 */
	@RequestMapping(value="/reviews/search", method=RequestMethod.GET)
	public String getSearchPage() {
		return "SearchReview";
	}
	
	/**
	 * TODO
	 * need to resolve this with the frontend
	 */
	@PostMapping(value="/reviews/search")
	public String getReview(HttpServletRequest req) {
		String revId = req.getParameter("id");
		return "redirect:/reviews/"+revId;
	}
	
	//call with URL/reviews/create
	@RequestMapping(value="/reviews/create", method=RequestMethod.GET)
	public String getCreatePage() {
		return "NewReview";
	}
	
	//call with URL/reviews/create
	@RequestMapping(value="/reviews/create", method=RequestMethod.POST)
	public String addReview(@RequestParam("body") String body, @RequestParam("rating") int rating,
			@RequestParam("needsReview") boolean needsReview, @RequestParam("userId") int userId, 
			@RequestParam("restaurantId") int restaurantId) {
		rdi.createReview(new Review(body, rating, needsReview), userId, restaurantId);
		return "redirect:/NewReview.html";
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value="/reviews/{id}")
	public String updateRevie(@PathVariable("id") int id) {
	    Review review = rdi.getReviewById(id);
	    review.setNeedsReview(!review.isNeedsReview());
	    rdi.updateReview(review);
	    return "redirect/NewReview.html";
	}
	
	//call with URL/reviews/byUser/{id}
	//@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/reviews/byUser/{id}")
	@ResponseBody
	public List<Review> getReviewsUserId(@PathVariable("id") Integer id){
		return rdi.getReviewsByUserId(id);
	}
	
	//call with URL/reviews/byUser/{id}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/reviews/byRestaurant/{id}")
	@ResponseBody
	public List<Review> getReviewsRestaurantId(@PathVariable("id") Integer id){
		return rdi.getReviewsByRestaurantId(id);
	}
	

}
