package StacksAndQueues;

import StacksAndQueues.algorithms.*;

public class Main {

    public static void main(String[] args){
//        demoArrayStack();

//        demoArrayOfThreeStacks();

//        minimumAtTop();

//        setOfStacks();

//        myQueue();

        getSmallestInt();
    }

    private static void getSmallestInt() {
        SmallestInteger smallestInteger = new SmallestInteger();
        smallestInteger.push(5);
        System.out.println("Current top (5) is: " + smallestInteger.peek());
        smallestInteger.push(3);
        System.out.println("Current top (3) is: " + smallestInteger.peek());
        smallestInteger.push(4);
        System.out.println("Current top (still 3) is: " + smallestInteger.peek());
        System.out.println("Removed: " + smallestInteger.pop());
        System.out.println("Current top (4) is: " + smallestInteger.peek());
        System.out.println("Removed: " + smallestInteger.pop());
        System.out.println("Current top (5) is: " + smallestInteger.peek());
        System.out.println("Removed: " + smallestInteger.pop());
        System.out.println("Removed: " + smallestInteger.pop());
        System.out.println("Stack is empty: " + smallestInteger.isEmpty());
    }

    private static void myQueue() {
        MyQueue<Integer> myQueue = new MyQueue<>();
        System.out.println("Current queue top (null): " + myQueue.peek());
        myQueue.enqueue(123);
        myQueue.enqueue(456);
        System.out.println("Current queue top (123): " + myQueue.peek());
        System.out.println("Queue is empty: " + myQueue.isEmpty());
        myQueue.dequeue();
        System.out.println("Current queue top (456): " + myQueue.peek());
        myQueue.enqueue(789);
        System.out.println("Current queue top (456): " + myQueue.peek());
        myQueue.dequeue();
        myQueue.dequeue();
        System.out.println("Current queue top (null): " + myQueue.peek());
        System.out.println("Queue is empty: " + myQueue.isEmpty());
    }

    private static void setOfStacks() {
        SetOfStacks<Integer> setOfStacks = new SetOfStacks<>(2);
        setOfStacks.push(4);
        setOfStacks.push(6);
        System.out.println("Current top item should be 6: " + setOfStacks.peek());
        setOfStacks.push(8);
        System.out.println("Current top item should be 8: " + setOfStacks.peek());
        setOfStacks.push(10);
        System.out.println("Current top item should be 10: " + setOfStacks.peek());
        System.out.println("Removed " + setOfStacks.pop());
        System.out.println("Current top item should be 8: " + setOfStacks.peek());
        System.out.println("Removing 6? Removed " + setOfStacks.popAt(1));
        System.out.println("Current top item should still be 8: " + setOfStacks.peek());
        System.out.println("Removed " + setOfStacks.pop());
        System.out.println("Current top item should be 4: " + setOfStacks.peek());
        System.out.println("Removed " + setOfStacks.pop());
        System.out.println("Everything should be deleted by now: " + setOfStacks.peek());
    }

    private static void minimumAtTop() {
        MinimumValue minimumValue = new MinimumValue(4);
        minimumValue.push(123);
        minimumValue.push(426);
        minimumValue.push(678);
        minimumValue.push(1000);
        System.out.println("The minimum value is: " + minimumValue.min());
    }

    private static void demoArrayOfThreeStacks() {
        ArrayOfThreeStacks<Integer> arrayOfThreeStacks = new ArrayOfThreeStacks<>(2, 3, 2);
        System.out.println("Stack 2 is empty: " + arrayOfThreeStacks.isEmpty(2));
        arrayOfThreeStacks.push(128, 2);
        arrayOfThreeStacks.push(256, 2);
        arrayOfThreeStacks.push(512, 2);
        arrayOfThreeStacks.push(1024, 2);
        System.out.println("Stack 2's top item: " + arrayOfThreeStacks.peek(2));
        System.out.println("Popped from stack 2: " + arrayOfThreeStacks.pop(2));
        System.out.println("Stack 2's top item: " + arrayOfThreeStacks.peek(2));
    }

    public static void demoArrayStack(){
        ArrayStack<Character> stackOfChars = new ArrayStack<>(5);
        System.out.println(stackOfChars.isEmpty());
        stackOfChars.push('A');
        System.out.println("Top item in the stack: " + stackOfChars.peek());
        System.out.println(stackOfChars.pop());
        System.out.println("Top item in the stack: " + stackOfChars.peek());
        System.out.println(stackOfChars.isEmpty());
    }
}
