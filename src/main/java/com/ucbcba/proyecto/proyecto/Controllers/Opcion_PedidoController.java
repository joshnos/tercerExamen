package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.Opcion_Pedido;
import com.ucbcba.proyecto.proyecto.Entities.Pedido;
import com.ucbcba.proyecto.proyecto.Services.Opcion_PedidoService;
import com.ucbcba.proyecto.proyecto.Services.OptionService;
import com.ucbcba.proyecto.proyecto.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class Opcion_PedidoController {

    private OptionService optionService;
    private Opcion_PedidoService opcion_pedidoService;
    private PedidoService pedidoService;
    @Autowired
    public void setOpcion_pedidoService(Opcion_PedidoService opcion_pedidoService){this.opcion_pedidoService = opcion_pedidoService;}
    @Autowired
    public void setOptionService(OptionService optionService){this.optionService = optionService;}
    @Autowired
    public void setPedidoService(PedidoService pedidoService){this.pedidoService=pedidoService;}

    @RequestMapping(value = "/opcion_pedido/{id}", method = RequestMethod.POST)
    public String save(@Valid Opcion_Pedido opcionPedido, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "opcion_pedido/{id}";
        }
        opcion_pedidoService.saveOpcion_Pedido(opcionPedido);
        return "redirect:/pedidos}";
    }
    @RequestMapping(value="/opcion_pedido/{id}", method = RequestMethod.GET)
    public String Pedir(@PathVariable Integer id, Model model){
        model.addAttribute("opcion_pedido",new Opcion_Pedido());
        return "opcion_pedido/{id}";
    }
}
