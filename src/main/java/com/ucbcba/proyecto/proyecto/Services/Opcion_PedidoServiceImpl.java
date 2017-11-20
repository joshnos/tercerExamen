package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Opcion_Pedido;
import com.ucbcba.proyecto.proyecto.Repositories.Opcion_PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Opcion_PedidoServiceImpl implements Opcion_PedidoService{

    private Opcion_PedidoRepository opcion_pedidoRepository;
    @Autowired
    @Qualifier(value = "opcion_PedidoRepository")
    private void setOpcion_pedidoRepository(Opcion_PedidoRepository opcion_pedidoRepository){
        this.opcion_pedidoRepository=opcion_pedidoRepository;
    }

    @Override
    public Iterable<Opcion_Pedido> listAllOpcion_Pedido() {
        return opcion_pedidoRepository.findAll();
    }

    @Override
    public Opcion_Pedido getOpcion_PedidoById(Integer id) {
        return opcion_pedidoRepository.findOne(id);
    }

    @Override
    public Opcion_Pedido saveOpcion_Pedido(Opcion_Pedido opcion_pedido) {
        return opcion_pedidoRepository.save(opcion_pedido);
    }

    @Override
    public void deleteOpcion_Pedido(Integer id) {
opcion_pedidoRepository.delete(id);
    }
}
