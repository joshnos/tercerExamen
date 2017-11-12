package com.ucbcba.proyecto.proyecto.Controllers;

import  com.ucbcba.proyecto.proyecto.Entities.Pedido;
import com.ucbcba.proyecto.proyecto.Entities.User;
import com.ucbcba.proyecto.proyecto.Services.EmpresaService;
import com.ucbcba.proyecto.proyecto.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PedidoController {

    private EmpresaService empresaService;
    private PedidoService pedidoService;
    @Autowired
    public void setPedidoService(PedidoService pedidoService){this.pedidoService=pedidoService;}
    @Autowired
    public void setEmpresaService(EmpresaService empresaService){this.empresaService=empresaService;}

    @RequestMapping(value="/pedido/{id}", method = RequestMethod.GET)
    public String Pedir(@PathVariable Integer id, Model model){
        model.addAttribute("empresa",empresaService.getEmpresaById(id));
        model.addAttribute("pedido",new Pedido());
        return "pedidos";
    }

    @RequestMapping(value="/registrarpedido", method = RequestMethod.POST)
    public String Pedido(@ModelAttribute("pedido") Pedido pedido, Model model){
        pedidoService.savePedido(pedido);
        return "redirect:/pago";
    }

    @RequestMapping(value="/Lista_de_pedidos")
    public String Listar(Model model){
        model.addAttribute("empresas",empresaService.listAllEmpresas());
        return "ListaPedidos";
    }

}
