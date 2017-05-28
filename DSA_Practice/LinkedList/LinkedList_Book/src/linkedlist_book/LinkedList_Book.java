/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package linkedlist_book;

import linkedlist.LinkedList;
import util.Util;

/**
 *
 * @author Phi
 */
public class LinkedList_Book {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Util.loadData(linkedList);
        System.out.println(linkedList);
        System.out.println("Number of book by JK Roling is " + linkedList.countBookByAuthor("JK Rowling"));
        System.out.println("Book present int 1998");
        linkedList.printBookOnYear(1998);
        System.out.println("Book has printed by NXB Trẻ");
        linkedList.printBookByPulisher("NXB Trẻ");
    }
    
}
