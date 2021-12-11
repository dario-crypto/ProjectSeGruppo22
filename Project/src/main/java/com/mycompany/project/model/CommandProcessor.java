/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.model;

import com.mycompany.project.command.Command;
import com.mycompany.project.exception.StackEmptyException;
import com.mycompany.project.model.Stack;

/**
 * CommandProcessor represents the invoker
 *
 * @author user
 */
public class CommandProcessor {

    private Stack<Command> commands;
    
    /**
     * This method is the constructor of the CommeandProcessor class
     */

    public CommandProcessor() {
        commands = new Stack();
    }

    /**
     * This method is use to execute a command and to save it
     *
     * @param command comando che si deve eseguire
     */
    public void executeCommand(Command command) {

        commands.push(command);
        command.exec();

    }

    /**
     * This method executes the undo operation
     */

    public void undo() {

        try {

            Command command = commands.pop();
            command.undo();
        } catch (StackEmptyException ex) {

        }

    }
/**
 * This method removes the last inserted command
 */
    public void popCommand() {
        {
            try {
                commands.pop();
            } catch (StackEmptyException ex) {
            }

        }
    }
}
