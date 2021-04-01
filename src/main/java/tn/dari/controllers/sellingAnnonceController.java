package tn.dari.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import tn.dari.repository.IannonceSellingRepository;
import tn.dari.services.AnnocceRentingImpl;
import tn.dari.services.IannonceSellingService;
import tn.dari.services.StripeService;

@RestController
@RequestMapping("/selling")

public class sellingAnnonceController {
	@Value("${stripe.key.public}")
	private String API_PUBLIC_KEY;
	private StripeService stripeService;
	
	public sellingAnnonceController(StripeService stripeService) {
		this.stripeService = stripeService;
	}
	@Autowired
	IannonceSellingService annoncesellingService;
	@Autowired
	IannonceSellingRepository annr ;
	@Autowired 
	AnnocceRentingImpl annI ;
	
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
	@PutMapping("/update-annAccepted/{annId}")
  	@ResponseBody
  	public ResponseEntity<String> updateRentannAccepted(@PathVariable("annId")int annId) {
		
		annr.acceptAnnonceJPQL(annId);
  		return new ResponseEntity<String>("rent annonce updated successfully",HttpStatus.OK);
  		
  	}
	@PutMapping("/update-annDenied/{annId}")
  	@ResponseBody
  	public ResponseEntity<String> updateRentannDenied(@PathVariable("annId")int annId) {
		
		annr.DeniedAnnonceJPQL(annId);
  		return new ResponseEntity<String>("rent annonce updated successfully",HttpStatus.OK);
  		
  	}
	@GetMapping(value = "/estimation/{roomNumber}")
	@ResponseBody
	public  double Prediction(@PathVariable("roomNumber") int roomNumber){
		 return annI.EstimationByRoomNumber(roomNumber);	
	}
	@PostMapping(value = "/payement/{email}/{token}/{id}")
	public  String PayerRent(@PathVariable String email,@PathVariable String token,@PathVariable int id){
		int price = (int) annr.Price(id);
		return stripeService.createCharge(email, token,price);
	}

}
