
package com.mycompany.project.exception;
/**
 * Class that represents the exception when the stack is empty
 */

public class StackEmptyException extends Exception {
    
    /**
     * This is the constructor for the StackEmptyException class
     * @param message the user needs ton see to understand the error
     */
    public StackEmptyException(String message) {
        super(message);
    }
}