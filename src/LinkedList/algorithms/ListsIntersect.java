package LinkedList.algorithms;

public class ListsIntersect<T> {

    // time complexity is O(nm)
    public Node<T> listsIntersect(Node<T> list1, Node<T> list2){
        // list1 has next and list2 has next_spare
        // cross your fingers

        //store the starting nodes so that the pointers can be reset
        Node<T> list2Head = list2;

        while (list1.next != null){
            while (list2.next_spare != null){
                if (list1 == list2){
                    System.out.println("Lists intersect, with data value: " + list1.data);
                    return list1;
                }
                list2 = list2.next_spare;
            }
            list2 = list2Head;
            list1 = list1.next;
        }

        System.out.println("Lists do not intersect");
        return null;
    }
}
