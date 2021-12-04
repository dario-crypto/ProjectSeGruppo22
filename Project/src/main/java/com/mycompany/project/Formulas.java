/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Dario
 */
public class Formulas {

    private TreeMap<String, String> formulaMap;

    public Formulas() {
        formulaMap = new TreeMap<>();
    }

    /**
     * Saves all formulas in a file
     *
     * @param path string representing path file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void save(String path) throws FileNotFoundException, IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))) {
            os.writeObject(formulaMap);

        }

    }

    /**
     * Returns a map representing formulas
     *
     * @return map representing formulas
     */
    public TreeMap<String, String> getMap() {
        return formulaMap;
    }

    /**
     * Returns the formula by name
     *
     * @param name a string representing the name of the formula
     * @return a string representing the formula
     */
    public String get(String name) {
        return formulaMap.get(name);

    }

    /**
     * Change the name of a formula
     *
     * @param oldName string representing the old name of the formula
     * @param newName string representing the new name of the formula
     * @return false if the operation is unsuccessful, otherwise it returns true
     */
    public boolean rename(String oldName, String newName) {
        if (formulaMap.containsKey(oldName) && !formulaMap.containsKey(newName)) {
            String formule = formulaMap.get(oldName);
            formulaMap.remove(oldName);
            return formulaMap.put(newName, formule) == null;
        }

        return false;
    }

    /**
     * Change an existing formula
     *
     * @param name string representing the name of the formula change
     * @param newFormula string representing new formula
     * @return false if the operation is unsuccessful, otherwise it returns true
     * @throws FormulaAlreadyExsist if newFormule is already present
     */
    public boolean update(String name, String newFormula) throws FormulaAlreadyExsist {

        boolean status = false;
        if (formulaMap.containsKey(name)) {
            if (!checkFormule(newFormula)) {
                throw new FormulaAlreadyExsist("Formule: " + newFormula + " already exsist!");
            }
            status = formulaMap.put(name, newFormula) != null;
        }
        return status;

    }

    /**
     * Load formulas from a file specified by path
     *
     * @param path string representing the path of file
     * @return map that represents the formulas loaded from the file
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public TreeMap<String, String> reaload(String path) throws FileNotFoundException, IOException, ClassNotFoundException {

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
            formulaMap = (TreeMap<String, String>) is.readObject();

        }
        return formulaMap;
    }

    /**
     * Check if a formula is already present
     *
     * @param formula string representing the formula to check
     * @return true if the formula does not exist, otherwise it returns false
     */
    private boolean checkFormule(String formula) {
        ArrayList<String> array = new ArrayList<>(formulaMap.values());

        for (int i = 0; i < array.size(); i++) {
            if (formula.equals(array.get(i))) {
                return false;
            }
        }

        return true;

    }

    /**
     * Add a new formula
     *
     * @param name string representing the name of formula
     * @param formule string representing the formule
     * @return false if the operation is unsuccessful, otherwise it returns true
     * @throws FormulaAlreadyExsist if formula is already present
     */
    public void add(String name, String formule) throws FormulaAlreadyExsist, NameFormulaAlreadyExsist {
      
        if (!checkFormule(formule)) {
            throw new FormulaAlreadyExsist("Formula: " + formule + " already exsist!");
        } else {

            //modifica formula
            if (formulaMap.containsKey(name)) {
                throw new NameFormulaAlreadyExsist("Name: " + name + " already exist!",name,formule);
            } else {

                formulaMap.put(name, formule);
            }

        }

    }

    /**
     * Delete a formule by name
     *
     * @param name string representing the formule
     * @return false if the operation is unsuccessful, otherwise it returns true
     */
    public boolean delete(String name) {

        return formulaMap.remove(name) != null;

    }

    /**
     * Returns the number of formulas
     *
     * @return
     */
    public int size() {
        return formulaMap.size();
    }

    /**
     * Delete all formulas
     *
     * @throws IOException
     */
    public void clear() throws IOException {
        formulaMap.clear();

    }

    /**
     * Returns string representing the formulas
     *
     * @return string representing the formulas
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        formulaMap.forEach((name, formule) -> sb.append(name).append("\t").append(formule).append("\n"));
        return sb.toString();
    }

    boolean contains(String f) {
        return formulaMap.get(f) != null;
    }

}
