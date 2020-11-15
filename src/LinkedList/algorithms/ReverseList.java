package LinkedList.algorithms;

public class ReverseList<T> {

    public Node<T> reverseNode(Node<T> head){
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List contains one node");
            return head;
        }

        if (head.next.next == null){
            head.next.next = head;
            Node<T> newHead = head.next;
            head.next = null;
            return newHead;
        }

        // for lists with at least three nodes
        Node<T> p = head;
        Node<T> q = head.next;
        Node<T> r = head.next.next;

        p.next = null;
        q.next = p;
        p = r;
        r = p.next;

        while(p.next != null){
            p.next = q;
            q = p;
            p = r;
            r = p.next;
        }
        p.next = q;
        return p;
    }

    // reverse up to but excluding Node K
    public Node<T> reverseNodeUptoK(Node<T> head, Node<T> K){
        if (head == null){
            System.out.println("List is empty");
            return null;
        }

        if (head.next == null){
            System.out.println("List contains one node");
            return head;
        }

        if (head.next.next == null){
            head.next.next = head;
            Node<T> newHead = head.next;
            head.next = null;
            return newHead;
        }

        // handle when K is near the beginning of the list
        if (K == head){
            System.out.println("Kth element is head node");
            return null;
        }

        if (K == head.next){
            System.out.println("Kth element is 2nd in the list");
            head.next = null;
            return head;
        }

        if (K == head.next.next){
            System.out.println("Kth element is 3rd in the list");
            Node<T> q = head.next;
            q.next = head;
            head.next = null;
            return q;
        }

        // for lists with at least three nodes
        Node<T> p = head;
        Node<T> q = head.next;
        Node<T> r = head.next.next;

        p.next = null;
        q.next = p;
        p = r;
        r = p.next;

        while(r != null && p.next != K){
            p.next = q;
            q = p;
            p = r;
            r = p.next;
        }
        p.next = q;
        return p;
    }
}
