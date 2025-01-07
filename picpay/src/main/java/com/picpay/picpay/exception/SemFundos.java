package com.picpay.picpay.exception;

public class SemFundos extends RuntimeException {
    public SemFundos() {
        super("NÃO HÁ FUNDOS PARA ISSO");
    }
}
