package com.algorithms.TreesAndGraphs.algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class FindAncestor {

    public class Node {
        private Node parent;

        private String name;

        public Node(String name) {
            this.name = name;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class Graph {
        private ArrayList<Node> nodes = new ArrayList<>();
        private HashMap<String, Node> map = new HashMap<>();

        public FindAncestor.Node buildOrGetNode(String name){
            if (!map.containsKey(name)){
                FindAncestor.Node node = new FindAncestor.Node(name);
                nodes.add(node);
                map.put(name, node);
            }

            return map.get(name);
        }
    }

    // this is horrendously O(n^2)
    public Node findAncestor(Node node1, Node node2){
        if (node1.getParent() == null || node2.getParent() == null){
            System.out.println("Both nodes must have a parent");
            return null;
        }

        Node temp1 = node1;
        Node temp2 = node2;

        while (temp1.getParent() != null){
            while (temp2.getParent() != null){
                if (temp1.getParent() == temp2.getParent()){
                    System.out.println("Found a common ancestor: " + temp1.getParent().getName());
                    return temp1.getParent();
                }

                // advance temp2 parent up one place and recompare
                temp2 = temp2.getParent();
            }

            temp2 = node2;
            temp1 = temp1.getParent();
        }

        // could not find common ancestor
        System.out.println("Could not find a common ancestor");
        return null;
    }

    // returns a pair of Nodes at the same level
    // this is O(n + m + n - m) or O(n + m + m - n), or just O(n)
    Node[] levelStartingPoint(Node node1, Node node2){
        if (node1.getParent() == null || node2.getParent() == null){
            System.out.println("Both nodes must have a parent");
            return null;
        }

        // neither node level 0 not root nodes
        int node1Level = 1;
        int node2Level = 1;

        Node temp1 = node1;
        Node temp2 = node2;

        //count the level for node1; O(n)
        while (temp1.getParent() != null){
            node1Level++;
            temp1 = temp1.getParent();
        }

        //count the level for node2; O(m)
        while (temp2.getParent() != null){
            node2Level++;
            temp2 = temp2.getParent();
        }

        // potentially O(n - m)
        while (node1Level > node2Level){
            // node1 too far down so advance starting point up
            node1 = node1.getParent();
            node1Level--;
        }

        // potentially O(m - n)
        while (node2Level > node1Level){
            // node2 too far down so advance starting point up
            node2 = node2.getParent();
            node2Level--;
        }

        return new Node[]{node1, node2};
    }

    // after establising a level 'playing-field' we compare parents and move up the tree with both nodes at the same time
    // this is now O(n), n = level number
    public Node findAncestorLevelled(Node node1, Node node2){
        if (node1.getParent() == null || node2.getParent() == null){
            System.out.println("Both nodes must have a parent");
            return null;
        }

        Node[] nodes = levelStartingPoint(node1, node2);

        while (node1 != node2 && node1.getParent() != null){
            node1 = node1.getParent();
            node2 = node2.getParent();

            if (node1 == node2){
                System.out.println("Found common ancestor: " + node1.getName());
                return node1;
            }
        }

        System.out.println("Could not find common ancestor");
        return null;
    }
}