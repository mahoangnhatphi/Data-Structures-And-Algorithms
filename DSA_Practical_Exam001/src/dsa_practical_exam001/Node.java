/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsa_practical_exam001;

/**
 *
 * @author Phi
 */
public class Node {
    int info;
    Node next;

    public Node(int info) {
        this.info = info;
        next = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return info + "";
    }

}
