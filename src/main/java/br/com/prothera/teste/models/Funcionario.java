package br.com.prothera.teste.models;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private int id;
    private BigDecimal salario;
    private String funcao;


    public BigDecimal getSalario() {
        String.format(Locale.of("pt", "BR"), "R$ %,.2f", this.salario);
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        return String.format(Locale.of("pt", "BR"), """
                           --------------------------------
                           |> Pessoa
                           |     Nome: %s
                           |     Data de Nascimento: %s
                           |> Funcionario
                           |     Função: %s
                           |     Salario: %s
                           --------------------------------
                        """,
                this.getNome(),
                formatadorData.format(this.getDataNascimento()),
                this.getFuncao(),
                formatadorMoeda.format(this.getSalario()));
    }


}
