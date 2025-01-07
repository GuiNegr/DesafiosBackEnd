package com.picpay.picpay.controller.exceptionControlelr;


import com.picpay.picpay.exception.NaoPermitido;
import com.picpay.picpay.exception.SemFundos;
import com.picpay.picpay.exception.emailUnico;
import com.picpay.picpay.exception.indetificacaoUnica;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(emailUnico.class)
    public ResponseEntity<String> throwIfExistEmail(emailUnico e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(indetificacaoUnica.class)
    public ResponseEntity<String> throwIfExistCPFCNPJ(indetificacaoUnica e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(SemFundos.class)
    public ResponseEntity<String> throwIfExistSemFundos(SemFundos e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NaoPermitido.class)
    public ResponseEntity<String> throwNaoPermitido(NaoPermitido e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
