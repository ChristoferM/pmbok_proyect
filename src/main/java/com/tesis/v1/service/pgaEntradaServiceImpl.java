package com.tesis.v1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.Reunion;
import com.tesis.v1.domain.pga.entradapga;
import com.tesis.v1.domain.pga.pga;
import com.tesis.v1.dto.pga.entradapgaDTO;
import com.tesis.v1.repository.pga.entradaPgaRepository;
import com.tesis.v1.repository.pga.pgaRespository;

@Service
@Scope("singleton")
public class pgaEntradaServiceImpl implements pgaEntradasServices {

	@Autowired
	entradaPgaRepository entradaPgaRepository;

	@Autowired
	pgaRespository PGArespository;

	@Override
	@Transactional(readOnly = true)
	public List<entradapga> findAll() {
		return entradaPgaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<entradapga> findById(Integer id) throws Exception {
		return entradaPgaRepository.findById(id);
	}

	@Override
	public Long count() {
		return entradaPgaRepository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public entradapga save(entradapga entity) throws Exception {
		return entradaPgaRepository.save(entity);
	}

	@Override
	public void delete(entradapga entity) throws Exception {

		if (entity == null) {
			throw new Exception("La entrada acta es nulo");
		}
		if (entity.getIdentradapga() == null || entity.getIdentradapga() <= 0) {
			throw new Exception("La id es obligatoria");

		}
		if (entradaPgaRepository.existsById(entity.getIdentradapga()) == false) {
			throw new Exception("La entrada acta  con id No existe (No se puede eliminar)");
		}
		entradaPgaRepository.deleteById(entity.getIdentradapga());

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(entradapga entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(readOnly = true)
	public List<entradapgaDTO>  BuscarEntradasPGAPorIdDelProyecto(Integer id) throws Exception {
		List<entradapgaDTO> EntradaPGAListDTO = new ArrayList<>();
		
		try {
			List<entradapga>  entradaPGALIST = entradaPgaRepository.BuscarEntradasPGAPorIdDelProyecto(id);
			
			for(entradapga entity:entradaPGALIST ) {
				entradapgaDTO dto = new entradapgaDTO();
				dto.setActivosprocesos(entity.getActivosprocesos());
				dto.setCiclo(entity.getCiclo());
				dto.setEnfoque(entity.getEnfoque());
				dto.setEstado(entity.getEstado());
				dto.setEstandares(entity.getEstandares());
				dto.setIdentradapga(entity.getIdentradapga());
				dto.setObjetivocalidad(entity.getObjetivocalidad());
				dto.setParticipa(entity.getParticipa());
				dto.setIdpga(entity.getPga().getIdpga());
				EntradaPGAListDTO.add(dto);
				
			}
			
		} catch (Exception e) {
			throw new Exception("Error SQL: No se grabo los datos de Entradas Del PGA " + "\n DETALLE:" + e);
		}
		return EntradaPGAListDTO; //entradaPgaRepository.BuscarEntradasPGAPorIdDelProyecto(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public entradapga update(entradapga entity) throws Exception {
		if (entity == null) {
			throw new Exception("Error en los datos");

		}
		if (entradaPgaRepository.existsById(entity.getIdentradapga()) == false) {
			throw new Exception("Error  El Id No existe");
		}
		return entradaPgaRepository.save(entity);
	}

	
	/*
	 * Metodos nuevos para guardar actualizar y buscar datos previos
	 * */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public entradapgaDTO guardarEntradaDelPga(entradapgaDTO entradasDTO) throws Exception {
		Integer idreuniones = PGArespository.buscarIdReunion(entradasDTO.getIdproyecto());

		pga pga = PGArespository.buscarPorIdReunion(idreuniones);

		if (pga == null) {
			Reunion reunion = new Reunion();
			reunion.setIdreuniones(idreuniones);

			reunion.setIdreuniones(idreuniones);
			pga = new pga();
			pga.setReuniones(reunion);
			pga = PGArespository.save(pga);

		}
		entradapga entity = new entradapga();
		entity.setActivosprocesos(entradasDTO.getActivosprocesos());
		entity.setCiclo(entradasDTO.getCiclo());
		entity.setEnfoque(entradasDTO.getEnfoque());
		entity.setEstado(true);
		entity.setEstandares(entradasDTO.getEstandares());
		entity.setIdentradapga(entradasDTO.getIdentradapga());
		entity.setObjetivocalidad(entradasDTO.getObjetivocalidad());
		entity.setParticipa(entradasDTO.getParticipa());
		entity.setPga(pga);

		try {
			entity = entradaPgaRepository.save(entity);
		} catch (Exception e) {
			throw new Exception("Error SQL: No se grabo los datos de Entradas Del PGA " + "\n DETALLE:" + e);
		}
		entradapgaDTO dto = new entradapgaDTO();
		dto.setActivosprocesos(entity.getActivosprocesos());
		dto.setCiclo(entity.getCiclo());
		dto.setEnfoque(entity.getEnfoque());
		dto.setEstado(entity.getEstado());
		dto.setEstandares(entity.getEstandares());
		dto.setIdentradapga(entity.getIdentradapga());
		dto.setObjetivocalidad(entity.getObjetivocalidad());
		dto.setParticipa(entity.getParticipa());
		dto.setIdpga(entity.getPga().getIdpga());

		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<entradapgaDTO> BuscarDatosDeEntradasDePga(entradapgaDTO entradapgaDTO) throws Exception {
		List<entradapgaDTO> EntradaPGAListDTO = new ArrayList<>();
		
		try {
			List<entradapga> entradaPGALIST =entradaPgaRepository.BuscarDatosDeEntradasPGA(entradapgaDTO.getIdproyecto());
			
			for(entradapga entity:entradaPGALIST ) {
				entradapgaDTO dto = new entradapgaDTO();
				dto.setActivosprocesos(entity.getActivosprocesos());
				dto.setCiclo(entity.getCiclo());
				dto.setEnfoque(entity.getEnfoque());
				dto.setEstado(entity.getEstado());
				dto.setEstandares(entity.getEstandares());
				dto.setIdentradapga(entity.getIdentradapga());
				dto.setObjetivocalidad(entity.getObjetivocalidad());
				dto.setParticipa(entity.getParticipa());
				dto.setIdpga(entity.getPga().getIdpga());
				EntradaPGAListDTO.add(dto);
				
			}
		} catch (Exception e) {
			throw new Exception("Error SQL: No se obtuvieron los datosPrevios de Entradas Del PGA "
					+ "\n DETALLE:"+e);
		}
		return EntradaPGAListDTO;
	}
}
