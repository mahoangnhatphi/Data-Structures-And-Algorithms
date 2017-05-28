/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlist;

/**
 *
 * @author Phi
 */
public class Node {
    Book value;
    Node next;
    Node pre;

    public Node(Book value) {
        this.value = value;
        next = pre = null;
    }

    public Book getValue() {
        return value;
    }

    public void setValue(Book value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return value.toString();
    }
    
}
