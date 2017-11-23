package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Pedido;

public interface PedidoService {
    Iterable<Pedido> listAllPedidos();
    Pedido getPedidoById(Integer id);

    Pedido savePedido(Pedido pedido);

    void deletePedido(Integer id);

}
