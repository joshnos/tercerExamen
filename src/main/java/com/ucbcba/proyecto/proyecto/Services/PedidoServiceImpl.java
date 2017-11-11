package com.ucbcba.proyecto.proyecto.Services;

import com.ucbcba.proyecto.proyecto.Entities.Pedido;
import com.ucbcba.proyecto.proyecto.Repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements  PedidoService{

    private PedidoRepository pedidoRepository;

    @Autowired
    @Qualifier(value = "pedidoRepository")
    public void setPedidoRepository(PedidoRepository pedidoRepository){
        this.pedidoRepository=pedidoRepository;
    }


    @Override
    public Iterable<Pedido> listAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido getPedidoById(Integer id) {
        return pedidoRepository.findOne(id);
    }

    @Override
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

}
