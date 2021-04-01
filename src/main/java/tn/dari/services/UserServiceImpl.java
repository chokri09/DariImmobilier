package tn.dari.services;

import java.util.List;

import tn.dari.entities.User;
import tn.dari.repository.UserRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements IuserService{
	
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepository ur;
	@Override
	public User addUser(User user) {
		return ur.save(user);
	}

	@Override
	public void updateUser(User user, int id) {
		User us = ur.findById(id).get();
		us.setLastName(us.getLastName());
		us.setFirstName(us.getFirstName());
		us.setPicture(us.getPicture());
		us.setAdresse(us.getAdresse());
		us.setActif(us.isActif());
		us.setGender(us.getGender());
		us.setRole(us.getRole());
		us.setTelephone(us.getTelephone());
		us.setEmail(us.getEmail());
		us.setPassword(us.getPassword());
		ur.save(us);
		
	}

	@Override
	public void DeleteUser(int id) {
	ur.deleteById(id);
		
	}

	@Override
	public List<User> retreiveAllUser() {
		List<User> user = (List<User>) ur.findAll();
		for(User usr : user) {
			l.info("prod +++ :" + usr);
		}
		return user;
	}

}
