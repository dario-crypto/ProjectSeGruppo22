package com.mycompany.project;

public interface StackLogic<E> extends Iterable<E> {

      /**
     * This method inserts an item into the stack
     *
     * @param item
     */
    void push(E item);

    /**
     * It removes the element on top of the stack
     *
     * @return last element
     * @throws StackEmptyException
     */
    E pop() throws StackEmptyException;

    /**
     * It returns the element on top of the stack
     *
     * @return last element
     */
    E top();
    
    /**
     * This method checks if the stack is empty
     *
     * @return true if the stack is empty,false otherwise
     */
    boolean isEmpty();

        /**
     * This method returns the number of elements of the stack
     *
     * @return size
     */

    int getSize();
    
    /**
     * This method return the element of the stack in the given index
     *
     * @param index
     */
    
    E getItem(int index);
    
    /**
     * This metod removes all of stack's items
     * @throws StackEmptyException
     */
    void clear() throws StackEmptyException;

}
