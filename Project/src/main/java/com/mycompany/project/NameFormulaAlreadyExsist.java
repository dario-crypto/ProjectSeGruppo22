/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

/**
 *
 * @author user
 */
public class NameFormulaAlreadyExsist extends Exception {
    String name;
    String formula;
    
    public NameFormulaAlreadyExsist(String message,String name,String formula){
       super(message);
       this.name = name;
       this.formula = formula;
    }
    
    public String getName(){
        return name;
    }
    
    public String getFormula(){
        return formula;
    }
    
    
}
