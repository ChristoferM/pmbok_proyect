package com.tesis.v1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.Acta;
import com.tesis.v1.domain.Reunion;
import com.tesis.v1.domain.pdp.Herramientas;
import com.tesis.v1.domain.pdp.Pdp;
import com.tesis.v1.dto.pdp.EntradasDTO;
import com.tesis.v1.dto.pdp.HerramientasDTO;
import com.tesis.v1.repository.pdp.herramientasPdpRepository;
import com.tesis.v1.repository.pdp.pdpRepository;

@Service
@Scope("singleton")
public class herramientasServicePdpImpl implements herramientasServicePdp {

	@Autowired
	herramientasPdpRepository herramientasPdpRepository;
	@Autowired
	pdpRepository PDPrepositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Herramientas> findAll() {
		// Auto-generated method stub
		return herramientasPdpRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Herramientas> findById(Integer id) throws Exception {
		// Auto-generated method stub
		if (id < 0 || id == null) {
			throw new Exception("error en el identificador");
		}
		return herramientasPdpRepository.findById(id);
	}

	@Override
	public Long count() {
		// Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Herramientas save(Herramientas entity) throws Exception {
		// Auto-generated method stub
		return herramientasPdpRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Herramientas entity) throws Exception {
		// Auto-generated method stub
		if (entity == null) {
			throw new Exception("La entrada acta es nulo");
		}
		if (entity.getIdherramienta() == null || entity.getIdherramienta() <= 0) {
			throw new Exception("La id es obligatoria");

		}
		if (herramientasPdpRepository.existsById(entity.getIdherramienta()) == false) {
			throw new Exception("La entrada acta  con id No existe (No se puede eliminar)");
		}
		herramientasPdpRepository.deleteById(entity.getIdherramienta());
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// Auto-generated method stub

	}

	@Override
	public void validate(Herramientas entity) throws Exception {
		// Auto-generated method stub

	}

	// JUNIO 8 AGREGADO POR REUNION

	@Override
	@Transactional(readOnly = true)
	public List<HerramientasDTO> BuscarHerramientasPdpPorIdDelProyecto(Integer id) throws Exception {
		List<HerramientasDTO> HerramientaPDPListDTO = new ArrayList<>();
		try {
			List <Herramientas> domain =herramientasPdpRepository.BuscarHerramientasPdpPorIdDelProyecto(id);
			
			
			for (Herramientas herramienta : domain) {
				HerramientasDTO dto = new HerramientasDTO();
				dto.setEstado(herramienta.getEstado());
				dto.setHabilidades(herramienta.getHabilidades());
				dto.setHerramientareuniones(herramienta.getHerramientareuniones());
				dto.setIdherramienta(herramienta.getIdherramienta());
				dto.setIdpdp(herramienta.getPdp().getIdpdp());
				dto.setJuicioexpertos(herramienta.getJuicioexpertos());
				dto.setParticipa(herramienta.getParticipa());
				dto.setRecopilaciondatos(herramienta.getRecopilaciondatos());

				HerramientaPDPListDTO.add(dto);
			}
		} catch (Exception e) {
			throw new Exception(
					"Error SQL: No se obtuvieron los datosPrevios de Herramientas Del PDP " + "\n DETALLE:" + e);
		}
		return HerramientaPDPListDTO;
		//return herramientasPdpRepository.BuscarHerramientasPdpPorIdDelProyecto(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Herramientas update(Herramientas entity) throws Exception {
		if (entity == null) {
			throw new Exception("Error en los datos");

		}
		if (herramientasPdpRepository.existsById(entity.getIdherramienta()) == false) {
			throw new Exception("Erro: El Id No existe");
		}
		return herramientasPdpRepository.save(entity);
	}

	/*
	 * NUEVOS MÉTODOS PARA GUARDAR ACTUALIZAR Y BUSCAR DATOS PREVIOS 25/9/2021
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public HerramientasDTO guardarHerramientasDelpdp(HerramientasDTO herramientasDTO) throws Exception {
		Integer idreuniones = herramientasPdpRepository.buscarIdReunion(herramientasDTO.getIdproyecto());

		// primero se crea un PDP para crear la instancia en base de datos
		// o verificar si YA existe la instancia
		// ambas deben ir ligado al id de proyecto

		Pdp pdp = PDPrepositorio.buscarPorIdReunion(idreuniones);

		if (pdp == null) {
			Reunion reunion = new Reunion();
			reunion.setIdreuniones(idreuniones);

			reunion.setIdreuniones(idreuniones);
			pdp = new Pdp();
			pdp.setReuniones(reunion);
			pdp = PDPrepositorio.save(pdp);

		}

		Herramientas entity = new Herramientas();

		entity.setEstado(true);
		entity.setHabilidades(herramientasDTO.getHabilidades());
		entity.setHerramientareuniones(herramientasDTO.getHerramientareuniones());
		entity.setJuicioexpertos(herramientasDTO.getJuicioexpertos());
		entity.setParticipa(herramientasDTO.getParticipa());
		entity.setRecopilaciondatos(herramientasDTO.getRecopilaciondatos());
		entity.setPdp(pdp);

		// entity.set
		entity = herramientasPdpRepository.save(entity);

		HerramientasDTO dto = new HerramientasDTO();
		dto.setEstado(entity.getEstado());
		dto.setHabilidades(entity.getHabilidades());
		dto.setHerramientareuniones(entity.getHerramientareuniones());
		dto.setJuicioexpertos(entity.getJuicioexpertos());
		dto.setParticipa(entity.getParticipa());
		dto.setRecopilaciondatos(entity.getRecopilaciondatos());
		dto.setIdpdp(entity.getPdp().getIdpdp());

		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HerramientasDTO> BuscarDatosDeHerramientasDePDP(HerramientasDTO herramientasDTO) throws Exception {

		List<HerramientasDTO> HerramientaPDPListDTO = new ArrayList<>();

		try {
			List<Herramientas> herramientasPdpList = herramientasPdpRepository
					.BuscarDatosDeHerramientasPdp(herramientasDTO.getIdproyecto());

			for (Herramientas herramienta : herramientasPdpList) {
				HerramientasDTO dto = new HerramientasDTO();
				dto.setEstado(herramienta.getEstado());
				dto.setHabilidades(herramienta.getHabilidades());
				dto.setHerramientareuniones(herramienta.getHerramientareuniones());
				dto.setIdherramienta(herramienta.getIdherramienta());
				dto.setIdpdp(herramienta.getPdp().getIdpdp());
				dto.setJuicioexpertos(herramienta.getJuicioexpertos());
				dto.setParticipa(herramienta.getParticipa());
				dto.setRecopilaciondatos(herramienta.getRecopilaciondatos());

				HerramientaPDPListDTO.add(dto);
			}

		} catch (Exception e) {
			throw new Exception(
					"Error SQL: No se obtuvieron los datosPrevios de Herramientas Del PDP " + "\n DETALLE:" + e);
		}

		return HerramientaPDPListDTO;
	}

}
