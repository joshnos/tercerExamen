package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.Option;
import com.ucbcba.proyecto.proyecto.Services.EmpresaService;
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
    private EmpresaService empresaService;

    @Autowired
    public void setOptionService(OptionService optionService){this.optionService = optionService;}

    @Autowired
    public void setEmpresaService(EmpresaService empresaService){this.empresaService = empresaService;}

    @RequestMapping(value = "/admin/option", method = RequestMethod.POST)
    public String save(@Valid Option option, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("empresas",empresaService.listAllEmpresas());
            return "optionForm";
        }
        optionService.saveOption(option);
        return "redirect:/admin/options";
    }
    @RequestMapping(value = "/admin/options", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("options",optionService.listAllOptions());
        model.addAttribute("empresa",empresaService.listAllEmpresas());
        return "options";
    }
    @RequestMapping(value = "/admin/option/new",method = RequestMethod.GET)
    public String newOption(Model model){
        model.addAttribute("option",new Option());
        model.addAttribute("empresas",empresaService.listAllEmpresas());
        return "optionForm";
    }
    @RequestMapping(value = "/admin/option/eliminar/{id}",method = RequestMethod.GET)
    public String deleteOption(@PathVariable Integer id, Model model){
        model.addAttribute("empresas",empresaService.listAllEmpresas());
        optionService.deleteOption(id);
        return "redirect:/admin//options";
    }
    @RequestMapping(value = "/admin/option/editar/{id}",method = RequestMethod.GET)
    public String editarOption(@PathVariable Integer id, Model model){
        model.addAttribute("option",optionService.getOptionById(id));
        model.addAttribute("empresas",empresaService.listAllEmpresas());
        return "optionForm";
    }
}