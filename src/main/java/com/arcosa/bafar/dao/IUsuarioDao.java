package com.arcosa.bafar.dao;

import org.springframework.data.repository.CrudRepository;

import com.arcosa.bafar.entidades.Usuario;



public interface IUsuarioDao extends CrudRepository<Usuario, Long>{

	public Usuario findByUsername(String username);
}
