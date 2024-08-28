import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        Departamento dep1 = new Departamento();
        Funcionario fun1 = new Funcionario();

        int variavelescolha1;
        int variavelescolha2;
        int varivaelescolha3;

        System.out.println("------------- BEM VINDO -------------");
        System.out.println("1 - DEPARTAMENTO      2 - FUNCIONARIO");
        System.out.println("Escolha uma funcao: ");
        variavelescolha1 = sc.nextInt();

        if (variavelescolha1 == 1) {
            System.out.println("----- DEPARTAMENTO -----");
            System.out.println("1 - INCLUIR");
            System.out.println("2 - CONSULTAR");
            System.out.println("3 - ALTERAR");
            System.out.println("4 - EXCLUIR");
            System.out.println("5 - CONSULTAR TODOS");
            variavelescolha2 = sc.nextInt();

            switch (variavelescolha2) {
                case 1:
                    // INCLUIR DEPARTAMENTO
                    dep1.setDescDepto(JOptionPane.showInputDialog("Informe a Descricao do Departamento"));
                    if
                    (dep1.incluirDepartamento()) {
                        System.out.println("Inclusão de departamento efetuada com sucesso");
                    } else {
                        System.out.println("Ocorreram erros na inclusão do departamento");
                    }
                    break;

                case 2:
                    // CONSULTAR UM DEPARTAMENTO
                    dep1.setIdDepto(Integer.parseInt(JOptionPane.showInputDialog("Informe o departamento")));
                    dep1 = dep1.consultaDepto();
                    if
                    (dep1.getDescDepto() == null) {
                        System.out.println("Não encontrei o departamento");
                    } else {
                        System.out.println("Departamento : " + dep1.getDescDepto());
                    }
                    break;

                case 3:
                    // ALTERAR DEPARTAMENTO
                    dep1.setIdDepto(Integer.parseInt(JOptionPane.showInputDialog("Informe o departamento")));
                    dep1.setDescDepto(JOptionPane.showInputDialog("Informe o departamento"));
                    if (dep1.alterarDepartamento()) {
                        System.out.println("Alteração do departamento efetuada com sucesso");
                    } else {
                        System.out.println("Erro ao alterar o departamento");
                    }
                    break;

                case 4:
                    // EXCLUIR DEPARTAMENTO
                    System.out.println(variavelescolha2);
                    dep1.setIdDepto(Integer.parseInt(JOptionPane.showInputDialog("Informe o departamento")));
                    if (dep1.excluirDepartamento()) {
                        System.out.println("Exclusão do departamento efetuada com sucesso");
                    } else {
                        System.out.println("Erro ao excluir o departamento");
                    }
                    break;

                case 5:
                    // CONSULTAR TODOS DEPARTAMENTOS
                    List<Departamento> lista = dep1.listarDeptos();
                    for (Departamento d : lista) {
                        System.out.println("Departamento.: " + d.getIdDepto() + " - " + d.getDescDepto());
                    }
                    break;

                default:
                    System.out.println("INVALIDO SAINDO DO PROGRAMA");
                    System.exit(0);
                    break;
            }
        } else if (variavelescolha1 == 2) {
            System.out.println("----- FUNCIONARIO -----");
            System.out.println("1 - INCLUIR");
            System.out.println("2 - CONSULTAR");
            System.out.println("3 - ALTERAR");
            System.out.println("4 - EXCLUIR");
            System.out.println("5 - CONSULTAR TODOS");
            varivaelescolha3 = sc.nextInt();

            switch (varivaelescolha3) {
                case 1:
                    // INCLUIR FUNCIONARIO
                    fun1.setNomeFunc(JOptionPane.showInputDialog("Informe o nome do Funcionario: "));
                    fun1.setIdDepto(Integer.parseInt(JOptionPane.showInputDialog("Informe o departamento do Funcionario")));
                    fun1.setSalHora(Double.parseDouble(JOptionPane.showInputDialog("Informe o salario hora do Funcionario")));
                    if (fun1.incluirFuncionario()) {
                        System.out.println("Inclusão de Funcionario efetuada com sucesso");
                    } else {
                        System.out.println("Ocorreram erros na inclusão do Funcionario");
                    }
                    break;

                case 2:
                    //listar um FUNCIONARIO ESPECÍFICIO
                    fun1.setIdFunc(Integer.parseInt(JOptionPane.showInputDialog("Informe o id do funcionario")));
                    fun1 = fun1.consultaFuncionario();
                    if (fun1 == null || fun1.getNomeFunc() == null) {
                        System.out.println("Não encontrei o funcionário");
                    } else {
                        System.out.println("nome : " + fun1.getNomeFunc());
                        System.out.println("idDepto : " + fun1.getIdDepto());
                        System.out.println("salario hora : " + fun1.getSalHora());
                    }
                    break;

                case 3:
                    // ALTERAR FUNCIONARIO
                    fun1.setNomeFunc(JOptionPane.showInputDialog("Informe o novo nome do funcionario"));
                    fun1.setIdDepto(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do novo departamento")));
                    fun1.setSalHora(Integer.parseInt(JOptionPane.showInputDialog("Informe o novo salario hora base")));
                    fun1.setIdFunc(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do funcionario que deseja alterar")));
                    if (fun1.alterarFuncionario()) {
                        System.out.println("Alteração do funcionario efetuada com sucesso");
                    } else {
                        System.out.println("Erro ao alterar o funcionario");
                    }
                    break;

                case 4:
                    // EXCLUIR de FUNCIONARIO
                    fun1.setIdFunc(Integer.parseInt(JOptionPane.showInputDialog("Informe o id do funcionario")));
                    if (fun1.excluirFuncionario()) {
                        System.out.println("Exclusão do funcionario efetuada com sucesso");
                    } else {
                        System.out.println("Erro ao excluir o funcionario");
                    }
                    break;

                case 5:
                    // CONSULTAR TODOS FUNCIONARIOS
                    List<Funcionario> lista = fun1.listarFuncionarios();
                    for (Funcionario f : lista) {
                        System.out.println("Funcionario.: " + f.getNomeFunc() + " - " + f.getIdFunc() + " - " + f.getIdDepto() + " - " + f.getSalHora());
                    }
                    break;

                default:
                    System.out.println("INVALIDO SAINDO DO PROGRAMA");
                    System.exit(0);
                    break;
            }

        } else {
            System.exit(0);

        }
    }
}
