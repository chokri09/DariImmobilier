package tn.dari.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.dari.entities.RentingAnnonce;
import tn.dari.services.AnnocceRentingImpl;
import tn.dari.services.IannonceRentingService;
import tn.dari.services.StripeService;

@RestController
@RequestMapping("/renting")
public class rentingAnnonceController {
	@Value("${stripe.key.public}")
	private String API_PUBLIC_KEY;
	private StripeService stripeService;
	
	
	public rentingAnnonceController(StripeService stripeService) {
		this.stripeService = stripeService;
	}
	
	@Autowired
	IannonceRentingService annoncerentingService;
	@Autowired
	AnnocceRentingImpl annr ;
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	@PostMapping("/uploadFile")
	public ResponseEntity<Object> fileUpload(@RequestParam("File") MultipartFile file) throws IOException{
		File myFile = new File(FILE_DIRECTORY+file.getOriginalFilename());
		System.out.print(myFile);
		myFile.createNewFile();		
		FileOutputStream fos =new FileOutputStream(myFile);
		fos.write(file.getBytes());
		fos.close();
		return new ResponseEntity<Object>("The File Uploaded Successfully", HttpStatus.OK);
	}

	
	@GetMapping(value = "/retrieves-all-rentingannonce")
	@ResponseBody
	public List<RentingAnnonce> getAnnonce() {
		List<RentingAnnonce> list = annoncerentingService.retreiveAllRentingAnnonce();
		return list;
	}
	
	@PostMapping(value="save-renting-annonce")
	public RentingAnnonce saveProduct(@RequestBody RentingAnnonce ann) 
	{
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
  	public ResponseEntity<String>  deleteRentingannonce(@PathVariable("id")int id) {
		annoncerentingService.DeleteRentingAnnonce(id);
  	    return new ResponseEntity<String>("Renting annonce deleted successfully",HttpStatus.ACCEPTED);
  		
  	}
	@GetMapping(value = "/estimation/{roomNumber}")
	@ResponseBody
	public  double Prediction(@PathVariable("roomNumber") int roomNumber){
		 return annr.EstimationByRoomNumber(roomNumber);	
	}
	@GetMapping(value = "/priceOfRent/{price}/{nb_jours}")
	@ResponseBody
	public  long PriceOfRent(@PathVariable("price") long price,@PathVariable("nb_jours") int nb_jours){
		 return annr.priceofRent(price, nb_jours);	
	}
	
	@PutMapping("/update-annAccepted/{annId}")
  	@ResponseBody
  	public ResponseEntity<String> updateRentannAccepted(@PathVariable("annId")int annId) {
		
		annoncerentingService.acceptAnnonceJPQL(annId);
  		return new ResponseEntity<String>("rent annonce updated successfully",HttpStatus.OK);
  		
  	}
	@PutMapping("/update-annDenied/{annId}")
  	@ResponseBody
  	public ResponseEntity<String> updateRentannDenied(@PathVariable("annId")int annId) {
		
		annr.DeniedAnnonceJPQL(annId);
  		return new ResponseEntity<String>("rent annonce updated successfully",HttpStatus.OK);
  		
  	}
	@GetMapping(value = "/Total/{id}")
	@ResponseBody
	public  long PriceOfRents(@PathVariable("id") int id){
		 return annr.TotalAPaye(id);	
	}
	@PostMapping(value = "/payement/{email}/{token}/{id}")
	public  String PayerRent(@PathVariable String email,@PathVariable String token,@PathVariable int id){
		int price = (int) PriceOfRents(id);
		return stripeService.createCharge(email, token,price);
	}
	@GetMapping(value = "/search/{keyword}")
     public List<RentingAnnonce> dynamicSearch(@PathVariable String keyword){
		return annr.DynamicSearch(keyword);
    	 
     }
	@GetMapping(value = "/actualite")
    public List<RentingAnnonce> latestRentingAnnonce(){
		return annr.latestRentingAnnonce();
   	 
    }
	@GetMapping(value = "/BestReviewed")
    public List<RentingAnnonce> BestReviewed(){
		return annr.BestReviewed();
   	 
    }
	@PutMapping("/addfavorit/{annId}")
  	@ResponseBody
  	public ResponseEntity<String> AddAnnoncetoFavorite(@PathVariable("annId")int annId) {
		
		annr.AddAnnnonceToFavorite(annId);;
  		return new ResponseEntity<String>("annonce added to favorite",HttpStatus.OK);
  		
  	}
	@GetMapping(value = "/MyFavoritAnn/{userId}")
	public List<RentingAnnonce> ListOfmyFavoriteAnnonce(@PathVariable int userId){
		return annr.ListOfMyFavoriteAnnonce(userId);
	}
	@GetMapping(value = "/MyInprogressList/{userId}")
	public List<RentingAnnonce> MyInprogressList(@PathVariable int userId){
		return annr.MyInprogressList(userId);
	}

}