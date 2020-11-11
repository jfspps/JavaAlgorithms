package linkedList.algorithms;

public class FindDuplicates<T> {

    // with tally buffer (assume only positive int's are applied)
    // time complexity is O(n)
    public void findDuplicates(Node<Integer> head){
        int[] tally = new int[1000];

        Node<Integer> currentNode = head;
        tally[head.data]++;
        int count = 0;

        while(currentNode.next != null){
            if (tally[currentNode.next.data] == 0){
                tally[currentNode.next.data]++;
                currentNode = currentNode.next;
            } else {
                //delete currentNode and move on
                currentNode.next = currentNode.next.next;
                count++;
            }
        }

        System.out.println(count + " duplicates removed");
    }

    // without tally buffer; using two pointers
    // time complexity is O(n^2)
    public void findDuplicates_noBuffer(Node<Integer> head){
        Node<Integer> currentNode = head;
        Node<Integer> leadPointer = currentNode;
        int count = 0;

        while (currentNode.next != null){
            while (leadPointer.next != null) {
                if (!leadPointer.next.data.equals(currentNode.data)){
                    leadPointer = leadPointer.next;
                } else {
                    leadPointer.next = leadPointer.next.next;
                    count++;
                }
            }
            currentNode = currentNode.next;
            leadPointer = currentNode;
        }

        System.out.println(count + " duplicates removed");
    }
}
