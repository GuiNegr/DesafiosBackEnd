package com.picpay.picpay.exception;

public class NaoPermitido extends RuntimeException {
    public NaoPermitido() {
        super("LOGISTAS NÃO PODEM TRANSFERIR DINHEIRO, SÓ RECEBER");
    }
}
