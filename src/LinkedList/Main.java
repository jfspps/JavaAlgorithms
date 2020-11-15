package LinkedList;

import LinkedList.algorithms.*;

public class Main {

    public static void main(String[] args) {

//        linkedListDemo();

//        reverseIntNode();
//        reverseIntNodeUptoK();

//        reverseCharNode();
//        reverseNodeOfCharUptoK();

//        evenList_isAPaldindrome();
//        oddList_isAPalindrome();
//        isNotAPalindrome();

//        findDuplicates();

//        findDuplicates_noBuffer();

//        findKthToLast_singlyLinkedList(5);
//        findKthToLast_singlyLinkedList(25);

//        deleteGivenNode();

//        partitionList(24);

//        getSumReversed();

//        getSumForward();

//        printArrayOfLists(buildTwoIntersectingLists());
//        listsIntersect();

        listIsLooped();
    }

    private static void isNotAPalindrome() {
        Node<Character> characterNode_Daod = buildNodeOfChar_daod();
        Palindrome truePalindrome = new Palindrome();
        truePalindrome.isAPalindrome(characterNode_Daod, characterNode_Daod.getListLength(characterNode_Daod));
    }

    private static void reverseCharNode() {
        Node<Character> list = buildNodeOfChar_daod();
        list.printLinkedList();
        ReverseList<Character> reverseList = new ReverseList<>();
        Node<Character> reversed = reverseList.reverseNode(list);
        reversed.printLinkedList();
    }

    private static void evenList_isAPaldindrome() {
        Node<Character> characterNode_Duud = buildNodeOfChar_duud();
        Palindrome truePalindrome = new Palindrome();
        truePalindrome.isAPalindrome(characterNode_Duud, characterNode_Duud.getListLength(characterNode_Duud));
    }

    private static void oddList_isAPalindrome(){
        Node<Character> characterNode_Dulud = buildNodeOfChar_dulud();
        Palindrome falsePalindrome = new Palindrome();
        falsePalindrome.isAPalindrome(characterNode_Dulud, characterNode_Dulud.getListLength(characterNode_Dulud));
    }

    private static void getSumForward() {
        Node<Integer> list_even = buildSingleDigitList_even();
        SumForward sumForward = new SumForward();
        Node<Integer> sumEven = sumForward.sumForward(list_even);
        sumEven.printLinkedList();

        Node<Integer> list_odd = buildSingleDigitList_odd();
        Node<Integer> sumOdd = sumForward.sumForward(list_odd);
        sumOdd.printLinkedList();
    }

    private static void getSumReversed() {
        Node<Integer> list_even = buildSingleDigitList_even();
        SumReversed sumReversed = new SumReversed();
        Node<Integer> sumEven = sumReversed.sumReversed(list_even);
        sumEven.printLinkedList();

        Node<Integer> list_odd = buildSingleDigitList_odd();
        Node<Integer> sumOdd = sumReversed.sumReversed(list_odd);
        sumOdd.printLinkedList();
    }

    private static void partitionList(int p) {
        Node<Integer> list = buildNode();
        PartitionAboutP partitionAboutP = new PartitionAboutP();
        partitionAboutP.partition(list, p);
    }

    private static void deleteGivenNode() {
        Node<Integer> list = buildNode();
        FindKthToLast<Integer> findKthToLast = new FindKthToLast<>();
        Node<Integer> kThToLast = findKthToLast.findKthToLast(list, 4);
        list.printLinkedList();
        list.deleteGivenNode(list, kThToLast);
        list.printLinkedList();
    }

    private static void findKthToLast_singlyLinkedList(int k) {
        Node<Integer> list = buildNode();
        list.printLinkedList();
        FindKthToLast<Integer> findKthToLast = new FindKthToLast<>();
        Node<Integer> kThToLast = findKthToLast.findKthToLast(list, k);
        if (kThToLast != null){
            System.out.println("Node found has " + k + "th to last: " + list.printNodeData(kThToLast));
        }
    }

    private static void findDuplicates_noBuffer(){
        Node<Integer> list = buildNode();
        list.printLinkedList();
        FindDuplicates<Integer> findDuplicates = new FindDuplicates<>();
        findDuplicates.findDuplicates_noBuffer(list);
        list.printLinkedList();
    }

    private static void findDuplicates(){
        Node<Integer> list = buildNode();
        list.printLinkedList();
        FindDuplicates<Integer> findDuplicates = new FindDuplicates<>();
        findDuplicates.findDuplicates(list);
        list.printLinkedList();
    }

