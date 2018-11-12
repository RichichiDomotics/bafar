package com.arcosa.bafar.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.arcosa.bafar.entidades.Entradas;
import com.arcosa.bafar.entidades.EntradasDetalle;
import com.arcosa.bafar.entidades.PalletsJpa;
import com.arcosa.bafar.entidades.PickingJpa;
import com.arcosa.bafar.entidades.SurtidoDetalle;



public interface IClienteDao extends CrudRepository<Entradas, Long>{ 

	@Query("select endt from EntradasDetalle endt inner join Entradas en on folio=en.id where noEntrega=?1")
	public List<EntradasDetalle> findByEntrega(String noentrega);
	
	@Query("select pick from PickingJpa pick where documento=?1")
	public List<PickingJpa> findByPicking(String noentrega);
	
	@Query("select endt from EntradasDetalle endt where check_in=?1")
	public List<EntradasDetalle> findByEntregaDetalle(int check);
	
	@Query("select endt from Entradas endt where check_in=?1")
	public List<Entradas> findByEntregas(int check);
	
	@Query("select endt.id from Entradas endt where noEntrega=?1")
	public Long findByEntregasId(String noentrega);
	
	@Query("select endt from PickingJpa endt where check_int=0")
	public List<PickingJpa> findByPicking();
	
	@Query("select pick from PickingJpa pick where nopedido=?1")
	public List<PickingJpa> findByPickingPed(String nopedido);
	
	@Query("select noclienteentrega,umb,posicion from PickingJpa where nopedido=?1 and noentrega=?2 and sku=?3")
	public String[] findByPickingExc(String nopedido,String noentrega,String sku);		
	
	@Query("select surtdet from SurtidoDetalle surtdet where foliosalida=?1 and check_in=?2")
	public List<SurtidoDetalle> findBySurtidoDetalle(String nopedido, int valor);
	
	@Query("select count(consecutivo)  from Consecutivo  where fechaingreso=?1")
	public int findByConsecutivo(String fecha);
	
	@Query("select documento  from Consecutivo  where nopedido=?1")
	public String findByCabecera(String folio);
	
	
	@Query("select pal  from PalletsJpa pal where check_in=0")
	public List<PalletsJpa> findByPallets();
	
	@Query("select count(id)  from PalletsJpa pal ")
	public int findByPalletsT();
	
	@Query("select nopallet  from PalletsJpa pal where pallet_surtido=?1 and nopedido=?2")
	public String findByPalletsNo(String numero, String nopedido);
	
	@Query(value="SELECT clientedestino, GROUP_CONCAT(sku) sku, nopallet,familia,GROUP_CONCAT(cnt) cnt FROM ( SELECT clientedestino,COUNT(cantidadsurtida) cnt,sku,nopallet, familia FROM surtido_detalle where foliosalida=?1 GROUP BY sku ) q group by nopallet order BY nopallet asc", nativeQuery = true)
	public List<Object[]>  findByGroupSurtido(String nopedido);
	
	@Query("select count(consecutivo)  from CodigoBarras  where fecha=?1")
	public int findByConsBarras(String fecha);
	
	
	/*@Query("select endt from EntradasDetalle endt where fecha ?1")
	public List<EntradasDetalle> findByEntregaDetalle(String fecha);
	
	@Query("select endt from Entradas endt where check_in=?1")
	public List<Entradas> findByEntregas(String fecha);
	*/
	
	@Query("select endt.codigo_asc from Entradas endt where noEntrega=?1")
	public String findByEntregasRD(String noentrega);
	
	@Query("select endt from EntradasDetalle endt inner join Entradas en on folio=en.id where noEntrega=?1 and endt.check_in=?2")
	public List<EntradasDetalle> findByEntFIN(String noentrega,int check);
	
	@Query("select surtdet from SurtidoDetalle surtdet where check_in=?1")
	public List<SurtidoDetalle> findBySalFIN(int check);
	
	
	
}
