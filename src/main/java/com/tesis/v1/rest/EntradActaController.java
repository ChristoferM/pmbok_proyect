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
import com.tesis.v1.dto.CasoDeNegocioDelActaDTO;
import com.tesis.v1.dto.EntradaDelActaDTO;
import com.tesis.v1.dto.EntradactaDTO;
import com.tesis.v1.dto.HerramientasDelActaDTO;
import com.tesis.v1.dto.PlanDeGestionDeBeneficiosDelActaDTO;
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
	
	// Métodos para buscar los datos previos de la entrada del Acta
	@RequestMapping("/BuscarDatosDeEntradas")
	public ResponseEntity<?> BuscarDatosDeEntradas(@Valid @RequestBody EntradaDelActaDTO EntradactaDTO) throws Exception {
		
		List<Entradacta> EntradactaLIST = entradaActaervice.BuscarDatosDeEntradas(EntradactaDTO);
		List<EntradactaDTO> EntradactaListDto = new ArrayList<>();
		for(Entradacta entrada :EntradactaLIST) {
			
			EntradactaDTO dto = new EntradactaDTO();
			dto.setIdentrada(entrada.getIdentrada());
			dto.setIdActa(entrada.getActas().getIdactas());
			dto.setAcuerdos(entrada.getAcuerdos());
			dto.setActivosprocesos(entrada.getActivosprocesos());
			dto.setEstado(entrada.getEstado());
			dto.setFactores(entrada.getFactores());
			dto.setParticipa(entrada.getParticipa());

			EntradactaListDto.add(dto);
			
		}
		return ResponseEntity.ok().body(EntradactaListDto);
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
	
	// *************************** Métodos para guardar la información de manera colaborativa
	@RequestMapping("/guardarEntradaDelActa")
	public ResponseEntity<?> guardarEntradaDelActa(@Valid @RequestBody EntradaDelActaDTO EntradactaDTO) throws Exception {
		log.info("********* Guardando Entradas del acta \n public ResponseEntity<?> guardarEntradaDelActa\n ");

		return ResponseEntity.ok().body(
				EntradactaMapper.toEntradActaDTO(
						entradaActaervice.guardarEntradaDelActa(EntradactaDTO)
						)
				);
	}
	



	// *************************** Métodos para guardar la información de manera colaborativa
	
	@RequestMapping("/actualiazrEntradaDelActa")
	public ResponseEntity<?> actualiazrEntradaDelActa(@Valid @RequestBody EntradaDelActaDTO EntradactaDTO) throws Exception {
		log.info("********* Actualizar Entradas del acta \n public ResponseEntity<?> actualiazrEntradaDelActa\n ");
		Entradacta domine =entradaActaervice.actualiazrEntradaDelActa(EntradactaDTO);
		EntradactaDTO EntradactaDTOnew  = new EntradactaDTO();
		EntradactaDTOnew.setAcuerdos(domine.getAcuerdos());
		EntradactaDTOnew.setActivosprocesos(domine.getActivosprocesos());
		EntradactaDTOnew.setEstado(domine.getEstado());
		EntradactaDTOnew.setFactores(domine.getFactores());
		EntradactaDTOnew.setIdActa(domine.getActas().getIdactas());
		EntradactaDTOnew.setIdentrada(domine.getIdentrada());
		EntradactaDTOnew.setParticipa(domine.getParticipa());
		
			
		return ResponseEntity.ok().body(EntradactaDTOnew);
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

		Entradacta entradasnew = entradaActaervice.save(entradas);
		
		EntradactaDTO EntradactaDTOnew = EntradactaMapper.toEntradActaDTO(entradasnew);
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
