package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.UploadVente;

@Repository
public interface UploadVenteRepository extends CrudRepository<UploadVente, Long> {

	
	

}
