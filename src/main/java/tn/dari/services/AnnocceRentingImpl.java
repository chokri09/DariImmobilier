package tn.dari.services;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.AdState;
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
		if (redundancyannounce(ann) == false) {
			
			System.out.print("application redondante");
		}
		Date d = new Date(System.currentTimeMillis());
		ann.setCreatedAt(d);
		ann.setAdState(AdState.Inprogress);
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
	public double EstimationByRoomNumber (int roomNumber){
		return annocerentingepository.Estimate(roomNumber);
	}
	public long priceofRent (long price ,long nb_jours){
		long rentprice = price * nb_jours ;
		return rentprice ;
	}
	
	public long calculateDateInterval(Date startDate, Date endDate) {
		return ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant());
	}
	public long TotalAPaye(int id) {
		Date date1 = annocerentingepository.DateDebut(id);
		Date date2 = annocerentingepository.DateFin(id);
		long nb_jours = calculateDateInterval(date1, date2);
		long price = annocerentingepository.Price(id);
		long TotalOfRent = priceofRent(price, nb_jours) ; 
		return TotalOfRent ;
	}
	public List<RentingAnnonce> latestRentingAnnonce(){
		List<RentingAnnonce> ls = (List<RentingAnnonce>) annocerentingepository.findAll();
		List<RentingAnnonce> subss = new ArrayList<>();
		Date datenow = new  Date(System.currentTimeMillis());
		for (RentingAnnonce rentingAnnonce : ls) {
			if (calculateDateInterval(rentingAnnonce.getCreatedAt(), datenow)<3) {
				subss.add(rentingAnnonce);
				
			}
		}
		return subss;
		
		
	}
	@Override
	public void acceptAnnonceJPQL(int annId) {
	annocerentingepository.acceptAnnonceJPQL(annId);
		
	}
	public void DeniedAnnonceJPQL(int annId) {
		annocerentingepository.DeniedAnnonceJPQL(annId);
			
	}
	public List<RentingAnnonce> DynamicSearch(String key){
		return annocerentingepository.search(key);
	}
	public boolean redundancyannounce (RentingAnnonce re) {
		List<RentingAnnonce> ls = (List<RentingAnnonce>) annocerentingepository.findAll();
	for (RentingAnnonce rentingAnnonce : ls) {
		if (re.equals(rentingAnnonce)) {
			return false ;
		}
	}
	return true;
	}
	public List<RentingAnnonce> BestReviewed(){
		return annocerentingepository.findBestReviewed();
	}
	public void AddAnnnonceToFavorite(int annId) {
	annocerentingepository.addAnnoncetoFavorite(annId);;
		
	}
	public List<RentingAnnonce> ListOfMyFavoriteAnnonce(int userId){
		return annocerentingepository.ListofmyFavorite(userId);
	}
	public List<RentingAnnonce> MyInprogressList(int userId){
		return annocerentingepository.InprogressAnnonce(userId);
	}
}
