
package com.mycompany.project.exception;
/**
 * Class that represents the exception when the stack is empty
 */

public class StackEmptyException extends Exception {


    public StackEmptyException(String message) {
        super(message);
    }
}