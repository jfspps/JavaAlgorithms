package StacksAndQueues;

import StacksAndQueues.algorithms.ArrayOfThreeStacks;
import StacksAndQueues.algorithms.ArrayStack;

public class Main {

    public static void main(String[] args){
//        demoArrayStack();

        demoArrayOfThreeStacks();
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
