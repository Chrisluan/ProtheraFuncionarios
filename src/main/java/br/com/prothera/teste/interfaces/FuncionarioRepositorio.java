package br.com.prothera.teste.interfaces;

import br.com.prothera.teste.models.Funcionario;

public interface FuncionarioRepositorio {
    public void adicionarFuncionario(Funcionario funcionario);
    public void removerFuncionario(int id);
    public Funcionario buscarFuncionario(int id);
    void carregarFuncionarios();
}
