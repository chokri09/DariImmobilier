package tn.dari.repository;

import org.springframework.data.repository.CrudRepository;

import tn.dari.entities.Annonce;
import tn.dari.entities.RentingAnnonce;

public interface IannoceRentingRepository extends CrudRepository<RentingAnnonce, Integer> {

}
