package br.com.prothera.teste.interfaces;

import br.com.prothera.teste.models.Funcionario;

import java.util.ArrayList;
import java.util.function.Predicate;

public interface FuncionarioRepositorio {
    void adicionarFuncionario(Funcionario funcionario);

    void removerFuncionario(Predicate<Funcionario> filtro);

    Funcionario buscarFuncionario(Predicate<Funcionario> filtro);

    void carregarFuncionarios();
    void persistir();
}
