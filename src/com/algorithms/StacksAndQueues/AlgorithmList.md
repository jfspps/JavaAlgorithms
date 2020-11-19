# Java Algorithms: Stacks and queues #

+ Implementation of a [stack (LIFO)](./algorithms/Stack.java). This class defines `pop()`, `push()`, `peek()` and `isEmpty()` as a linked list.
+ Implementation of a [queue (FIFO)](./algorithms/Queue.java). This class defines `enqueue()`, `dequeue()`, `peek()` and `isEMpty()` as a linked list.
+ Implementation of [one stack](./algorithms/ArrayStack.java) with an array and [three stacks](./algorithms/ArrayOfThreeStacks.java) with an array.
+ Implementation of a stack such that [min()](./algorithms/MinimumValue.java), which returns the node with the smallest value, is O(1).
+ Implementation of a set of stacks where pop() and push() process items (nodes) at the most recently build array and popAt() removes items from a specific array, [SetOfStacks](./algorithms/SetOfStacks.java)
+ Implementation of a Queue, using two stacks [MyQueue](./algorithms/MyQueue.java)
+ An algorithm which returns the smallest integer present in a stack, [smallestInteger](./algorithms/SmallestInteger.java)
+ Animal shelter queue, with dequeueDog(), dequeueCat(), dequeueAny(), enqueue(). The first* registered animal is the only animal that can be released (FIFO); the user can request adoption of a cat or dog if available. All other* animals in the queue must wait their turn [dogsAndCats](./algorithms/DogsAndCats.java)