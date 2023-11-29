package com.examplo.exemplo1.service;

import com.examplo.exemplo1.model.Cliente;
import java.util.List;

public interface ClienteService {

  List<Cliente> getAllClientes();

  void save(Cliente cliente);

  Cliente getClienteById(Integer id);

  void deleteClienteById(Integer id);
}
