/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

/**
 *
 * @author user
 */
public interface OperationVariable extends GlobalOperation {
    
    @Override
    void apply(Calculator c, String name,VariablesSpace vs) throws StackEmptyException;
    
}
