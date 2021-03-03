package tn.dari.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Annonce;
import tn.dari.entities.RentingAnnonce;
import tn.dari.entities.SellingAnnonce;
import tn.dari.repository.IannonceSellingRepository;
@Service
public class AnnonceSellingImpl implements IannonceSellingService {

	private static final Logger l = LogManager.getLogger(AnnocceRentingImpl.class);
	@Autowired
IannonceSellingRepository annoncesellingrepository ;
	@Override
	public SellingAnnonce addSellingAnnonce(SellingAnnonce ann) {
		return annoncesellingrepository.save(ann);
	}



	@Override
	public void DeleteSellingAnnonce(int id) {
		annoncesellingrepository.deleteById(id);
		
	}

	@Override
	public List<SellingAnnonce> retreiveAllSellingAnnonce() {
		List<SellingAnnonce> sellingannonce = (List<SellingAnnonce>) annoncesellingrepository.findAll();
		for(Annonce anno : sellingannonce) {
			l.info("prod +++ :" + anno);
		}
		return sellingannonce;
	}



	@Override
	public void updateSellingAnnonce(SellingAnnonce ann, int id) {
		SellingAnnonce sellingannonce = annoncesellingrepository.findById(id).get();
		sellingannonce.setTitle(ann.getTitle());
		sellingannonce.setAdresse(ann.getAdresse());
		sellingannonce.setEngagementLettre(ann.getEngagementLettre());
		sellingannonce.setInnerSurface(ann.getInnerSurface());
		sellingannonce.setPlaneSurface(ann.getInnerSurface());
		sellingannonce.setFavoriteAnnonce(ann.getFavoriteAnnonce());
		sellingannonce.setPhotoIdentity(ann.getPhotoIdentity());
		sellingannonce.setRoomNumber(ann.getRoomNumber());
		sellingannonce.setStatePrice(ann.getStatePrice());
		annoncesellingrepository.save(sellingannonce);
	}





}
