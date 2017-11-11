package com.ucbcba.proyecto.proyecto.Repositories;

import com.ucbcba.proyecto.proyecto.Entities.Pedido;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
}
