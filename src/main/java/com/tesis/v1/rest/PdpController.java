package com.tesis.v1.rest;

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

import com.tesis.v1.domain.Reunion;
import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.domain.pdp.Herramientas;
import com.tesis.v1.domain.pdp.Pdp;
import com.tesis.v1.dto.pdp.EntradasDTO;
import com.tesis.v1.dto.pdp.HerramientasDTO;
import com.tesis.v1.dto.pdp.PdpDTO;
import com.tesis.v1.service.entradasPdpService;
import com.tesis.v1.service.herramientasServicePdp;
import com.tesis.v1.service.pdpService;
import com.tesis.v1.mapper.PdpEntradasMapper;
import com.tesis.v1.mapper.PdpHerramientasMapper;
import com.tesis.v1.mapper.PdpMapper;

@RestController // Servicio
@RequestMapping("/api/pdp") // Forma de llamar datos
@CrossOrigin
public class PdpController {

    private final static Logger log = LoggerFactory.getLogger(PdpController.class);

    @Autowired
    pdpService pdpServices;

    @Autowired
    entradasPdpService entradasPdpServices;

    @Autowired
    herramientasServicePdp herramientasServicePdps;

    @Autowired
    PdpMapper pdpMapper;

    @Autowired
    PdpHerramientasMapper pdpHerramientasMapper;

    @Autowired
    PdpEntradasMapper pdpEntradasMapper;

    @RequestMapping("/savePdp")
    public ResponseEntity<?> savePdp(@Valid @RequestBody PdpDTO pdpDTO) throws Exception {
        log.info("GUARDANDADO ");
        Pdp pdp = new Pdp();
        Reunion reuniones0 = new Reunion();
        reuniones0.setIdreuniones(pdpDTO.getIdreuniones());

        pdp.setReuniones(reuniones0);
        PdpDTO pdp0 = new PdpDTO();
        pdp = pdpServices.save(pdp);

        pdp0.setIdpdp(pdp.getIdpdp());
        pdp0.setIdreuniones(pdp.getReuniones().getIdreuniones());
        return ResponseEntity.ok().body(pdp0);
    }

    @RequestMapping("/saveHerramientasPdp")
    public ResponseEntity<?> saveHerramientasPdp(@Valid @RequestBody HerramientasDTO herramientasDTO) throws Exception {
        log.info("GUARDANDADO ");
        Pdp pdp = new Pdp();
        Herramientas herramientasPdp = new Herramientas();
        pdp.setIdpdp(
                herramientasDTO.getIdpdp());
        herramientasPdp.setPdp(pdp);

        herramientasPdp.setJuicioexpertos(
                herramientasDTO.getJuicioexpertos());

        herramientasPdp.setRecopilaciondatos(
                herramientasDTO.getRecopilaciondatos());

        herramientasPdp.setHabilidades(
                herramientasDTO.getHabilidades());

        herramientasPdp.setHerramientareuniones(
                herramientasDTO.getHerramientareuniones());
        //herramientasacta herramientasactaNew = herramientasActasService.save(herramienta);

        herramientasPdp = herramientasServicePdps.save(herramientasPdp);

        HerramientasDTO herramientasDTOs = pdpHerramientasMapper.toherramientaDTO(herramientasPdp);

        return ResponseEntity.ok().body(herramientasDTOs);
    }

    @RequestMapping("/saveEntradasPdp")
    public ResponseEntity<?> saveEntradasPdp(@Valid @RequestBody EntradasDTO entradasDTO) throws Exception {

        // PdpEntradasMapper
        //entradasPdpServices
        log.info("GUARDANDADO ");

        Pdp pdp = new Pdp();

        pdp.setIdpdp(entradasDTO.getIdpdp());
        Entradas entradasPdp = new Entradas();

        entradasPdp.setPdp(pdp);
        entradasPdp.setOtrosprocesos(entradasDTO.getOtrosprocesos());
        entradasPdp.setFactoresambientales(entradasDTO.getFactoresambientales());
        entradasPdp.setActivosprocesos(entradasDTO.getActivosprocesos());

        entradasPdp = entradasPdpServices.save(entradasPdp);

        entradasDTO = pdpEntradasMapper.toEntradasPdpDTO(entradasPdp);
        log.info(entradasPdp.getIdentradapdp().toString());
        entradasDTO.setIdentradapdp(entradasPdp.getIdentradapdp());
        entradasDTO.setIdpdp(entradasPdp.getPdp().getIdpdp());
        log.info(entradasPdp.getPdp().getIdpdp().toString());
        return ResponseEntity.ok().body(entradasDTO);
    }

    // --- Controllers de buscar 
    @RequestMapping("/BuscarPdp/{id}")//pdpServices
    public ResponseEntity<?> findByIdPdp(@PathVariable("id") Integer id) throws Exception {
        //
        Optional<Pdp> pdpOpt = pdpServices.findById(id);
        log.info("Cargando ...");
        if (pdpOpt.isEmpty()) {
            return ResponseEntity.ok().body("Error: No se encontro Usuario");

        }
        Pdp pdps = pdpOpt.get();
        PdpDTO pdpDTOs = pdpMapper.toPdpDTO(pdps);
        log.info(pdps.getIdpdp().toString());
        pdpDTOs.setIdpdp(pdps.getIdpdp());
        pdpDTOs.setIdreuniones(pdps.getReuniones().getIdreuniones());
        log.info("*");
        return ResponseEntity.ok().body(pdpDTOs);
    }

    @RequestMapping("/BuscarHerramientasPdp/{id}")//herramientasServicePdp
    public ResponseEntity<?> findByIdHerramientasPdp(@PathVariable("id") Integer id) throws Exception {
        //herramientasDTO
        //herramientas
        Optional<Herramientas> herramientaspdpOpt = herramientasServicePdps.findById(id);
        log.info("Cargando ...");
        if (herramientaspdpOpt.isEmpty()) {
            return ResponseEntity.ok().body("Error: No se encontro El Dato");

        }
        Herramientas herramientasPdp = herramientaspdpOpt.get();
        HerramientasDTO herramientasDTOs = pdpHerramientasMapper.toherramientaDTO(herramientasPdp);

        //log.info(herramientasPdp.getPdp().getIdpdp().toString());
        herramientasDTOs.setIdpdp(herramientasPdp.getPdp().getIdpdp());
        return ResponseEntity.ok().body(herramientasDTOs);
    }

    @RequestMapping("/BuscarEntradasPdp/{id}")// entradasPdpServices
    public ResponseEntity<?> findByIdEntradasPdp(@PathVariable("id") Integer id) throws Exception {
        //entradasPdpServices
        //pdpEntradasMapper
        //entradasDTO
        //entradas

        Optional<Entradas> entradaspdpOpt = entradasPdpServices.findById(id);
        log.info("Cargando ...");
        if (entradaspdpOpt.isEmpty()) {
            return ResponseEntity.ok().body("Error: No se encontro El Dato");

        }
        Entradas entradasPdp = entradaspdpOpt.get();
        EntradasDTO entradasDTOs = pdpEntradasMapper.toEntradasPdpDTO(entradasPdp);
        //log.info(herramientasPdp.getPdp().getIdpdp().toString());
        entradasDTOs.setIdpdp(entradasPdp.getPdp().getIdpdp());
        return ResponseEntity.ok().body(entradasDTOs);
    }
}
