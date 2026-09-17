package br.com.prothera.teste.interfaces;

import br.com.prothera.teste.models.Funcionario;

import java.util.List;
import java.util.function.Predicate;

public interface FuncionarioService {
    public void adicionarFuncionario(Funcionario funcionario);
    public void removerFuncionario(int funcionario);
    Funcionario buscarFuncionarioPorId(int id);
    List<Funcionario> buscarFuncionarios();
    List<Funcionario> buscarFuncionarios(Predicate<Funcionario> filtro);
    void salvarAlteracao();

}
