package br.com.prothera.teste;

import br.com.prothera.teste.interfaces.FuncionarioService;
import br.com.prothera.teste.models.Funcionario;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GestorDeFuncionarios {
    private final FuncionarioService funcionarioService;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Map<String, List<Funcionario>> listaPorFuncao = null;

    public GestorDeFuncionarios(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarioService.adicionarFuncionario(funcionario);
    }

    //3.2
    public void removerFuncionarioJoao() {
        try {
            var idFuncionario = funcionarioService.buscarFuncionarios(
                    f -> f.getNome().contains("João")
            ).getFirst().getId();
            funcionarioService.removerFuncionario(idFuncionario);
        } catch (Exception ex) {
            System.out.println("Falha ao remover funcionario, certeza que ele existe? " + ex.getMessage());
        }


    }

    //3.3
    public void verTodosFuncionarios() {
        System.out.println(funcionarioService.buscarFuncionarios());
    }

    //3.4
    public void efetivarAumentoSalarialEmGrupo() {
        efetivarAumentoSalarialEmGrupo(BigDecimal.TEN);
    }

    public void efetivarAumentoSalarialEmGrupo(BigDecimal porcentagem) {
        for (Funcionario funcionario : funcionarioService.buscarFuncionarios()) {
            funcionario.setSalario(funcionario.getSalario().add(
                    funcionario.getSalario()
                            .multiply(porcentagem)
                            .divide(BigDecimal.valueOf(100))
            ));
        }
    }

    //3.5
    public void agruparPorFuncao() {
        listaPorFuncao = funcionarioService.buscarFuncionarios()
                .stream()
                .collect(Collectors.groupingBy(f -> f.getFuncao()));
    }

    //3.6
    public void imprimirAgrupadoFuncao() {
        agruparPorFuncao();
        listaPorFuncao.forEach((funcao, listaDeFuncionarios) -> {
            System.out.println("=---> " + funcao + " <----=");
            System.out.println(listaDeFuncionarios);
        });
    }

    //3.8
    public void imprimirAniversariantes() {

        var aniversariantes = funcionarioService.buscarFuncionarios(
                f -> {
                    LocalDate date = f.getDataNascimento();
                    return date.getMonthValue() == 10 || date.getMonthValue() == 12;
                }
        );
        System.out.println(aniversariantes);
    }

    //3.9
    public void imprimirFuncionarioMaisVelho() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        var funcionarioMaisVelho = funcionarioService.buscarFuncionarios()
                .stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento));

        if (funcionarioMaisVelho.isPresent()) {
            var funcionario = funcionarioMaisVelho.get();

            LocalDate dataNascimento = funcionario.getDataNascimento();

            long idade = ChronoUnit.YEARS.between(
                    dataNascimento,
                    LocalDate.now()
            );
            System.out.printf(
                    """
                            Nome: %s
                            Idade: %d anos - %s
                            %n""", funcionario.getNome(),
            idade,
            funcionario.getDataNascimento().format(formatter)
    );
        }
    }

    //3.10
    public void imprimirOrdemAlfa() {
        var funcionarios = funcionarioService.buscarFuncionarios();
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));

        System.out.println(funcionarios);
    }

    //3.11
    public void imprimirFolhaSalarial() {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        BigDecimal totalSalarios = funcionarioService.buscarFuncionarios()
                .stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total da folha salarial: " + formatador.format(totalSalarios));
    }

    //3.12
    public void imprimirSalariosMinimos() {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        funcionarioService.buscarFuncionarios()
                .forEach(f -> {
                    System.out.printf(
                            """
                                        ===================
                                        Nome: %s , Função: %s,
                                        Salario: %s (%s vezes o salario mínimos)
                                        ===================
                                    %n""", f.getNome(),
                    f.getFuncao(),
                    formatador.format(f.getSalario()),
                    f.getSalario().divide(BigDecimal.valueOf(1212), 2, RoundingMode.HALF_UP)
            );
                });
    }
}


