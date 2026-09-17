package br.com.prothera.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Principal {
    public static void main(String[] args) {
        var context = SpringApplication.run(Principal.class, args);

        GestorDeFuncionarios gestorDeFuncionarios = context.getBean(GestorDeFuncionarios.class);
        gestorDeFuncionarios.imprimirSalariosMinimos();

    }
}
