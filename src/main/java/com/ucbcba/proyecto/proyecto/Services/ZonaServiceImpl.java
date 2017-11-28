package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Zona;
import com.ucbcba.proyecto.proyecto.Repositories.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ZonaServiceImpl implements ZonaService {

    private ZonaRepository zonaRepository;

    @Autowired
    @Qualifier(value = "zonaRepository")
    private  void setZonaRepository(ZonaRepository zonaRepository){
        this.zonaRepository=zonaRepository;
    }

    @Override
    public Iterable<Zona> listAllZonas() {
        return zonaRepository.findAll();
    }

    @Override
    public Zona getZonaById(Integer id) {
        return zonaRepository.findOne(id);
    }

    @Override
    public Zona saveZona(Zona zona) {
        return zonaRepository.save(zona);
    }

    @Override
    public void deleteZona(Integer id) {
        zonaRepository.delete(id);
    }
}
