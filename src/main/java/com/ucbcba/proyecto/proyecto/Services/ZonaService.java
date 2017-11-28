package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Zona;

public interface ZonaService {
    Iterable<Zona> listAllZonas();

    Zona getZonaById(Integer id);

    Zona saveZona(Zona zona);

    void deleteZona(Integer id);
}
