/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.project;

import com.mycompany.project.exception.*;
import com.mycompany.project.model.Formulas;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dario
 */
public class FormulasTest {

    private Formulas formulas;

    @Before
    public void setUp() {
        formulas = new Formulas();
    }

    /**
     * Test of get method, of class Formules.
     */
    @Test
    public void testGet() throws FormulaAlreadyExsist, NameFormulaAlreadyExsist {

        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";
        formulas.add(name1, formule1);
        formulas.add(name2, formule2);

        assertEquals(formulas.get(name1), formule1);
        assertEquals(formulas.get(name2), formule2);

        assertEquals(null, formulas.get("a"));

    }

    /**
     * Test of rename method, of class Formules.
     */
    @Test
    public void testRename() throws FormulaAlreadyExsist, NameFormulaAlreadyExsist {
        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";
        formulas.add(name1, formule1);

        formulas.rename(name1, "Delta2");
        assertEquals(null, formulas.get(name1));
        assertEquals(formulas.get("Delta2"), formule1);

    }

    /**
     * Test of update method, of class Formules.
     */
    @Test
    public void testUpdate() throws FormulaAlreadyExsist, NameFormulaAlreadyExsist {
        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";
        formulas.add(name1, formule1);
        formulas.add(name2, formule2);

        String newFormule = "a*b*c";
        boolean status = formulas.update(name1, newFormule);
        assertEquals(true, status);
        assertEquals(newFormule, formulas.get(name1));

    }
    
    /**
     * Test of clear method, of class Formules.
     */
    @Test
    public void testClear() throws FormulaAlreadyExsist, IOException, NameFormulaAlreadyExsist {
        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";

        formulas.add(name1, formule1);
        formulas.add(name2, formule2);
        formulas.clear();
        assertEquals(0, formulas.size());
        assertEquals(null, formulas.get(name1));
        assertEquals(null, formulas.get(name2));

    }
    

    /**
     * Test of save and reaload methods, of class Formules.
     */
    @Test
    public void testSaveReload() throws IOException, FileNotFoundException, ClassNotFoundException, FormulaAlreadyExsist, NameFormulaAlreadyExsist {

        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";

        String path = "formules.dat";

        formulas.add(name1, formule1);
        formulas.add(name2, formule2);
        formulas.save();
        File file = new File(path);
        
        

        //verifico che il file è stato creato
        
        //assertEquals(true, file.exists());
        formulas.clear();
        
        formulas.reaload();
        assertEquals(formule1, formulas.get(name1));
        assertEquals(formule2, formulas.get(name2));

    }

    /**
     * Test of add method, of class Formules.
     */
    @Test
    public void testAdd() throws FormulaAlreadyExsist, NameFormulaAlreadyExsist {

        String name1 = "Delta";
        String formula1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formula2 = "sqrt(a*a+b*b)";
        boolean status;

        //formula non presente (nome e formula)
        formulas.add(name2, formula2);
        assertEquals(formula2, formulas.get(name2));
        formulas.add(name1, formula1);
        assertEquals(formula1, formulas.get(name1));

        //caso formula già presente
        //FormulaAlreadyExsist assertThrows = assertThrows(FormulaAlreadyExsist.class, () -> formulas.add("newName", formula2));
        //assertEquals("Formula: " + formula2 + " already exsist!", assertThrows.getMessage());
      

        //caso nome già presente
        NameFormulaAlreadyExsist assertThrowsName = assertThrows(NameFormulaAlreadyExsist.class, () -> formulas.add(name1, "a+b"));
        assertEquals("Name: " + name1 + " already exsist!", assertThrowsName.getMessage());

    }

    /**
     * Test of delete method, of class Formules.
     */
    @Test
    public void testDelete() throws Exception {
        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";

        formulas.add(name1, formule1);
        formulas.add(name2, formule2);

        formulas.delete("Delta");
        assertEquals(null, formulas.get("Delta"));
        assertEquals(1, formulas.size());

    }



}
