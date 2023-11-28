package com.examplo.exemplo1.controller;

import com.examplo.exemplo1.model.Divida;
import com.examplo.exemplo1.service.DividaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller("/dividas")
public class DividaController {

    @Autowired
    private DividaService dividaService;

//    @GetMapping
//    public String getViewDividaPage(Model model){
//        model.addAttribute("listDividas", dividaService.getAllDividas());
//        return "new_divida";
//    }

    @GetMapping("/showNewDividaForm")
    public String showNewDividaForm(Model model){
        Divida divida = new Divida();
        model.addAttribute("divida", divida);
        return "new_divida";
    }

    @PostMapping("/saveDivida")
    public String saveDivida(@ModelAttribute("divida") Divida divida){
        dividaService.save(divida);
        return "redirect:/home";
    }

    @GetMapping("/showDividaUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Divida divida = dividaService.getDividaById(id);
        model.addAttribute("divida", divida);
        return "update_usuario";
    }

    @GetMapping("/deleteDivida/{id}")
    public String deleteDivida(@PathVariable(value = "id") long id){
        this.dividaService.deleteDividaById(id);
        return "redirect:/home";
    }
}
