/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

import com.mycompany.project.command.Command;
import com.mycompany.project.controller.CommandController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asiav
 */
public class CommandControllerTest {
    
    public CommandControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of executeCommand method, of class CommandController.
     */
    @Test
    public void testExecuteCommand() {
        System.out.println("executeCommand");
        Command command = null;
        CommandController instance = new CommandController();
        instance.executeCommand(command);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of undo method, of class CommandController.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        CommandController instance = new CommandController();
        instance.undo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of popCommand method, of class CommandController.
     */
    @Test
    public void testPopCommand() {
        System.out.println("popCommand");
        CommandController instance = new CommandController();
        instance.popCommand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
