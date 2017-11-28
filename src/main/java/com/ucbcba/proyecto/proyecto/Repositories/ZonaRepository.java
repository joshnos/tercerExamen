package com.ucbcba.proyecto.proyecto.Repositories;

import com.ucbcba.proyecto.proyecto.Entities.Zona;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ZonaRepository extends CrudRepository<Zona, Integer> {
}
