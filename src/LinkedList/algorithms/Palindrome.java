package LinkedList.algorithms;

public class Palindrome {

    // time complexity is O(n)
    public boolean isAPalindrome(Node<Character> head, int length){
        Node<Character> slow = head, fast = head;

        // this part is O(n/2) or O(n)
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        ReverseList<Character> reverseList = new ReverseList<>();
        Node<Character> reversedLeftHalf;

        // if the list is odd in length, partition first then advance slow; otherwise advance slow then partition
        if (length%2 != 0){
            reversedLeftHalf = reverseList.reverseNodeUptoK(fast, slow);
            slow = slow.next;
        } else {
            slow = slow.next;
            reversedLeftHalf = reverseList.reverseNodeUptoK(fast, slow);
        }

        // this final part is O(n/2) or O(n)
        while (slow != null){
            if (reversedLeftHalf.data != slow.data){
                System.out.println("Given list is not a palindrome");
                return false;
            }
            slow = slow.next;
            reversedLeftHalf = reversedLeftHalf.next;
        }

        System.out.println("Given list is a palindrome");
        return true;
    }
}
