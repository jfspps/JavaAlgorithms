package com.algorithms.TreesAndGraphs.algorithms;

import com.algorithms.StacksAndQueues.algorithms.Queue;

public class SearchableTree<T> {

    private final T data;
    private boolean visited;

    private SearchableTree<T>[] children;

    public SearchableTree(T data) {
        this.visited = false;
        this.data = data;
    }

    public void setChildren(SearchableTree<T>[] children){
        this.children = children;
    }

    public SearchableTree<T>[] getChildren(){
        return this.children;
    }

    // can be reviewed as required
    public void printData(SearchableTree<T> node){
        System.out.println(node.data);
    }

    // traverses a tree following a depth-based approach (visit child nodes before peers)
    public void depthFirstSearch(SearchableTree<T> root){
        if (root == null){
            System.out.println("Given node is null");
            return;
        }

        // in considering recursion, the newly found node is printed before visiting it's child nodes (hence pre-order)
        printData(root);
        root.visited = true;

        if (root.children != null && root.children.length != 0){
            for (SearchableTree<T> tree : root.children){
                if (!tree.visited){
                    depthFirstSearch(tree);
                }
            }
        }
    }

    // build a queue of neighbouring nodes using rootsNeighbours and visit them once all are queued
    // unlike depthFirstSearch(), breadthFirstSearch() would need to be called again for its children
    public void breadthFirstSearch(SearchableTree<T> root, SearchableTree<T>[] rootsNeighbours){
        Queue neighbouringNodes = new Queue();
        root.visited = true;
        neighbouringNodes.enqueue(root);    // FIFO, root handled first

        while (!neighbouringNodes.isEmpty()){
            SearchableTree<T> currentNode = (SearchableTree<T>) neighbouringNodes.dequeue();
            printData(currentNode);

            // with root processed, add its neighbours
            // the while loop exits once all neighbours are processed
            // a single call to breadthFirstSearch() is O(n) time, where n = number of neighbours
            for (SearchableTree<T> node : rootsNeighbours){
                if (!node.visited){
                    node.visited = true;
                    neighbouringNodes.enqueue(node);
                }
            }
        }
    }
}