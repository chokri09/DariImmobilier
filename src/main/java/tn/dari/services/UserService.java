package tn.dari.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.dari.entities.RechercheUser;
import tn.dari.entities.User;
import tn.dari.repository.RechercheUserRepository;
import tn.dari.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class UserService {
    public static final int MAX_FAILED_ATTEMPT = 3;
    public static final int MAX_SIGNALS = 100;
    private static final long LOCK_TIME_DURATION = 10 * 60 * 1000; // 24 hours
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CustomLoginSuccessHandler cc;
    
    @Autowired
    private RechercheUserRepository RR;

    public void increaseFailedAttempt(User user){
        int newFailedAttempts  = user.getFailedAttempt() + 1;
        userRepository.updateFailedAttempt(newFailedAttempts , user.getUsername());
    }

    public void lock(User user) {
        user.setAccountNonLocked(false);
        user.setLockTime(new Date());
        userRepository.save(user);
    }
    public boolean unclock(User user){
        long lockTimeInMillis = user.getLockTime().getTime();
        long currentTimeInMillis = System.currentTimeMillis();
        if (lockTimeInMillis + LOCK_TIME_DURATION < currentTimeInMillis){
            user.setAccountNonLocked(true);
            user.setLockTime(null);
            user.setFailedAttempt(0);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void resetFailedAttempt(String username) {
        userRepository.updateFailedAttempt(0 , username);
    }
    
    
    public User advancedSearsh(String motif){
    	final int id = cc.idConnectedUser;
    	User u = new User();
    	if(userRepository.advancedSearchByUsername(motif)!=null){
    		RechercheUser u1 = new RechercheUser(id,motif);
        	RR.save(u1);
    		return userRepository.advancedSearchByUsername(motif);
    	}else if(userRepository.advancedSearchByEmail(motif)!=null){
    		RechercheUser u1 = new RechercheUser(id,motif);
        	RR.save(u1);
    		return userRepository.advancedSearchByEmail(motif);
    	}else if (userRepository.advancedSearchByTelephone(motif)!=null){
    		RechercheUser u1 = new RechercheUser(id,motif);
        	RR.save(u1);
    		return userRepository.advancedSearchByTelephone(motif);
    	}
    	
    	
    	RechercheUser u1 = new RechercheUser(id,motif);
    	RR.save(u1);
    	
    	return u;
    }
    
    public String BlockUserAccount(int id){
    	userRepository.BlockUserAccount(id);
    	return "User blocked successfuly";
    }
    
    public String deBlockUserAccount(int id){
    	userRepository.deBlockUserAccount(id);
    	return "User unlocked successfuly";
    }
    
    
    public List<User> listAll(){
    	
    	return (List<User>) userRepository.findAll();
    }
    
    public String signalUser(int id){
    	userRepository.signalUser(id);
    	int nbrSignals = userRepository.getUserSignalsNumber(id);
    	if(nbrSignals >100){
    		userRepository.BlockUserAccount(id);
    		userRepository.reseNbrtsignalUser(id);
    	}else
    		userRepository.deBlockUserAccount(id);
		return "Signal send successfuly";
    }
    
    
    public int GetIdConnectedUser(){
    	 final int id = cc.idConnectedUser; 
    	return id;
    }
}
