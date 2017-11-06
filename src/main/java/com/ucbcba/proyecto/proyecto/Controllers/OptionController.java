package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.Option;
import com.ucbcba.proyecto.proyecto.Services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class OptionController {

    private OptionService optionService;
    @Autowired
    public void setOptionService(OptionService optionService){this.optionService = optionService;}

    @RequestMapping(value = "/option", method = RequestMethod.POST)
    public String save(@Valid Option option, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "optionForm";
        }
        optionService.saveOption(option);
        return "redirect:/options";
    }
    @RequestMapping(value = "/options", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("options",optionService.listAllOptions());
        return "options";
    }
    @RequestMapping(value = "/option/new",method = RequestMethod.GET)
    public String newOption(Model model){
        model.addAttribute("option",new Option());
        return "optionForm";
    }
    @RequestMapping(value = "/option/{id}",method = RequestMethod.GET)
    public String showOption(@PathVariable Integer id, Model model){
        model.addAttribute("option", optionService.getOptionById(id));
        return "option";
    }
    @RequestMapping(value = "/option/eliminar/{id}",method = RequestMethod.GET)
    public String deleteOption(@PathVariable Integer id, Model model){
        optionService.deleteOption(id);
        return "redirect:/options";
    }
    @RequestMapping(value = "/option/editar/{id}",method = RequestMethod.GET)
    public String editarOption(@PathVariable Integer id, Model model){
        model.addAttribute("option",optionService.getOptionById(id));
        return "optionForm";
    }
}