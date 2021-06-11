package com.tesis.v1.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.v1.domain.Acta;
import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.dto.EntradactaDTO;
import com.tesis.v1.dto.ValidarActaDTO;
import com.tesis.v1.service.ActaService;
import com.tesis.v1.service.EntradaActaService;
import com.tesis.v1.mapper.EntradactaMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController // Servicio
@RequestMapping("/api/EntradasActa") // Forma de llamar datos
@CrossOrigin
public class EntradActaController {
	private final static Logger log = LoggerFactory.getLogger(EntradActaController.class);

	@Autowired
	EntradaActaService entradaActaervice;

	@Autowired
	ActaService Actaervice;

	@Autowired
	EntradactaMapper EntradactaMapper;

	@RequestMapping("/validarActa/{idProyecto}")
	public ResponseEntity<?> finByAll(@PathVariable("idProyecto") Integer idProyecto) throws Exception {

		log.info("Validando Acta");

		ValidarActaDTO validaciones = new ValidarActaDTO();
		log.info("validaciones realizadas");

		validaciones = entradaActaervice.encontrarData(idProyecto);
		log.info("Resquest de validaciones");

		return ResponseEntity.ok().body(validaciones);
	}

	@RequestMapping("/finById/{entradaId}")
	public ResponseEntity<?> finById(@PathVariable("entradaId") Integer entradaId) throws Exception {

		Optional<Entradacta> Entradactaopc = entradaActaervice.findById(entradaId);
		log.info("Cargando ...");
		if (Entradactaopc.isEmpty()) {
			return ResponseEntity.ok().body("Error: No se encontro La referencia");

		}
		Entradacta Entradacta = Entradactaopc.get();
		EntradactaDTO EntradactaDTO = EntradactaMapper.toEntradActaDTO(Entradacta);
		log.info("*");
		EntradactaDTO.setIdActa(Entradacta.getActas().getIdactas());
		return ResponseEntity.ok().body(EntradactaDTO);

	}

	@RequestMapping("/findByAll")
	public ResponseEntity<?> finByAll() throws Exception {
		// Acta acta
		List<Entradacta> EntradactaLIST = entradaActaervice.findAll();

		List<EntradactaDTO> EntradactaListDto = EntradactaMapper.toEntradActaDTO(EntradactaLIST);

		return ResponseEntity.ok().body(EntradactaListDto);
	}

	@RequestMapping("/findEntradaDelActa/{idProyecto}")
	public ResponseEntity<?> entradaDelActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
		List<Entradacta> EntradactaLIST = entradaActaervice.entradaDelActa(idProyecto);

		List<EntradactaDTO> listDTO = new ArrayList<EntradactaDTO>( EntradactaLIST.size() );
		
		   for ( Entradacta entradacta : EntradactaLIST ) {
				EntradactaDTO entradactaDTO = new EntradactaDTO();
				entradactaDTO.setIdActa( entradacta.getActas().getIdactas() );
				entradactaDTO.setIdentrada( entradacta.getIdentrada() );
				entradactaDTO.setAcuerdos( entradacta.getAcuerdos() );
				entradactaDTO.setFactores( entradacta.getFactores() );
				entradactaDTO.setActivosprocesos( entradacta.getActivosprocesos() );
				listDTO.add(entradactaDTO );
		   }

	   return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping("/getIdActa/{idProyecto}")
	public ResponseEntity<?> valorIdActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
		// Acta acta
		Integer idActa = entradaActaervice.valorIdActa(idProyecto);

		return ResponseEntity.ok().body(idActa);
	}

	@RequestMapping("/getEntradaIdActa/{idProyecto}")
	public ResponseEntity<?> valorIdEntraActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
		// Acta acta
		Integer idActa = entradaActaervice.valorIdEntraActa(idProyecto);

		return ResponseEntity.ok().body(idActa);
	}

	@RequestMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody EntradactaDTO EntradactaDTO) throws Exception {
		log.info("************************************ 1");
		Acta acta = new Acta();
		acta.setIdactas(EntradactaDTO.getIdActa());
		Entradacta entradas = new Entradacta();
		entradas.setActas(acta);
		entradas.setAcuerdos(EntradactaDTO.getAcuerdos());
		entradas.setFactores(EntradactaDTO.getFactores());
		entradas.setActivosprocesos(EntradactaDTO.getActivosprocesos());

		log.info("************************************ 2");

		Entradacta entradasnew = entradaActaervice.save(entradas);
		log.info("************************************ 3");
		EntradactaDTO EntradactaDTOnew = EntradactaMapper.toEntradActaDTO(entradasnew);

		log.info("************************************ 4");
		return ResponseEntity.ok().body(EntradactaDTOnew);
	}


	/// REUNION 9 reunion

	@PutMapping("/updateEntradaActa")
	public ResponseEntity<?> update(@Valid @RequestBody EntradactaDTO EntradactaDTO) throws Exception {
    	Acta acta = new Acta();
		acta.setIdactas(EntradactaDTO.getIdActa());
		Entradacta entradas = new Entradacta();
		entradas.setActas(acta);
		entradas.setIdentrada(EntradactaDTO.getIdentrada());
		entradas.setAcuerdos(EntradactaDTO.getAcuerdos());
		entradas.setFactores(EntradactaDTO.getFactores());
		entradas.setActivosprocesos(EntradactaDTO.getActivosprocesos());

		log.info("************ 2");

		Entradacta entradasnew = entradaActaervice.update(entradas);
		
		EntradactaDTO.setIdActa(entradasnew.getActas().getIdactas());
		EntradactaDTO.setIdentrada(entradasnew.getIdentrada());
		EntradactaDTO.setAcuerdos(entradasnew.getAcuerdos());
		EntradactaDTO.setFactores(entradasnew.getFactores());
		EntradactaDTO.setActivosprocesos(entradasnew.getActivosprocesos());
		
		return ResponseEntity.ok().body(EntradactaDTO);  
	}

}
