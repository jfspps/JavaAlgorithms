package StacksAndQueues.algorithms;

public class SmallestInteger {

    private int smallestInt;
    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public SmallestInteger() {
        stack = new Stack<>();
        tempStack = new Stack<>();
        smallestInt = 0;
    }

    // when pushing, one compares the topmost node with the incoming node
    // if top <= incoming data, then pop top to tempStack and then push incoming data
    // time complexity is either O(3) or O(1), so just O(1)
    public void push(int data){
        if (!stack.isEmpty()) {
            if (stack.peek() <= data) {
                // make way for incoming data
                tempStack.push(stack.pop());
                stack.push(data);
                stack.push(tempStack.pop());    //tempStack is not always empty; see pop()
            } else
                stack.push(data);
        } else
            stack.push(data);

        smallestInt = data;
    }

    // when popping from stack, check if there are nodes beneath top that are smaller than top
    // time complexity is O(3n) or just O(n)
    public Integer pop(){
        if (stack.isEmpty() && tempStack.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }

        // transfer everything to tempStack
        while (!stack.isEmpty()){
            tempStack.push(stack.pop());
        }

        // reset smallestInt and transfer one item
        smallestInt = tempStack.peek();
        stack.push(tempStack.pop());

        // transfer all other items to stack, checking their values
        while (!tempStack.isEmpty()){
            if (smallestInt > tempStack.peek()){
                smallestInt = tempStack.peek();
            }
            stack.push(tempStack.pop());
        }

        // transfer items to tempStack until an item with a value matching smallestInt is found (there may be >1 item)
        // this also means tempStack may not always be empty
        while (!stack.isEmpty()){
            if (stack.peek() == smallestInt){
                break;
            }
            tempStack.push(stack.pop());
        }

        return stack.pop();
    }

    public int peek(){
        return this.stack.peek();
    }

    public boolean isEmpty(){
        return this.stack.isEmpty();
    }
}