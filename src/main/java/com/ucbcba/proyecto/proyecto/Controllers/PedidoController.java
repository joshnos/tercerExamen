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
        model.addAttribute("Empresa_Seleccionada",empresaService.getEmpresaById(id));
        model.addAttribute("TempOp",new Option());
        model.addAttribute("pedido",new Pedido());
        model.addAttribute("opcionPedido",new Opcion_Pedido());
        return "pedidos";
    }

    @RequestMapping(value="/registrarpedido/{id}", method = RequestMethod.POST)
    public String Pedido(@PathVariable Integer id,@ModelAttribute("pedido") Pedido pedido,@ModelAttribute("opcionPedido") Opcion_Pedido opcionpedido, Model model){
        model.addAttribute("pedidos",pedidoService.getPedidoById(id));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String Email = auth.getName(); //get logged in username
        User usuario=userService.findByEmail(Email);
        pedido.setUser(usuario);
        pedido.setEmpresa(empresaService.getEmpresaById(id));
        pedidoService.savePedido(pedido);
        opcionpedido.setPedido(pedido);
        opcionpedido.setOption(optionService.getOptionById(1));
        opcion_pedidoService.saveOpcion_Pedido(opcionpedido);

        return "redirect:/bienvenidos";
    }

    @RequestMapping(value="/Lista_de_pedidos")
    public String Listar(Model model){
        model.addAttribute("empresas",empresaService.listAllEmpresas());
        return "ListarRestaurantes";
    }
}
