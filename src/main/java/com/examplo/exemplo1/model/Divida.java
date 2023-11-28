package com.examplo.exemplo1.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Divida")
public class Divida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Integer id;

    private int codigo;

    private Integer credorId;

    private Date dataAtualizacao;

    private Integer devedorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
