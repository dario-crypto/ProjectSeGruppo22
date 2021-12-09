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
 *
 * @author Dario
 */
public class Formulas {

    private TreeMap<String, String> formulaMap;
    private final String path = "formulas.dat";

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
    public void save() throws FileNotFoundException, IOException {
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
     */
    public void rename(String oldName, String newName) throws NameFormulaAlreadyExsist {
        if (!formulaMap.containsKey(newName)) {
            String formule = formulaMap.get(oldName);
            if (formule != null) {
                formulaMap.remove(oldName);
                formulaMap.put(newName, formule);
            }
        } else {
            throw new NameFormulaAlreadyExsist("Name already exist!", newName, null);
        }

    }

    /**
     * Change an existing formula
     *
     * @param name string representing the name of the formula change
     * @param newFormula string representing new formula
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
     * Load formulas from a file specified by path
     *
     * @param path string representing the path of file
     * @return map that represents the formulas loaded from the file
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public TreeMap<String, String> reaload() throws FileNotFoundException, IOException, ClassNotFoundException {

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
            formulaMap = (TreeMap<String, String>) is.readObject();

        }
        return formulaMap;
    }

    /**
     * Add a new formula
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

    /**
     * Restituisce true se un nome della formula è già presente
     *
     * @param name stringa che rappresenta il nome della formula
     * @return true se il nome della formula è presente, altrimenti restituisce
     * false
     */
    public boolean contains(String name) {
        return formulaMap.get(name) != null;
    }

}
