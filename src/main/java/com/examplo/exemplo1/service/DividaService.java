package com.examplo.exemplo1.service;


import com.examplo.exemplo1.model.Divida;
import java.util.List;


public interface DividaService {

  List<Divida> getAllDividas();

  void save(Divida divida);

  Divida getDividaById(Integer id, List<String> errors);

  void deleteDividaById(Integer id, List<String> errors);
}
