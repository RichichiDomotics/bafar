package com.arcosa.bafar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arcosa.bafar.entidades.Catalogos;

@Repository
public interface ICatalogosDao extends CrudRepository<Catalogos,Long> {

}
