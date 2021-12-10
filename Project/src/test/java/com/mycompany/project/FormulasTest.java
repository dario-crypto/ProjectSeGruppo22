package com.mycompany.project;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */


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
    public void testGet() throws NameFormulaAlreadyExsist {

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
    public void testRename() throws NameFormulaAlreadyExsist {
        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";
        formulas.add(name1, formule1);
        formulas.add(name2, formule2);

        //vecchio nome presente e nuovo nome non presente
        formulas.rename(name1, "Delta2");
        assertEquals(null, formulas.get(name1));
        assertEquals(formulas.get("Delta2"), formule1);

        //casi in cui l'operazione non viene eseguita
        //vecchio nome non presente nuovo nome presente
        NameFormulaAlreadyExsist assertThrows = assertThrows(NameFormulaAlreadyExsist.class, () -> formulas.rename("name1", "Delta2"));
        assertEquals("New name Delta2 already exist!", assertThrows.getMessage());
        //vecchio nome presente e nuovo nome presente
        NameFormulaAlreadyExsist assertThrows2 = assertThrows(NameFormulaAlreadyExsist.class, () -> formulas.rename(name2, "Delta2"));
        assertEquals("New name Delta2 already exist!", assertThrows2.getMessage());
        //vecchio nome non presente e nuovo nome non presente
        formulas.rename("name1", "name2");
        assertEquals(null, formulas.get("name2"));
    }

    /**
     * Test of update method, of class Formules.
     */
    @Test
    public void testUpdate() throws NameFormulaAlreadyExsist {
        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";
        formulas.add(name1, formule1);
        formulas.add(name2, formule2);

        String newFormula = "a*b*c";
        //caso nome formula presente
        boolean status = formulas.update(name1, newFormula);
        assertEquals(true, status);
        assertEquals(newFormula, formulas.get(name1));

        //caso nome formula non presente
        status = formulas.update("hyp", newFormula);
        assertEquals(false, status);
        assertEquals(null, formulas.get("hyp"));
    }

    /**
     * Test of save and reaload methods, of class Formules.
     */
    @Test
    public void testSaveReload() throws IOException, FileNotFoundException, ClassNotFoundException, NameFormulaAlreadyExsist {

        String name1 = "Delta";
        String formule1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formule2 = "sqrt(a*a+b*b)";

        String path = "formules.dat";

        formulas.add(name1, formule1);
        formulas.add(name2, formule2);
        formulas.save();

        //verifico che il file è stato creato
        File file = new File(path);
        // assertEquals(true, file.exists());
        formulas.reaload();
        assertEquals(formule1, formulas.get(name1));
        assertEquals(formule2, formulas.get(name2));

    }

    /**
     * Test of add method, of class Formules.
     */
    @Test
    public void testAdd() throws NameFormulaAlreadyExsist {

        String name1 = "Delta";
        String formula1 = "sqrt(b*b -4*a*c)";
        String name2 = "Pitagora";
        String formula2 = "sqrt(a*a+b*b)";
        boolean status;

        //caso nome non presente
        formulas.add(name2, formula2);
        assertEquals(formula2, formulas.get(name2));
        formulas.add(name1, formula1);
        assertEquals(formula1, formulas.get(name1));

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

    /**
     * Test of clear method, of class Formules.
     */
    @Test
    public void testClear() throws IOException, NameFormulaAlreadyExsist {
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
