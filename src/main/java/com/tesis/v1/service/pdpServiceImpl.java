package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.pdp.Pdp;
import com.tesis.v1.repository.pdp.pdpRepository;
import com.tesis.v1.repository.ReunionRepository;

@Service
@Scope("singleton")
public class pdpServiceImpl implements pdpService {

    private final static Logger log = LoggerFactory.getLogger(pdpServiceImpl.class);

    @Autowired
    pdpRepository pdpRepository;

    @Autowired
    ReunionRepository reunionesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Pdp> findAll() {
        return pdpRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pdp> findById(Integer id) throws Exception {

        if (id < 0 || id == null) {
            throw new Exception("error en el identificador");
        }
        return pdpRepository.findById(id);
    }

    @Override
    public Long count() {
        log.info("count");
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Pdp save(Pdp entity) throws Exception {
        if (entity == null) {
            throw new Exception("error en peticion");
        }
        return pdpRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Pdp update(Pdp entity) throws Exception {
        if (entity == null) {
            throw new Exception("error en peticion");
        }
        return pdpRepository.save(entity);
    }

    @Override
    public void delete(Pdp entity) throws Exception {
        if (entity == null) {
            throw new Exception("Error Con el Plan...");
        }
        if (entity.getReuniones() == null || entity.getReuniones().getIdreuniones() < 0) {
            throw new Exception("ERROR ES SERVICIOS");
        }
        pdpRepository.deleteById(entity.getIdpdp());

    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public void validate(Pdp entity) throws Exception {

    }

}
