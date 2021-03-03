package tn.dari.services;

import java.util.List;

import tn.dari.entities.SellingAnnonce;

public interface IannonceSellingService {
	
	//service for selling
	public SellingAnnonce addSellingAnnonce(SellingAnnonce ann);
	public void updateSellingAnnonce(SellingAnnonce ann ,int id);
	public void DeleteSellingAnnonce(int id);
	public List<SellingAnnonce> retreiveAllSellingAnnonce() ;
}
