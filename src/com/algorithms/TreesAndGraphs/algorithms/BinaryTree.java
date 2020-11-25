package com.algorithms.TreesAndGraphs.algorithms;

public class BinaryTree<T> {

    private final T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;
    private boolean visited;

    public BinaryTree(T data) {
        this.data = data;
        this.visited = false;
    }

    public void setLeftChild(BinaryTree<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(BinaryTree<T> rightChild) {
        this.rightChild = rightChild;
    }

    public void inOrderTraversal(BinaryTree<T> tree) {
        // reach the bottom of the tree and return the leftChild, then the node, then the right child
        if (tree != null) {
            inOrderTraversal(tree.leftChild);
            printNode(tree);
            inOrderTraversal(tree.rightChild);
        }
    }

    public void setChildren(BinaryTree<T> lChild, BinaryTree<T> rChild) {
        this.leftChild = lChild;
        this.rightChild = rChild;
    }

    public void preOrderTraversal(BinaryTree<T> tree) {
        // process current node then visit the child nodes, left-to-right
        if (tree != null) {
            printNode(tree);
            preOrderTraversal(tree.leftChild);
            preOrderTraversal(tree.rightChild);
        }
    }

    public void postOrderTraversal(BinaryTree<T> tree) {
        // process the child nodes first, left-to-right and then process the given node
        if (tree != null) {
            postOrderTraversal(tree.leftChild);
            postOrderTraversal(tree.rightChild);
            printNode(tree);
        }
    }

    public void printNode(BinaryTree<T> node) {
        // do something with data (can be overridden if required)
        System.out.print(node.data + " ");
    }

    public T getData() {
        return this.data;
    }

    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }

    public BinaryTree<T> getRightChild() {
        return rightChild;
    }

    public int getMaxDepth(BinaryTree<T> tree) {
        int leftBranch = 0;
        int rightBranch = 0;

        if (tree != null){
            leftBranch = getMaxDepth(tree.leftChild);
            rightBranch = getMaxDepth(tree.rightChild);

            if (leftBranch > rightBranch){
                return leftBranch + 1;
            } else {
                return rightBranch + 1;
            }
        }
        return 0;
    }
}
