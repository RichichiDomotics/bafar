package com.arcosa.bafar.service;

import java.util.List;
import java.util.Set;

import com.arcosa.bafar.entidades.Entradas;
import com.arcosa.bafar.entidades.EntradasDetalle;
import com.arcosa.bafar.entidades.PalletsJpa;
import com.arcosa.bafar.entidades.PickingJpa;
import com.arcosa.bafar.entidades.SurtidoDetalle;


public interface IClienteService {

	public List<EntradasDetalle> findByEntrega(String noentrega);
	public List<PickingJpa> findByPicking(String noentrega);
	
	public List<EntradasDetalle> findByEntregaDetalle(int check);
	public List<Entradas> findByEntregas(int check);
	
	public List<PickingJpa> findByPicking();
	
	public List<SurtidoDetalle> findBySurtidoDetalle(String nopedido, int valor);
	
	public Long findByEntregasId(String noentrega);
	
	public int findByConsecutivo(String fecha);
	
	public String findByCabecera(String folio);
	
	public List<PickingJpa>  findByPickingPed(String nopedido);
	public List<PalletsJpa> findByPallets();
	public int findByPalletsT();
	public List<Object[]>  findByGroupSurtido(String nopedido);
	public int findByConsBarras(String fecha);
	
	public String findByEntregasRD(String noentrega);
	public List<EntradasDetalle> findByEntFIN(String noentrega,int check);
	public List<SurtidoDetalle> findBySalFIN(int check);
	public String findByPalletsNo(String numero,String nopedido);
	public String[] findByPickingExc(String nopedido,String noentrega,String sku);
}
