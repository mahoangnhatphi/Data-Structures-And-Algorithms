/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentdoublelinkedlist;

import data.Student;
import linkedlist.DoubleLinkedList;
import util.Util;

/**
 *
 * @author Phi
 */
public class StudentDoubleLinkedList {

    /**
     * @param args the command line arguments
     */
    private final static String FILENAME = "input.txt";
    
    public static void menu(DoubleLinkedList linkedList) {
        String msg = "1 - Add new student at head of Linked List\n"
                + "2 - Add new student at tail of Linked List\n"
                + "3 - Add new student at a position\n"
                + "4 - Print students in Linked List\n"
                + "5 - Delete student in list by student code\n"
                + "6 - Delete student in list by position\n"
                + "7 - Sort student Linked List by Score\n"
                + "8 - Save to file\n"
                + "0 - Exit\n"
                + "Select: ";
        int choice = 0;
        boolean check;
        do {
            System.out.print(msg);
            do {
                choice = Util.getInt("", "Please input from 0 to 8");
            } while (choice < 0 || choice > 8);
            switch (choice) {
                case 1:
                    check = linkedList.addHead(Student.inputStudent());
                    if (check) {
                        System.out.println("Add successful");
                    } else {
                        System.out.println("Student code has been existed");
                    }
                    break;
                case 2:
                    check = linkedList.addTail(Student.inputStudent());
                    if (check) {
                        System.out.println("Add successful");
                    } else {
                        System.out.println("Student code has been existed");
                    }
                    break;
                case 3:
                    check = linkedList.insert(Student.inputStudent(), Util.getInt("Input student position in list: ", "Please input an integer") - 1);
                    if (check) {
                        System.out.println("Add successful");
                    } else {
                        System.out.println("Student code has been existed");
                    }
                    break;
                case 4:
                    System.out.println("Student linked list: ");
                    System.out.println(linkedList);
                    break;
                case 5:
                    check = linkedList.deleteNode(Util.getString("Input deleted student code: "));
                    if (check) {
                        System.out.println("Delete successful");
                    } else {
                        System.out.println("Student code has not been existed");
                    }
                    break;
                case 6:
                    check = linkedList.deleteNode(Util.getInt("Input postion of deleted student: ", "Please input an integer") - 1);
                    if (check) {
                        System.out.println("Delete successful");
                    } else {
                        System.out.println("Student has not been existed");
                    }
                    break;
                case 7:
                    linkedList.sort();
                    System.out.println("Sort successful");
                    break;
                case 8:
                    Util.saveToFile(FILENAME, linkedList);
                    System.out.println("Save successful");
                    break;
                case 0:
                    System.out.println("Have a nice day");

            }
            for (int i = 0; i < 100; i++) {
                System.out.print("-");
            }
            System.out.println("");
        } while (choice != 0);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        DoubleLinkedList linkedList = new DoubleLinkedList();
        Util.readFile(FILENAME, linkedList);
        menu(linkedList);
    }

}
