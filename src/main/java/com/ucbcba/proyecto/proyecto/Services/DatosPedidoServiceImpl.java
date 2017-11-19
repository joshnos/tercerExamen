package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.DatosPedido;
import com.ucbcba.proyecto.proyecto.Repositories.DatosPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DatosPedidoServiceImpl implements DatosPedidoService {

    private DatosPedidoRepository datosPedidoRepository;


    @Autowired
    @Qualifier(value="datosPedidoRepository")
    public void setDatosPedidoRepository(DatosPedidoRepository datosPedidoRepository) {
        this.datosPedidoRepository = datosPedidoRepository;
    }

    @Override
    public DatosPedido getDatosPedidoById(Integer id){ return datosPedidoRepository.findOne(id);}

    @Override
    public DatosPedido saveDatosPedido(DatosPedido datosPedido) {
        return datosPedidoRepository.save(datosPedido);
    }
}
