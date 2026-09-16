package br.com.prothera.teste;
import br.com.prothera.teste.models.Funcionario;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GestorDeFuncionarios {
    List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    public void adicionarFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
    public void removerFuncionarioJoao(){
        funcionarios.removeIf(f -> "João".equalsIgnoreCase(f.getNome()));
    }

    public void efetivarAumentoSalarialEmGrupo(){
        efetivarAumentoSalarialEmGrupo(BigDecimal.TEN);
    }
    public void efetivarAumentoSalarialEmGrupo(BigDecimal porcentagem){
        for(Funcionario funcionario : funcionarios){
            BigDecimal salarioAtual = funcionario.getSalario();

            BigDecimal novoSalario = salarioAtual.add(
                    salarioAtual
                            .multiply(porcentagem)
                            .divide(BigDecimal.valueOf(100), 2, java.math.RoundingMode.HALF_UP)
            );
            funcionario.setSalario(novoSalario);
        }
    }
}
