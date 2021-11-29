package com.mycompany.project;

import java.util.Iterator;

public class Stack<E> implements Iterable<E>, StackLogic<E> {

    private E[] stack;
    private int size = 0;
    private int currentCapacity;


    public Stack(int initialCapacity) {
        this.stack = (E[]) new Object[initialCapacity];
        this.currentCapacity = initialCapacity;

    }

    
    public Stack() {
        int defaultCapacity = 30;
        this.stack = (E[]) new Object[defaultCapacity];
        this.currentCapacity = defaultCapacity;
    }

    /**
     * This method returns the number of elements of the stack
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * It returns the element on top of the stack
     *
     * @return last element
     */
    @Override
    public E top() {
        return stack[size - 1];
    }

    /**
     * This method inserts an item into the stack
     *
     * @param item
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
     * @param newCapacity
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
     * @return last element
     * @throws StackEmptyException
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
     * @param index
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
     * @throws StackEmptyException
     */
    
    @Override
     public void clear() throws StackEmptyException{
        while(!isEmpty())
            pop();
    }
    
    
    
    

}
