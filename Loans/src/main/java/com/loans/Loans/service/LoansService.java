package com.loans.Loans.service;


import com.loans.Loans.domain.Emprestimo;
import com.loans.Loans.domain.JsonResponse;
import com.loans.Loans.domain.TipoEmprestimo;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor

public class LoansService {


    public JsonResponse retornoProposta(Map<String,Object> jsonRequest){
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setNome((String)jsonRequest.get("name"));
        jsonResponse.setEmprestimoDisponiveis(createEmprestimo(jsonRequest));
        return jsonResponse;
    }

    private List<Emprestimo> createEmprestimo(Map<String,Object> jsonRequest){
        Double renda = (Double) jsonRequest.get("income");
        List<Emprestimo> emprestimos = new ArrayList<>();

        if(renda <= 3000 || renda <= 5000 && (Double)jsonRequest.get("age") <= 30 && jsonRequest.get("location").equals("sp")){
            Emprestimo emprestimo = new Emprestimo(TipoEmprestimo.PESSOAL, 4);
            emprestimos.add(emprestimo);
        };

        if(renda >= 5000){
            Emprestimo emprestimo = new Emprestimo(TipoEmprestimo.CONSIGNADO, 2);
            emprestimos.add(emprestimo);
        }

        if(renda <= 3000 || renda <= 5000 && (Double)jsonRequest.get("age") <= 30 && jsonRequest.get("location").equals("sp")){
            Emprestimo emprestimo = new Emprestimo(TipoEmprestimo.GARANTIA, 3);
            emprestimos.add(emprestimo);
        }
        return emprestimos;
    }
}
