package com.examplo.exemplo1.service;

import com.examplo.exemplo1.model.Divida;
import com.examplo.exemplo1.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DividaServiceImpl implements DividaService{

    @Autowired
    private DividaRepository dividaRepository;

    @Override
    public List<Divida> getAllDividas() {
        return dividaRepository.findAll();
    }

    @Override
    public void save(Divida divida) {
        this.dividaRepository.save(divida);
    }

    @Override
    public Divida getDividaById(long id) {
        Optional<Divida> optional = dividaRepository.findById(id);
        Divida divida = null;
        if (optional.isPresent()){
            divida = optional.get();
        }
        else{
            throw new RuntimeException("Usuario não encontrado");
        }

        return divida;
    }

    @Override
    public void deleteDividaById(long id) {
        this.dividaRepository.deleteById(id);
    }



}
