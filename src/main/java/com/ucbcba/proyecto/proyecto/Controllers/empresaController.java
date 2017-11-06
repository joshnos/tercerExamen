package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.Empresa;
import com.ucbcba.proyecto.proyecto.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class empresaController {

    private EmpresaService empresaService;

    @Autowired
    public void setEmpresaService(EmpresaService empresaService){this.empresaService = empresaService;}

    @RequestMapping(value = "/empresa", method = RequestMethod.POST)
    public String save(@Valid Empresa empresa, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "empresaForm";
        }
        empresaService.saveEmpresa(empresa);
        return "redirect:/empresas";
    }

    @RequestMapping(value = "/empresas", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("empresas",empresaService.listAllEmpresas());
        return "empresas";
    }

    @RequestMapping(value = "/empresa/new",method = RequestMethod.GET)
    public String newEmpresa(Model model){
        model.addAttribute("empresa",new Empresa());
        return "empresaForm";
    }

    @RequestMapping(value = "/empresa/{id}",method = RequestMethod.GET)
    public String showEmpresa(@PathVariable Integer id, Model model){
        model.addAttribute("empresa", empresaService.getEmpresaById(id));
        return "empresa";
    }

    @RequestMapping(value = "/empresa/eliminar/{id}",method = RequestMethod.GET)
    public String deleteEmpresa(@PathVariable Integer id, Model model){
        empresaService.deleteEmpresa(id);
        return "redirect:/empresas";
    }

    @RequestMapping(value = "/empresa/editar/{id}",method = RequestMethod.GET)
    public String editarEmpresa(@PathVariable Integer id, Model model){
        model.addAttribute("empresa",empresaService.getEmpresaById(id));
        return "empresaForm";
    }
}
