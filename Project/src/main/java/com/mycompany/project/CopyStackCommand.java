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
public class CopyStackCommand implements Command{
private Calculator calculator;
private Stack<ComplexNumber> backup;
    
    public CopyStackCommand(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public void exec() {
        backup = new Stack();
        for(ComplexNumber cn : calculator.getStack()){
            backup.push((ComplexNumber) cn.clone());
        }
        
        
    }

    @Override
    public void undo() {

        calculator.setStack(backup);
        
    }
    
}
