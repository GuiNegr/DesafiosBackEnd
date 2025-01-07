package com.picpay.picpay.exception;

public class FalhaTransacao extends RuntimeException {
    public FalhaTransacao() {
        super(" FALHA COM A TRANSAÇÃO");
    }
}
