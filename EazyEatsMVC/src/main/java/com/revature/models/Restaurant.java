package com.revature.models;

import javax.persistence.*;

@Entity
@Table
public class Restaurant {
	//Later remove generatedValue annotations
	@Id
	@Column(name="RESTAURANT_ID")
	private int id;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Restaurant(int id) {
		super();
		this.id = id;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Restaurant other = (Restaurant) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
