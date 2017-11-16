package com.ucbcba.proyecto.proyecto.Controllers;

import com.ucbcba.proyecto.proyecto.Entities.DatosPedido;

import com.ucbcba.proyecto.proyecto.Services.DatosPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class DatosPedidoController {
    private DatosPedidoService datosPedidoService;

    @Autowired
        public void setDatosPedidoService(DatosPedidoService datosPedidoService){
        this.datosPedidoService=datosPedidoService;
        }

    @RequestMapping(value = "/{pedido.id}/factura",method = RequestMethod.POST)
    public String save(@Valid DatosPedido datosPedido, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "datosPedido";
        }

       datosPedidoService.saveDatosPedido(datosPedido);
        return "datosPedido";
    }


}
