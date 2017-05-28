/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsa_practical_exam001;

import java.util.Scanner;

/**
 *
 * @author Phi
 */
public class DSA_Practical_Exam001 {

    /**
     * @param args the command line arguments
     */
    
    final static Scanner SCANNER = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Enter integer values(Enter to exit): ");
        LinkedList linkedList = new LinkedList();
        linkedList.parse(SCANNER.nextLine());
        LinkedList deleteList = new LinkedList();
        deleteList.parse(SCANNER.nextLine());
        linkedList.deleteManyNode(deleteList);
    }
    
}
