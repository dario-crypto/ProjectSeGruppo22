/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.model;

import com.mycompany.project.model.ComplexNumber;
import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author dilet
 */
public class VariablesSpace {

    private HashMap<String, ComplexNumber> variablesMap;

    public VariablesSpace() {
        variablesMap = new HashMap<>();
        initSpace();

    }

    public void setVariablesMap(HashMap<String, ComplexNumber> variablesMap) {
        this.variablesMap = variablesMap;

    }

    private void initSpace() {

        for (int i = 97; i < 123; i++) {

            char variable = (char) i;
            variablesMap.put(String.valueOf(variable), new ComplexNumber());
        }

    }

    public boolean update(String variable, ComplexNumber cn) {

        if (variablesMap.containsKey(variable)) {
            return variablesMap.put(variable, cn) != null;

        } else {
            return false;
        }
    }

    public ComplexNumber get(String name) {

        return variablesMap.get(name);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

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

    public HashMap<String, ComplexNumber> getVariablesMap() {
        return variablesMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        variablesMap.forEach((name, complex) -> sb.append(name).append("\t").append(complex).append("\n"));
        return sb.toString();

    }

}
