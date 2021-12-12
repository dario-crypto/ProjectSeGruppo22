package com.mycompany.project.model;

import com.mycompany.project.exception.StackEmptyException;
import java.util.Arrays;
import java.util.Iterator;

/**
 * This class represents the stack in which the numbers are pushed
 * @author Dario
 * @param <E> that is a generic object
 */

public class Stack<E> implements Iterable<E>, StackLogic<E> {

    private E[] stack;
    private int size = 0;
    private int currentCapacity;
    
    /**
     * This is the constructor for the Stack class
     * @param initialCapacity the capacity of the stack
     */
    public Stack(int initialCapacity) {
        this.stack = (E[]) new Object[initialCapacity];
        this.currentCapacity = initialCapacity;

    }

    /**
     * This method is the second constructor of the Stack class
     */
    public Stack() {
        int defaultCapacity = 30;
        this.stack = (E[]) new Object[defaultCapacity];
        this.currentCapacity = defaultCapacity;
    }

    /**
     * This method returns the number of elements of the stack
     *
     * @return size of the stack
     */
    public int getSize() {
        return size;
    }

    /**
     * It returns the element on top of the stack
     *
     * @return last element of the stack
     */
    @Override
    public E top() {
        return stack[size - 1];
    }

    /**
     * This method inserts an item into the stack
     *
     * @param item that needs to be pushed in the stack
     */
    @Override
    public void push(E item) {

        if (isFull()) {
            realloc(currentCapacity * 2);
        }

        stack[size] = item;
        size++;

    }

    /**
     * This method inserts the stack into a new stack with specified capacity
     *
     * @param newCapacity that is the capacity of the new stack
     */
    private void realloc(int newCapacity) {
        E[] newStack = (E[]) new Object[newCapacity];
        System.arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
        currentCapacity = newCapacity;

    }

    /**
     * It removes the element on top of the stack
     *
     * @return last element of the stack
     * @throws StackEmptyException when the stack is empty
     */
    @Override
    public E pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        E item = stack[size - 1];
        stack[size - 1] = null;
        size--;
        return item;

    }

    /**
     * This method checks if the stack is full
     *
     * @return true if the stack is Full, false otherwise
     */
    private boolean isFull() {
        return size >= currentCapacity;
    }

    /**
     * This method checks if the stack is empty
     *
     * @return true if the stack is empty,false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This Class allows to iterate the stack
     */
    public class StackIterator implements Iterator<E> {

        int index = 0;

        /**
         * This method checks if there is a following item in the stack
         *
         * @return true if there is a following item,
         * otherwise it returns false
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * This method returns the following item
         *
         * @return following element
         */
        @Override
        public E next() {
            if (hasNext()) {
                E item = stack[index];
                index++;
                return item;
            }
            return null;
        }
    }

    /**
     * This method returns the iterator of the stack
     *
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

   

    /**
     * This method return the element of the stack in the given index
     *
     * @param index in which the desired element is 
     * @return the item in the given index
     */
    public E getItem(int index) {
        return stack[index];
    }

    /**
     * This method returns the current capacity of the stack
     *
     * @return current capacity
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }
    
    /**
     * This metod removes all of stack's items
     * @throws StackEmptyException when the stack is empty
     */
    
    @Override
     public void clear() throws StackEmptyException{
        while(!isEmpty())
            pop();
    }
     
     /**
      * This is the hash code method of the Stack class
      * @return the hash value
      */
    
      @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
    
    /**
     * This is the equals method of the Stack class
     * @param obj that represents the object that we want to compare to another Stack's object
     * @return true if they are equals,otherwise false
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Stack<?> other = (Stack<?>) obj;
        if (!Arrays.deepEquals(this.stack, other.stack)) {
            return false;
        }
        return true;
    }
    
    

}