    private static void reverseNodeOfCharUptoK(){
        Node<Character> list = buildNodeOfChar_daod();
        list.printLinkedList();

        System.out.println("Finding the 2nd to last element");
        FindKthToLast<Character> findKthToLast = new FindKthToLast<>();
        Node<Character> k_th = findKthToLast.findKthToLast(list, 2);

        ReverseList<Character> reverseList = new ReverseList<>();
        Node<Character> reversed = reverseList.reverseNodeUptoK(list, k_th);
        reversed.printLinkedList();
    }

    private static void reverseIntNodeUptoK(){
        Node<Integer> list = buildNode();
        list.printLinkedList();

        System.out.println("Finding the 5th to last element");
        FindKthToLast<Integer> findKthToLast = new FindKthToLast<>();
        Node<Integer> k_th = findKthToLast.findKthToLast(list, 5);

        ReverseList<Integer> reverseList = new ReverseList<>();
        Node<Integer> reversed = reverseList.reverseNodeUptoK(list, k_th);
        reversed.printLinkedList();
    }

    private static void reverseIntNode(){
        Node<Integer> list = buildNode();
        list.printLinkedList();
        ReverseList<Integer> reverseList = new ReverseList<>();
        Node<Integer> reversed = reverseList.reverseNode(list);
        reversed.printLinkedList();
    }

    private static void linkedListDemo(){
        Node<Integer> list1 = buildNode();
        list1.printLinkedList();

        Node<Integer> list2 = list1.delete(list1, 24);
        list2.printLinkedList();
        list1.printLinkedList();    //left over with a single isolated node

        list2.delete(list2, 136);
        list2.printLinkedList();
    }

    private static Node<Integer> buildNode(){
        Node<Integer> list1 = new Node<>(24);

        list1.appendData(25);
        list1.appendData(25);
        list1.appendData(23);
        list1.appendData(8);
        list1.appendData(16);
        list1.appendData(136);
        list1.appendData(23);
        list1.appendData(77);
        list1.appendData(4);
        list1.appendData(999);
        list1.appendData(0);
        list1.appendData(488);

        return list1;
    }

    private static Node<Character> buildNodeOfChar_duud(){
        Node<Character> string = new Node<>('d');
        string.appendData('u');
        string.appendData('u');
        string.appendData('d');
        return string;
    }

    private static Node<Character> buildNodeOfChar_daod(){
        Node<Character> string = new Node<>('d');
        string.appendData('a');
        string.appendData('o');
        string.appendData('d');
        return string;
    }

    private static Node<Character> buildNodeOfChar_dulud(){
        Node<Character> string = new Node<>('d');
        string.appendData('u');
        string.appendData('l');
        string.appendData('u');
        string.appendData('d');
        return string;
    }

    private static Node<Integer> buildSingleDigitList_even(){
        Node<Integer> list1 = new Node<>(4);

        list1.appendData(4);
        list1.appendData(4);
        list1.appendData(6);
        System.out.println("-----------Even list 44 66-------------");
        return list1;
    }

    private static Node<Integer> buildSingleDigitList_odd(){
        Node<Integer> list1 = new Node<>(4);

        list1.appendData(4);
        list1.appendData(4);
        list1.appendData(6);
        list1.appendData(6);
        System.out.println("--------Odd list 44 466------------");
        return list1;
    }

    private static Node<Character>[] buildTwoIntersectingLists(){
        Node<Character> intersectingNode = new Node<>('X');

        Node<Character> list1 = new Node<>('a');
        list1.appendData('a');
        list1.appendData('a');
        list1.appendNode(intersectingNode);
        list1.appendData('a');

        Node<Character> list2 = new Node<>('b');
        list2.appendData_spare('b');
        list2.appendData_spare('b');
        list2.appendNode_spare(intersectingNode);
        list2.appendData_spare('b');
        list2.appendData_spare('b');
        list2.appendData_spare('b');

        Node[] array = new Node[2];
        array[0] = list1;
        array[1] = list2;
        return array;
    }

    private static void printArrayOfLists(Node[] array){
        array[0].printLinkedList();
        array[1].printLinkedList_spare();
    }

    private static void listsIntersect(){
        Node<Character>[] temp = buildTwoIntersectingLists();
        ListsIntersect<Character> listsIntersect = new ListsIntersect<>();
        listsIntersect.listsIntersect(temp[0], temp[1]);
    }

    private static Node<Integer> buildLoopedIntList(){
        Node<Integer> newlist = new Node<>(0);
        newlist.appendData(1);
        newlist.appendData(2);
        newlist.appendData(3);
        newlist.appendData(4);

        Node<Integer> marker = new Node<>(5);
        newlist.appendNode(marker);

        newlist.appendData(6);
        newlist.appendData(7);

        newlist.linkToTail(newlist, marker);
        return newlist;
    }

    private static void listIsLooped(){
        Node<Integer> temp = buildLoopedIntList();
        ListIsLooped<Integer> listIsLooped = new ListIsLooped<>();
        listIsLooped.isLooped(temp);
    }
}