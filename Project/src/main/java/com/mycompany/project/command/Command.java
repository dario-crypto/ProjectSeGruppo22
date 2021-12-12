/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.command;

/**
 * This is the functional interface for the command design pattern
 * @author user
 */
public interface Command {

    /**
     * This method allows to execute operations
     */
    void exec();

    /**
     * This method allows to revert operations
     */
    void undo();
    
    
    
}
