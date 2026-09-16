package br.com.prothera.teste.interfaces;

import br.com.prothera.teste.models.Funcionario;

public interface FuncionarioService {
    public void adicionarFuncionario(Funcionario funcionario);
    public void removerFuncionario(int funcionario);
    Funcionario buscarFuncionarioPorId(int id);

}
