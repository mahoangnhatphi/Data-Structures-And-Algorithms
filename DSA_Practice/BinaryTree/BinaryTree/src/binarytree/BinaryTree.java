/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import data.IntBinaryTree;
import data.Node;

/**
 *
 * @author Phi
 */
public class BinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntBinaryTree tree = new IntBinaryTree();
        tree.insert(9);
        tree.insert(8);
        tree.insert(5);
        tree.insert(15);
        tree.insert(100);
        tree.insert(10);
        tree.insert(12);
        tree.insert(14);
        tree.insert(7);
        tree.deleteNode(8);
        tree.inorder(tree);
    }
    
}
