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
public class Tree {

    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public Tree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Tree getLeftBranch() {
        return new Tree(root.getLeft());
    }

    public Tree getRightBranch() {
        return new Tree(root.getRight());
    }

    public void addNode(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node pre = null, p = root;
            boolean isLeft = root.info > value;
            while (p != null) {
                pre = p;
                if (p.info < value) {
                    p = pre.right;
                    isLeft = false;
                } else if (p.info > value) {
                    p = pre.left;
                    isLeft = true;
                }
            }
            if (isLeft) {
                pre.left = new Node(value);
            } else {
                p = new Node(value);
                pre.right = new Node(value);
            }
        }
    }

    public void inOrderTraversal() {
        if (root != null) {
            System.out.print(root.info + " ");
            getLeftBranch().inOrderTraversal();
            getRightBranch().inOrderTraversal();
        }
    }

    public void preOrderTraversal() {
        if (root != null) {
            getLeftBranch().preOrderTraversal();
            System.out.print(root.info + " ");
            getRightBranch().preOrderTraversal();
        }
    }
    
    public void postOrderTraversal() {
        if (root != null) {
            getLeftBranch().postOrderTraversal();
            getRightBranch().postOrderTraversal();
            System.out.print(root.info + " ");
        }
    }
    
    public int findMin() {
        Node p = root, pre = null;
        while (p != null) {
            pre = p;
            p = p.left;
        }
        return pre.info;
    }
    
    public int findMax() {
        Node p = root, pre = null;
        while (p != null) {
            pre = p;
            p = p.right;
        }
        return pre.info;
    }
}
