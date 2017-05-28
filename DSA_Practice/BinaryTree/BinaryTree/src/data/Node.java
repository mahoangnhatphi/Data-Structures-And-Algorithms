/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author Phi
 */
public class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return value + "";
    }
    
    public boolean isLeaf() {
        return left == null && right == null;
    }
    
    public boolean isHasOneChild() {
        return (left == null && right != null) || (left != null && right == null);
    }
    
    public boolean isHasLeftBranch() {
        return left != null;
    }
    
    public boolean isHasRightBranch() {
        return right != null;
    }
    
    public boolean isHasTwoChild() {
        return (left != null && right != null);
    }
}
