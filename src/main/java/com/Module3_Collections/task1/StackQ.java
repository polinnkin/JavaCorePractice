package main.java.com.Module3_Collections.task1;

/**
 * StackQ class for Task #1.
 * <p>
 * This program implements stack using a single queue.
 *
 * @author Polina Bochkareva
 * @version 1.0 11/10/2018
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackQ {
    Queue<Integer> queue = new LinkedList<Integer>();

    /**
     * Unit tests the {@code StackQ} data type.
     */
    public static void main(String[] args) {
        StackQ stack = new StackQ();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Top element :" + stack.peek());
        stack.pop();
        stack.push(5);
        stack.pop();
        System.out.println("Top element :" + stack.peek());
    }

    /**
     * Adds the item to this stack.
     *
     * @param item the item to add
     */
    public void push(int item) {
        // Get size of queue
        int size = queue.size();

        // Add current element
        queue.add(item);

        // Pop all previous elements and put them after the current element
        for (int i = 0; i < size; i++) {
            int x = queue.remove();
            queue.add(x);
        }
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    public int pop() {
        if (queue.isEmpty()) {
            if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        }
        int x = queue.remove();
        return x;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    public int peek() {
        if (queue.isEmpty())
            throw new NoSuchElementException("Stack underflow");
        return queue.peek();
    }

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}