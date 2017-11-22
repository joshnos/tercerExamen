package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.*;
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
        return "pedidos";
    }

    @RequestMapping(value="/cargar", method = RequestMethod.POST)
    public String Cargar(@ModelAttribute("empresa")Integer Id_Empresa, @ModelAttribute("pedidoId") Integer Id_Pedido, @ModelAttribute("OptionId") Integer Id_Option, Model model){
        Opcion_Pedido opcion_pedido = new Opcion_Pedido();
        opcion_pedido.setOption(optionService.getOptionById(Id_Option));
        if(Id_Pedido==0){
            Pedido pedido = new Pedido();
            opcion_pedido.setCantidad(1);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String Email = auth.getName(); //get logged in username
            User usuario=userService.findByEmail(Email);
            pedido.setUser(usuario);
            pedido.setEmpresa(empresaService.getEmpresaById(Id_Empresa));
            pedido.setPrecio(optionService.getOptionById(Id_Option).getPrice());
            pedidoService.savePedido(pedido);
            opcion_pedido.setPedido(pedido);
            opcion_pedidoService.saveOpcion_Pedido(opcion_pedido);
        }
        else
        {
            int Total=0;
            boolean Existe = false;
            Pedido pedido = pedidoService.getPedidoById(Id_Pedido);
            for(Opcion_Pedido opcion_pedido1: pedido.getOpcion_pedidos()){
                if(opcion_pedido1.getOption()==optionService.getOptionById(Id_Option)){
                    Existe=true;
                    opcion_pedido1.setCantidad(opcion_pedido1.getCantidad()+1);
                    opcion_pedido=opcion_pedido1;
                }
                Total += opcion_pedido1.getOption().getPrice() * opcion_pedido1.getCantidad();

            }
            if(Existe!=true){
                opcion_pedido.setPedido(pedido);
                opcion_pedido.setCantidad(1);
                Total+=optionService.getOptionById(Id_Option).getPrice();
            }
            opcion_pedidoService.saveOpcion_Pedido(opcion_pedido);
            pedido.setPrecio(Total);
            pedidoService.savePedido(pedido);
        }
        return "redirect:/pedido/continuar";
    }

    @RequestMapping(value = "/pedido/continuar", method=RequestMethod.GET)
    public String Contitnuar(Model model){
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
        return "pedidos";
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
