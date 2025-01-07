package com.picpay.picpay.exception;

public class emailUnico extends RuntimeException {
    public emailUnico() {
        super("EMAIL JÁ CADASTRADO");
    }
}
