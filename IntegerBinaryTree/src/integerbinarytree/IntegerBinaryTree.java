/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integerbinarytree;

/**
 *
 * @author Phi
 */
public class IntegerBinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tree tree = new Tree();
        tree.addNode(10);
        tree.addNode(15);
        tree.addNode(12);
        tree.addNode(8);
        tree.addNode(5);
        tree.addNode(6);
        tree.addNode(7);
        tree.preOrderTraversal();
        System.out.println("");
        System.out.println(tree.findMin());
        System.out.println(tree.findMax());
    }
    
}
