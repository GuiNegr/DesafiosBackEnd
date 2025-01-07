package com.loans.Loans.domain;

import lombok.Data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Data
@Component
public class JsonResponse {
     String nome;
     List<Emprestimo> emprestimoDisponiveis;

     public JsonResponse() {
         emprestimoDisponiveis = new ArrayList<>();
     }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Emprestimo> getEmprestimoDisponiveis() {
        return emprestimoDisponiveis;
    }

    public void setEmprestimoDisponiveis(List<Emprestimo> emprestimoDisponiveis) {
        this.emprestimoDisponiveis = emprestimoDisponiveis;
    }
}
