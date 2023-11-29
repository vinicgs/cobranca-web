package com.examplo.exemplo1.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "divida")
public class Divida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;

    private int codigo;

    private String credor;

    private Date dataAtualizacao;

    private String devedor;

    private Double valor;

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

    public Divida(Integer id, int codigo, String credor, Date dataAtualizacao, String devedor, Double valor) {
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

    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getDevedor() {
        return devedor;
    }

    public void setDevedor(String devedor) {
        this.devedor = devedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Divida)) return false;
        Divida divida = (Divida) o;
        return codigo == divida.codigo && Objects.equals(id, divida.id) && Objects.equals(credor, divida.credor) && Objects.equals(dataAtualizacao, divida.dataAtualizacao) && Objects.equals(devedor, divida.devedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, credor, dataAtualizacao, devedor);
    }
}
