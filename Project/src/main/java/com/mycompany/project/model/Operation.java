/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.model;

import com.mycompany.project.exception.StackEmptyException;

/**
 * This is a functional interface that is used by the Calculator's operation on the numbers' and variables' stack
 * @author user
 */
@FunctionalInterface
public interface Operation extends GlobalOperation {
    
    /**
     * This is the method that allows to execute the operation on the stacks
     * @param c calculator
     * @param cp the needed command processor
     * @param vs tha variables space
     * @throws StackEmptyException when there are not enough elements to execute the operations
     */

    @Override
    void apply(Calculator c, CommandProcessor cp, VariablesSpace vs) throws StackEmptyException;

}
