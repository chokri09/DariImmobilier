package tn.dari;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.dari.entities.Annonce;
import tn.dari.entities.RentingAnnonce;
import tn.dari.entities.SellingAnnonce;
import tn.dari.services.IannonceRentingService;
import tn.dari.services.IannonceSellingService;

@SpringBootTest
class DariApplicationTests {
	@Autowired
	IannonceRentingService ann;
	@Autowired
	IannonceSellingService sell ;
	@Test
	void contextLoads() {
	 RentingAnnonce anns = new RentingAnnonce(1, null, null, null, null, 0, 0, 0, 0, 0, null, null, "ddaaad", null);
	 //SellingAnnonce sells = new SellingAnnonce(1, "a vendre appartement", null, "l aouina dar fadhel", null, 255.0f, 250.0f, 250.0f, 3, 250.f, null, null, null, true);
	 SellingAnnonce sellsa = new SellingAnnonce(1, "a vendre appartement", null, "l aouina dar fadhel", null, 255.0f, 250.0f, 250.0f, 3, 250.f, null, null, null, true);
	ann.addRentingAnnonce(anns);
	//sell.addSellingAnnonce(sells);
	sell.addSellingAnnonce(sellsa);
	 //ann.retreiveAllRentingAnnonce();
	 
	}

}
