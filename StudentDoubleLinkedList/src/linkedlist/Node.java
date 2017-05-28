/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlist;

import data.Student;

/**
 *
 * @author Phi
 */
public class Node {
    Student info;
    Node next;
    Node pre;

    public Node(Student info) {
        this.info = info;
        next = pre = null;
    }
    
    public Node(String code, String name, int age, double score) { 
        this.info = new Student(code, name, age, score);
        next = pre = null;
    }

    public Student getInfo() {
        return info;
    }

    public void setInfo(Student info) {
        this.info = info;
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
        return info.toString();
    }
    
    
}
