package com.examplo.exemplo1.service;


import com.examplo.exemplo1.model.Divida;

import java.util.List;


public interface DividaService {
    List<Divida> getAllDividas();
    void save(Divida usuario);
    Divida getDividaById(long id);
    void deleteDividaById(long id);
}
