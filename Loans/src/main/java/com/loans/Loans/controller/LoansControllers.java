package com.loans.Loans.controller;

import com.loans.Loans.service.LoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/customer-loans")
public class LoansControllers{

    @Autowired
    LoansService loansService;

    @PostMapping
    public ResponseEntity postMethod(@RequestBody Map<String,Object> jsonRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(loansService.retornoProposta(jsonRequest));
    }
}
