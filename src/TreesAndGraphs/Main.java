package TreesAndGraphs;

import TreesAndGraphs.algorithms.BinaryTree;

public class Main {

    public static void main(String[] args){
        binaryTree();
    }

    private static void binaryTree() {
        BinaryTree<Character> rootNode = new BinaryTree<>('A');
        BinaryTree<Character> childx = new BinaryTree<>('x');
        BinaryTree<Character> childy = new BinaryTree<>('y');
        rootNode.setChildren(childx, childy);

        BinaryTree<Character> child1 = new BinaryTree<>('1');
        BinaryTree<Character> child2 = new BinaryTree<>('2');
        childx.setChildren(child1, child2);

        BinaryTree<Character> child3 = new BinaryTree<>('3');
        BinaryTree<Character> child4 = new BinaryTree<>('4');
        childy.setChildren(child3, child4);

        System.out.println("In-order traversal:");
        rootNode.inOrderTraversal(rootNode);
        System.out.println();

        System.out.println("Pre-order traversal:");
        rootNode.preOrderTraversal(rootNode);
        System.out.println();

        System.out.println("Post-order traversal:");
        rootNode.postOrderTraversal(rootNode);
    }
}
