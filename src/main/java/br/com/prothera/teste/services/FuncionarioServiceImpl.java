package br.com.prothera.teste.services;

import br.com.prothera.teste.interfaces.FuncionarioRepositorio;
import br.com.prothera.teste.interfaces.FuncionarioService;
import br.com.prothera.teste.models.Funcionario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepositorio repositorio;

    public FuncionarioServiceImpl(FuncionarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {

    }

    @Override
    public void removerFuncionario(int id) {
        repositorio.removerFuncionario(f -> f.getId() == id);
    }

    @Override
    public Funcionario buscarFuncionarioPorId(int funcionarioId) {
        if(funcionarioId < 1) return null;
        return repositorio.buscarFuncionario(f -> f.getId() == funcionarioId);
    }

}
