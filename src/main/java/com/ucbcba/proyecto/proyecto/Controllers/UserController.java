package com.ucbcba.proyecto.proyecto.Controllers;



import com.ucbcba.proyecto.proyecto.Entities.Role;
import com.ucbcba.proyecto.proyecto.Entities.User;
import com.ucbcba.proyecto.proyecto.Services.CiudadService;
import com.ucbcba.proyecto.proyecto.Services.RolesService;
import com.ucbcba.proyecto.proyecto.Services.SecurityService;
import com.ucbcba.proyecto.proyecto.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    private RolesService rolesService;
    private CiudadService ciudadService;

    @Autowired
    private void setCiudadService(CiudadService ciudadService){
        this.ciudadService=ciudadService;
    }
    @Autowired
    private void setRolesService(RolesService rolesService){this.rolesService=rolesService;}
    //@Autowired
    //private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationInit(Model model) {
        model.addAttribute("ciudades",ciudadService.listAllCiudades());
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        ///userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("ciudades",ciudadService.listAllCiudades());
            return "registration";
        }
        userService.save(user);
        securityService.autologin(user.getEmail(), user.getPasswordConfirm());
        return "redirect:/bienvenidos";
    }
    @RequestMapping(value = "/admin/listar",method = RequestMethod.GET)
    public String root(Model model) {
        model.addAttribute("users", userService.listAllUser());
        return "listar";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null){
            model.addAttribute("message", "You have been logged out successfully.");
            return "redirect:/bienvenidos";
        }

        return "login";
    }

}