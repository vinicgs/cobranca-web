package com.examplo.exemplo1.controller;

import com.examplo.exemplo1.model.Pagamento;
import com.examplo.exemplo1.service.PagamentoService;
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
@RequestMapping("/pagamentos")
public class PagamentoController {

  @Autowired
  private PagamentoService pagamentoService;

  @GetMapping("/listPagamento")
  public String listPagamento(Model model) {
    model.addAttribute("listPagamento", pagamentoService.getAllPagamentos());
    return "list_pagamento";
  }

  @GetMapping("/createPagamento")
  public String createPagamento(Model model) {
    Pagamento pagamento = new Pagamento();
    model.addAttribute("pagamento", pagamento);
    return "create_pagamento";
  }

  @PostMapping("/savePagamento")
  public String savePagamento(@ModelAttribute("pagamento") Pagamento pagamento) {
    pagamentoService.save(pagamento);
    return "redirect:/pagamentos/listPagamento";
  }

  @GetMapping("/updatePagamento/{id}")
  public String updatePagamento(@PathVariable(value = "id") Integer id, Model model) {
    List<String> errors = new ArrayList<>();
    Pagamento pagamento = pagamentoService.getPagamentoById(id, errors);
    model.addAttribute("pagamento", pagamento);
    return "update_pagamento";
  }

  @GetMapping("/deletePagamento/{id}")
  public String deletePagamento(@PathVariable(value = "id") Integer id) {
    List<String> errors = new ArrayList<>();
    this.pagamentoService.deletePagamentoById(id, errors);
    return "redirect:/pagamentos/listPagamento";
  }
}
