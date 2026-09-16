package br.com.prothera.teste.services;

import br.com.prothera.teste.interfaces.FuncionarioService;
import br.com.prothera.teste.models.Funcionario;

import java.util.ArrayList;

public class FuncionarioServiceImpl implements FuncionarioService {

    public List<Funcionario> cache = new ArrayList<Funcionario>();
    @Override
    public void AddEmployee(Funcionario funcionario) {

    }

    @Override
    public void RemoveEmployee(int funcionario) {

    }
}
