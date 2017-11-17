package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.DatosPedido;

import com.ucbcba.proyecto.proyecto.Services.DatosPedidoService;
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
public class DatosPedidoController {
    private DatosPedidoService datosPedidoService;
    private PedidoService pedidoService;


    @Autowired
    private void setPedidoService(PedidoService pedidoService){
        this.pedidoService=pedidoService;
    }
    @Autowired
        public void setDatosPedidoService(DatosPedidoService datosPedidoService){
        this.datosPedidoService=datosPedidoService;
        }


    @RequestMapping(value = "/{id}/factura/new",method = RequestMethod.GET)
    public String save(@PathVariable Integer id, Model model) {
        model.addAttribute("DatosPedido",new DatosPedido());
        model.addAttribute("MiPedido",pedidoService.getPedidoById(id));
        return "datosPedido";
    }
    @RequestMapping(value = "/{id}/facturar",method = RequestMethod.POST)
    public String save(@Valid DatosPedido datosPedido, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "datosPedido";
        }

       datosPedidoService.saveDatosPedido(datosPedido);
        return "datosPedido";
    }


}
