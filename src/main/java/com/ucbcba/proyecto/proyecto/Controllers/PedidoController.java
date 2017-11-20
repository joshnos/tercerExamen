package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.Opcion_Pedido;
import  com.ucbcba.proyecto.proyecto.Entities.Pedido;
import com.ucbcba.proyecto.proyecto.Entities.User;
import com.ucbcba.proyecto.proyecto.Services.EmpresaService;
import com.ucbcba.proyecto.proyecto.Services.Opcion_PedidoService;
import com.ucbcba.proyecto.proyecto.Services.OptionService;
import com.ucbcba.proyecto.proyecto.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PedidoController {

    private OptionService optionService;
    private EmpresaService empresaService;
    private PedidoService pedidoService;
    private Opcion_PedidoService opcion_pedidoService;
    @Autowired
    public void setPedidoService(PedidoService pedidoService){this.pedidoService=pedidoService;}
    @Autowired
    public void setEmpresaService(EmpresaService empresaService){this.empresaService=empresaService;}
    @Autowired
    public void setOptionService(OptionService optionService){this.optionService = optionService;}
    @Autowired
    public void setOpcion_pedidoService(Opcion_PedidoService opcion_pedidoService){this.opcion_pedidoService = opcion_pedidoService;}


    @RequestMapping(value = "/pedido/{id}", method = RequestMethod.POST)
    public String save(@Valid Pedido pedido,@Valid Opcion_Pedido opcionPedido, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("empresas",empresaService.listAllEmpresas());
            model.addAttribute("options",optionService.listAllOptions());
            return "optionForm";
        }
        pedidoService.savePedido(pedido);
        opcion_pedidoService.saveOpcion_Pedido(opcionPedido);
        return "redirect:/datosPedido";
    }
    @RequestMapping(value="/pedido/{id}", method = RequestMethod.GET)
    public String Pedir(@PathVariable Integer id, Model model){
        model.addAttribute("empresa",empresaService.getEmpresaById(id));
        model.addAttribute("options",optionService.listAllOptions());
        model.addAttribute("pedido",new Pedido());
        model.addAttribute("opcionPedido",new Opcion_Pedido());
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
        return "ListarRestaurantes";
    }
}
