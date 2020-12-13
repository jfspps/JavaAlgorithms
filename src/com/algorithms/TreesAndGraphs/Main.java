package com.algorithms.TreesAndGraphs;

import com.algorithms.TreesAndGraphs.algorithms.*;

import java.util.*;

public class Main {

    public static void main(String[] args){
//        binaryTree();

//        demonstrateDepthFirstSearch();

//        demonstrateBreadthFirstSearch();

//        findARoute_BFS();

//        balancedBinarySearchTree();

//        buildLinkedListOfLevels();
//        binarySearchTreeToListOfList();

//        unbalancedBinaryTree();

//        isABinarySearchTree();
//        getNodeWithData();
        
//        isBuildable();
        getBuildOrder();
    }

    private static void getBuildOrder() {
        String[][] dependencies = {{"a", "d"}, {"e", "b"}, {"b", "d"}, {"e", "a"}, {"d", "c"}};
        TopologicalSort sorted = new TopologicalSort();

        TopologicalSort.Node[] nodes = sorted.findBuildOrder(dependencies);

        for (TopologicalSort.Node nodeKey : nodes){
            System.out.print(nodeKey.getName() + " ");
        }
        System.out.println();

        System.out.println("Another node list....");
        String[][] dependencies2 = {{"a", "b"}, {"b", "c"}, {"c", "d"}, {"d", "e"}, {"e", "f"}};
        TopologicalSort.Node[] nodes2 = sorted.findBuildOrder(dependencies2);

        for (TopologicalSort.Node nodeKey : nodes2){
            System.out.print(nodeKey.getName() + " ");
        }
        System.out.println();
    }

    private static void isBuildable() {
        Set<Character> allProjects = buildListOfAllProjects();
        BuildOrder buildOrder = new BuildOrder(buildProjectList(), allProjects);
        buildOrder.isBuildable();
    }

    private static Set<Character> buildListOfAllProjects() {
        Character[] characters = {'a', 'b', 'c', 'd', 'e', 'f'};
        return new HashSet<>(Arrays.asList(characters));
    }

    private static List<List<Character>> buildProjectList(){
        List<List<Character>> lists = new ArrayList<>();
        Character[] project1 = {'a', 'd'};
        Character[] project2 = {'f', 'b'};
        Character[] project3 = {'b', 'd'};
        Character[] project4 = {'f', 'a'};
        Character[] project5 = {'d', 'c'};

        lists.add(List.of(project1));
        lists.add(List.of(project2));
        lists.add(List.of(project3));
        lists.add(List.of(project4));
        lists.add(List.of(project5));

        return lists;
    }

    private static void getNodeWithData() {
        Integer[] orderedArrayEven = new Integer[8];
        for (int i = 0; i < orderedArrayEven.length; i++){
            orderedArrayEven[i] = i;
        }

        BinarySearchTree tree = new BinarySearchTree(orderedArrayEven[orderedArrayEven.length/2]);
        BinarySearchTree BST = tree.buildBinarySearchTree(orderedArrayEven);

        BinarySearchTree found = BST.getNode(BST, 4);

        getNodeAndPrintNext(found);

        found = BST.getNode(BST, 1);

        getNodeAndPrintNext(found);

        found = BST.getNode(BST, 3);

        getNodeAndPrintNext(found);

        found = BST.getNode(BST, 7);

        getNodeAndPrintNext(found);
    }

    private static void getNodeAndPrintNext(BinarySearchTree found) {
        if (found != null) {
            System.out.println("Found node: " + found.getData());
            if (found.getNextInOrder(found) != null) {
                System.out.println("Next in-order node is: " + found.getNextInOrder(found).getData());
            } else
                System.out.println("No next in-order node present");
        } else
            System.out.println("Could not find node with given value");
    }

    private static void isABinarySearchTree() {
        BinaryTree<Integer> isBST = manualBST();
        BinaryTree<Integer> isNotBST = manual_nonBST();

        System.out.println("Should be true: " + isBST.isABinarySearchTree(isBST, new LinkedList<>()));
        System.out.println("Should be false: " + isNotBST.isABinarySearchTree(isNotBST, new LinkedList<>()));
    }

