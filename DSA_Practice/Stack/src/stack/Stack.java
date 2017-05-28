/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stack;

import data.MyStack;

/**
 *
 * @author Phi
 */
public class Stack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(9);
        stack.push(8);
        stack.push(15);
        stack.pop();
        System.out.println(stack);
    }
    
}
