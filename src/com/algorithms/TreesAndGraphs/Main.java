package com.algorithms.TreesAndGraphs;

import com.algorithms.TreesAndGraphs.algorithms.BinaryTree;
import com.algorithms.TreesAndGraphs.algorithms.SearchableTree;

public class Main {

    public static void main(String[] args){
//        binaryTree();

        demonstrateDepthFirstSearch();
    }

    private static void demonstrateDepthFirstSearch() {
        SearchableTree<Character> root = buildSearchableTree();

        root.depthFirstSearch(root);
    }


    private static SearchableTree<Character> buildSearchableTree() {
        SearchableTree<Character> characterSearchableTreeRoot = new SearchableTree<>('R');

        SearchableTree<Character> characterSearchableTree1 = new SearchableTree<>('A');
        SearchableTree<Character> characterSearchableTree2 = new SearchableTree<>('B');
        SearchableTree<Character>[] searchableTrees = new SearchableTree[2];
        searchableTrees[0] = characterSearchableTree1;
        searchableTrees[1] = characterSearchableTree2;
        characterSearchableTreeRoot.setChildren(searchableTrees);

        SearchableTree<Character> characterSearchableTree3 = new SearchableTree<>('a');
        SearchableTree<Character> characterSearchableTree4 = new SearchableTree<>('b');
        SearchableTree<Character>[] searchableTreesA = new SearchableTree[2];
        searchableTreesA[0] = characterSearchableTree3;
        searchableTreesA[1] = characterSearchableTree4;
        characterSearchableTree1.setChildren(searchableTreesA);

        SearchableTree<Character> characterSearchableTree5 = new SearchableTree<>('c');
        SearchableTree<Character> characterSearchableTree6 = new SearchableTree<>('d');
        SearchableTree<Character>[] searchableTreesB = new SearchableTree[2];
        searchableTreesB[0] = characterSearchableTree5;
        searchableTreesB[1] = characterSearchableTree6;
        characterSearchableTree2.setChildren(searchableTreesB);

        return characterSearchableTreeRoot;
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
