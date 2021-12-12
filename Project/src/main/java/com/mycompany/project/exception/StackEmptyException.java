
package com.mycompany.project.exception;
/**
 * Class that represents the exception when the stack is empty
 */

public class StackEmptyException extends Exception {
    
    /**
     * This method is the constructor of the StackEmptyException class
     * @param message the message the user needs to see to understand the
     * exception
     */


    public StackEmptyException(String message) {
        super(message);
    }
}