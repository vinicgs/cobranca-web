package com.examplo.exemplo1.service;

import com.examplo.exemplo1.model.Divida;
import com.examplo.exemplo1.model.Pagamento;
import com.examplo.exemplo1.repository.DividaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DividaServiceImpl implements DividaService {

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
  public Divida getDividaById(Integer id, List<String> errors) {
    Divida divida = dividaRepository.findById(id).orElse(null);
    if (divida == null) {
      errors.add("Divida não encontrada");
      return null;
    } else {
      return divida;
    }
  }

  @Override
  public void deleteDividaById(Integer id, List<String> errors) {
    Pagamento pagamento = this.dividaRepository.buscarPagamentoComDivida(id).orElse(null);
    if (pagamento == null) {
      errors.add("Não é possível excluir uma dívida que possui pagamento");
    } else {
      this.dividaRepository.deleteById((int) id);
    }
  }


}
