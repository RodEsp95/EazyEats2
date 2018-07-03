package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/reviews")
	@ResponseBody
	public List<Review> getReviews(){
		return rdi.getReviews();
	}
	
	//call with: URL/reviews/{id} where id is from the ID column in REVIEW
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
			@RequestParam("needsReview") boolean needsReview) {
		rdi.createReview(new Review(body, rating, needsReview));
		return "redirect:/NewReview.html";
		
	}
	
	//call with URL/reviews/byUser/{id}
	@GetMapping("/reviews/byUser/{id}")
	@ResponseBody
	public List<Review> getReviewsUserId(@PathVariable("id") Integer id){
		return rdi.getReviewsByUserId(id);
	}
	
	//call with URL/reviews/byUser/{id}
	@GetMapping("/reviews/byRestaurant/{id}")
	@ResponseBody
	public List<Review> getReviewsRestaurantId(@PathVariable("id") Integer id){
		return rdi.getReviewsByRestaurantId(id);
	}
	

}
