/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import data.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import linkedlist.DoubleLinkedList;

/**
 *
 * @author Phi
 */
public class Util {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getInt(String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }

    public static double getDouble(String msg, String err) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }

    public static String getString(String msg) {
        do {
            System.out.print(msg);
            String s = SCANNER.nextLine().trim();
            if (s.equals("")) {
                System.out.println("Please input a string");
            } else {
                return s;
            }
        } while (true);
    }

    public static void readFile(String filename, DoubleLinkedList linkedList) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            StringTokenizer stk = null;
            String s;
            while ((s = br.readLine()) != null) {
                stk = new StringTokenizer(s, ";");
                while (stk.hasMoreTokens()) {
                    String code = stk.nextToken().trim();
                    String name = stk.nextToken().trim();
                    int age = Integer.parseInt(stk.nextToken().trim());
                    double score = Double.parseDouble(stk.nextToken().trim());
                    linkedList.addTail(new Student(code, name, age, score));
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void saveToFile(String filename, DoubleLinkedList linkedList) {
        linkedList.saveToFile(filename);
    }
}