    private static void binarySearchTreeToListOfList() {
        Integer[] orderedArrayEven = new Integer[8];
        for (int i = 0; i < orderedArrayEven.length; i++){
            orderedArrayEven[i] = i;
        }

        BinarySearchTree tree = new BinarySearchTree(orderedArrayEven[orderedArrayEven.length/2]);
        BinarySearchTree BST = tree.buildBinarySearchTree(orderedArrayEven);

        ArrayList<LinkedList<BinaryTree<Integer>>> levelList = new ArrayList<>();
        levelList = BST.createLevelLinkedList(BST, levelList, 0);
        int level = 0;

        for (LinkedList<BinaryTree<Integer>> list : levelList){
            System.out.print("Level " + level++ + ": ");
            for (BinaryTree<Integer> binaryTree : list){
                System.out.print(binaryTree.getData() + " ");
            }
            System.out.println();
        }
    }

    private static void buildLinkedListOfLevels() {
        ListOfData<Integer> listOfData = new ListOfData<>(10);
        LinkedListOfLevels<Integer> linkedListOfLevels = new LinkedListOfLevels<>(listOfData, "test");

        System.out.println(linkedListOfLevels.getLabel());
        linkedListOfLevels.getHeadDataNode().printDataList();

        linkedListOfLevels.getHeadDataNode().appendDataList(20);
        linkedListOfLevels.getHeadDataNode().appendDataList(40);
        linkedListOfLevels.getHeadDataNode().printDataList();

        System.out.println("Next level...");
        ListOfData<Integer> listOfData2 = new ListOfData<>(88);
        listOfData2.appendDataList(99);
        linkedListOfLevels.appendNewLevelList(listOfData2);
        LinkedListOfLevels<Integer> nextLevelList = linkedListOfLevels.getNextLevelList();
        nextLevelList.getHeadDataNode().printDataList();
    }

    private static void balancedBinarySearchTree() {
        Integer[] orderedArrayEven = new Integer[8];
        for (int i = 0; i < orderedArrayEven.length; i++){
            orderedArrayEven[i] = i;
        }

        BinarySearchTree tree = new BinarySearchTree(orderedArrayEven[orderedArrayEven.length/2]);
        System.out.println("Even number of elements. Root node:");
        tree.inOrderTraversal(tree);
        System.out.println();
        BinarySearchTree BST = tree.buildBinarySearchTree(orderedArrayEven);
        System.out.println("Preorder traversal:");
        BST.preOrderTraversal(BST);
        System.out.println();
        System.out.println("Inorder traversal:");
        BST.inOrderTraversal(BST);
        System.out.println();
        System.out.println("Postorder traversal:");
        BST.postOrderTraversal(BST);
        System.out.println();

        System.out.println("=====================================");
        Integer[] orderedArrayOdd = new Integer[9];
        for (int i = 0; i < orderedArrayOdd.length; i++){
            orderedArrayOdd[i] = i;
        }

        BinarySearchTree treeOdd = new BinarySearchTree(orderedArrayOdd[orderedArrayOdd.length/2]);
        System.out.println("Odd number of elements. Root node:");
        treeOdd.inOrderTraversal(treeOdd);
        System.out.println();
        BinarySearchTree BSTOdd = treeOdd.buildBinarySearchTree(orderedArrayOdd);
        System.out.println("Preorder traversal:");
        BSTOdd.preOrderTraversal(BSTOdd);
        System.out.println();
        System.out.println("Inorder traversal:");
        BSTOdd.inOrderTraversal(BSTOdd);
        System.out.println();
        System.out.println("Postorder traversal:");
        BSTOdd.postOrderTraversal(BSTOdd);
    }

