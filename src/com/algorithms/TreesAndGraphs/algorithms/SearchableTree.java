package com.algorithms.TreesAndGraphs.algorithms;

public class SearchableTree<T> {

    private final T data;
    private boolean visited;
    private SearchableTree<T>[] searchableTrees;

    public SearchableTree(T data) {
        this.visited = false;
        this.data = data;
    }


}