package com.examplo.exemplo1.service;

import com.examplo.exemplo1.model.Cliente;
import com.examplo.exemplo1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public void save(Cliente cliente) {
        this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteById(Integer id) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        Cliente cliente = null;
        if (optional.isPresent()){
            cliente = optional.get();
        }
        else{
            throw new RuntimeException("Cliente não encontrado");
        }

        return cliente;
    }

    @Override
    public void deleteClienteById(Integer id) {
        this.clienteRepository.deleteById(id);
    }



}
