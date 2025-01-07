package com.loans.Loans.domain;


import lombok.Data;


public class Emprestimo {

     TipoEmprestimo tipoEmprestimo;
     double taxaJuros;

    public Emprestimo(TipoEmprestimo emprestimo, double taxa) {
        this.tipoEmprestimo = emprestimo;
        this.taxaJuros = taxa;
    }

    public TipoEmprestimo getTipoEmprestimo() {
        return tipoEmprestimo;
    }

    public void setTipoEmprestimo(TipoEmprestimo tipoEmprestimo) {
        this.tipoEmprestimo = tipoEmprestimo;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
}
