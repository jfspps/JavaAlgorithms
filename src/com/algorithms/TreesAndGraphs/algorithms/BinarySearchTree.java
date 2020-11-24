package com.algorithms.TreesAndGraphs.algorithms;

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
}
