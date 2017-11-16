package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Opcion_Pedido;

public interface Opcion_PedidoService {
    Iterable<Opcion_Pedido> listAllOpcion_Pedido();

    Opcion_Pedido getOpcion_PedidoById(Integer id);

    Opcion_Pedido saveEmpresa(Opcion_Pedido opcion_pedido);

    void deleteOpcion_Pedido(Integer id);
}
