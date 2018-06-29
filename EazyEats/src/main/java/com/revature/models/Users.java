package com.revature.models;

import java.util.List;

import javax.persistence.*;


@Entity
@Table
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userSequence")
	@SequenceGenerator(allocationSize=1, name="userSequence", sequenceName="SQ_USER_PK")
	@Column(name="USER_ID")
	private int id;
	@Column
	private String name;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String email;
	
	@Column 
	private String status;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="FAV_RESTAURANTS",
			joinColumns = {@JoinColumn(name="USER_ID")}, //cols from this table
			inverseJoinColumns = {@JoinColumn(name="RESTAURANT_ID")}) //cols from beehive table
	private List<Restaurant> favorites;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Users(String name, String username, String password, String email, String status, List<Restaurant> favorites) {
		super();
		//this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.status = status;
		this.favorites = favorites;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Restaurant> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Restaurant> favorites) {
		this.favorites = favorites;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((favorites == null) ? 0 : favorites.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Users other = (Users) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (favorites == null) {
			if (other.favorites != null)
				return false;
		} else if (!favorites.equals(other.favorites))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", email="
				+ email + ", status=" + status + ", favorites=" + favorites + "]";
	}

}
