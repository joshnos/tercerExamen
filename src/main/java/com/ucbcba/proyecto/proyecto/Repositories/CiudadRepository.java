package com.ucbcba.proyecto.proyecto.Repositories;

import com.ucbcba.proyecto.proyecto.Entities.Ciudad;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CiudadRepository extends CrudRepository<Ciudad,Integer> {
}
