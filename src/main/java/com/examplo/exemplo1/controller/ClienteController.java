package com.examplo.exemplo1.controller;

import com.examplo.exemplo1.model.Cliente;
import com.examplo.exemplo1.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listCliente")
    public String listClientes(Model model){
        model.addAttribute("listCliente", clienteService.getAllClientes());
        return "list_cliente";
    }

    @GetMapping("/createCliente")
    public String createCliente(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "create_cliente";
    }

    @PostMapping("/saveCliente")
    public String saveCliente(@ModelAttribute("cliente") Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/clientes/listCliente";
    }

    @GetMapping("/updateCliente/{id}")
    public String updateCliente(@PathVariable(value = "id") Integer id, Model model){
        Cliente cliente = clienteService.getClienteById(id);
        model.addAttribute("cliente", cliente);
        return "update_cliente";
    }

    @GetMapping("/deleteCliente/{id}")
    public String deleteCliente(@PathVariable(value = "id") Integer id){
        this.clienteService.deleteClienteById(id);
        return "redirect:/clientes/listCliente";
    }
}
