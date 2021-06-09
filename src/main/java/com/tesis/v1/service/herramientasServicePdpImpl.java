package com.tesis.v1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tesis.v1.domain.pdp.Herramientas;
import com.tesis.v1.repository.pdp.herramientasPdpRepository;

@Service
@Scope("singleton")
public class herramientasServicePdpImpl implements herramientasServicePdp {

    @Autowired
    herramientasPdpRepository herramientasPdpRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Herramientas> findAll() {
        //  Auto-generated method stub
        return herramientasPdpRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Herramientas> findById(Integer id) throws Exception {
        //  Auto-generated method stub
        if (id < 0 || id == null) {
            throw new Exception("error en el identificador");
        }
        return herramientasPdpRepository.findById(id);
    }

    @Override
    public Long count() {
        //  Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Herramientas save(Herramientas entity) throws Exception {
        //  Auto-generated method stub
        return herramientasPdpRepository.save(entity);
    }

    @Override
    public Herramientas update(Herramientas entity) throws Exception {
        //  Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(Herramientas entity) throws Exception {
        //  Auto-generated method stub
        if (entity == null) {
            throw new Exception("La entrada acta es nulo");
        }
        if (entity.getIdherramienta() == null || entity.getIdherramienta() <= 0) {
            throw new Exception("La id es obligatoria");

        }
        if (herramientasPdpRepository.existsById(entity.getIdherramienta()) == false) {
            throw new Exception("La entrada acta  con id No existe (No se puede eliminar)");
        }
        herramientasPdpRepository.deleteById(entity.getIdherramienta());
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        //  Auto-generated method stub

    }

    @Override
    public void validate(Herramientas entity) throws Exception {
        //  Auto-generated method stub

    }


    // JUNIO 8 AGREGADO POR REUNION

    @Override
	@Transactional(readOnly = true)
	public Herramientas BuscarHerramientasPdpPorIdDelProyecto(Integer id) throws Exception {

		return herramientasPdpRepository.BuscarHerramientasPdpPorIdDelProyecto(id);
	}
}
