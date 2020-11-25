package com.algorithms.TreesAndGraphs.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTree extends BinaryTree<Integer> {

    public BinarySearchTree(Integer data) {
        super(data);
    }

    // in a binary search method, the central element will reside at the root
    // with all left-hand elements on the left branch and all right-hand elements on the right branch

    public BinarySearchTree buildBinarySearchTree(Integer[] sortedArray) {
        if (sortedArray.length == 1){
            return new BinarySearchTree(sortedArray[0]);
        }

        if (sortedArray.length > 1) {
            int length = sortedArray.length;
            BinarySearchTree parent = new BinarySearchTree(sortedArray[length / 2]);

            Integer[] left = new Integer[length / 2];
            for (int i = 0; i < length / 2; i++) {
                left[i] = sortedArray[i];
            }

            Integer[] right;
            if (length % 2 == 0) {
                // right-hand will be one element smaller than the left
                right = new Integer[(length / 2) - 1];
                for (int j = 0; j < (length / 2) - 1; j++) {
                    right[j] = sortedArray[j + (length / 2) + 1];
                }
            } else {
                // left- and right-hand arrays would be of equal length
                right = new Integer[(length / 2)];
                for (int j = 0; j < (length / 2); j++) {
                    right[j] = sortedArray[j + (length / 2) + 1];
                }
            }

            parent.setChildren(buildBinarySearchTree(left), buildBinarySearchTree(right));
            return parent;
        } else
            return null;
    }

    // problem is to build a linked list of each level
    // solution presented here taken from book (there was difficulty with traversing the graph** while keeping track of most recent node)
    // prior assumption was not knowing the depth of the graph

    // level is zero-based to coincide with ArrayList and signifies which level is being processed
    // time complexity is O(n), where n = number of nodes + null nodes
    public ArrayList<LinkedList<BinaryTree<Integer>>> createLevelLinkedList(
            BinaryTree<Integer> node, ArrayList<LinkedList<BinaryTree<Integer>>> levelList, int level){
        if (node == null){
            return null;
        }

        LinkedList<BinaryTree<Integer>> dataList;
        // **initially, size() is 0 and level is 0 meaning this level has not been visited before;
        // it soon changes: size() of 1 and level 0
        if (levelList.size() == level){
            dataList = new LinkedList<>();
            levelList.add(dataList);
        } else {
            dataList = levelList.get(level);
        }

        dataList.add(node);
        createLevelLinkedList(node.getLeftChild(), levelList, level + 1);
        createLevelLinkedList(node.getRightChild(), levelList, level + 1);
        return levelList;
    }
}
