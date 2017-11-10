package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Ciudad;

public interface CiudadService {

    Iterable<Ciudad> listAllCiudades();

    Ciudad getCiudadById(Integer id);

    Ciudad saveCiudad(Ciudad ciudad);

    void deleteCiudad(Integer id);
}
