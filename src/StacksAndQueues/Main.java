package StacksAndQueues;

import StacksAndQueues.algorithms.ArrayOfThreeStacks;
import StacksAndQueues.algorithms.ArrayStack;
import StacksAndQueues.algorithms.MinimumValue;
import StacksAndQueues.algorithms.SetOfStacks;

public class Main {

    public static void main(String[] args){
//        demoArrayStack();

//        demoArrayOfThreeStacks();

//        minimumAtTop();

        setOfStacks();
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
