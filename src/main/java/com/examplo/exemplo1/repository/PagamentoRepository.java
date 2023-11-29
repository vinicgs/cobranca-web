package com.examplo.exemplo1.repository;

import com.examplo.exemplo1.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}