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

    public StackLogic<ComplexNumber> getStack() {
        return stack;
    }
    
    /**
     * Questo metodo inserisce un numero complesso nello stack della classe Calculator
     * @param c 
     */
    public void insert(ComplexNumber c){
        stack.push(c);
        
    }
    
    
    
    /**
     * Questo metodo calcola la somma di due numeri complessi prelevati da
     * uno stack.
     * @return ComplexNumber
     * @throws StackEmptyException 
     */
    
    public ComplexNumber sum() throws StackEmptyException{
        ComplexNumber c1=stack.pop();
        ComplexNumber c2=stack.pop();
        ComplexNumber result=ComplexNumber.add(c1, c2);
        insert(result);
        return result;
    }
    
    /**
     *Questo metodo calcola la sottrazione fra gli ultimi due numeri complessi presenti nello stack.
     * @return ComplexNumber
     * @throws StackEmptyException
    */
    public ComplexNumber sub() throws StackEmptyException{  
        ComplexNumber c1=stack.pop();
        ComplexNumber c2=stack.pop();
        ComplexNumber subResult=ComplexNumber.subtract(c2, c1);
        insert(subResult);
        
        return subResult; 
    }
    
    public ComplexNumber divide(){
        return null;
    }
    
    /**
     * Questo metodo calcola il prodotto di due numeri complessi prelevati
     * da uno stack
     * @return ComplexNumber
     * @throws StackEmptyException 
     */
    
    public ComplexNumber prod() throws StackEmptyException{
        ComplexNumber c1=stack.pop();
        ComplexNumber c2=stack.pop();
        ComplexNumber result=ComplexNumber.multiply(c1, c2);
        insert(result);
        return result;
        
    }
    
    /**
     *Questo metodo calcola la radice quadrata fra gli ultimi due numeri complessi presenti nello stack.
     * @return ComplexNumber
     * @throws StackEmptyException
    */
    public ComplexNumber squareRoot() throws StackEmptyException{
        ComplexNumber c1= stack.pop(); 
        ComplexNumber result=c1.sqrt();
        insert(result);
        return result;
    }
    
    public ComplexNumber invertSign(){
        return null;
    }
    
    public ComplexNumber execOperation(String op) throws StackEmptyException{
        switch(op){
            case "+":
                return sum();
             
            case "-":
                return sub();
            
            case ":":
                return divide();
            
            case "x":
                return prod();
            
            case "sqrt":
                return squareRoot();
            
            case "+-":
                return invertSign();
            
            default: 
                return null;
            
        }
        
        
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
    
 
}
