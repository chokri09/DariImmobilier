package tn.dari.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.dari.entities.SellingAnnonce;

public interface IannonceSellingRepository extends CrudRepository<SellingAnnonce, Integer> {

	@Query("SELECT AVG(price) FROM Annonce WHERE roomNumber = ?1 AND type_annoce= 'selling'")
	public double Estimate(int roomNumber);

	@Modifying
	@Transactional
	@Query("UPDATE Annonce e SET e.AdState='Accepted' where e.id=:annonceId AND type_annoce= 'selling'")
	public void acceptAnnonceJPQL(@Param("annonceId") int annonceId);

	@Modifying
	@Transactional
	@Query("UPDATE Annonce e SET e.AdState='Denied' where e.id=:annonceId AND type_annoce= 'selling'")
	public void DeniedAnnonceJPQL(@Param("annonceId") int annonceId);

	@Query("SELECT o FROM Annonce o WHERE CONCAT(o.title, o.adresse, o.price) LIKE %?1% AND type_annoce= 'selling'")
	public List<SellingAnnonce> search(String keyword);

	@Query("SELECT price FROM Annonce WHERE id = ?1 AND type_annoce= 'selling'")
	public long Price(int id);

	@Query("SELECT CreatedAt FROM Annonce WHERE type_annoce= 'renting'")
	public List<Date> CreatedAt();

	@Query("SELECT u FROM Annonce u WHERE u.AdState ='Accepted' AND type_annoce= 'selling' ORDER BY u.price Desc")
	public List<SellingAnnonce> findBestReviewed();
}
