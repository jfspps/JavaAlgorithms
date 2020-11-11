package linkedList.algorithms;

public class PartitionAboutP {

    // partition a list
    // time complexity is O(2n) or just O(n)
    public Node<Integer> partition(Node<Integer> head, int p){
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List only contains one node");
            return head;
        }

        //get to the tail Node
        Node<Integer> tail = head;
        while (tail.next != null){
            tail = tail.next;
        }
        Node<Integer> k = tail;  //set the stopping point

        // establish the head node (the first node where data < p; this may require several iterations)
        while (head.data >= p){
            tail.next = head;
            head = head.next;
            tail.next.next = null;
            tail = tail.next;
        }
        Node<Integer> currentNode = head;

        // essentially a repeat of the above while loop but with currentNode instead of head
        while (currentNode.next != null && currentNode.next != k){
            if (currentNode.next.data >= p){
                // update links such that the node is linked to the tail
                tail.next = currentNode.next;
                currentNode.next = currentNode.next.next;
                tail.next.next = null;
                tail = tail.next;
            } else {
                currentNode = currentNode.next;
            }
        }

        System.out.println("List partitioned about " + p);
        head.printLeftPartition(head, k);
        head.printRightPartition(k);

        return head;
    }
}
