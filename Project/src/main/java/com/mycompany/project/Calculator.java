/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author dilet
 */
public class Calculator {
    private StackLogic<ComplexNumber> stack;
    private VariablesSpace variablesSpace;
    
    public Calculator(StackLogic stack){
        this.stack=stack;
        //this.variablesSpace=variablesSpace;
    }
    
    public void insert(ComplexNumber c){
        stack.push(c);
        
    }
    
    public ComplexNumber sum(){
        return null;
    }
    
    public ComplexNumber sub(){
        return null;
    }
    
    public ComplexNumber divide(){
        return null;
    }
    
    public ComplexNumber prod(){
        return null;
    }
    
    public ComplexNumber square(){
        return null;
    }
    
    public ComplexNumber invertSign(){
        return null;
    }
    
    public ComplexNumber execOperation(String op){
        return null;
    }
    
    public void clear(){
        
    }
    
    public void drop(){
        
    }
    
    public void dup(){
        
    }
    
    public void swap(){
        
    }
    
    public void over(){
        
    }
    
    public void saveToVariable(String name){
        
    }
    
    public void saveToStack(String name){
        
    }
    
    public void addToVariable(String name){
        
    }
    
    public void subToVariable(String name){
        
    }
    
    public String stringStack(){
        StringBuilder sb = new StringBuilder();
        for(ComplexNumber c: stack){
            sb.append(c);
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public ComplexNumber topStack(){
        return stack.top();
    }
    
    public StackLogic<ComplexNumber> getStack(){
        return stack;
    }
}
