package com.revature.dao;

import java.util.List;

import com.revature.models.Users;

public interface UsersDao {
	
	public List<Users> getUsers();
	public Users getUserById(int id);
	public int createUser (Users user);
	public void updateUser(Users user);
	public void deleteUserById(int id);

}
