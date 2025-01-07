package com.picpay.picpay.domain.dto;

import com.picpay.picpay.domain.entity.TipoUser;

public record UserDTO (
        long id,
        String nome,
        String cpf,
        String email,
        String senha,
        TipoUser tipoUser
) {

}
