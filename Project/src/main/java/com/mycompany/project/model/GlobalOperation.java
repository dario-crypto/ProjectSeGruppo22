/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.model;

import com.mycompany.project.exception.StackEmptyException;

/**
 *
 * @author user
 */
public interface GlobalOperation {

    default void apply(Calculator c, String name, VariablesSpace vs) throws StackEmptyException {

    }

    default void apply(Calculator c, CommandProcessor commandProcessor, VariablesSpace vs) throws StackEmptyException{

    }

}
