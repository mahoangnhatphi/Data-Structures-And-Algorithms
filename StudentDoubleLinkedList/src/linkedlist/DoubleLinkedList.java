/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import data.Student;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Phi
 */
public class DoubleLinkedList {

    Node head;
    Node tail;
    
    int size;

    public DoubleLinkedList() {
        head = tail = null;
        size = 0;
    }

    public DoubleLinkedList(Node initialNode) {
        head = tail = initialNode;
        size = 1;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node p = head;
        int index = 1;
        while (p != null) {
            result.append(index++).append(" . ").append(p.info).append("\n");
            p = p.next;
        }
        return result + "";
    }

    public boolean addHead(Student student) {
        if (isExisted(student.getCode())) return false;
        Node newNode = new Node(student);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean addTail(Student student) {
        if (isExisted(student.getCode())) return false;
        Node newNode = new Node(student);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.pre = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public Student findStudentHasMaximumScore() {
        Node p = null;
        if (head == null) {
            return null;
        }
        Node result = head;
        if (head.next != null) {
            p = head.next;
        }
        while (p != null) {
            if (result.info.getScore() < p.info.getScore()) {
                result = p;
            }
            p = p.next;
        }
        return result.info;
    }

    public void removeHead() {
        Node nextNode = head.next;
        head.next.pre = null;
        head.next = null;
        head = nextNode;
    }
    
    public void removeTail() {
        Node preTail = tail.pre;
        tail.pre.next = null;
        tail.pre = null;
        tail = preTail;
    }
    
    public Node getNode(int index) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i++ == index) {
                return p;
            }
            p = p.next;
        }
        return null;
    }
    
    public Student get(int index) {
        Student student = null;
        Node p;
        if ( (p = getNode(index)) != null) student = p.info;
        return student;
    }
    
    public int getPosition(String studentCode) {
        Node p = head;
        int i = 0;
        while (p != null) {
            if (p.info.getCode().equalsIgnoreCase(studentCode)) {
                return i;
            }
            i++;
            p = p.next;
        }
        return -1;
    }
    
    public boolean isExisted(String studentCode) {
        return getPosition(studentCode) != -1;
    }
    
    public boolean deleteNode(String studentCode) {
        return deleteNode(getPosition(studentCode));
    }

    public boolean deleteNode(int position) {
        int i = 1;
        if (position == 0) {
            removeHead();
            size--;
            return true;
        }
        Node p = head.next, pre = head;
        while (p != null) {
            if (i++ == position) {
                if (p == tail) {
                    removeTail();
                    size--;
                    return true;
                }
                p.next.pre = pre;
                pre.next = p.next;
                p.next = null;
                p.pre = null;
                System.gc();
                size--;
                return true;
            }
            pre = p;
            p = p.next;
        }
        return false;
    }
    
    public void quickSort(int left, int right) {
        if (left > right) return;
        int i = left, j = right;
        Student p = get( (i + j) / 2);
        while (i <= j) {
            while (get(i).getScore() < p.getScore()) i++;
            while (get(j).getScore() > p.getScore()) j--;
            if (i <= j) {
                Student tmp = getNode(i).info;
                getNode(i).info = getNode(j).info;
                getNode(j).info = tmp;
                i++;
                j--;
            }
        }
        if (i < right) quickSort(i, right);
        if (j > left) quickSort(left, j);
    }
    
    public boolean insert(Student student, int position) {
        if (position < 0 || isExisted(student.getCode())) return false;
        Node newNode = new Node(student);
        if (position == 0) {
            addHead(student);
        }
        else if (position >= size) {
            addTail(student);
        } else {
            Node p = getNode(position);
            Node pre = p.pre;
            Node next = p.next;
            p.pre = null;
            p.next = null;
            pre.next = next;
            next.pre = pre;
        }
        size++;
        return true;
    }
    
    public void sort() {
        quickSort(0, size - 1);
    }
    
    public void saveToFile(String filename) {
        try {
            FileWriter fw = new  FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
            Node p = head;
            while (p != null) {
                bw.append(p.info.getCode() + ";" + p.info.getName()+ ";" + p.info.getAge()+ ";" + p.info.getScore() + "\n");
                p = p.next;
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
        }
    }
}
