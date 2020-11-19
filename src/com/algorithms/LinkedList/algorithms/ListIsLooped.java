package com.algorithms.LinkedList.algorithms;

public class ListIsLooped<T> {

    // time complexity is O(n + nm) or simply O(nm), where n is the loop size and m the mth Node where the loop begins
    public Node<T> isLooped(Node<T> head){
        // slow and fast pointers to navigate until fast.next is null

        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List is not looped");
            return null;
        }

        Node<T> slow = head;
        Node<T> fast = head.next;

        // potentially O(n) at worst
        while (slow != fast){
            if (fast.next == null || fast.next.next == null){
                System.out.println("List is not looped");
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        // slow would be in the loop by now
        // leave fast where it is and move slow one node ahead
        slow = slow.next;

        Node<T> outsideLoop = head;
        //move outsideLoop while looping slow until it finds fast again

        // this would be O(nm), where n is the loop size and m the mth Node where the loop begins
        while (outsideLoop != fast){
            while (slow != fast){
                if (slow == outsideLoop){
                    System.out.println("Loop starts at value: " + outsideLoop.data);
                    return outsideLoop;
                }
                slow = slow.next;
            }
            outsideLoop = outsideLoop.next;

            if (outsideLoop == fast){
                break;
            }
            slow = slow.next;
        }

        System.out.println("Loop starts at value: " + outsideLoop.data);
        return outsideLoop;
    }
}
