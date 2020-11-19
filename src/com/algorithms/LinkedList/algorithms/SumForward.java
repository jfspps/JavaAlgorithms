package com.algorithms.LinkedList.algorithms;

public class SumForward {

    // time complexity is a series of O(n/2) or just O(n)
    public Node<Integer> sumForward(Node<Integer> head){
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

        //set multiplier based on count
        while (nodeCount > 1){
            multiplier *= 10;
            nodeCount--;
        }
        int sum = 0;
        int divisor = multiplier;

        // for odd-sized 'head' lists, the left-hand operand, marked by 'faster' is one digit shorter than the right-hand operand
        // so process right-hand once
        if (head.getListLength(head)%2 != 0){
            sum = slower.data * multiplier;
            multiplier /= 10;
            slower = slower.next;
        }

        // process each digit until faster is halfway along the list
        // building the sum is O(n/2)
        while (faster != halfway){
            sum += (faster.data + slower.data) * multiplier;
            multiplier /= 10;
            faster = faster.next;
            slower = slower.next;
        }

        return printIntToList_forward(sum, divisor);
    }

    // print sum in a linked list in forward direction
    // overall printing is O(n/2)
    private Node<Integer> printIntToList_forward(int sum, int divisor) {
        Node<Integer> sumList = new Node<>(sum / divisor);
        sum %= divisor;
        divisor /= 10;

        // add remaining digits
        while (sum >= 10){
            sumList.appendData(sum / divisor);
            sum %= divisor;
            divisor /= 10;
        }

        // add the last digit
        sumList.appendData(sum / divisor);
        return sumList;
    }
}