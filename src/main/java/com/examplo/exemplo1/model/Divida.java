package com.examplo.exemplo1.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "divida")
public class Divida {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private Integer id;

  private int codigo;

  @ManyToOne
  @JoinColumn(name = "credor_id", nullable = false)
  private Cliente credor;

  private Date dataAtualizacao;

  @ManyToOne
  @JoinColumn(name = "devedor_id", nullable = false)
  private Cliente devedor;

  private Double valor;

//    @OneToMany(mappedBy = "divida")
//    private Pagamento pagamento;

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Integer getId() {
    return id;
  }


  public void setId(Integer id) {
    this.id = id;
  }


  public Divida() {
  }

  public Divida(Integer id, int codigo, Cliente credor, Date dataAtualizacao, Cliente devedor,
      Double valor) {
    this.id = id;
    this.codigo = codigo;
    this.credor = credor;
    this.dataAtualizacao = dataAtualizacao;
    this.devedor = devedor;
    this.valor = valor;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }


  public Date getDataAtualizacao() {
    return dataAtualizacao;
  }

  public void setDataAtualizacao(Date dataAtualizacao) {
    this.dataAtualizacao = dataAtualizacao;
  }

  public Cliente getCredor() {
    return credor;
  }

  public void setCredor(Cliente credor) {
    this.credor = credor;
  }

  public Cliente getDevedor() {
    return devedor;
  }

  public void setDevedor(Cliente devedor) {
    this.devedor = devedor;
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (!(o instanceof Divida)) {
          return false;
      }
    Divida divida = (Divida) o;
    return codigo == divida.codigo && Objects.equals(id, divida.id) && Objects.equals(credor,
        divida.credor) && Objects.equals(dataAtualizacao, divida.dataAtualizacao) && Objects.equals(
        devedor, divida.devedor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, codigo, credor, dataAtualizacao, devedor);
  }
}
