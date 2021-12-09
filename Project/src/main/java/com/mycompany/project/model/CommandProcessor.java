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
 * CommandProcessor rappresenta l'invoker
 *
 * @author user
 */
public class CommandProcessor {

    private Stack<Command> commands;

    public CommandProcessor() {
        commands = new Stack();
    }

    /**
     * Esegue un comando e lo salva
     *
     * @param command comando che si deve eseguire
     */
    public void executeCommand(Command command) {

        commands.push(command);
        command.exec();

    }

    /**
     * Effettua un'operazione di undo
     */

    public void undo() {

        try {

            Command command = commands.pop();
            command.undo();
        } catch (StackEmptyException ex) {

        }

    }
/**
 * Rimuove l'ultimo comando memorizzato
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
