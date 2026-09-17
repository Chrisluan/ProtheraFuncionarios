package br.com.prothera.teste.repositories;

import br.com.prothera.teste.interfaces.FuncionarioRepositorio;
import br.com.prothera.teste.models.Funcionario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class FuncionarioRepositorioImpl implements FuncionarioRepositorio {

    private final File arquivoData = new File("src/main/resources/data.json");
    private final ObjectMapper mapper = new ObjectMapper();
    List<Funcionario> funcionarios = new ArrayList<Funcionario>();


    public FuncionarioRepositorioImpl() {
        mapper.registerModule(new JavaTimeModule());
        carregarFuncionarios();
    }

    @Override
    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        persistir();
    }

    @Override
    public void removerFuncionario(Predicate<Funcionario> filtro) {
        this.funcionarios.removeIf(filtro);
        persistir();
    }

    @Override
    public Funcionario buscarFuncionario(Predicate<Funcionario> filtro) {
        return this.funcionarios.stream().filter(filtro).findFirst().orElse(null);
    }

    @Override
    public List<Funcionario> buscarTodosFuncionarios(Predicate<Funcionario> filtro) {
        return funcionarios.stream().filter(filtro).toList();
    }

    public List<Funcionario> buscarTodosFuncionarios() {
        return funcionarios;
    }

    @Override
    public void carregarFuncionarios() {
        try {
            this.funcionarios = mapper.readValue(
                    arquivoData,
                    new TypeReference<List<Funcionario>>() {
                    }
            );
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao carregar funcionários", ex);
        }
    }

    @Override
    public void persistir() {
        try {
            mapper.writeValue(arquivoData, this.funcionarios);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao persistir: ", ex);
        }

    }

}
