/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeMap;
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
    public void testGet() throws FormulaAlreadyExsist {

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
    public void testRename() throws FormulaAlreadyExsist {
        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";
        formulas.add(name1, formule1);

        boolean status = formulas.rename(name1, "Delta2");
        assertEquals(true, status);
        assertEquals(null, formulas.get(name1));
        assertEquals(formulas.get("Delta2"), formule1);

    }

    /**
     * Test of update method, of class Formules.
     */
    @Test
    public void testUpdate() throws FormulaAlreadyExsist {
        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";
        formulas.add(name1, formule1);
        formulas.add(name2, formule2);

        //caso formula già presente
        FormulaAlreadyExsist assertThrows = assertThrows(FormulaAlreadyExsist.class, () -> formulas.update(name1, formule2));
        assertEquals("Formule: " + formule2 + " already exsist!", assertThrows.getMessage());

        //caso formula non presente
        String newFormule = "a*b*c";
        boolean status = formulas.update(name1, newFormule);
        assertEquals(true, status);
        assertEquals(newFormule, formulas.get(name1));

    }

    /**
     * Test of save and reaload methods, of class Formules.
     */
    @Test
    public void testSaveReload() throws IOException, FileNotFoundException, ClassNotFoundException, FormulaAlreadyExsist {

        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";

        String path = "formules.dat";

        formulas.add(name1, formule1);
        formulas.add(name2, formule2);
        formulas.save(path);

        //verifico che il file è stato creato
        File file = new File(path);
        // assertEquals(true, file.exists());
        formulas.reaload(path);
        assertEquals(formule1, formulas.get(name1));
        assertEquals(formule2, formulas.get(name2));

    }

    /**
     * Test of add method, of class Formules.
     */
    @Test
    public void testAdd() throws FormulaAlreadyExsist {

        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";
        boolean status;

        //caso formula non presente
        status = formulas.add(name1, formule1);
        assertEquals(true, status);
        assertEquals(formule1, formulas.get(name1));
        status = formulas.add(name2, formule2);
        assertEquals(true, status);
        assertEquals(formule2, formulas.get(name2));

        //caso formula presente
        FormulaAlreadyExsist assertThrows = assertThrows(FormulaAlreadyExsist.class, () -> formulas.add("newName", formule2));
        assertEquals("Formule: " + formule2 + " already exsist!", assertThrows.getMessage());

        //caso nome già presente
        status = formulas.add(name1, formule2);
        assertEquals(false, status);
        assertEquals(formule1, formulas.get(name1));

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

    /**
     * Test of clear method, of class Formules.
     */
    @Test
    public void testClear() throws FormulaAlreadyExsist, IOException {
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

}
