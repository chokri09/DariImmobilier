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
import tn.dari.entities.SellingAnnonce;
import tn.dari.services.IannonceSellingService;

@RestController
@RequestMapping("/selling")
public class sellingAnnonceController {
	@Autowired
	IannonceSellingService annoncesellingService;
	
	@GetMapping(value = "/retrieves-all-sellingannonce")
	@ResponseBody
	public List<SellingAnnonce> getSellingAnnonce() {
		List<SellingAnnonce> list = annoncesellingService.retreiveAllSellingAnnonce();
		return list;
	}
	
	@PostMapping(value="save-selling-annonce")
	public SellingAnnonce saveSellingAnnonce(@RequestBody SellingAnnonce ann) {
		annoncesellingService.addSellingAnnonce(ann);
		return ann;
	
	}
	  //creating a put  mapping that upgrade rent annonce
  	@PutMapping("/update-sellannonce/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updateSellingAnnonce(
  		@RequestBody SellingAnnonce sellannonce,@PathVariable("id")int id) {
  		annoncesellingService.updateSellingAnnonce(sellannonce,id);
  		return new ResponseEntity<String>("Category updated successfully",HttpStatus.OK);
  		
  	}
	@DeleteMapping("/delete-sellingannonce/{id}")
  	@ResponseBody
  	public ResponseEntity<String>  deleteRentingannonce(
  		@RequestBody RentingAnnonce rentingannonce,@PathVariable("id")int id) {
		annoncesellingService.DeleteSellingAnnonce(id);
  	    return new ResponseEntity<String>("selling annonce deleted successfully",HttpStatus.ACCEPTED);
  		
  	}

}
