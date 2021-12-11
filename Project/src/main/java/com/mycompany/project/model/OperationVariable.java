package com.mycompany.project.model;

import com.mycompany.project.exception.StackEmptyException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mycompany.project.model.VariablesSpace;
import com.mycompany.project.model.Calculator;

/**
 * This is a functional interface used by the Calculator's operation on the variables
 * @author user
 */
public interface OperationVariable extends GlobalOperation {
    
    @Override
    void apply(Calculator c, String name,VariablesSpace vs) throws StackEmptyException;
    
}
