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
	
	@GetMapping("/reviews")
	public List<Review> getReviews(){
		return rdi.getReviews();
	}
	
	@GetMapping("/reviews/{id}")
	@ResponseBody
	public Review getReviewById(@PathVariable("id") int id) {
		Review r = rdi.getReviewById(id);
		if(r == null) {
			throw new ReviewNotFoundException();
		}
		return r;
	}
	
	@RequestMapping(value="/reviews/search", method=RequestMethod.GET)
	public String getSearchPage() {
		return "SearchReview";
	}
	
	@PostMapping(value="/reviews/search")
	public String getReview(HttpServletRequest req) {
		String revId = req.getParameter("id");
		return "redirect:/reviews/"+revId;
	}
	
	@RequestMapping(value="/reviews/create", method=RequestMethod.GET)
	public String getCreatePage() {
		return "NewReview";
	}
	
	@RequestMapping(value="/reviews/create", method=RequestMethod.POST)
	public String addReview(@RequestParam("body") String body, @RequestParam("rating") int rating,
			@RequestParam("needsReview") boolean needsReview) {
		rdi.createReview(new Review(body, rating, needsReview));
		return "redirect:/NewReview.html";
		
	}
	

}
