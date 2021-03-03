package tn.dari;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.dari.entities.Annonce;
import tn.dari.entities.RentingAnnonce;
import tn.dari.services.IannonceRentingService;

@SpringBootTest
class DariApplicationTests {
	@Autowired
	IannonceRentingService ann;
	@Test
	void contextLoads() {
	 RentingAnnonce anns = new RentingAnnonce(1, null, null, null, null, 0, 0, 0, 0, 0, null, null, "ddaaad", null);
	
	 ann.retreiveAllRentingAnnonce();
	 
	}

}
