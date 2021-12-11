/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.model;

import com.mycompany.project.exception.StackEmptyException;

/**
 * This is a functional interface for all the operation available on the Calculator
 * @author user
 */
public interface GlobalOperation {
    
    /**
     * This is the method apply for the OperationVariables class
     * @param c the calculator
     * @param name the name of the variable
     * @param vs the variables space
     * @throws StackEmptyException when the stack is empty or when there are not enough elements to execute the operation
     */

    default void apply(Calculator c, String name, VariablesSpace vs) throws StackEmptyException {

    }
    
    /**
     * This is the apply method for the Operation class
     * @param c the calculator
     * @param commandProcessor the needed command processor
     * @param vs the space variables
     * @throws StackEmptyException when the stack is empty or when there are not
     * enough elements to execute the operation
     */

    default void apply(Calculator c, CommandProcessor commandProcessor, VariablesSpace vs) throws StackEmptyException{

    }

}
