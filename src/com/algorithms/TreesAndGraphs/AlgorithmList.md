# Java Algorithms: Trees and Graphs #

The basic implementation of a tree (which is really a type of graph) is given in [Tree](./algorithms/Tree.java). A binary tree is defined here, [BinaryTree](./algorithms/BinaryTree.java) together with methods: preOrder, postOrder, inOrder and levelOrder (left-to-right and right-to-left) traversals. Such traversals could be adopted to store BSTs in arrays (instead of printing out nodes).

A more generic graph, in which the child node count is undefined and each child node is stored in an array of Nodes is defined in [SearchableNode](./algorithms/SearchableTree.java).

A depth-first search is provided [here](./algorithms/SearchableTree.java#L49). A breadth-first search is also provided, shown [here](./algorithms/SearchableTree.java#L71).

Problems related algorithms:

+ Given a directed graph, show that there is a [route](./algorithms/SearchableTree.java#L98) between two nodes, using a bidirectional search.
+ Given a sorted array of integers (in ascending order of size), build a binary search tree of minimum height, [BST](./algorithms/BinarySearchTree.java)
+ Given a binary search tree, build (and print) a linked lists each of which store the node values at a given level, [ListBST](./algorithms/BinarySearchTree.java#L56)
+ Find the [maxDepth](./algorithms/BinaryTree.java#L72) and [minDepth](./algorithms/BinaryTree.java#L89) of a tree and ascertain if one is balanced or unbalanced, when maxDepth - minDepth > 1.
+ Check to see if a binary tree is a binary search tree (where the nodes of an in-order traversal are always increasing), [isABinarySearchTree](./algorithms/BinaryTree.java#L111)
+ Retrieve a BST based on value (return null if not), [getNode](./algorithms/BinarySearchTree.java#L82)
+ Retrieve the next in-order node, [getNextInOrder](./algorithms/BinarySearchTree.java#L97)
+ Deduce if a list of paired projects can be built, [isBuildable](./algorithms/BuildOrder.java#L21) and if so in what order, [topologicalSort](./algorithms/TopologicalSort.java)
+ Deduce the closest common ancestor of two nodes in a binary tree, [findCommonAncestor](./algorithms/FindAncestor.java)