package com.picpay.picpay.controller;


import com.picpay.picpay.domain.entity.ContaUser;
import com.picpay.picpay.service.PicPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.util.Map;

@RestController
@RequestMapping("/PicPayDesafio")
public class Controller {

    @Autowired
    PicPayService  picPayService;

    @PostMapping("/transfer")
    public ResponseEntity<ContaUser> transferenciaMonetaria(
            @RequestBody Map<String,Object>requestTranfers){
        ContaUser contaUser = picPayService.transferencia(requestTranfers);
        return ResponseEntity.ok().body(contaUser);
    }
}
