package com.ucbcba.proyecto.proyecto.Controllers;


import com.ucbcba.proyecto.proyecto.Entities.Pedido;
import com.ucbcba.proyecto.proyecto.Entities.Role;
import com.ucbcba.proyecto.proyecto.Entities.User;
import com.ucbcba.proyecto.proyecto.Services.PedidoService;
import com.ucbcba.proyecto.proyecto.Services.RolesService;
import com.ucbcba.proyecto.proyecto.Services.SecurityService;
import com.ucbcba.proyecto.proyecto.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private UserService userService;
    private PedidoService pedidoService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService=userService;
    }
    @Autowired
    public void setPedidoService(PedidoService pedidoService){
        this.pedidoService=pedidoService;
    }

    @RequestMapping({"/","/bienvenidos"})
    public String root(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        if(name!="anonymousUser"){
            for(User user: userService.listAllUser()){
                if(user.getEmail().equals(name)){
                    model.addAttribute("name",user.getName());
                    model.addAttribute("roles",user.getRoles());
                    break;
                }
            }
        }
        model.addAttribute("email",name);
        int Existe=0;
        for(Pedido pedido:pedidoService.listAllPedidos()){
            if(pedido.getUser()==userService.findByEmail(name))
                Existe=1;
        }
        model.addAttribute("TamPedido",Existe);
        return "bienvenidos";
    }

    @RequestMapping(value = "/UserList", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("users",userService.listAllUser());
        return "UserList";
    }
}
