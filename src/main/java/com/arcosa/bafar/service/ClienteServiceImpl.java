package com.arcosa.bafar.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arcosa.bafar.dao.IClienteDao;
import com.arcosa.bafar.entidades.Entradas;
import com.arcosa.bafar.entidades.EntradasDetalle;
import com.arcosa.bafar.entidades.PalletsJpa;
import com.arcosa.bafar.entidades.PickingJpa;
import com.arcosa.bafar.entidades.SurtidoDetalle;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	IClienteDao entradasDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<EntradasDetalle> findByEntrega(String noentrega) {
		return entradasDao.findByEntrega(noentrega);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<PickingJpa>  findByPicking(String noentrega){
		return entradasDao.findByPicking(noentrega);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Entradas>  findByEntregas(int check){
		return entradasDao.findByEntregas(check);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<EntradasDetalle>  findByEntregaDetalle(int check){
		return entradasDao.findByEntregaDetalle(check);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Long findByEntregasId(String noentrega) {
		return entradasDao.findByEntregasId(noentrega);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<PickingJpa> findByPicking(){
		return entradasDao.findByPicking();
	}

	@Override
	@Transactional(readOnly = true)
	public List<SurtidoDetalle> findBySurtidoDetalle(String nopedido, int valor){
		return entradasDao.findBySurtidoDetalle(nopedido, valor);
	}
	
	@Override
	@Transactional(readOnly = true)
	public int findByConsecutivo(String fecha) {
		
		return entradasDao.findByConsecutivo(fecha);
	}
	
	@Override
	@Transactional(readOnly = true)
	public String findByCabecera(String folio) {
		return entradasDao.findByCabecera(folio);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<PickingJpa>  findByPickingPed(String nopedido) {
		return entradasDao.findByPickingPed(nopedido);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<PalletsJpa> findByPallets(){
		return entradasDao.findByPallets();
	}
	
	@Override
	@Transactional(readOnly = true)
	public int findByPalletsT(){
		return entradasDao.findByPalletsT();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Object[]>  findByGroupSurtido(String nopedido){
		return entradasDao.findByGroupSurtido(nopedido);
	}
	
	@Override
	@Transactional(readOnly = true)
	public int findByConsBarras(String fecha) {
		return entradasDao.findByConsBarras(fecha);
	}
	
	@Override
	@Transactional(readOnly = true)
	public String findByEntregasRD(String noentrega) {
	return entradasDao.findByEntregasRD( noentrega);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<EntradasDetalle> findByEntFIN(String noentrega,int check){
	return entradasDao.findByEntFIN(noentrega,check);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<SurtidoDetalle> findBySalFIN(int check){
		return entradasDao.findBySalFIN( check);
	
	}
	
	@Override
	@Transactional(readOnly = true)
	public String findByPalletsNo(String numero,String nopedido){
		return entradasDao.findByPalletsNo( numero,nopedido);
	
	}
	
	@Override
	@Transactional(readOnly = true)
	public String[] findByPickingExc(String nopedido,String noentrega,String sku){
		return entradasDao.findByPickingExc(nopedido,noentrega,sku);
	
	}
	
}
