package tn.dari.services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.entities.Reclamation;
import tn.dari.entities.Typerec;
import tn.dari.entities.User;
import tn.dari.repository.IReclamationRepository;
@Service
public class ReclamationImpl implements IreclamationService {
	private static final Logger l = LogManager.getLogger(ReclamationImpl.class);
@Autowired
IReclamationRepository reclamationrepostory ;
	@Override
	public Reclamation addReclamation(Reclamation rec) {
		return reclamationrepostory.save(rec);
	}

	@Override
	public void updateReclamation(Reclamation rec, int id) {
		Reclamation rc = reclamationrepostory.findById(id).get();
		rc.setDescr(rc.getDescr());
		rc.setSujet(rc.getSujet());
		rc.setType(rc.getType());
		rc.setReponse(rc.getReponse());
		rc.setIdUserConn(rc.getIdUserConn());
		reclamationrepostory.save(rc);
		
		
		
	}

	@Override
	public void DeleteReclamation(int id) {
		reclamationrepostory.deleteById(id);		
	}

	@Override
	public List<Reclamation> retreiveAllReclamation() {
		List<Reclamation> rct = (List<Reclamation>) reclamationrepostory.findAll();
		for(Reclamation rc : rct) {
			l.info("prod +++ :" + rc);
		}
		return rct;
	}
	
	public String repondreReclamation (Reclamation rec, int id){
		Boolean k=true;
		//Reclamation rc = new Reclamation();
		Reclamation rc = reclamationrepostory.findById(id).get();
		rc.setReponse(rc.getReponse());
		rc.setIsTreated(k);
		//reclamationrepostory.repondreRec(reponse, idrec);
		reclamationrepostory.save(rec);
		
		return "message envoyé";
	}
	
	public int NombreReclamationNonTraitees (){
		return reclamationrepostory.reclamationNNTraitees();
	}
	
	
	public double StatistiquesSelonTypeReclamation (Typerec ty){
		int Motif = reclamationrepostory.statisticsMotif(ty);
		int all = reclamationrepostory.statisticsAll();
		 double a = Motif*100 ;
		 
		 double b = a / all ;
		 System.out.print(b);
		return b ;
		
	}
}



