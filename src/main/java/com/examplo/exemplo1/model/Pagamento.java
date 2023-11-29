package com.examplo.exemplo1.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

//  @ManyToOne
//  @JoinColumn(name = "divida_id", nullable = false)
//  private Divida divida;

  private Date dataPagamento;

  private Double valorPago;

  public Pagamento() {
  }

  public Pagamento(Divida divida, Date dataPagamento, Double valorPago) {
    this.dataPagamento = dataPagamento;
    this.valorPago = valorPago;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Pagamento)) {
      return false;
    }
    Pagamento pagamento = (Pagamento) o;
    return Objects.equals(id, pagamento.id) && Objects.equals(dataPagamento,
        pagamento.dataPagamento) && Objects.equals(valorPago, pagamento.valorPago);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, dataPagamento, valorPago);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDataPagamento() {
    return dataPagamento;
  }

  public void setDataPagamento(Date dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public Double getValorPago() {
    return valorPago;
  }

  public void setValorPago(Double valorPago) {
    this.valorPago = valorPago;
  }
}
