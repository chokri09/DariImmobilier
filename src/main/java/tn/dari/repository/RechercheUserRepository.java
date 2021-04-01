package tn.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.entities.RechercheUser;

@Repository
public interface RechercheUserRepository extends CrudRepository<RechercheUser, Integer> {

}
