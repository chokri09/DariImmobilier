package tn.dari.services;

import java.util.List;

import tn.dari.entities.User;

public interface IuserService {
	public User addUser(User user);
	public void updateUser(User user ,int id);
	public void DeleteUser(int id);
	public List<User> retreiveAllUser() ;
}
