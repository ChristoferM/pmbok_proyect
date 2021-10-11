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
import com.tesis.v1.domain.pga.herramientaspga;
import com.tesis.v1.domain.pga.pga;
import com.tesis.v1.dto.pga.herramientaspgaDTO;
import com.tesis.v1.repository.pga.herramientasPgaRepository;
import com.tesis.v1.repository.pga.pgaRespository;

@Service
@Scope("singleton")
public class pgaHerramientasServiceImpl implements pgaHerramientasService {

	@Autowired
	herramientasPgaRepository herramientasPgaRepository;

	@Autowired
	pgaRespository PGArespository;

	@Override
	@Transactional(readOnly = true)
	public List<herramientaspga> findAll() {
		return herramientasPgaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<herramientaspga> findById(Integer id) throws Exception {
		return herramientasPgaRepository.findById(id);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return herramientasPgaRepository.count();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public herramientaspga save(herramientaspga entity) throws Exception {
		return herramientasPgaRepository.save(entity);
	}

	@Override
	public void delete(herramientaspga entity) throws Exception {

		if (entity == null) {
			throw new Exception("La entrada acta es nulo");
		}
		if (entity.getIdherramientapga() == null || entity.getIdherramientapga() <= 0) {
			throw new Exception("La id es obligatoria");

		}
		if (herramientasPgaRepository.existsById(entity.getIdherramientapga()) == false) {
			throw new Exception("EL id No existe (No se puede eliminar)");
		}
		herramientasPgaRepository.deleteById(entity.getIdherramientapga());

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(herramientaspga entity) throws Exception {
		// TODO Auto-generated method stub

	}

	// JUNIO 8 AGREGADO POR REUNION
	@Transactional(readOnly = true)
	public List<herramientaspgaDTO> BuscarHerramientasPGAPorIdDelProyecto(Integer id) throws Exception {
		if (id < 0 || id == null) {
			throw new Exception("error en el identificador");
		}
		
		List<herramientaspgaDTO> EntradaPGAListDTO = new ArrayList<>();
		try {
			List<herramientaspga> herramientasPGALIST = herramientasPgaRepository.BuscarHerramientasPGAPorIdDelProyecto(id);
			for (herramientaspga entity : herramientasPGALIST) {
				herramientaspgaDTO dto = new herramientaspgaDTO();
				dto.setAnalisis(entity.getAnalisis());
				dto.setEstado(entity.getEstado());
				dto.setIdherramientapga(entity.getIdherramientapga());
				dto.setJuicioexpertos(entity.getJuicioexpertos());
				dto.setParticipa(entity.getParticipa());
				dto.setIdpdp(entity.getPga().getIdpga());
				EntradaPGAListDTO.add(dto);

			}
		} catch (Exception e) {
			throw new Exception(
					"Error SQL: No se obtuvieron los datosPrevios de HERRAMIENTAS Del PGA " + "\n DETALLE:" + e);
		}

		return EntradaPGAListDTO ;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public herramientaspga update(herramientaspga entity) throws Exception {
		if (entity == null) {
			throw new Exception("Error en los datos");

		}
		if (herramientasPgaRepository.existsById(entity.getIdherramientapga()) == false) {
			throw new Exception("Erro: El Id No existe");
		}
		return herramientasPgaRepository.save(entity);
	}

	/*
	 * Metodos nuevos para guardar actualizar y buscar datos previos
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public herramientaspgaDTO guardarHerramientasDelPga(herramientaspgaDTO herramientasDTO) throws Exception {
		Integer idreuniones = PGArespository.buscarIdReunion(herramientasDTO.getIdproyecto());

		pga pga = PGArespository.buscarPorIdReunion(idreuniones);

		if (pga == null) {
			Reunion reunion = new Reunion();
			reunion.setIdreuniones(idreuniones);

			reunion.setIdreuniones(idreuniones);
			pga = new pga();
			pga.setReuniones(reunion);
			pga = PGArespository.save(pga);

		}
		herramientaspga entity = new herramientaspga();
		entity.setAnalisis(herramientasDTO.getAnalisis());
		entity.setEstado(true);
		entity.setIdherramientapga(herramientasDTO.getIdherramientapga());
		entity.setJuicioexpertos(herramientasDTO.getJuicioexpertos());
		entity.setParticipa(herramientasDTO.getParticipa());
		entity.setPga(pga);
		try {
			entity = herramientasPgaRepository.save(entity);
		} catch (Exception e) {
			throw new Exception("Error SQL: No se grabo los datos de HERRAMIENTAS Del PGA " + "\n DETALLE:" + e);
		}
		herramientaspgaDTO dto = new herramientaspgaDTO();

		dto.setAnalisis(entity.getAnalisis());
		dto.setEstado(entity.getEstado());
		dto.setIdherramientapga(entity.getIdherramientapga());
		dto.setJuicioexpertos(entity.getJuicioexpertos());
		dto.setParticipa(entity.getParticipa());
		dto.setIdpdp(entity.getPga().getIdpga());

		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public List<herramientaspgaDTO> BuscarDatosDeHerramientasDePga(herramientaspgaDTO herramientasDTO)
			throws Exception {
		List<herramientaspgaDTO> EntradaPGAListDTO = new ArrayList<>();
		try {
			List<herramientaspga> herramientasPGALIST = herramientasPgaRepository
					.BuscarDatosDeHerramientasPGA(herramientasDTO.getIdproyecto());
			for (herramientaspga entity : herramientasPGALIST) {
				herramientaspgaDTO dto = new herramientaspgaDTO();
				dto.setAnalisis(entity.getAnalisis());
				dto.setEstado(entity.getEstado());
				dto.setIdherramientapga(entity.getIdherramientapga());
				dto.setJuicioexpertos(entity.getJuicioexpertos());
				dto.setParticipa(entity.getParticipa());
				dto.setIdpdp(entity.getPga().getIdpga());
				EntradaPGAListDTO.add(dto);

			}
		} catch (Exception e) {
			throw new Exception(
					"Error SQL: No se obtuvieron los datosPrevios de HERRAMIENTAS Del PGA " + "\n DETALLE:" + e);
		}

		return EntradaPGAListDTO;
	}

}
