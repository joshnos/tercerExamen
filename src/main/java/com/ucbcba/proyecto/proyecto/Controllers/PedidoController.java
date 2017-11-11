package com.ucbcba.proyecto.proyecto.Controllers;

import  com.ucbcba.proyecto.proyecto.Entities.Pedido;
import com.ucbcba.proyecto.proyecto.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PedidoController {

    private PedidoService pedidoService;
    @Autowired
    public void setPedidoService(PedidoService pedidoService){this.pedidoService=pedidoService;}

    @RequestMapping(value="/pedidos", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("pedidos",pedidoService.listAllPedidos());
        return "pedidos";
    }
}
