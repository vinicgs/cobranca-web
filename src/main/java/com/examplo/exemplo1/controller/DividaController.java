package com.examplo.exemplo1.controller;

import com.examplo.exemplo1.model.Cliente;
import com.examplo.exemplo1.model.Divida;
import com.examplo.exemplo1.service.ClienteService;
import com.examplo.exemplo1.service.DividaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dividas")
public class DividaController {

    @Autowired
    private DividaService dividaService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listDivida")
    public String listDivida(Model model){
        model.addAttribute("listDivida", dividaService.getAllDividas());
        return "list_divida";
    }

    @GetMapping("/createDivida")
    public String createDivida(Model model){
        List<Cliente> clientes = clienteService.getAllClientes();
        Divida divida = new Divida();
        model.addAttribute("divida", divida);
        model.addAttribute("clientes", clientes);
        return "create_divida";
    }

    @PostMapping("/saveDivida")
    public String saveDivida(@ModelAttribute("divida") Divida divida){
        dividaService.save(divida);
        return "redirect:/dividas/listDivida";
    }

    @GetMapping("/updateDivida/{id}")
    public String updateDivida(@PathVariable(value = "id") long id, Model model){
        List<Cliente> clientes = clienteService.getAllClientes();
        Divida divida = dividaService.getDividaById(id);
        model.addAttribute("divida", divida);
        model.addAttribute("clientes", clientes);
        return "update_divida";
    }

    @GetMapping("/deleteDivida/{id}")
    public String deleteDivida(@PathVariable(value = "id") long id){
        this.dividaService.deleteDividaById(id);
        return "redirect:/dividas/listDivida";
    }
}
