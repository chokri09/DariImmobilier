package tn.dari.controllers;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.entities.Reclamation;
import tn.dari.entities.Typerec;
import tn.dari.services.IreclamationService;
import tn.dari.services.ReclamationImpl;
@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
	
	@Autowired
	IreclamationService reclamationservice;
	@Autowired
	ReclamationImpl recImpl;
	
	@GetMapping(value = "/retrieves-all-reclamation")
	@ResponseBody
	public List<Reclamation> getReclamation() {
		List<Reclamation> list = reclamationservice.retreiveAllReclamation();
		return list;
	}
	@PostMapping(value="save-reclamation")
	public Reclamation saveRecalamtion(@RequestBody Reclamation rec) {
		reclamationservice.addReclamation(rec);
		return rec;
	
	}
	@PutMapping("/update-reclamation/{id}")
  	@ResponseBody
  	public ResponseEntity<String> updatereclamation(@RequestBody Reclamation rec,@PathVariable("id")int id) {
		reclamationservice.updateReclamation(rec, id);
  		return new ResponseEntity<String>("Reclamation updated successfully",HttpStatus.OK);
  		
  	}
	
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deletePost(@PathVariable int id){
		
		reclamationservice.DeleteReclamation(id);
		
		return new ResponseEntity<String>("reclamation supprimé",HttpStatus.OK);
	}
	
	@PutMapping("/repondre/{id}")
  	@ResponseBody
  	public ResponseEntity<String> reponse(@RequestBody Reclamation rec,@PathVariable("id")int id) {
		recImpl.repondreReclamation(rec, id);
  		return new ResponseEntity<String>("message envoyé",HttpStatus.OK);
  		
  	}
	
	@GetMapping(value = "/nbr")
	@ResponseBody
	public  int countRecNonTraitees(){
		 return recImpl.NombreReclamationNonTraitees();
				
		
	} 
	
	//Methode findAll() paramétrée pour les statistiques graphique////////////////////////////

    @RequestMapping(value ="findall", method= RequestMethod.GET,produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Reclamation>> findAll(){
		try {
			return new ResponseEntity<List<Reclamation>>(reclamationservice.retreiveAllReclamation(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Reclamation>>(HttpStatus.BAD_REQUEST);
		}
		
	}
    
    /////////////////////////////////////////////////////// fin /////////////
    
    
    
    @GetMapping("/statistique/{type}")
  	@ResponseBody
  	public double Stat(@PathVariable("type")Typerec t) {
	return	recImpl.StatistiquesSelonTypeReclamation(t);
  		
  		
  	}
    
    
    
}
