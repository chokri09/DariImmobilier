package tn.dari.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.dari.entities.Reclamation;
import tn.dari.entities.Typerec;

public interface IReclamationRepository extends CrudRepository<Reclamation, Integer> {

	@Query("UPDATE Reclamation u SET u.isTreated=1, u.reponse = ?1 WHERE u.id = ?2 ")
	@Modifying
	public void repondreRec(String reponse , int id);
	
	@Query("SELECT COUNT(id) FROM Reclamation WHERE isTreated = false")
	public int reclamationNNTraitees();
	
	@Query("SELECT COUNT(id) FROM Reclamation WHERE type = ?1")
	public int statisticsMotif(Typerec type);
	
	@Query("SELECT COUNT(id) FROM Reclamation")
	public int statisticsAll();
	
}
