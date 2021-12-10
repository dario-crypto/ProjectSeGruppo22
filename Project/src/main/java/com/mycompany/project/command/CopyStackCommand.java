/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.command;

import com.mycompany.project.model.Calculator;
import com.mycompany.project.model.ComplexNumber;
import com.mycompany.project.model.Stack;

/**
 * Command that does the backup and the restoration of the stack
 *
 * @author user
 */
public class CopyStackCommand implements Command {

    private Calculator calculator;
    private Stack<ComplexNumber> backup;

    public CopyStackCommand(Calculator calculator) {
        this.calculator = calculator;
    }

    /**
     * This method saves a copy of the stack
     */
    @Override
    public void exec() {
        backup = new Stack();
        for (ComplexNumber cn : calculator.getStack()) {
            backup.push((ComplexNumber) cn.clone());
        }

    }

    /**
     * This method restores the value of the saved stack
     */
    @Override
    public void undo() {

        calculator.setStack(backup);

    }

    public Stack<ComplexNumber> getBackupStack() {
       return backup;
    }

}
