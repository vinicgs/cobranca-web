package com.examplo.exemplo1.service;

import com.examplo.exemplo1.model.Cliente;
import com.examplo.exemplo1.model.Pagamento;
import com.examplo.exemplo1.repository.ClienteRepository;
import com.examplo.exemplo1.repository.PagamentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl implements PagamentoService {

  @Autowired
  private PagamentoRepository pagamentoRepository;

  @Override
  public List<Pagamento> getAllPagamentos() {
    return pagamentoRepository.findAll();
  }

  @Override
  public void save(Pagamento pagamento) {
    this.pagamentoRepository.save(pagamento);
  }

  @Override
  public Pagamento getPagamentoById(Integer id, List<String> errors) {
    Optional<Pagamento> optional = pagamentoRepository.findById(id);
    Pagamento pagamento = null;
    if (optional.isPresent()) {
      pagamento = optional.get();
    } else {
      throw new RuntimeException("Cliente não encontrado");
    }

    return pagamento;
  }

  @Override
  public void deletePagamentoById(Integer id, List<String> errors) {
    this.pagamentoRepository.deleteById(id);

  }


}
