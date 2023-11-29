package com.examplo.exemplo1.repository;

import com.examplo.exemplo1.model.Divida;
import com.examplo.exemplo1.model.Pagamento;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DividaRepository extends JpaRepository<Divida, Integer> {

  @Query(nativeQuery = true, value = "SELECT * FROM pagamento p where p.divida_id = :id")
  Optional<Pagamento> buscarPagamentoComDivida(@Param("id") Integer id);

}