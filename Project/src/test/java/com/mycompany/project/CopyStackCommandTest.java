package com.mycompany.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.project.command.CopyStackCommand;
import static org.junit.Assert.*;
import com.mycompany.project.model.Calculator;
import com.mycompany.project.model.ComplexNumber;
import com.mycompany.project.model.Stack;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author user
 */
public class CopyStackCommandTest {

    private CopyStackCommand copy;
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator(new Stack());
        copy = new CopyStackCommand(calculator);
    }

    /**
     * Test of exec method, of class CopyStackCommand.
     */
    @Test
    public void testExec() {
        calculator.insert(new ComplexNumber(2, 1));

        copy.exec();

        calculator.insert(new ComplexNumber(3, 2));
        Stack<ComplexNumber> stack = new Stack<>();
        stack.push(new ComplexNumber(2,1));
        Stack<ComplexNumber> backup = copy.getBackupStack();
        assertEquals(stack, backup);

    }

    /**
     * Test of undo method, of class CopyStackCommand.
     */
    @Test
    public void testUndo() {

        calculator.insert(new ComplexNumber(2, 1));

        copy.exec();
        calculator.insert(new ComplexNumber(3, 2));

        copy.undo();
        Calculator c2 = new Calculator(new Stack());
        c2.insert(new ComplexNumber(2,1));
        assertEquals(c2, calculator);
        
    }

}
