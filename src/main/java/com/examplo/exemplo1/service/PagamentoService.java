package com.examplo.exemplo1.service;

import com.examplo.exemplo1.model.Pagamento;
import java.util.List;

public interface PagamentoService {

  List<Pagamento> getAllPagamentos();

  void save(Pagamento pagamento);

  Pagamento getPagamentoById(Integer id, List<String> errors);

  void deletePagamentoById(Integer id, List<String> errors);
}
