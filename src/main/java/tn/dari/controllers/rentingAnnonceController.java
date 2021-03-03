package tn.dari.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.RentingAnnonce;
import tn.dari.services.IannonceRentingService;

@RestController
@RequestMapping("/renting")
public class rentingAnnonceController {
	@Autowired
	IannonceRentingService annoncerentingService;
	
	@GetMapping(value = "/retrieves-all-rentingannonce")
	@ResponseBody
	public List<RentingAnnonce> getAnnonce() {
		List<RentingAnnonce> list = annoncerentingService.retreiveAllRentingAnnonce();
		return list;
	}
	
	@PostMapping(value="save-renting-annonce")
	public RentingAnnonce saveProduct(@RequestBody RentingAnnonce ann) {
		annoncerentingService.addRentingAnnonce(ann);
		return ann;
	
	}
	  //creating a put  mapping that upgrade rent annonce
  	@PutMapping("/update-rentannonce/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateRentAnnonce(
  		@RequestBody RentingAnnonce rentannonce,@PathVariable("id")int id) {
  		annoncerentingService.updateRentingAnnonce(rentannonce,id);
  		return new ResponseEntity<String>("rent annonce updated successfully",HttpStatus.OK);
  		
  	}
	@DeleteMapping("/delete-rentingannonce/{id}")
  	@ResponseBody
  	public ResponseEntity<String>  deleteRentingannonce(
  		@RequestBody RentingAnnonce rentingannonce,@PathVariable("id")int id) {
		annoncerentingService.DeleteRentingAnnonce(id);
  	    return new ResponseEntity<String>("Renting annonce deleted successfully",HttpStatus.ACCEPTED);
  		
  	}
  
}
