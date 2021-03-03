package tn.dari.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Annonce;
import tn.dari.entities.RentingAnnonce;
import tn.dari.repository.IannoceRentingRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Service
public class AnnocceRentingImpl implements IannonceRentingService {
	
	private static final Logger l = LogManager.getLogger(AnnocceRentingImpl.class);
	@Autowired
	IannoceRentingRepository annocerentingepository ;
	@Override
	public RentingAnnonce addRentingAnnonce(RentingAnnonce ann) {
		return annocerentingepository.save(ann);
	}
	@Override
	public void updateRentingAnnonce(RentingAnnonce ann , int id) {
		RentingAnnonce rentingannonce = annocerentingepository.findById(id).get();
		rentingannonce.setTitle(ann.getTitle());
		rentingannonce.setAdresse(ann.getAdresse());
		rentingannonce.setEngagementLettre(ann.getEngagementLettre());
		rentingannonce.setInnerSurface(ann.getInnerSurface());
		rentingannonce.setPlaneSurface(ann.getInnerSurface());
		rentingannonce.setNbrPersonne(ann.getNbrPersonne());
		rentingannonce.setFavoriteAnnonce(ann.getFavoriteAnnonce());
		rentingannonce.setRented(ann.isRented());
		rentingannonce.setPhotoIdentity(ann.getPhotoIdentity());
		rentingannonce.setDateDebut(ann.getDateDebut());
		rentingannonce.setDateFin(ann.getDateFin());
		rentingannonce.setRoomNumber(ann.getRoomNumber());
		rentingannonce.setStatePrice(ann.getStatePrice());
		annocerentingepository.save(rentingannonce);
	}
	@Override
	public void DeleteRentingAnnonce(int id) {
		annocerentingepository.deleteById(id);
		
	}
	@Override
	public List<RentingAnnonce> retreiveAllRentingAnnonce() {
		List<RentingAnnonce> rentingannoce = (List<RentingAnnonce>) annocerentingepository.findAll();
		for(Annonce anno : rentingannoce) {
			l.info("prod +++ :" + anno);
		}
		return rentingannoce;
	}

	

}
