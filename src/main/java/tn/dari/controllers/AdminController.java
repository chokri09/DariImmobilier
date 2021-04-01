package tn.dari.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.Gender;
import tn.dari.entities.Typerec;
import tn.dari.entities.User;
import tn.dari.repository.UserRepository;
import tn.dari.services.CustomUserDetailService;
import tn.dari.services.UserExcelExporter;
import tn.dari.services.UserService;

@RestController
@RequestMapping("/secure/auth")
public class AdminController {
	
	@Autowired
	private CustomUserDetailService usr ;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	UserService US;
	
	
	//http://localhost:8084/secure/auth/admin/add
	@PostMapping("/admin/add")
	public String addUser( @RequestBody User user)
	{
		String pwd = user.getPassword();
		String encreptedPWD = passwordEncoder.encode(pwd);
		user.setPassword(encreptedPWD);
		userRepository.save(user);
		
		return "employé ajouté";
		
	}
	
	//http://localhost:8084/secure/auth/statistic/femme
	 @GetMapping("/statistic/{gender}")
	  	@ResponseBody
	  	public String Stat(@PathVariable("gender")Gender t) {
		return	usr.StatistiquesSelonSexeUsers(t);
	  		
	  		
	  	}
	 
	 
	 //http://localhost:8084/secure/auth/searsh/chokri
	 @GetMapping("/searsh/{m}")
	 @ResponseBody
	 public User advancedSearsh(@PathVariable() String m){ 
		 return US.advancedSearsh(m) ;
	 }
	 
	 
	 //http://localhost:8084/secure/auth/block/1
	 @PutMapping("/block/{id}")
	 @ResponseBody
	 public String block(@PathVariable("id") int id){ 
		 return US.BlockUserAccount(id) ;
	 }
	 
	 
	 
	 
	 //http://localhost:8084/secure/auth/unlock/1
	 @PutMapping("/unlock/{id}")
	 @ResponseBody
	 public String unlockUserAccount(@PathVariable("id") int id){ 
		 return US.deBlockUserAccount(id) ;
	 }
	
	 
	 //http://localhost:8084/secure/auth/users/exportexcel
	 @GetMapping("/users/exportexcel")
	 public void exportExcel(HttpServletResponse response) throws IOException{
		 response.setContentType("application/octet-stream");
		 String headerKey = "Content-Disposition";
		 String headerValue = "attachement; filename=users.xlsx";
		 
		 response.setHeader(headerKey, headerValue);
		 
		 
		 List<User>listUsers = (List<User>) US.listAll();
		 
		 UserExcelExporter excelExporter = new UserExcelExporter(listUsers);
		 excelExporter.export(response);
	 }
	 //http://localhost:8084/secure/auth/signaler/1
	 @PutMapping("/signaler/{id}")
	 @ResponseBody
	 public String SignalUser(@PathVariable("id") int id){
		return US.signalUser(id);	
	}
	 
	//http://localhost:8084/secure/auth/getidhttp://localhost:8084/secure/auth/getid
	 @GetMapping(value = "/getid")
		@ResponseBody
		public int getUserId() {
			
			return US.GetIdConnectedUser();
	 }		
}
