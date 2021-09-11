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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.v1.domain.Acta;
import com.tesis.v1.domain.Herramientasacta;
import com.tesis.v1.dto.EntradaDelActaDTO;
import com.tesis.v1.dto.HerramientasActaDTO;
import com.tesis.v1.dto.HerramientasDelActaDTO;
import com.tesis.v1.dto.pdp.HerramientasDTO;
import com.tesis.v1.service.ActaService;
import com.tesis.v1.service.HerramientasActasService;
import com.tesis.v1.mapper.HerramientasactaMapper;

@RestController // Servicio
@RequestMapping("/api/herramientasActa") // Forma de llamar datos
@CrossOrigin
public class HerramientasActaController {

    private final static Logger log = LoggerFactory.getLogger(HerramientasActaController.class);

    @Autowired
    HerramientasactaMapper herramientasactaMapper;

    @Autowired
    HerramientasActasService herramientasActasService;

    @Autowired
    ActaService actaService;

    @RequestMapping("/findHerramientaDelActa/{idProyecto}")
    public ResponseEntity<?> herramientaDelActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
        List<Herramientasacta> herramientaLIST = herramientasActasService.herramientaDelActa(idProyecto);

		List<HerramientasActaDTO> listDTO = new ArrayList<HerramientasActaDTO>(herramientaLIST.size());
		for (Herramientasacta herramientasActa : herramientaLIST) {

			HerramientasActaDTO herramientasActaDTO = new HerramientasActaDTO();
			
			herramientasActaDTO.setIdactas(herramientasActa.getActas().getIdactas() );
			herramientasActaDTO.setIdherramienta(herramientasActa.getIdherramienta());
			herramientasActaDTO.setJuicioexpertos(herramientasActa.getJuicioexpertos());
			herramientasActaDTO.setRecopilaciondatos(herramientasActa.getRecopilaciondatos());
			herramientasActaDTO.setHabilidades(herramientasActa.getHabilidades());
			herramientasActaDTO.setHerramientareuniones(herramientasActa.getHerramientareuniones());
			listDTO.add(herramientasActaDTO);
		}

		return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping("/finById/{herramientaId}")
    public ResponseEntity<?> finById(@PathVariable("herramientaId") Integer herramientaID) throws Exception {
        //herramientasacta herramienta= new Herramientasacta();

        Optional<Herramientasacta> herramientaoOpt = herramientasActasService.findById(herramientaID);
        log.info("Cargando ...");
        if (herramientaoOpt.isEmpty()) {
            return ResponseEntity.ok().body("Error: No se encontro Usuario");

        }
        Herramientasacta herramienta = herramientaoOpt.get();
        HerramientasActaDTO herramientasactaDTO = herramientasactaMapper.toherramientasActaDTO(herramienta);
        log.info("*");
        return ResponseEntity.ok().body(herramientasactaDTO);

    }

    @RequestMapping("/findByAll")
    public ResponseEntity<?> finByAll() throws Exception {
        List<Herramientasacta> herramientaLIST = herramientasActasService.findAll();
        List<HerramientasActaDTO> herramientaListDto = herramientasactaMapper.toherramientasActa(herramientaLIST);

        return ResponseEntity.ok().body(herramientaListDto);
    }

