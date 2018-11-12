package com.arcosa.bafar.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arcosa.bafar.entidades.PickingJpa;



@Repository
public interface IPickingDao extends CrudRepository<PickingJpa,Long> {

}
