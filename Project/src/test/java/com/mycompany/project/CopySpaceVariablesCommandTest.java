package com.mycompany.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.mycompany.project.command.CopySpaceVariablesCommand;
import com.mycompany.project.model.*;
import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CopySpaceVariablesCommandTest {

    CopySpaceVariablesCommand command;
    VariablesSpace vs;

    /**
     * This method is used to set the conditionts in common for multiple case of
     * testing
     */
    @Before
    public void setUp() {
        vs = new VariablesSpace();
        command = new CopySpaceVariablesCommand(vs);

    }
    /**
     * This method is used to reset the postconditions
     */
    @After
    public void tearDown() {
    }

    /**
     * Test of exec method, of class CopySpaceVariablesCommand.
     */
    @Test
    public void testExec() {

        vs.update("a", new ComplexNumber(2, 1));
        command.exec();
        vs.update("b", new ComplexNumber(3, 3));
        HashMap<String, ComplexNumber> backup = command.getBackupMap();
        VariablesSpace vs2 = new VariablesSpace();
        vs2.update("a", new ComplexNumber(2, 1));
        assertEquals(backup, vs2.getVariablesMap());

    }

    /**
     * Test of undo method, of class CopySpaceVariablesCommand.
     */
    @Test
    public void testUndo() {
        vs.update("a", new ComplexNumber(2, 1));
        command.exec();
        vs.update("b", new ComplexNumber(2, 1));
        vs.update("c", new ComplexNumber(2, 1));
        vs.update("d", new ComplexNumber(2, 1));
        command.undo();

        VariablesSpace expectedRestore = new VariablesSpace();
        expectedRestore.update("a", new ComplexNumber(2, 1));
        assertEquals(expectedRestore, vs);

        vs.update("b", new ComplexNumber(3, 2.5));
        vs.update("d", new ComplexNumber(3, 1));

        expectedRestore.update("b", new ComplexNumber(3, 2.5));
        expectedRestore.update("d", new ComplexNumber(3, 1));

    }

}
