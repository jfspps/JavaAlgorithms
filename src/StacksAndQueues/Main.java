package StacksAndQueues;

import StacksAndQueues.algorithms.ArrayStack;

public class Main {

    public static void main(String[] args){
        demoArrayStack();
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
