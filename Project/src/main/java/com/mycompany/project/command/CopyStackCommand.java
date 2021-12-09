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
 * Comando che si occupa di fare un backup dello stack e di farne un ripristino
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
     * Salva una copia dello stack
     */
    @Override
    public void exec() {
        backup = new Stack();
        for (ComplexNumber cn : calculator.getStack()) {
            backup.push((ComplexNumber) cn.clone());
        }

    }

    /**
     * Ripristina il contenuto dello stack salvato
     */
    @Override
    public void undo() {

        calculator.setStack(backup);

    }

}
