package com.algorithms.StacksAndQueues.algorithms;

public class MinimumValue {

    // whenever a new node is pushed to the stack, the top node is compared with the incoming node and the adjusted accordingly

    private final int stackSize;
    private final int[] stackArray;
    private int topIndex;

    public MinimumValue(int stackSize){
        this.stackSize = stackSize;
        this.stackArray = new int[stackSize];
        this.topIndex = -1;
    }

    public void push(int data){
        if (this.topIndex == this.stackSize - 1){
            System.out.println("Stack is full, cannot push to stack");
            return;
        }

        if (isEmpty() || data < peek()){
            this.stackArray[++this.topIndex] = data;
        } else {
            int temp = pop();
            this.stackArray[++this.topIndex] = data;
            this.stackArray[++this.topIndex] = temp;
        }
    }

    public int pop(){
        if (topIndex == -1){
            System.out.println("Stack is empty");
            return 0;
        }
        return stackArray[topIndex--];
    }

    public int peek(){
        if (topIndex == -1){
            System.out.println("Stack is already empty");
            return 0;
        }
        return stackArray[topIndex];
    }

    public boolean isEmpty(){
        return topIndex < 0;
    }

    public int min(){
        return peek();
    }
}