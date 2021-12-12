/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.exception;

/**
 * This class represents the exception that is thrown when you want to insert a formula with a name already used
 * @author immacolata
 */
public class NameFormulaAlreadyExists extends Exception {
    String name;
    String formula;
    
    
    

    /**
     * This is the constructor pf the class NameFormulaAlreadyExists
     * @param message the message the user needs to see to understand the exception
     * @param name the name of the formula
     * @param formula  the formula
     */
    public NameFormulaAlreadyExists(String message,String name,String formula){
       super(message);
       this.name = name;
       this.formula = formula;
    }
    

    /**
     * This method returns the formula
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * This method returns the formula
     * @return formula
     */
    public String getFormula(){
        return formula;
    }
    
    
}
