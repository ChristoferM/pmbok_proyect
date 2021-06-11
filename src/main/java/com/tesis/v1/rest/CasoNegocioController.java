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

import com.tesis.v1.domain.CasoNegocio;
import com.tesis.v1.domain.Entradacta;
import com.tesis.v1.dto.CasoNegocioDTO;
import com.tesis.v1.service.CasoNegocioService;
import com.tesis.v1.service.EntradaActaService;
import com.tesis.v1.mapper.CasoNegocioMapper;
import org.springframework.web.bind.annotation.PutMapping;

@RestController // Servicio
@RequestMapping("/api/CasoNegocio") // Forma de llamar datos
@CrossOrigin
public class CasoNegocioController {

    private final static Logger log = LoggerFactory.getLogger(CasoNegocioController.class);

    @Autowired
    EntradaActaService entradaActaService;

    @Autowired
    CasoNegocioService CasoNegocioService;

    @Autowired
    CasoNegocioMapper casonegocioMapper;

    @RequestMapping("/finById/{casoId}")
    public ResponseEntity<?> finById(@PathVariable("casoId") Integer casoId) throws Exception {
        //casonegocio casonegocio0 = new CasoNegocio (); 
        Optional<CasoNegocio> casonegocioopc = CasoNegocioService.findById(casoId);

        log.info("Cargando ...");
      
        CasoNegocio casonegocio = casonegocioopc.get();

        CasoNegocioDTO casonegocioDTO = casonegocioMapper.tocasoNegocioDTO(casonegocio);
        casonegocioDTO.setIdEntradaActa(casonegocio.getEntradacta().getIdentrada());
        log.info("*");
        return ResponseEntity.ok().body(casonegocioDTO);

    }

    @RequestMapping("/findCasoNegocioDelActa/{idProyecto}")
    public ResponseEntity<?> casoNegocioDelActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
        List<CasoNegocio> casonegocioLIST = CasoNegocioService.casoNegocioDelActa(idProyecto);

		List<CasoNegocioDTO> listDTO = new ArrayList<CasoNegocioDTO>(casonegocioLIST.size());
		
		for (CasoNegocio casoNegocio1 : casonegocioLIST) {

			CasoNegocioDTO casoNegocioDTO = new CasoNegocioDTO();

			casoNegocioDTO.setIdEntradaActa(casoNegocio1.getEntradacta().getIdentrada());
			casoNegocioDTO.setId_caso_negocio(casoNegocio1.getId_caso_negocio());
			casoNegocioDTO.setMetas(casoNegocio1.getMetas());
			casoNegocioDTO.setObjetivos(casoNegocio1.getObjetivos());
			casoNegocioDTO.setIncidentes(casoNegocio1.getIncidentes());
			casoNegocioDTO.setOportunidades(casoNegocio1.getOportunidades());
			listDTO.add(casoNegocioDTO);
		}

		return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping("/findByAll")
    public ResponseEntity<?> finByAll() throws Exception {

        List<CasoNegocio> casonegocioLIST = CasoNegocioService.findAll();

        List<CasoNegocioDTO> casonegocioDTO = casonegocioMapper.tocasoNegocioDTO(casonegocioLIST);

        return ResponseEntity.ok().body(casonegocioDTO);
    }

    @RequestMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody CasoNegocioDTO casonegocioDTO) throws Exception {
        log.info("************************************ 1");
        /*
		private Integer idEntradaActa;
		private Integer id_caso_negocio;
		private String metas;
		private String objetivos;
		private String incidentes;
		private String oportunidades;
         */
        CasoNegocio casonegocio = new CasoNegocio();
        Entradacta entradas = new Entradacta();
        casonegocio.setId_caso_negocio(casonegocioDTO.getId_caso_negocio());
        casonegocio.setMetas(casonegocioDTO.getMetas());
        casonegocio.setObjetivos(casonegocioDTO.getObjetivos());
        casonegocio.setIncidentes(casonegocioDTO.getIncidentes());
        casonegocio.setOportunidades(casonegocioDTO.getOportunidades());
        entradas.setIdentrada(casonegocioDTO.getIdEntradaActa());
        casonegocio.setEntradacta(entradas);

        log.info("************************************ 2");

        CasoNegocio casonegocionew = CasoNegocioService.save(casonegocio);

        log.info("************************************ 3");
        CasoNegocioDTO casonegocioDTOnew = casonegocioMapper.tocasoNegocioDTO(casonegocionew);

        log.info("************************************ 4");
        return ResponseEntity.ok().body(casonegocioDTOnew);
    }
    
    /// JUNIO 9 reunion
  
    @PutMapping("/updateCasoNegocio")
    public ResponseEntity<?> update(@Valid @RequestBody CasoNegocioDTO casonegocioDTO) throws Exception {
        
           
    	  CasoNegocio casonegocio = new CasoNegocio();
          Entradacta entradas = new Entradacta();
          casonegocio.setId_caso_negocio(casonegocioDTO.getId_caso_negocio());
          casonegocio.setMetas(casonegocioDTO.getMetas());
          casonegocio.setObjetivos(casonegocioDTO.getObjetivos());
          casonegocio.setIncidentes(casonegocioDTO.getIncidentes());
          casonegocio.setOportunidades(casonegocioDTO.getOportunidades());
          entradas.setIdentrada(casonegocioDTO.getIdEntradaActa());
          casonegocio.setEntradacta(entradas);

          log.info("************ 2");

          CasoNegocio casonegocionew = CasoNegocioService.update(casonegocio);

          casonegocioDTO.setId_caso_negocio(casonegocionew.getId_caso_negocio());
          casonegocioDTO.setMetas(casonegocionew.getMetas());
          casonegocioDTO.setObjetivos(casonegocionew.getObjetivos());
          casonegocioDTO.setIncidentes(casonegocionew.getIncidentes());
          casonegocioDTO.setOportunidades(casonegocionew.getOportunidades());
          
          casonegocioDTO.setIdEntradaActa(casonegocionew.getEntradacta().getIdentrada());

      
        return ResponseEntity.ok().body(casonegocioDTO);
    }

}
