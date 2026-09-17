# Teste Prático de Programação — Prothera

Projeto desenvolvido como parte do teste prático de programação.

## Sobre o projeto

O projeto consiste no gerenciamento de funcionários de uma indústria, permitindo realizar operações como cadastro, remoção, reajuste salarial, agrupamento por função, filtros e ordenações.

## Tecnologias utilizadas

* Java
* Spring Boot
* Maven
* Java Stream API
* Collections Framework

## Estrutura do projeto

```text
src
└── main
    └── java
        └── br.com.prothera.teste
            ├── interfaces
            │   └── FuncionarioService.java
            │
            ├── models
            │   ├── Pessoa.java
            │   └── Funcionario.java
            │
            ├── repositories
            │   └── FuncionarioRepositorio.java
            │
            ├── services
            │   └── ...
            │
            ├── GestorDeFuncionarios.java
            └── Principal.java
```

## Requisitos implementados

### 1. Pessoa

Criada a classe `Pessoa` contendo:

* `nome`
* `dataNascimento`

A data de nascimento é representada utilizando `LocalDate`.

### 2. Funcionário

Criada a classe `Funcionario`, que estende `Pessoa`, contendo:

* `salario`
* `funcao`

O salário é representado utilizando `BigDecimal` para evitar problemas de precisão em operações envolvendo valores monetários.

### 3. Operações

Na classe Principal.java temos acesso a implementação GestorDeFuncionarios que por sua vez
é a responsável pelas implemenações seguintes:

* Inserção dos funcionários na ordem apresentada no teste; ``(Efetuada na classe na injeção do repositório FuncionarioRepositorioImpl.)``
* 
* Remoção do funcionário João -> ``gestorDeFuncionarios.removerFuncionarioJoao();``
* 
* Listagem dos funcionários; -> ``gestorDeFuncionarios.verTodosFuncionarios();``
* 
* Aplicação de aumento salarial de 10% -> ``gestorDeFuncionarios.efetivarAumentoSalarialEmGrupo();``
* 
* Agrupamento dos funcionários por função -> ``gestorDeFuncionarios.agruparPorFuncao();``
* 
* Impressão dos funcionários agrupados por função -> ``gestorDeFuncionarios.imprimirAgrupadoFuncao();``
* 
* Busca dos funcionários que fazem aniversário nos meses 10 e 12 -> ``gestorDeFuncionarios.imprimirAniversariantes();;``
* 
* Identificação do funcionário mais velho -> ``gestorDeFuncionarios.imprimirFuncionarioMaisVelho();;``
* 
* Ordenação dos funcionários por ordem alfabética -> ``gestorDeFuncionarios.imprimirOrdemAlfa();;``
* 
* Cálculo do total da folha salarial -> ``gestorDeFuncionarios.imprimirFolhaSalarial();``
* 
* Cálculo de quantos salários mínimos cada funcionário recebe. -> ``gestorDeFuncionarios.imprimirSalariosMinimos();``

## Conceitos utilizados

Durante a implementação foram utilizados conceitos e recursos importantes da linguagem Java, como:

### Orientação a objetos

* Herança;
* Encapsulamento;
* Interfaces;
* Separação de responsabilidades.

### Collections

* `List`;
* `Map`;
* `Comparator`;
* `Collectors.groupingBy`.

### Stream API

Foram utilizados recursos da Stream API para operações de:

* filtragem;
* ordenação;
* agrupamento;
* busca;
* redução e soma.

Exemplo de agrupamento por função:

```java
funcionarioService.buscarFuncionarios()
        .stream()
        .collect(Collectors.groupingBy(Funcionario::getFuncao));
```

### Manipulação de datas

As datas são representadas utilizando `LocalDate` e formatadas utilizando `DateTimeFormatter`.

```java
DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd/MM/yyyy");
```

### Valores monetários

Os salários são representados utilizando `BigDecimal`.

Para operações que envolvem divisão, é utilizada escala e estratégia de arredondamento para evitar exceções relacionadas a divisões decimais não terminantes.

Exemplo:

```java
salario.divide(
        BigDecimal.valueOf(1212),
        2,
        RoundingMode.HALF_UP
);
```

## Salário mínimo

Para o requisito de quantidade de salários mínimos recebidos por cada funcionário, foi considerado o valor informado no teste:

```text
R$ 1.212,00
```

O cálculo é realizado através da divisão do salário do funcionário pelo salário mínimo.

## Como executar

### Pré-requisitos

* Java instalado;
* Maven instalado ou utilização do Maven Wrapper;
* IDE de preferência (IntelliJ IDEA, Eclipse, VS Code etc.).

### Executando pela IDE

1. Clone ou abra o projeto na IDE;
2. Aguarde o carregamento das dependências Maven;
3. Localize a classe `Principal`;
4. Execute a aplicação.

### Executando pelo Maven

No diretório raiz do projeto:

```bash
mvn spring-boot:run
```

Caso o projeto utilize Maven Wrapper:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

## Observações

O projeto foi desenvolvido buscando manter as responsabilidades separadas e utilizar recursos nativos do Java para solucionar os requisitos propostos.

A implementação prioriza legibilidade, organização e utilização adequada das estruturas de dados e APIs disponíveis na linguagem.

---

## Autor

**Chrisluan Lucas**

Projeto desenvolvido para o processo seletivo — Teste Prático de Programação.
