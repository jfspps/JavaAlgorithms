package com.algorithms.StacksAndQueues.algorithms;

// handles a set of stacks and populates each each stack to its capacity before continuing the next stack
// use a linked list of arrays such that a longer linked list is actually in place but partitioned across a number of arrays
// requirements: pop() should remove items and automatically navigate between arrays until the entire list is empty
// and popAt() removes items from a specific stack

public class SetOfStacks<T> {

    private static class ArrayStack<T>{
        private static int numberOfStacks = 0;  // relayed to SetOfStacks

        private final T[] array;
        private final int stackSize;
        private int topIndex;
        private ArrayStack<T> nextStack;
        private ArrayStack<T> previousStack;

        private final int stackID;

        public ArrayStack(int stackSize) {
            this.stackSize = stackSize;
            this.topIndex = -1;     // set an empty stack
            this.array = (T[]) new Object[this.stackSize];
            stackID = ++numberOfStacks;
        }

        // this is the only method which can instantiate more ArrayStacks; returns reference to stack where top resides
        // time complexity of push() is constant O(1)
        public ArrayStack<T> push(T data){
            if (currentStackIsFull()){
                // build a new stack or recycle previous stacks
                ArrayStack<T> newStack;
                if (nextStack != null){
                    newStack = nextStack;
                } else {
                    newStack = new ArrayStack<>(this.stackSize);
                }

                newStack.previousStack = this;
                this.nextStack = newStack;
                System.out.println("New stack initialised");

                newStack.array[++newStack.topIndex] = data;
                return newStack;
            } else {
                this.array[++this.topIndex] = data;
                return this;
            }
        }

        private boolean currentStackIsFull() {
            return this.topIndex == this.stackSize - 1;
        }

        private boolean currentStackIsEmpty(){
            return this.topIndex < 0;
        }

        // time complexity of pop() is O(m) where m is the number of stacks built by push()
        public T pop(){
            if (currentStackIsEmpty()){
                numberOfStacks--;
                // look for any preceding stack and run pop
                if (this.previousStack != null){
                    ArrayStack<T> currentStack = this.previousStack;
                    currentStack.nextStack = null;
                    return currentStack.pop();
                }
                System.out.println("All stacks are empty");
                return null;
            }
            return this.array[this.topIndex--];
        }

        // time complexity of popAt() is, like pop(), is O(m)
        public T popAt(int stackNo){
            if (stackNo > this.stackID){
                System.out.println("Given stack number is too high");
                return null;
            }

            // find the appropriate stack
            if (stackNo != this.stackID && this.previousStack != null){
                return this.previousStack.popAt(--stackNo);
            }

            // check if empty
            if (this.isEmpty()){
                System.out.println("No items to pop in required stack");
                return null;
            }

            return this.array[this.topIndex--];
        }

        // time complexity of peek(), like pop(), O(m)
        public T peek(){
            if (!this.isEmpty()){
                return this.array[topIndex];
            } else if (this.previousStack != null){
                return this.previousStack.peek();
            }

            System.out.println("All stacks are empty");
            return null;
        }

        public boolean isEmpty(){
            return this.topIndex < 0;
        }
    }

    private ArrayStack<T> arrayStack;

    public ArrayStack<T> getStack(){
        return this.arrayStack;
    }

    public SetOfStacks(int stackSize) {
        arrayStack = new ArrayStack<>(stackSize);
    }

    // all methods below call ArrayStack methods once; hence, time complexities of SetOfStacks methods
    // are the same as that of ArrayStack methods

    public void push(T data){
        // ArrayStack handles whether stack is full or not, while keeping currentStack pointer updated
        arrayStack = arrayStack.push(data);
    }

    public T pop(){
        return this.arrayStack.pop();
    }

    public T popAt(int stackNumber){
        return this.getStack().popAt(stackNumber);
    }

    public T peek(){
        return getStack().peek();
    }
}
