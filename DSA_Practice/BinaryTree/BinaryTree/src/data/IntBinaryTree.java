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
public class IntBinaryTree {

    Node root;

    public IntBinaryTree() {
        root = null;
    }

    public IntBinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void visit(Node p) {
        System.out.println(p.value + " ");
    }

    public IntBinaryTree getLeftBranch() {
        return new IntBinaryTree(root.left);
    }

    public IntBinaryTree getRightBranch() {
        return new IntBinaryTree(root.right);
    }

    public void insert(int value) {
        Node node = root, prev = null;
        while (node != null) {
            prev = node;
            if (node.value > value) {
                node = node.left;
            } else if (node.value < value) {
                node = node.right;
            } else {
                break;
            }
        }
        if (root == null) {
            root = new Node(value);
        } else if (prev.value > value) {
            prev.left = new Node(value);
        } else {
            prev.right = new Node(value);
        }
    }

    public void inorder(IntBinaryTree tree) {
        if (tree.root != null) {
            tree.visit(root);
            if (tree.getLeftBranch() != null) {
                tree.getLeftBranch().inorder(tree.getLeftBranch());
            }
            if (tree.getRightBranch() != null) {
                tree.getRightBranch().inorder(tree.getRightBranch());
            }
        }
    }

    public void deleteNode(int value) {
        Node p = root, pre = root;
        while (p != null && p.value != value) {
            pre = p;
            if (p.value < value) {
                p = p.right;
            } else if (p.value > value) {
                p = p.left;
            } else {
                return;
            }
        }
        if (p.isLeaf()) {
            if (pre == p) {
                p = null;
                return;
            }
            if (pre != null && p.value < pre.value) {
                pre.left = null;
            } else if (pre != null && p.value > pre.value) {
                pre.right = null;
            } else if (pre != null && p.value == pre.value) {
                return;
            }
        } else if (p.isHasOneChild()) {
            if (pre == p) {
                if (p.isHasLeftBranch()) {
                    this.root = p.left;
                } else {
                    this.root = p.right;
                }
                return;
            }
            if (p.isHasLeftBranch()) {
                if (pre.value > p.value) {
                    pre.left = p.left;
                } else {
                    pre.right = p.left;
                }
            } else {
                if (pre.value > p.value) {
                    pre.left = p.right;
                } else {
                    pre.right = p.right;
                }
            }
        } else if (p.isHasTwoChild()) {
            Node leftOfRight = p.right, preRight = p.right, prePreRight = p.right;
            while (leftOfRight != null) {
                prePreRight = preRight;
                preRight = leftOfRight;
                leftOfRight = leftOfRight.left;
            }
            p.value = preRight.value;
            prePreRight.left = preRight.right;
            preRight = null;
        }
    }
}