    @RequestMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody HerramientasActaDTO herramientasactaDTO) throws Exception {
        Acta acta = new Acta();
        acta.setIdactas(herramientasactaDTO.getIdactas());
        Herramientasacta herramienta = new Herramientasacta();
        herramienta.setIdherramienta(0);
        herramienta.setActas(acta);
        herramienta.setJuicioexpertos(herramientasactaDTO.getJuicioexpertos());
        herramienta.setRecopilaciondatos(herramientasactaDTO.getRecopilaciondatos());
        herramienta.setHabilidades(herramientasactaDTO.getHabilidades());
        herramienta.setHerramientareuniones(herramientasactaDTO.getHabilidades());

        Herramientasacta herramientasactaNew = herramientasActasService.save(herramienta);

        HerramientasActaDTO herramientaDto = herramientasactaMapper.toherramientasActaDTO(herramientasactaNew);

        return ResponseEntity.ok().body(herramientaDto);
    }


    /// JUNIO 9 reunion

    @PutMapping("/updateHerramientasAcata")
	public ResponseEntity<?> update(@Valid @RequestBody HerramientasActaDTO herramientasactaDTO) throws Exception {
    	 Acta acta = new Acta();
         acta.setIdactas(herramientasactaDTO.getIdactas());
         Herramientasacta herramienta = new Herramientasacta();
         herramienta.setIdherramienta(herramientasactaDTO.getIdherramienta());
         
         herramienta.setActas(acta);
         herramienta.setJuicioexpertos(herramientasactaDTO.getJuicioexpertos());
         herramienta.setRecopilaciondatos(herramientasactaDTO.getRecopilaciondatos());
         herramienta.setHabilidades(herramientasactaDTO.getHabilidades());
         herramienta.setHerramientareuniones(herramientasactaDTO.getHerramientareuniones());
         Herramientasacta herramientasactaNew = herramientasActasService.update(herramienta);
         
         herramientasactaDTO.setIdherramienta(herramientasactaNew.getIdherramienta());
         herramientasactaDTO.setJuicioexpertos(herramientasactaNew.getJuicioexpertos());
         herramientasactaDTO.setRecopilaciondatos(herramientasactaNew.getRecopilaciondatos());
         herramientasactaDTO.setHabilidades(herramientasactaNew.getHabilidades());
         herramientasactaDTO.setHerramientareuniones(herramientasactaNew.getHerramientareuniones());
         herramientasactaDTO.setIdactas(herramientasactaNew.getActas().getIdactas());
         return ResponseEntity.ok().body(herramientasactaDTO);

	}
    
    @RequestMapping("/actualiazrHerramientasDelActa")
	public ResponseEntity<?> actualiazrHerramientasDelActa(@Valid @RequestBody HerramientasDelActaDTO herramientasDelActaDTO) throws Exception {
		log.info("********* Actualizar HERRAMIENTAS del acta \n public  ResponseEntity<?> guardarHerramientasDelActa\n ");
		Herramientasacta domine = herramientasActasService.actualiazrHerramientasDelActa(herramientasDelActaDTO);
		
		HerramientasDTO dto = new HerramientasDTO();
		dto.setEstado(domine.getEstado());
		dto.setHabilidades(domine.getHabilidades());
		dto.setHerramientareuniones(domine.getHerramientareuniones());
		dto.setIdherramienta(domine.getIdherramienta());
		dto.setIdpdp(null);
		dto.setJuicioexpertos(domine.getJuicioexpertos());
		dto.setParticipa(domine.getParticipa());
		dto.setRecopilaciondatos(domine.getRecopilaciondatos());
		
		return ResponseEntity.ok().body(dto);
	}
	
    
	@RequestMapping("/guardarHerramientasDelActa")
	public ResponseEntity<?> guardarHerramientasDelActa(@Valid @RequestBody HerramientasDelActaDTO herramientasDelActaDTO) throws Exception {
		log.info("********* Guardando HERRAMIENTAS del acta \n public  ResponseEntity<?> guardarHerramientasDelActa\n ");
		
		return ResponseEntity.ok().body(herramientasActasService.guardarHerramientasDelActa(herramientasDelActaDTO));
	}
	
	@RequestMapping("/BuscarDatosDeHerramietasPrevias")
	public ResponseEntity<?> BuscarDatosDeHerramietasPrevias(@Valid @RequestBody HerramientasDelActaDTO herramientasDelActaDTO) throws Exception {
		
		List<Herramientasacta> herrmientasList = herramientasActasService.BuscarDatosDeHerramietasPrevias(herramientasDelActaDTO);
		List<HerramientasActaDTO> herrmientasListDTO = new ArrayList<>();
		
		/*
		   private Integer idherramienta;
		    private Integer idactas;
		    private String juicioexpertos;
		    private String recopilaciondatos;
		    private String habilidades;
		    private String herramientareuniones;
			private String participa ;*/
		
		for( Herramientasacta herramienta  :herrmientasList) {
			HerramientasActaDTO DTO = new HerramientasActaDTO();
			
			DTO.setIdactas(herramienta.getActas().getIdactas());
			DTO.setIdherramienta(herramienta.getIdherramienta());
			DTO.setJuicioexpertos(herramienta.getJuicioexpertos());
			DTO.setHabilidades(herramienta.getHabilidades());
			DTO.setHerramientareuniones(herramienta.getHerramientareuniones());
			DTO.setParticipa(herramienta.getParticipa());
			
			herrmientasListDTO.add(DTO);
		}
		  return ResponseEntity.ok().body(herrmientasListDTO);
	}

}
