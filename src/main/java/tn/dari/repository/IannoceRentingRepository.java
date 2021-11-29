package tn.dari.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.dari.entities.RentingAnnonce;

public interface IannoceRentingRepository extends CrudRepository<RentingAnnonce, Integer> {
	@Query("SELECT AVG(price) FROM Annonce WHERE roomNumber = ?1 AND type_annoce= 'renting'")
	public double Estimate(int roomNumber);

	// @Query("SELECT COUNT(id) FROM Reclamation WHERE isTreated = false")
//	public int reclamationNNTraitees();
	@Modifying
	@Transactional
	@Query("UPDATE Annonce e SET e.AdState='Accepted' where e.id=:annonceId AND type_annoce= 'renting'")
	public void acceptAnnonceJPQL(@Param("annonceId") int annonceId);

	@Modifying
	@Transactional
	@Query("UPDATE Annonce e SET e.AdState='Denied' where e.id=:annonceId AND type_annoce= 'renting'")
	public void DeniedAnnonceJPQL(@Param("annonceId") int annonceId);

	@Query("SELECT dateDebut FROM Annonce WHERE id = ?1 AND type_annoce= 'renting'")
	public Date DateDebut(int id);

	@Query("SELECT dateFin FROM Annonce WHERE id = ?1 AND type_annoce= 'renting'")
	public Date DateFin(int id);

	@Query("SELECT price FROM Annonce WHERE id = ?1 AND type_annoce= 'renting'")
	public long Price(int id);

	@Query("SELECT o FROM Annonce o WHERE CONCAT(o.title, o.adresse, o.price) LIKE %?1% AND type_annoce= 'renting'")
	public List<RentingAnnonce> search(String keyword);

	@Query("SELECT CreatedAt FROM Annonce WHERE type_annoce= 'renting'")
	public List<Date> CreatedAt();

	@Query("SELECT u FROM Annonce u WHERE u.AdState ='Accepted' AND type_annoce= 'renting' ORDER BY u.price Desc")
	public List<RentingAnnonce> findBestReviewed();
	@Modifying
	@Transactional
	@Query("UPDATE Annonce e SET e.favoriteAnnonce=1 where e.id=:annonceId AND type_annoce= 'renting' AND e.user.id=:userId")
	public void addAnnoncetoFavorite(@Param("annonceId") int annonceId);
	@Query("SELECT e FROM Annonce e WHERE e.favoriteAnnonce=1 AND e.AdState ='Accepted' AND type_annoce= 'renting' AND e.user.id=:userId")
	public List<RentingAnnonce> ListofmyFavorite(@Param("userId")int userId);
	@Query("SELECT e FROM Annonce e WHERE e.AdState ='Inprogress' AND type_annoce= 'renting' AND e.user.id=:userId")
	public List<RentingAnnonce> InprogressAnnonce(@Param("userId")int userId);
	
}
