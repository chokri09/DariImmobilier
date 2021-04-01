package tn.dari.repository;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import tn.dari.entities.Gender;
import tn.dari.entities.Typerec;
import tn.dari.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);
	
	
	
	    @Query("select u from User u where u.username = :username" )
	    User getUserByUsername(@Param("username") String username);

	    
	   //update failed login attempt
	
	    @Query("update User u set u.failedAttempt = ?1 where u.username = ?2")
	    @Modifying
	    void updateFailedAttempt(int failedAttempt , String username);

	
	
	   ///// Partie Reporting /////
	   @Query("SELECT COUNT(id) FROM User WHERE gender = ?1")
	   public int statisticsMotif(Gender gender);
	
	   @Query("SELECT COUNT(id) FROM User")
	   public int statisticsAll();
	
	    ///////// end///////////
	   
	   
	   ///////// Partie recherche avanceé//////////
	   @Query("SELECT  u FROM User u WHERE u.username LIKE %?1%")
	   public User advancedSearchByUsername(String motif);
	   
	   @Query("SELECT u FROM User u WHERE u.email LIKE %?1%")
	   public User advancedSearchByEmail(String motif);
	   
	   @Query("SELECT u FROM User u WHERE u.telephone LIKE %?1%")
	   public User advancedSearchByTelephone(String motif);
	   //////////// end recherche //////////////////////////////////////////////////////
	   
	   /////////// block user ///////////
	   @Query("update User u set u.accountNonLocked = 0 where u.id = ?1")
	    @Modifying
	    void BlockUserAccount(int id);
	   ////////////////// end ///////////////
	   
	   /////////deblock user ///////
	   @Query("update User u set u.accountNonLocked = 1 where u.id = ?1")
	    @Modifying
	    void deBlockUserAccount(int id);
	   /////////// end ///////////////
	   
	   
	   //////////// signaler user //////////
	   @Query("update User u set u.nbrSignals = u.nbrSignals + 1 where id = ?1")
	    @Modifying
	    void signalUser(int id);
	   
	   @Query("update User u set u.nbrSignals = 0 where id = ?1")
	    @Modifying
	    void reseNbrtsignalUser(int id);
	   
	   @Query("select nbrSignals from User u where u.id = ?1" )
	   public int getUserSignalsNumber(int id);
	   
	   ///////////////////// end ///////////
}
