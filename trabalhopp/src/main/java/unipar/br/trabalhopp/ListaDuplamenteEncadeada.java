/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unipar.br.trabalhopp;

/**
 *
 * @author jjoao
 */
public class ListaDuplamenteEncadeada {
    private Node head;
    private Node tail;

    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addCliente(Cliente cliente) {
        Node newNode = new Node(cliente);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public Cliente removeCliente(String codigo) {
        Node current = head;
        while (current != null) {
            if (current.cliente.getCodigo().equals(codigo)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                if (current == head) {
                    head = current.next;
                }
                if (current == tail) {
                    tail = current.prev;
                }
                return current.cliente;
            }
            current = current.next;
        }
        return null;
    }

    public Cliente updateCliente(String codigo, String nome, String dataNascimento, String telefone) {
        Cliente cliente = findCliente(codigo);
        if (cliente != null) {
            cliente.setNome(nome);
            cliente.setDataNascimento(dataNascimento);
            cliente.setTelefone(telefone);
            return cliente;
        }
        return null;
    }

    public Cliente findCliente(String codigo) {
        Node current = head;
        while (current != null) {
            if (current.cliente.getCodigo().equals(codigo)) {
                return current.cliente;
            }
            current = current.next;
        }
        return null;
    }

    public String listAllClientes() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.cliente.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}
