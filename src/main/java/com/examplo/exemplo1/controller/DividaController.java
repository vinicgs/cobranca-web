package com.examplo.exemplo1.controller;

import com.examplo.exemplo1.model.Cliente;
import com.examplo.exemplo1.model.Divida;
import com.examplo.exemplo1.service.ClienteService;
import com.examplo.exemplo1.service.DividaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dividas")
public class DividaController {

  @Autowired
  private DividaService dividaService;

  @Autowired
  private ClienteService clienteService;

  @GetMapping("/listDivida")
  public String listDivida(Model model) {
    model.addAttribute("listDivida", dividaService.getAllDividas());
    return "list_divida";
  }

  @GetMapping("/createDivida")
  public String createDivida(Model model) {
    List<Cliente> clientes = clienteService.getAllClientes();
    Divida divida = new Divida();
    model.addAttribute("divida", divida);
    model.addAttribute("clientes", clientes);
    return "create_divida";
  }

  @PostMapping("/saveDivida")
  public String saveDivida(@ModelAttribute("divida") Divida divida) {
    dividaService.save(divida);
    return "redirect:/dividas/listDivida";
  }

  @GetMapping("/updateDivida/{id}")
  public String updateDivida(@PathVariable(value = "id") Integer id, Model model) {
    List<String> errors = new ArrayList<>();
    List<Cliente> clientes = clienteService.getAllClientes();
    Divida divida = dividaService.getDividaById(id, errors);
    model.addAttribute("divida", divida);
    model.addAttribute("clientes", clientes);
    model.addAttribute("errors", errors);
    return "update_divida";
  }

  @GetMapping("/deleteDivida/{id}")
  public String deleteDivida(@PathVariable(value = "id") Integer id) {
    List<String> errors = new ArrayList<>();
    this.dividaService.deleteDividaById(id, errors);
    return "redirect:/dividas/listDivida";
  }
}
