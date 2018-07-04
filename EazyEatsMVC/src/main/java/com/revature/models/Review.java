package com.revature.models;

import javax.persistence.*;

@Entity
@Table
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reviewSequence")
	@SequenceGenerator(allocationSize=1, name="reviewSequence", sequenceName="SQ_REVIEW_PK")
	@Column(name="REVIEW_ID")
	private int id;
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Users user;
	//@ManyToOne
	//@JoinColumn(name="RESTAURANT_ID")
	//@Transient
	@Column
	private Integer restaurantId;
	@Column
	private String body;
	@Column
	private int rating;
	@Column(name="FLAGGED")
	private boolean needsReview;
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Review(String body, int rating, boolean needsReview) {
		super();
		this.body = body;
		this.rating = rating;
		this.needsReview = needsReview;
	}
	
	
	
	
	public Review(Users user, Integer restaurantId, String body, int rating, boolean needsReview) {
		super();
		this.user = user;
		this.restaurantId = restaurantId;
		this.body = body;
		this.rating = rating;
		this.needsReview = needsReview;
	}
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public boolean isNeedsReview() {
		return needsReview;
	}
	public void setNeedsReview(boolean needsReview) {
		this.needsReview = needsReview;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + id;
		result = prime * result + (needsReview ? 1231 : 1237);
		result = prime * result + rating;
		result = prime * result + ((restaurantId == null) ? 0 : restaurantId.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (id != other.id)
			return false;
		if (needsReview != other.needsReview)
			return false;
		if (rating != other.rating)
			return false;
		if (restaurantId == null) {
			if (other.restaurantId != null)
				return false;
		} else if (!restaurantId.equals(other.restaurantId))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", user=" + user + ", restaurantId=" + restaurantId + ", body=" + body + ", rating="
				+ rating + ", needsReview=" + needsReview + "]";
	}
	
	
	

	
	
	
	
	
	
	
}
