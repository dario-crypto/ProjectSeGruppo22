/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.model;

import com.mycompany.project.exception.NameFormulaAlreadyExsist;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

/**
 * This class represents the set of all the formulas and the operation we can do on them
 * @author Dario
 */
public class Formulas {

    private TreeMap<String, String> formulaMap;
    private final String path = "formulas.dat";
    
    /**
     * This method is the constructor of the Formulas class
     */

    public Formulas() {
        formulaMap = new TreeMap<>();
    }

    /**
     * This method saves all formulas in a file
     *
     * @param path string representing path file
     * @throws FileNotFoundException if it is not able to find the file
     * @throws IOException when any kind of IOException occurs
     */
    public void save() throws FileNotFoundException, IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))) {
            os.writeObject(formulaMap);

        }

    }

    /**
     * This method returns a map representing formulas
     *
     * @return map representing formulas
     */
    public TreeMap<String, String> getMap() {
        return formulaMap;
    }

    /**
     * This method returns the formula by name
     *
     * @param name a string representing the name of the formula
     * @return a string representing the formula
     */
    public String get(String name) {
        return formulaMap.get(name);

    }

    /**
     * This method changes the name of a formula
     *
     * @param oldName string representing the old name of the formula
     * @param newName string representing the new name of the formula
     */
    public void rename(String oldName, String newName) throws NameFormulaAlreadyExsist {
        if (!formulaMap.containsKey(newName)) {
            String formule = formulaMap.get(oldName);
            if (formule != null) {
                formulaMap.remove(oldName);
                formulaMap.put(newName, formule);
            }
        } else {
            throw new NameFormulaAlreadyExsist("New name "+newName+ " already exist!", newName, null);
        }

    }

    /**
     * This method changes an existing formula
     *
     * @param name string representing the name of the formula change
     * @param newFormula string representing a new formula
     * @return false if the operation is unsuccessful, otherwise it returns true
     * @throws FormulaAlreadyExsist if newFormule is already present
     */
    public boolean update(String name, String newFormula) {

        boolean status = false;
        if (formulaMap.containsKey(name)) {

            status = formulaMap.put(name, newFormula) != null;
        }
        return status;

    }

    /**
     * This method loads formulas from a file with a specified by path
     *
     * @param path string representing the path of file
     * @return map that represents the formulas loaded from the file
     * @throws FileNotFoundException if it is not able to find the file
     * @throws IOException when any kind of IOException occurs
     * @throws ClassNotFoundException when it the class does not exist
     */
    public TreeMap<String, String> reaload() throws FileNotFoundException, IOException, ClassNotFoundException {

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
            formulaMap = (TreeMap<String, String>) is.readObject();

        }
        return formulaMap;
    }

    /**
     * This method adds a new formula
     *
     * @param name string representing the name of formula
     * @param formule string representing the formule
     * @return false if the operation is unsuccessful, otherwise it returns true
     * @throws FormulaAlreadyExsist if formula is already present
     */
    public void add(String name, String formule) throws NameFormulaAlreadyExsist {

        if (formulaMap.containsKey(name)) {
            throw new NameFormulaAlreadyExsist("Name: " + name + " already exsist!", name, formule);
        } else {

            formulaMap.put(name, formule);
        }

    }

    /**
     * This method deletes a formule by name
     *
     * @param name string representing the formule
     * @return false if the operation is unsuccessful, otherwise it returns true
     */
    public boolean delete(String name) {

        return formulaMap.remove(name) != null;

    }

    /**
     * This method returns the number of formulas
     *
     * @return
     */
    public int size() {
        return formulaMap.size();
    }

    /**
     * This method deletes all formulas
     *
     * @throws IOException when any kind of IOException occurs
     */
    public void clear() throws IOException {
        formulaMap.clear();

    }

    /**
     * This method returns a string representing the formulas
     *
     * @return string representing the formulas
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        formulaMap.forEach((name, formule) -> sb.append(name).append("\t").append(formule).append("\n"));
        return sb.toString();
    }

    /**
     * This method returns true if the name of the formula already exists
     *
     * @param name represents the name of the formula
     * @return true if the name already exists,otherwise false
     */
    public boolean contains(String name) {
        return formulaMap.get(name) != null;
    }
    


}
