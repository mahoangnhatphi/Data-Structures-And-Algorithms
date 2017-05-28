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
public class LinkedList {

    Node head;
    Node tail;

    public LinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public LinkedList() {
        head = tail = null;
    }

    public void addTail(int x) {
        if (head == null) {
            head = tail = new Node(x);
        } else {
            Node node = new Node(x);
            tail.next = node;
            tail = node;
        }
    }

    public void addHead(int x) {
        if (head == null) {
            head = tail = new Node(x);
        } else {
            Node node = new Node(x);
            node.next = head;
            head = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node p = head;
        while (p != null) {
            result.append(p).append(" ");
            p = p.next;
        }
        return result.toString();
    }

    public void parse(String s) {
        String arr[] = s.split(",");
        head = tail = null;
        for (String x : arr) {
            this.addTail(Integer.parseInt(x.trim()));
        }
        System.out.println("List " + toString() + "is created successful");
    }

    public void deleteOneNode(int position) {
        Node p = head, pre = p;
        int count = 0;
        boolean check = false;
        if (position == 0) {
            head = head.next;
            check = true;
        } else
        while (p != null) {
            if (count++ == position) {
                pre.next = p.next;
                if (p == tail) {
                    tail = pre;
                }
                p = null;
                System.gc();
                check = true;
                break;
            }
            pre = p;
            p = p.next;
        }
        if (check) {
            System.out.println("The node at position " + position + " was deleted");
            System.out.println("The list after deletion is " + toString());
        } else {
            System.out.println(position + " is not existed in positions of list");
        }
    }

    public void deleteManyNode(LinkedList deleteList) {
        Node p = deleteList.head;
        while (p != null) {
            int i;
            while ((i = getPositionInList(p.info)) != -1) {
                deleteOneNode(i);
            }
            p = p.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getPositionInList(int value) {
        Node p = head;
        int i = 0;
        while (p != null) {
            if (p.info == value) {
                return i;
            }
            p = p.next;
            i++;
        }
        return -1;
    }
}
