package com.tesis.v1.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.pdp.Entradas;
import com.tesis.v1.repository.pdp.entradaPdpRepository;

@Service
@Scope("singleton")
public class entradasPdpServiceImpl implements entradasPdpService {

    @Autowired
    entradaPdpRepository entradaPdpRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Entradas> findAll() {
        //  Auto-generated method stub
        return entradaPdpRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Entradas> findById(Integer id) throws Exception {
        if (id < 0 || id == null) {
            throw new Exception("error en el identificador");
        }
        return entradaPdpRepository.findById(id);
    }

    @Override
    public Long count() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Entradas save(Entradas entity) throws Exception {

        return entradaPdpRepository.save(entity);
    }

    @Override
    public Entradas update(Entradas entity) throws Exception {
        //  Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Entradas entity) throws Exception {
        //  Auto-generated method stub
        if (entity == null) {
            throw new Exception("La entrada acta es nulo");
        }
        if (entity.getIdentradapdp() == null || entity.getIdentradapdp() <= 0) {
            throw new Exception("La id es obligatoria");

        }
        if (entradaPdpRepository.existsById(entity.getIdentradapdp()) == false) {
            throw new Exception("La entrada acta  con id No existe (No se puede eliminar)");
        }
        entradaPdpRepository.deleteById(entity.getIdentradapdp());
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        //  Auto-generated method stub

    }

    @Override
    public void validate(Entradas entity) throws Exception {
        //  Auto-generated method stub

    }

    @Override
    @Transactional(readOnly = true)
    public Entradas BuscarEntradasPdpPorIdDelProyecto(Integer id) throws Exception {
        if (id < 0 || id == null) {
            throw new Exception("error en el identificador");
        }
        return entradaPdpRepository.BuscarEntradasPdpPorIdDelProyecto(id);
    }


}
