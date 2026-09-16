package br.com.prothera.teste.models;

import java.math.BigDecimal;
import java.util.Locale;

public class Funcionario extends Pessoa{
    private int id;
    private BigDecimal salario;
    private String funcao;


    public BigDecimal getSalario() {
        String.format(Locale.of("pt", "BR"), "R$ %,.2f", this.salario);
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public int getId() {
        return this.id;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return String.format(Locale.of("pt", "BR"), """
                ======================
                Nome: %s
                Data de Nascimento: %s
                ----------------------
                Função: %s
                Salario: R$ %,.2f
                ======================
                """,
                this.getNome(),
                this.getDataNascimento(),
                this.getFuncao(),
                this.getSalario());
    }


}
