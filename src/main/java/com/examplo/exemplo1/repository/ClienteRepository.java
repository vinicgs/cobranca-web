package com.examplo.exemplo1.repository;

import com.examplo.exemplo1.model.Cliente;
import com.examplo.exemplo1.model.Pagamento;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

  @Query(nativeQuery = true, value = "SELECT * FROM clienetes d where d.cliente = :id")
  Optional<Pagamento> buscarPagamentoComDivida(@Param("id") Integer id);

}