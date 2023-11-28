/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplo.exemplo1.controller;

import com.examplo.exemplo1.model.Usuario;
import com.examplo.exemplo1.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/")
    public String getViewHomePage(Model model){
        model.addAttribute("listUsuarios", usuarioService.getAllUsuarios());
        return "home";
    }
    
    @GetMapping("/showNewUsuarioForm")
    public String showNewUsuarioForm(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "new_usuario";
    }
    
    @PostMapping("/saveUsuario")
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario){
        usuarioService.save(usuario);
        return "redirect:/home";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id,Model model){
        Usuario usuario = usuarioService.getUsuarioById(id);
        model.addAttribute("usuario", usuario);
        return "update_usuario";
    }
    
    @GetMapping("/deleteUsuario/{id}")
    public String deleteUsuario(@PathVariable(value = "id") long id){
        this.usuarioService.deleteUsuarioById(id);
        return "redirect:/home";
    }
}
