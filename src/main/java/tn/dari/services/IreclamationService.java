package tn.dari.services;

import java.util.List;

import tn.dari.entities.Reclamation;
import tn.dari.entities.User;

public interface IreclamationService {
	public Reclamation addReclamation(Reclamation rec);
	public void updateReclamation(Reclamation rec ,int id);
	public void DeleteReclamation(int id);
	public List<Reclamation> retreiveAllReclamation() ;
}
