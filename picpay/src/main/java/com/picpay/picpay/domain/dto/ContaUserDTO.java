package com.picpay.picpay.domain.dto;

import com.picpay.picpay.domain.entity.User;

public record ContaUserDTO(
        Long id,
        double saldoConta,
        User userConta
) {
    public ContaUserDTO(Long id, double saldoConta, User userConta) {
        this.id = id;
        this.saldoConta = saldoConta;
        this.userConta = userConta;
    }

    public ContaUserDTO(double saldoConta, User userConta) {
        this(0L, saldoConta, userConta);
    }
}
