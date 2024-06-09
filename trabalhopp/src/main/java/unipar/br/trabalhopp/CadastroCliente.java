/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unipar.br.trabalhopp;

/**
 *
 * @author jjoao
 */
import javax.swing.JOptionPane;

public class CadastroCliente {

    static ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();

    public static void main(String[] args) {
        
        int opcao = -1;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:\n"
                    + "1 - Gravar novo cadastro\n"
                    + "2 - Excluir cadastro\n"
                    + "3 - Alterar cadastro\n"
                    + "4 - Recuperar cadastro\n"
                    + "5 - Exibir todos os cadastros\n"
                    + "0 - Sair"));
            
            switch(opcao) {
                case 1:
                    gravarNovoCadastro();
                    break;
                case 2:
                    excluirCadastro();
                    break;
                case 3:
                    alterarCadastro();
                    break;
                case 4:
                    recuperarCadastro();
                    break;
                case 5:
                    exibirTodosCadastros();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            }
        } while(opcao != 0);
    }
    
    public static void gravarNovoCadastro() {
        String codigo = JOptionPane.showInputDialog("Código: ");
        String nome = JOptionPane.showInputDialog("Nome: ");
        String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento (dd/mm/yyyy): ");
        String telefone = JOptionPane.showInputDialog("Telefone: ");
        Cliente cliente = new Cliente(codigo, nome, dataNascimento, telefone);
        lista.addCliente(cliente);
        JOptionPane.showMessageDialog(null, "Cadastro adicionado com sucesso.");
    }

    public static void excluirCadastro() {
        String codigo = JOptionPane.showInputDialog("Código do cliente a ser excluído: ");
        Cliente cliente = lista.removeCliente(codigo);
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, "Cliente excluído: " + cliente);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não foi  encontrado.");
        }
    }

    public static void alterarCadastro() {
        String codigo = JOptionPane.showInputDialog("Código do cliente a ser alterado: ");
        Cliente cliente = lista.findCliente(codigo);
        if (cliente != null) {
            String nome = JOptionPane.showInputDialog("Novo Nome (anterior: " + cliente.getNome() + "): ");
            String dataNascimento = JOptionPane.showInputDialog("Nova Data de Nascimento (anterior: " + cliente.getDataNascimento() + "): ");
            String telefone = JOptionPane.showInputDialog("Novo Telefone (anterior: " + cliente.getTelefone() + "): ");
            cliente = lista.updateCliente(codigo, nome, dataNascimento, telefone);
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não foi  encontrado.");
        }
    }

    public static void recuperarCadastro() {
        String codigo = JOptionPane.showInputDialog("Código do cliente a ser recuperado: ");
        Cliente cliente = lista.findCliente(codigo);
        if (cliente != null) {
            JOptionPane.showMessageDialog(null, cliente);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não foi encontrado.");
        }
    }

    public static void exibirTodosCadastros() {
        String clientes = lista.listAllClientes();
        if (!clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, clientes);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado.");
        }
    }
}
