/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package unipar.br.trabalhopp;

/**
 *
 * @author jjoao
 */
public class Node {
    Cliente cliente;
    Node next;
    Node prev;

    public Node(Cliente cliente) {
        this.cliente = cliente;
        this.next = null;
        this.prev = null;
    }
}
