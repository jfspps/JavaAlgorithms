package com.algorithms.TreesAndGraphs.algorithms;

import com.algorithms.StacksAndQueues.algorithms.Queue;

public class SearchableTree<T> {

    private final T data;
    private boolean visited;

    private SearchableTree<T>[] children;
    private SearchableTree<T>[] siblings;

    public SearchableTree(T data) {
        this.visited = false;
        this.data = data;
    }

    public void setChildren(SearchableTree<T>[] children){
        this.children = children;
    }

    public void setSiblings(SearchableTree<T>[] siblings){
        this.siblings = siblings;
    }

    public SearchableTree<T>[] getSiblings(){
        return  this.siblings;
    }

    public SearchableTree<T>[] getChildren(){
        return this.children;
    }

    // can be reviewed as required
    public void printData(SearchableTree<T> node){
        System.out.println(node.data);
    }

    // traverses a tree following a depth-based approach (visit child nodes before peers)
    // like BFS, DFS is O(n)
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
    // like DFS, BFS is O(n)
    public void breadthFirstSearch(SearchableTree<T> root, SearchableTree<T>[] rootsNeighbours){
        Queue neighbouringNodes = new Queue();
        root.visited = true;
        neighbouringNodes.enqueue(root);    // FIFO, root handled first

        while (!neighbouringNodes.isEmpty()){
            // initially, this returns root and then adds its siblings to the queue
            // the for loop should not repeat itself for each sibling since the flag node.visited is true
            SearchableTree<T> currentNode = (SearchableTree<T>) neighbouringNodes.dequeue();
            printData(currentNode);

            for (SearchableTree<T> node : rootsNeighbours){
                if (!node.visited){
                    node.visited = true;
                    neighbouringNodes.enqueue(node);
                }
            }
        }
    }
}