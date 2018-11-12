package com.arcosa.bafar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arcosa.bafar.entidades.PalletsJpa;


@Repository
public interface IPalletDao extends CrudRepository<PalletsJpa,Long> {

}
