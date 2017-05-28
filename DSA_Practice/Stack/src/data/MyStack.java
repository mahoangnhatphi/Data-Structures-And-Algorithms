/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Phi
 */
public class MyStack {

    private Node top;

    public MyStack() {
        top = null;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public void push(int x) {
        if (top == null) {
            top = new Node(x);
        } else {
            Node tmp = new Node(x);
            tmp.setNext(top);
            top = tmp;
        }
    }
    
    public Node pop() {
        Node tmp = top;
        top = top.getNext();
        return tmp;
    }
    
    public Node peek() {
        return top;
    }

    @Override
    public String toString() {
        String str = "";
        Node tmp = top;
        while (top != null) {
            str += top + " ";
            top = top.getNext();
        }
        return str;
    }
    
    
}
