package com.mycompany.project.model;

import com.mycompany.project.exception.StackEmptyException;

/**
 * This class is functional interface to implement the stack logic
 * @author dilet
 * @param <E> generic object
 */



public interface StackLogic<E> extends Iterable<E> {

      /**
     * This method inserts an item into the stack
     *
     * @param item the item we want to insert
     */
    void push(E item);

    /**
     * It removes the element on top of the stack
     *
     * @return last element of the stack
     * @throws StackEmptyException when the stack is empty
     */
    E pop() throws StackEmptyException;

    /**
     * It returns the element on top of the stack
     *
     * @return last element of the stack
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
     * @return size of the stack
     */

    int getSize();
    
    /**
     * This method return the element of the stack in the given index
     *
     * @param index which is the given index
     * @return the item in the given index
     */
    
    E getItem(int index);
    
    /**
     * This metod removes all of stack's items
     * @throws StackEmptyException when the stack is empty
     */
    void clear() throws StackEmptyException;

}
