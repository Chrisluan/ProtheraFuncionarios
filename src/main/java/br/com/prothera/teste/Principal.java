package br.com.prothera.teste;
import br.com.prothera.teste.interfaces.FuncionarioService;
import br.com.prothera.teste.models.Funcionario;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class Principal {
    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(Principal.class, args);


        FuncionarioService funcionarioService = context.getBean(FuncionarioService.class);

        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(1);
        System.out.println(funcionario);
        funcionarioService.removerFuncionario(funcionario.getId());

        System.out.println(funcionarioService.buscarFuncionarioPorId(1));
    }
}
