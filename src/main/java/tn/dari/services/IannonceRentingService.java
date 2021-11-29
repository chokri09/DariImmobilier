package tn.dari.services;

import java.util.List;

import tn.dari.entities.RentingAnnonce;

public interface IannonceRentingService {
	//serivice for renting annonce
	public RentingAnnonce addRentingAnnonce(RentingAnnonce ann);
	public void updateRentingAnnonce(RentingAnnonce ann ,int id);
	public void DeleteRentingAnnonce(int id);
	public List<RentingAnnonce> retreiveAllRentingAnnonce() ;
	void acceptAnnonceJPQL(int annId);
	
	
}
