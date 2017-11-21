package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.Opcion_Pedido;
import com.ucbcba.proyecto.proyecto.Entities.Option;
import  com.ucbcba.proyecto.proyecto.Entities.Pedido;
import com.ucbcba.proyecto.proyecto.Entities.User;
import com.ucbcba.proyecto.proyecto.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.*;

@Controller
public class PedidoController {

    private OptionService optionService;
    private EmpresaService empresaService;
    private PedidoService pedidoService;
    private Opcion_PedidoService opcion_pedidoService;
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }
    @Autowired
    public void setPedidoService(PedidoService pedidoService){this.pedidoService=pedidoService;}
    @Autowired
    public void setEmpresaService(EmpresaService empresaService){this.empresaService=empresaService;}
    @Autowired
    public void setOptionService(OptionService optionService){this.optionService = optionService;}
    @Autowired
    public void setOpcion_pedidoService(Opcion_PedidoService opcion_pedidoService){this.opcion_pedidoService = opcion_pedidoService;}


    @RequestMapping(value="/pedido/{id}", method = RequestMethod.GET)
    public String Pedir(@PathVariable Integer id, Model model){
        model.addAttribute("empresa",empresaService.getEmpresaById(id));
        model.addAttribute("pedido",new Pedido());
        model.addAttribute("top",new Opcion_Pedido());
        return "pedidos";
    }

    @RequestMapping(value = "/pedidoPdefecto", method=RequestMethod.GET)
    public String Defecto(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String Email = auth.getName(); //get logged in username
        User usuario=userService.findByEmail(Email);
        Pedido pedidoactual = new Pedido();
        for (Pedido pedido: pedidoService.listAllPedidos()){
            if(pedido.getUser()==usuario)
                pedidoactual=pedido;
        }
        model.addAttribute("empresa",pedidoactual.getEmpresa());
        model.addAttribute("pedido",pedidoactual);
        Opcion_Pedido opcion_pedido = new Opcion_Pedido();
        for(Opcion_Pedido opcion_pedido1: pedidoactual.getOpcion_pedidos()){
            opcion_pedido=opcion_pedido1;
        }
        model.addAttribute("top",opcion_pedido);

        return "pedidos";
    }

    @RequestMapping(value="/registrarpedido/{id}", method = RequestMethod.POST)
    public String Pedido(@PathVariable Integer id, @ModelAttribute("pedido") Pedido pedido,@ModelAttribute("top") Opcion_Pedido opcion_pedido, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String Email = auth.getName(); //get logged in username
        User usuario=userService.findByEmail(Email);
        pedido.setUser(usuario);
        pedido.setEmpresa(empresaService.getEmpresaById(id));
        int Total = opcion_pedido.getOption().getPrice() * opcion_pedido.getCantidad();
        pedido.setPrecio(Total);
        pedidoService.savePedido(pedido);
        opcion_pedido.setPedido(pedido);
        opcion_pedidoService.saveOpcion_Pedido(opcion_pedido);
        return "redirect:/total/"+pedido.getId();
    }

    @RequestMapping(value="/total/{id}")
    public String total(@PathVariable Integer id,Model model){
        model.addAttribute("pedido",pedidoService.getPedidoById(id));
        return "total";
    }

    @RequestMapping(value="/Lista_de_pedidos")
    public String Listar(Model model){
        model.addAttribute("empresas",empresaService.listAllEmpresas());
        return "ListarRestaurantes";
    }
}
