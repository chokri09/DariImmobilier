package tn.dari.services;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.dari.entities.Gender;
import tn.dari.entities.Typerec;
import tn.dari.entities.User;
import tn.dari.repository.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService{
	

	
	@Autowired
	UserRepository x;

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		CustomerUserDetails userDetails = null ;
		
		if (user != null)
		{
			userDetails = new CustomerUserDetails();
			userDetails.setUser(user);
		}
		
		else{
			throw  new UsernameNotFoundException("user not exsit with name "+ username);
		}
		
		return userDetails;
	}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/// partie statistique //////////
		public 	String StatistiquesSelonSexeUsers (Gender gr){
			int Motif = userRepository.statisticsMotif(gr);
			int all = userRepository.statisticsAll();
			 double a = Motif*100 ;
			 
			 double b = a / all ;
			 System.out.print(b);
			 
			 if (b>50){
				 
				 return "la majorité des users de ce site sont des :"+ gr + " (s) et de taux qui s'éleve à: "+ b +" %";
			 }else 
				 return "la minorité des users de ce site sont des :" + gr + " (s) et de taux qui s'éleve à: "+ b +" %";
			
		}
		//end partie statisque

}
