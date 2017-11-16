package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.DatosPedido;

public interface DatosPedidoService {


    DatosPedido getDatosPedidoById(Integer id);

   DatosPedido saveDatosPedido(DatosPedido datosPedido);
}
