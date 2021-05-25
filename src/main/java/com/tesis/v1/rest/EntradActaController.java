package com.tesis.v1.rest;

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
    EntradaActaService entradaActaService;

    @Autowired
    ActaService actaService;

    @Autowired
    EntradactaMapper entradactaMapper;

    @RequestMapping("/validarActa/{idProyecto}")
    public ResponseEntity<?> finByAll(@PathVariable("idProyecto") Integer idProyecto) throws Exception {

        log.info("Validando Acta");

        ValidarActaDTO validaciones = new ValidarActaDTO();
        log.info("validaciones realizadas");

        validaciones = entradaActaService.encontrarData(idProyecto);
        log.info("Resquest de validaciones");

        return ResponseEntity.ok().body(validaciones);
    }

    @RequestMapping("/finById/{entradaId}")
    public ResponseEntity<?> finById(@PathVariable("entradaId") Integer entradaId) throws Exception {

        Optional<Entradacta> entradactaopc = entradaActaService.findById(entradaId);
        log.info("Cargando ...");
        if (entradactaopc.isEmpty()) {
            return ResponseEntity.ok().body("Error: No se encontro La referencia");

        }
        Entradacta entradActa = entradactaopc.get();
        EntradactaDTO entradactaDTO = entradactaMapper.toEntradActaDTO(entradActa);
        log.info("*");
        return ResponseEntity.ok().body(entradactaDTO);

    }

    @RequestMapping("/findByAll")
    public ResponseEntity<?> finByAll() throws Exception {
        //actas acta
        List<Entradacta> entradactaLIST = entradaActaService.findAll();

        List<EntradactaDTO> entradactaListDto = entradactaMapper.toEntradActaDTO(entradactaLIST);

        return ResponseEntity.ok().body(entradactaListDto);
    }

    @RequestMapping("/entradaDelActa/{idProyecto}")
    public ResponseEntity<?> entradaDelActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
        //actas acta
        List<Entradacta> entradactaLIST = entradaActaService.entradaDelActa(idProyecto);

        List<EntradactaDTO> entradactaListDto = entradactaMapper.toEntradActaDTO(entradactaLIST);

        return ResponseEntity.ok().body(entradactaListDto);
    }

    @RequestMapping("/getIdActa/{idProyecto}")
    public ResponseEntity<?> valorIdActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
        //actas acta
        Integer idActa = entradaActaService.valorIdActa(idProyecto);

        return ResponseEntity.ok().body(idActa);
    }

    @RequestMapping("/getEntradaIdActa/{idProyecto}")
    public ResponseEntity<?> valorIdEntraActa(@PathVariable("idProyecto") Integer idProyecto) throws Exception {
        //actas acta
        Integer idActa = entradaActaService.valorIdEntraActa(idProyecto);

        return ResponseEntity.ok().body(idActa);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@Valid @RequestBody EntradactaDTO entradactaDTO) throws Exception {
        
           
        Entradacta entradasnew = entradactaMapper.toEntradActa(entradactaDTO);      
        entradasnew = entradaActaService.update(entradasnew);
        entradactaDTO = entradactaMapper.toEntradActaDTO(entradasnew);
   
        return ResponseEntity.ok().body(entradactaDTO);
    }
    
    
    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody EntradactaDTO entradactaDTO) throws Exception {
        log.info("************************************ 1");
        /*
		 * private Integer idActa;
		private Integer identrada ;
		private String acuerdos ;
		private String factores;
		private String activosprocesos ;
         */
        Acta acta = new Acta();
        acta.setIdactas(entradactaDTO.getIdActa());
        Entradacta entradas = new Entradacta();
        entradas.setActas(acta);
        entradas.setAcuerdos(entradactaDTO.getAcuerdos());
        entradas.setFactores(entradactaDTO.getFactores());
        entradas.setActivosprocesos(entradactaDTO.getActivosprocesos());

        log.info("************************************ 2");

        Entradacta entradasnew = entradaActaService.save(entradas);
        log.info("************************************ 3");
        EntradactaDTO entradactaDTOnew = entradactaMapper.toEntradActaDTO(entradasnew);

        log.info("************************************ 4");
        return ResponseEntity.ok().body(entradactaDTOnew);
    }


}
