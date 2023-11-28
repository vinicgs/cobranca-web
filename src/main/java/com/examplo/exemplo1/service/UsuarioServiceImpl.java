/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplo.exemplo1.service;

import com.examplo.exemplo1.model.Usuario;
import com.examplo.exemplo1.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author andre
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
            
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void save(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuarioById(long id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        Usuario usuario = null;
        if (optional.isPresent()){
            usuario = optional.get();
        }
        else{
            throw new RuntimeException("Usuario não encontrado");
        }
        
        return usuario;
    }

    @Override
    public void deleteUsuarioById(long id) {
       this.usuarioRepository.deleteById(id);
    }
    
    
}
