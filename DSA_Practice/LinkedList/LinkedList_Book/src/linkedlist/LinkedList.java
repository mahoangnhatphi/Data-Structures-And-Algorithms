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
public class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        head = tail = null;
    }
    
    public void addHead(Book value) {
        if (head == null) {
            head = tail = new Node(value);
        } else {
            Node node = new Node(value);
            node.next = head;
            head.pre = node;
            head = node;
        }
    }
    
    public void addTail(Book value) {
        if (head == null) {
            head = tail = new Node(value);
        } else {
            Node node = new Node(value);
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }
    
    public int countBookByAuthor(String name) {
        if (head == null) return 0;
        int count = 0;
        Node node = head;
        do {
            if (node.getValue().getAuthorName().equalsIgnoreCase(name)) count++;
            if (node != null) node = node.next;
        }while (node != null);
        return count;
    }
    
    public void printBookOnYear(int year) {
        if (head == null) return;
        Node node = head;
        do  {
            if (node.value.getYear() == year) {
                System.out.println(node.value);
            }
            node = node.next;
        } while (node != null);
    }
    
    public void printBookByPulisher(String namePulisher) {
        if (head == null) return;
        Node node = head;
        do  {
            if (node.value.getPulisher().equalsIgnoreCase(namePulisher)) {
                System.out.println(node.value);
            }
            node = node.next;
        } while (node != null);
    }

    @Override
    public String toString() {
        String result = "";
        if (head == null) return "";
        Node node = head;
        do {
            result += node + "\n";
            if (node != null) node = node.next;
        } while (node != null);
        return result;
    }
    
}
