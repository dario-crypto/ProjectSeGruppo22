package com.mycompany.project;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mycompany.project.model.ComplexNumber;
import com.mycompany.project.model.VariablesSpace;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class VariablesSpaceTest {

    VariablesSpace vs;
    /**
     * This is the constructor of class the VariablesSpaceTest
     */
    public VariablesSpaceTest() {
        vs = new VariablesSpace();
    }
    /**
     * This method is used to set the conditionts in common for multiple case of
     * testing
     */
    @Before
    public void setUp() {
        vs = new VariablesSpace();
    }

    /**
     * Test of update method, of class VariablesSpace.
     */
    @Test
    public void testUpdate() {
        ComplexNumber c1 = new ComplexNumber(2, 1);
        ComplexNumber c2 = new ComplexNumber(3, 2);
        ComplexNumber c3 = new ComplexNumber(2, 4);

        //caso variabile presente nello spazio
        vs.update("a", c1);
        assertEquals(c1, vs.get("a"));
        vs.update("z", c2);
        assertEquals(c2, vs.get("z"));
        //caso variabile non presente nello spazio
        vs.update("cv", new ComplexNumber(3, 3));
        assertEquals(null, vs.get("cv"));

    }

    /**
     * Test of equals method, of class VariablesSpace.
     */
    @Test
    public void testEquals() {

        VariablesSpace vs2 = new VariablesSpace();
        //caso uguali
        vs2.update("a", new ComplexNumber(2, 1));
        vs.update("a", new ComplexNumber(2, 1));
        assertEquals(true, vs.equals(vs2));
        //caso non uguali 
        vs2.update("b", new ComplexNumber(2, 1));
        vs.update("c", new ComplexNumber(2, 1));
        assertEquals(false, vs.equals(vs2));

    }

}
