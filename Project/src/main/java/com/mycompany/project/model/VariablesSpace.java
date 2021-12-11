/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.model;

import com.mycompany.project.model.ComplexNumber;
import java.util.HashMap;
import java.util.Objects;

/**
 * This class represents the space of the variables
 * @author dilet
 */
public class VariablesSpace {

    private HashMap<String, ComplexNumber> variablesMap;
    
    /**
     * This method is the constructor of the VariablesSpace class
     */

    public VariablesSpace() {
        variablesMap = new HashMap<>();
        initSpace();

    }
    
    /**
     * This method sets the variablesMap with the given map
     * @param variablesMap the given map
     */

    public void setVariablesMap(HashMap<String, ComplexNumber> variablesMap) {
        this.variablesMap = variablesMap;

    }
    
    /**
     * This method sets all the variables value to 0
     */

    private void initSpace() {

        for (int i = 97; i < 123; i++) {

            char variable = (char) i;
            variablesMap.put(String.valueOf(variable), new ComplexNumber());
        }

    }
    
    /**
     * This method updates the value of a variable
     * @param variable that represents the variable to update
     * @param cn that represents the new value
     * @return true if the operation was successful, otherwise false
     */
    public boolean update(String variable, ComplexNumber cn) {

        if (variablesMap.containsKey(variable)) {
            return variablesMap.put(variable, cn) != null;

        } else {
            return false;
        }
    }
    
    /**
     * This method returns the value of the given variable
     * @param name of the variable
     * @return its value
     */

    public ComplexNumber get(String name) {

        return variablesMap.get(name);

    }
    
    /**
     * This is the hashCode method for the VariablesSpace class
     * @return the hash value 
     */

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    /**
     * This is the method equals of the class VariablesSpace
     * @param obj that represents the object that we want to compare to another VariablesSpace's object
     * @return true if they are equals,otherwise false
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VariablesSpace other = (VariablesSpace) obj;
        return Objects.equals(this.variablesMap, other.variablesMap);
    }
    
    /**
     * This method returns the variableMap
     * @return the variablesMap
     */

    public HashMap<String, ComplexNumber> getVariablesMap() {
        return variablesMap;
    }
    
    /**
     * This method converts into a string the variablesMap
     * @return a string that represents the variablesMap
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        variablesMap.forEach((name, complex) -> sb.append(name).append("\t").append(complex).append("\n"));
        return sb.toString();

    }

}
