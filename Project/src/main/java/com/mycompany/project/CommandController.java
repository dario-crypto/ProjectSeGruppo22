/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class CommandController {

    private Stack<Command> commands;

    public CommandController() {
        commands = new Stack();
    }

    public void executeCommand(Command command) {

        commands.push(command);
        command.exec();

    }

    public void undo() {

        try {
            Command command = commands.pop();
            command.undo();
        } catch (StackEmptyException ex) {
        }

    }

    public void popCommand() {
        {
            try {
                commands.pop();
            } catch (StackEmptyException ex) {
            }

        }
    }
}
