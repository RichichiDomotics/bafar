package com.arcosa.bafar.dao;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.arcosa.bafar.entidades.EntradasJpa;




@Repository
public interface IEntradasDao extends CrudRepository<EntradasJpa,Long> {

	
}
