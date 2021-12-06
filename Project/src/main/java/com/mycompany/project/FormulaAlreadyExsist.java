/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author Dario
 */
public class FormulaAlreadyExsist extends Exception {
    private String oldName;;
    private String name;
    
    
    public FormulaAlreadyExsist(String message,String oldName,String name){
        super(message);
        this.oldName = oldName;
        this.name = name;
    }

    public String getOldName() {
        return oldName;
    }

    public String getName() {
        return name;
    }
    
    
}
