import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Empresa empresa = new Empresa();
        Departamento departamento = new Departamento(empresa);
        Funcionario funcionario = new Funcionario(empresa);
        Menus menus = new Menus(empresa);

        menus.tituloInicial();
        empresa.cadastrarEmpresa();
        empresa.menu();

    }
}

class Empresa {

    Scanner entrada = new Scanner(System.in);

    private String nomeEmpresa;
    private String cnpjEmpresa;
    private ArrayList<String> departamentos = new ArrayList<>();

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public ArrayList<String> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<String> departamentos) {
        this.departamentos = departamentos;
    }

     void cadastrarEmpresa() {
        System.out.print("Nome da Empresa: ");
        nomeEmpresa = entrada.nextLine();
        System.out.print("CNPJ da Empresa: ");
        cnpjEmpresa = entrada.nextLine();
    }

    void menu() {
        int opcao;
        Departamento departamento = new Departamento(this);

        do {
            System.out.println();
            System.out.println("*************** Empresa " + this.nomeEmpresa + " ****************");
            System.out.println();
            System.out.println(">>>>> Escolha uma opção:");
            System.out.println();
            System.out.println("1. Cadastrar Departamento");
            System.out.println("2. Listar Departamentos");
            System.out.println("3. Acessar Departamento");
            System.out.println("4. Sair");

            System.out.print(">>>>> ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    departamento.cadastrarDepartamento();
                    break;
                case 2:
                    departamento.listarDepartamentos();
                    break;
                case 3:
                    departamento.acessarDepartamento();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 4);
    }


}

class Departamento {

    private String nomeDepartamento;

    private ArrayList<String> funcionarios = new ArrayList<>();
    private final Empresa empresa;



    public Departamento(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    void cadastrarDepartamento() {
        Scanner entrada = new Scanner(System.in);
        System.out.println();
        System.out.print("Informe o nome do departamento: ");
        this.nomeDepartamento = entrada.nextLine();
        empresa.getDepartamentos().add(nomeDepartamento);
    }

    void listarDepartamentos() {
        System.out.println();
        System.out.println("*************** Lista de Departamentos ***************");
        System.out.println();

        if (empresa.getDepartamentos().isEmpty()) {
            System.out.println("Nenhum departamento cadastrado.");
        } else {
            for (int i = 0; i < empresa.getDepartamentos().size(); i++) {
                System.out.println((i + 1) + " - " + empresa.getDepartamentos().get(i));
            }
        }
    }

    void acessarDepartamento() {

        Scanner entrada = new Scanner(System.in);

        System.out.println();
        System.out.println("*************** Escolha o Departamento ***************");
        System.out.println();

        if (empresa.getDepartamentos().isEmpty()) {
            System.out.println("Nenhum departamento cadastrado.");
        } else {

            for (int i = 0; i < empresa.getDepartamentos().size(); i++) {
                System.out.println((i + 1) + " - " + empresa.getDepartamentos().get(i));
            }

            System.out.println();
            System.out.print(">>>>> ");

            int opcao = entrada.nextInt();

            if (opcao < 1 || opcao > empresa.getDepartamentos().size()) {
                System.out.println("Opção inválida!");
            } else {
                Funcionario funcionario = new Funcionario(empresa);

                do {
                    System.out.println();
                    System.out.println("*************** Departamento " + getNomeDepartamento() + " ****************");
                    System.out.println();
                    System.out.println(">>>>> Escolha uma opção:");
                    System.out.println();
                    System.out.println("1. Cadastrar Funcionario");
                    System.out.println("2. Sair");

                    System.out.print(">>>>> ");
                    opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            funcionario.cadastrarFuncionario();
                            break;
                        case 2:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                } while (opcao != 2);
            }
        }

    }

    public ArrayList<String> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<String> funcionarios) {
        this.funcionarios = funcionarios;
    }
}

class Funcionario {
    private String nomeFuncionario;
    private double salarioFuncionario;
    private LocalDate  dataAdmissao;

    private final Empresa empresa;



    public Funcionario(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public double getSalarioFuncionario() {
        return salarioFuncionario;
    }

    public void setSalarioFuncionario(double salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }


    void cadastrarFuncionario() {
        Scanner entrada = new Scanner(System.in);
        System.out.println();
        System.out.print("Informe o nome do funcionario: ");
        this.nomeFuncionario = entrada.nextLine();
        System.out.print("Informe o salario do funcionario: ");
        this.salarioFuncionario = entrada.nextDouble();
        System.out.print("Informe a data de admissao (aaaa-mm-dd): ");
        this.dataAdmissao = LocalDate.parse(entrada.next());

//        this.empresa.getDepartamentos().get(0).getFuncionarios().add(nomeFuncionario);
    }

    void listarFuncionario() {
        System.out.println();
        System.out.println("*************** Lista de Funcionarios ***************");
        System.out.println();

        if (empresa.getDepartamentos().isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
        } else {
            for (int i = 0; i < empresa.getDepartamentos().size(); i++) {
                System.out.println((i + 1) + " - " + empresa.getDepartamentos().get(i));
            }
        }
    }
}

record Menus(Empresa empresa) {

    void tituloInicial() {
        System.out.println();
        System.out.println("*************** BEM VINDO ***************");
        System.out.println();
        System.out.println("Primeiro cadastre a empresa!");
        System.out.println();
    }


}