    private static void findARoute_BFS() {
        // use breadthFirstSearch to find out if there is a route between two nodes
        // by checking the visited property
        SearchableTree<Character>[] graph = buildConnectedGraph();
        System.out.println("Graph from node M: ");
        printBFS(graph[3]);
        for (SearchableTree<Character> node : graph){
            node.setVisited(false);
        }

        System.out.println("Cyclic graph from node R: ");
        printBFS(graph[0]);
        for (SearchableTree<Character> node : graph){
            node.setVisited(false);
        }

        System.out.println("Finding out if there is a path...");
        SearchableTree<Character> firstNode = graph[0];
        SearchableTree<Character> secondNode = graph[3];

        lookForPath(firstNode, secondNode);
    }

    private static void lookForPath(SearchableTree<Character> currentNode1, SearchableTree<Character> currentNode2) {
        while (!currentNode1.hasBeenVisitedByOthers(currentNode1, currentNode1.getSiblings())
                && !currentNode2.hasBeenVisitedByOthers(currentNode2, currentNode2.getSiblings())){
            // advance each node pointer if there are more children
            // stop advancing when either (i) reached the end of a acyclic graph or (ii) circled a cyclic graph

            if (currentNode1.getChildren() != null){
                currentNode1 = currentNode1.getChildren()[0];
            }

            if (currentNode2.getChildren() != null){
                currentNode2 = currentNode2.getChildren()[0];
            }
        }
    }

    private static void demonstrateBreadthFirstSearch() {
        SearchableTree<Character> root = buildSearchableTree();

        printBFS(root);
    }

    private static void printBFS(SearchableTree<Character> root) {
        root.breadthFirstSearch(root, root.getSiblings());
        SearchableTree<Character> currentNode = root;
        while (currentNode != null){
            if (currentNode.getChildren() != null && !currentNode.getChildren()[0].hasBeenVisited()){
                root.breadthFirstSearch(currentNode.getChildren()[0], currentNode.getChildren()[0].getSiblings());
                currentNode = currentNode.getChildren()[0];
            } else
                break;
        }
    }

    private static void demonstrateDepthFirstSearch() {
        SearchableTree<Character> root = buildSearchableTree();

        root.depthFirstSearch(root);
    }

    private static SearchableTree<Character>[] buildConnectedGraph() {
        // no siblings required; cyclic R, S and T
        SearchableTree<Character> characterRoot = new SearchableTree<>('R');
        SearchableTree<Character>[] R_children = new SearchableTree[1];

        SearchableTree<Character> characterS = new SearchableTree<>('S');
        SearchableTree<Character>[] S_children = new SearchableTree[1];
        R_children[0] = characterS;
        characterRoot.setChildren(R_children);

        SearchableTree<Character> characterT = new SearchableTree<>('T');
        SearchableTree<Character>[] T_children = new SearchableTree[1];
        S_children[0] = characterT;
        characterS.setChildren(S_children);

        T_children[0] = characterRoot;
        characterT.setChildren(T_children);

        // linear graph, joined to 'S', above
        SearchableTree<Character> characterM = new SearchableTree<>('M');
        SearchableTree<Character>[] M_children = new SearchableTree[1];

        SearchableTree<Character> characterN = new SearchableTree<>('N');
        SearchableTree<Character>[] N_children = new SearchableTree[1];
        M_children[0] = characterN;
        characterM.setChildren(M_children);

        N_children[0] = characterS;
        characterN.setChildren(N_children);

        SearchableTree<Character>[] allNodes = new SearchableTree[5];
        allNodes[0] = characterRoot;
        allNodes[1] = characterS;
        allNodes[2] = characterT;
        allNodes[3] = characterM;
        allNodes[4] = characterN;

        return allNodes;
    }

    private static SearchableTree<Character> buildSearchableTree() {
        SearchableTree<Character> characterSearchableTreeRoot = new SearchableTree<>('R');
        SearchableTree<Character>[] levelOne = new SearchableTree[1];
        setSibling(characterSearchableTreeRoot, levelOne, 0);

        SearchableTree<Character> characterSearchableTree1 = new SearchableTree<>('A');
        SearchableTree<Character> characterSearchableTree2 = new SearchableTree<>('B');
        SearchableTree<Character>[] searchableTrees = new SearchableTree[2];
        searchableTrees[0] = characterSearchableTree1;
        searchableTrees[1] = characterSearchableTree2;
        characterSearchableTreeRoot.setChildren(searchableTrees);
        SearchableTree<Character>[] levelTwo = new SearchableTree[2];
        setSibling(characterSearchableTree1, levelTwo, 0);
        setSibling(characterSearchableTree2, levelTwo, 1);

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

        SearchableTree<Character>[] levelThree = new SearchableTree[4];
        setSibling(characterSearchableTree3, levelThree, 0);
        setSibling(characterSearchableTree4, levelThree, 1);
        setSibling(characterSearchableTree5, levelThree, 2);
        setSibling(characterSearchableTree6, levelThree, 3);

        return characterSearchableTreeRoot;
    }

