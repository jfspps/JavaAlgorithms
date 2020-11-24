# Java Algorithms: Trees and Graphs #

The basic implementation of a tree (which is really a type of graph) is given in [Tree](./algorithms/Tree.java). A binary tree is defined here, [BinaryTree](./algorithms/BinaryTree.java)

A more generic graph, in which the child node count is undefined and each child node is stored in an array of Nodes is defined in [SearchableNode](./algorithms/SearchableTree.java).

A depth-first search is provided [here](./algorithms/SearchableTree.java#L49). A breadth-first search is also provided, shown [here](./algorithms/SearchableTree.java#L71).

Problems related algorithms:

+ Given a directed graph, show that there is a [route](./algorithms/SearchableTree.java#L98) between two nodes, using a bidirectional search.
+ Given a sorted array of integers (in ascending order of size), build a binary search tree of minimum height, [BST](./algorithms/BinarySearchTree.java)