package com.tesis.v1.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesis.v1.domain.FaseProyecto;
import com.tesis.v1.domain.Proyecto;
import com.tesis.v1.domain.Reunion;
import com.tesis.v1.dto.ReunionesDTO;
import com.tesis.v1.service.ReunionesService;
import com.tesis.v1.mapper.ReunionMapper;

@RestController // Servicio
@RequestMapping("/api/Reunion") // Forma de llamar datos
@CrossOrigin
public class ReunionController {

    private final static Logger log = LoggerFactory.getLogger(ReunionController.class);

    @Autowired
    ReunionesService reunionesService;

    @Autowired
    ReunionMapper reunionesMapper;

    @RequestMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody ReunionesDTO reunionesDTO) throws Exception {
        log.info("************************************ Reuniones save ");
        FaseProyecto faseproyecto = new FaseProyecto();
        Proyecto proyectos = new Proyecto();

        Reunion reunion = new Reunion();
        reunion.setDescripcionreunion(reunionesDTO.getDescripcionreunion());
        reunion.setNombrereunion(reunionesDTO.getNombrereunion());

        faseproyecto.setIdfase(reunionesDTO.getIdfase());
        reunion.setFaseproyecto(faseproyecto);

        proyectos.setIdproyecto(reunionesDTO.getIdproyecto());
        reunion.setProyectos(proyectos);

        log.info("************************************ 2");

        Reunion reunionnew = reunionesService.save(reunion);
        log.info("************************************ 3");
        ReunionesDTO reunionesDTOnew = new ReunionesDTO();

        reunionesDTOnew = reunionesMapper.toReunionDTO(reunionnew);

        log.info("************************************ Fin Reuniones Save");
        return ResponseEntity.ok().body(reunionesDTOnew);

    }
}