    private static void setSibling(SearchableTree<Character> node, SearchableTree<Character>[] level, int index) {
        level[index] = node;
        node.setSiblings(level);
    }

    private static void unbalancedBinaryTree() {
        BinaryTree<Character> rootNode = new BinaryTree<>('A');
        BinaryTree<Character> childx = new BinaryTree<>('x');
        rootNode.setChildren(childx, null);

        BinaryTree<Character> child1 = new BinaryTree<>('1');
        BinaryTree<Character> child2 = new BinaryTree<>('2');
        childx.setChildren(child1, child2);

        int maxDepth = rootNode.getMaxDepth(rootNode);
        int minDepth = rootNode.getShortestDepth(rootNode);

        System.out.println("Max depth: " + maxDepth);
        System.out.println("Min depth: " + minDepth);

        System.out.println("In-order traversal:");
        rootNode.inOrderTraversal(rootNode);
        System.out.println();

        System.out.println("Pre-order traversal:");
        rootNode.preOrderTraversal(rootNode);
        System.out.println();

        System.out.println("Post-order traversal:");
        rootNode.postOrderTraversal(rootNode);
        System.out.println();

        if (maxDepth - minDepth > 1){
            System.out.println("Tree is unbalanced");
        } else
            System.out.println("Tree is balanced");
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

        System.out.println("Max depth: " + rootNode.getMaxDepth(rootNode));
        System.out.println("Min depth: " + rootNode.getShortestDepth(rootNode));

        System.out.println("In-order traversal:");
        rootNode.inOrderTraversal(rootNode);
        System.out.println();

        System.out.println("Pre-order traversal:");
        rootNode.preOrderTraversal(rootNode);
        System.out.println();

        System.out.println("Post-order traversal:");
        rootNode.postOrderTraversal(rootNode);
    }

    private static BinaryTree<Integer> manualBST() {
        BinaryTree<Integer> rootNode = new BinaryTree<>(4);
        BinaryTree<Integer> childx = new BinaryTree<>(2);
        BinaryTree<Integer> childy = new BinaryTree<>(6);
        rootNode.setChildren(childx, childy);

        BinaryTree<Integer> child1 = new BinaryTree<>(1);
        BinaryTree<Integer> child2 = new BinaryTree<>(3);
        childx.setChildren(child1, child2);

        BinaryTree<Integer> child3 = new BinaryTree<>(5);
        BinaryTree<Integer> child4 = new BinaryTree<>(7);
        childy.setChildren(child3, child4);

        System.out.println("In-order traversal:");
        rootNode.inOrderTraversal(rootNode);
        System.out.println();
        return rootNode;
    }

    private static BinaryTree<Integer> manual_nonBST() {
        BinaryTree<Integer> rootNode = new BinaryTree<>(4);
        BinaryTree<Integer> childx = new BinaryTree<>(2);
        BinaryTree<Integer> childy = new BinaryTree<>(6);
        rootNode.setChildren(childx, childy);

        BinaryTree<Integer> child1 = new BinaryTree<>(1);
        BinaryTree<Integer> child2 = new BinaryTree<>(3);
        childx.setChildren(child1, child2);

        BinaryTree<Integer> child3 = new BinaryTree<>(4);
        BinaryTree<Integer> child4 = new BinaryTree<>(5);
        childy.setChildren(child3, child4);

        System.out.println("In-order traversal:");
        rootNode.inOrderTraversal(rootNode);
        System.out.println();
        return rootNode;
    }
}
