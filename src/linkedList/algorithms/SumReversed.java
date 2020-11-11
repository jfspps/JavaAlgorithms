package linkedList.algorithms;

public class SumReversed {

    // time complexity is a series of O(n/2) or just O(n)
    public Node<Integer> sumReversed(Node<Integer> head){
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List contains only one node");
            return head;
        }

        // set the two pointers and establish the linked list length
        // this part is O(n/2)
        Node<Integer> slower = head;
        Node<Integer> faster = head;
        int nodeCount = 1;
        while(faster.next != null && faster.next.next != null){
            faster = faster.next.next;
            slower = slower.next;
            nodeCount++;
        }
        System.out.println("Max. no. of digits per operand: " + nodeCount);

        // the list is of even length then advance slower one more place
        if (nodeCount%2 == 0){
            slower = slower.next;
        }

        head.printLeftPartition(head, slower);
        head.printRightPartition(slower);

        // place 'faster' back to the beginning ('slower' will be halfway along the list)
        faster = head;
        Node<Integer> halfway = slower;      // set a marker
        int multiplier = 1;
        int sum = 0;

        // process each digit until faster is halfway along the list
        // building the sum is O(n/2)
        while (faster != halfway){
            sum += (faster.data + slower.data) * multiplier;
            multiplier *= 10;
            faster = faster.next;
            slower = slower.next;
        }

        // for odd-sized 'head' lists, the left-hand operand, marked by 'faster' is one digit shorter than the right-hand operand
        if (slower != null){
            sum += slower.data * multiplier;
        }

        return printIntToList_reverse(sum);
    }

    // overall printing is O(n/2)
    public Node<Integer> printIntToList_reverse(int sum) {
        // print sum in a linked list in reverse
        int divisor = 10;
        Node<Integer> sumList = new Node<>(sum % divisor);
        sum /= 10;

        // add remaining digits
        while (sum > 0){
            sumList.appendData(sum % 10);
            sum /= 10;
        }
        return sumList;
    }
}
