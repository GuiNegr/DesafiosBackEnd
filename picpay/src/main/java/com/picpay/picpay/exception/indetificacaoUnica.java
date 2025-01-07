package com.picpay.picpay.exception;

public class indetificacaoUnica extends RuntimeException {
    public indetificacaoUnica() {
        super("CPF/CNPJ JÁ UTILIZADOS");
    }
}
