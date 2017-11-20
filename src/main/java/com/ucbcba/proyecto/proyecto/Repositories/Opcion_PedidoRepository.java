package com.ucbcba.proyecto.proyecto.Repositories;

import com.ucbcba.proyecto.proyecto.Entities.Opcion_Pedido;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface Opcion_PedidoRepository extends CrudRepository<Opcion_Pedido,Integer> {
}
