package linkedList.algorithms;

public class FindKthToLast<T> {

    // find the Kth to last element of a singly linked list
    // time complexity is O(n^2)
    public Node<T> findKthToLast(Node<T> head, int k){
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        //traverse to the end of the list
        int length = head.getListLength(head);

        if (k > length){
            System.out.println("Kth parameter is larger than the list length");
            return null;
        }

        int nodeIndex = 0;
        Node<T> currentNode = head;
        // k decreases from length to 1 as list traversed from head node
        // start from the beginning, increment nodeIndex = 0 until (length - nodeIndex = k)
        while (length - nodeIndex > k && currentNode.next != null){
            currentNode = currentNode.next;
            nodeIndex++;
        }

        return currentNode;
    }
}
