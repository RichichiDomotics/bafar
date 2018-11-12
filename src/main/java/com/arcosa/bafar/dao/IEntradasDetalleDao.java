package com.arcosa.bafar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arcosa.bafar.entidades.EntradasDetalle;

@Repository
public interface IEntradasDetalleDao extends CrudRepository<EntradasDetalle,Long> {

}
