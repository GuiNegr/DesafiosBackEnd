package com.picpay.picpay.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ContaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    double saldoConta;

    @OneToOne
    User usuarioConta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public User getUsuarioConta() {
        return usuarioConta;
    }

    public void setUsuarioConta(User usuarioConta) {
        this.usuarioConta = usuarioConta;
    }
}
