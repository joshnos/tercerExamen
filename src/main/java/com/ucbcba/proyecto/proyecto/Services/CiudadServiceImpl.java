package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Ciudad;
import com.ucbcba.proyecto.proyecto.Repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CiudadServiceImpl implements CiudadService {

    private CiudadRepository ciudadRepository;

    @Autowired
    @Qualifier(value = "ciudadRepository")
    private  void setCiudadRepository(CiudadRepository ciudadRepository){
        this.ciudadRepository=ciudadRepository;
    }

    @Override
    public Iterable<Ciudad> listAllCiudades() {
        return ciudadRepository.findAll();
    }

    @Override
    public Ciudad getCiudadById(Integer id) {
        return ciudadRepository.findOne(id);
    }

    @Override
    public Ciudad saveCiudad(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public void deleteCiudad(Integer id) {
        ciudadRepository.delete(id);
    }
}
