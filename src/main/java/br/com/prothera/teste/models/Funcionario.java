package br.com.prothera.teste.models;

import java.math.BigDecimal;
import java.util.Locale;

public class Funcionario extends Pessoa{
    private BigDecimal salario;
    private String funcao;

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
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
                Nome: %s
                Data de Nascimento: %s
                ----------------------
                Função: %s
                Salario: %f,.2f
                """,
                this.getNome(),
                this.getDataNascimento(),
                this.getFuncao(),
                this.getSalario());
    }
}
