package com.algorithms.TreesAndGraphs.algorithms;

public class BinaryTree<T> {

    private final T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;

    public BinaryTree(T data) {
        this.data = data;
    }

    public void setLeftChild(BinaryTree<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTree<T> rightChild) {
        this.rightChild = rightChild;
    }

    public void inOrderTraversal(BinaryTree<T> tree){
        // reach the bottom of the tree and return the leftChild, then the node, then the right child
        if (tree != null){
            inOrderTraversal(tree.leftChild);
            printNode(tree);
            inOrderTraversal(tree.rightChild);
        }
    }

    public void setChildren(BinaryTree<T> lChild, BinaryTree<T> rChild){
        this.leftChild = lChild;
        this.rightChild = rChild;
    }

    public void preOrderTraversal(BinaryTree<T> tree){
        // process current node then visit the child nodes, left-to-right
        if (tree != null){
            printNode(tree);
            preOrderTraversal(tree.leftChild);
            preOrderTraversal(tree.rightChild);
        }
    }

    public void postOrderTraversal(BinaryTree<T> tree){
        // process the child nodes first, left-to-right and then process the given node
        if (tree != null){
            postOrderTraversal(tree.leftChild);
            postOrderTraversal(tree.rightChild);
            printNode(tree);
        }
    }

    public void printNode(BinaryTree<T> node){
        // do something with data (can be overridden if required)
        System.out.print(node.data + " ");
    }
}
