package com.algorithms.LinkedList.algorithms;

public class Node<T> {
    Node<T> next = null;   //reference to the next Node
    Node<T> next_spare = null;  // allow for intersecting Nodes (assign to all Nodes of the same list)
    T data;

    public Node(T data) {
        this.data = data;
    }

    // for list of n nodes, this will require 1 + 2 + ... + n calls to append, i.e. O(n^2)
    public void appendData(T data){
        Node<T> newEnd = new Node<>(data);   // new Node referenced by newEnd
        Node<T> thisNode = this;           // grab this Node

        // traverse list and append to the tail
        while (thisNode.next != null){
            thisNode = thisNode.next;
        }
        thisNode.next = newEnd;
    }

    public void appendData_spare(T data){
        Node<T> newEnd = new Node<>(data);   // new Node referenced by newEnd
        Node<T> thisNode = this;           // grab this Node

        // traverse list and append to the tail
        while (thisNode.next_spare != null){
            thisNode = thisNode.next_spare;
        }
        thisNode.next_spare = newEnd;
    }

    public void appendNode(Node<T> next){
        if (next == null){
            System.out.println("Cannot append null node");
            return;
        }
        Node<T> thisNode = this;           // grab this Node

        // traverse list and append to the tail
        while (thisNode.next != null){
            thisNode = thisNode.next;
        }
        thisNode.next = next;
    }

    public void appendNode_spare(Node<T> next){
        if (next == null){
            System.out.println("Cannot append null node");
            return;
        }
        Node<T> thisNode = this;           // grab this Node

        // traverse list and append to the tail
        while (thisNode.next_spare != null){
            thisNode = thisNode.next_spare;
        }
        thisNode.next_spare = next;
    }

    public void linkToTail(Node<T> head, Node<T> node){
        // go to the end and set next property
        while (head.next != null){
            head = head.next;
        }
        head.next = node;
    }

    // in Java, this simply breaks the link between node to be deleted and the next one (singly linked list)
    // time complexity is O(n)
    public Node<T> delete(Node<T> head, int T){
        System.out.println("Attempting to delete " + data + " ---------------------------");
        // check linked list isn't already null
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        Node<T> currentNode = head;

        // if head holds requisite data, return head.next
        if (currentNode.data == data){
            Node<T> newHead = head.next;
            System.out.println("Head moved down list one place");
            return newHead;
        }

        // still at head; traverse Node until data found
        while (currentNode.next != null){
            if (currentNode.next.data == data){
                // at required currentNode; break link to next Node and instead assign it to the next one along
                // garbage collection will remove currentNode at some point
                currentNode.next = currentNode.next.next;
                return head;
            }
            currentNode = currentNode.next;
        }

        return head;
    }

    // time complexity is O(n)
    public void printLinkedList(){
        System.out.println("--------Head node: " + this.data);

        if (this.next == null){
            return;
        }

        int count = 1;
        Node<T> currentNode = this.next;
        while (currentNode.next != null){
            System.out.println("Node " + count++ + " with value: " + currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println("---------Tail node: " + currentNode.data);
    }

    public void printLinkedList_spare(){
        System.out.println("--------Head node: " + this.data);

        if (this.next_spare == null){
            return;
        }

        int count = 1;
        Node<T> currentNode = this.next_spare;
        while (currentNode.next_spare != null){
            System.out.println("Node " + count++ + " with value: " + currentNode.data);
            currentNode = currentNode.next_spare;
        }
        System.out.println("---------Tail node: " + currentNode.data);
    }

    // time complexity is constant, O(1)
    public String printNodeData(Node<T> node){
        return String.valueOf(node.data);
    }

    // given a reference to a Node, delete it if it exists
    // time complexity is O(n)
    public void deleteGivenNode(Node<T> head, Node<T> node){
        if (head == node){
            System.out.println("Cannot delete head of list");
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null){
            if (currentNode.next == node){
                currentNode.next = currentNode.next.next;
                System.out.println("Node with value " + node.data + " deleted");
                return;
            } else {
                currentNode = currentNode.next;
            }

            //check if at tail
            if (currentNode.next == null){
                System.out.println("At end of list, node not found");
                return;
            }
        }
    }

    public void printRightPartition(Node<T> k) {
        System.out.print("Right-hand partition is: ");
        while (k.next !=null){
            System.out.print(k.data + " ");
            k = k.next;
        }
        System.out.println(k.data);
    }

    public void printLeftPartition(Node<T> node, Node<T> k){
        System.out.print("Left-hand partition is: ");
        while (node.next != null && node.next != k){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    public int getListLength(Node<T> node){
        if (node == null){
            return 0;
        }

        if (node.next == null){
            return 1;
        }

        int count = 1;
        while (node.next != null){
            count++;
            node = node.next;
        }

        return count;
    }
}
