/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examplo.exemplo1.service;

import com.examplo.exemplo1.model.Usuario;

import java.util.List;

/**
 *
 * @author andre
 */
public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    void save(Usuario usuario);
    Usuario getUsuarioById(long id);
    void deleteUsuarioById(long id);
}
