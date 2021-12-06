/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dario
 */
public class CalculatorController {
    
    private Calculator calculator;
    private VariablesSpace vs;
    private Formulas formulas;
    
    public CalculatorController(StackLogic<ComplexNumber> stack) {
        calculator = new Calculator(stack);
        vs = new VariablesSpace();
        formulas = new Formulas();
        
    }
    
    public boolean insert(String complex) {
        ComplexNumber cn = null;
        try {
            cn = ComplexNumber.parseComplex(complex);
        } catch (Exception ex) {
            return false;
        }
        if (cn != null) {
            calculator.insert(cn);
            return true;
            
        }
        
        return false;
    }
    
    public Calculator getCalculator() {
        return this.calculator;
    }
    
    public void execOperation(String op) throws StackEmptyException, OperationDoesNotExist {
        
        if (FactoryOperator.contains(op)) {
            FactoryOperator.getOperation(op).apply(calculator);
        } else if (isOperationVariable(op)) {
            processVariableOp(op);
            
        } else {
            throw new OperationDoesNotExist("The operation: " + op + "does not exist!");
        }
        
    }
    
    public void sum() throws StackEmptyException {
        calculator.sum();
    }
    
    public void sub() throws StackEmptyException {
        calculator.sub();
        
    }
    
    public void prod() throws StackEmptyException {
        calculator.prod();
    }
    
    public void divide() throws StackEmptyException, ArithmeticException {
        
        calculator.divide();
        
    }
    
    public void squareRoot() throws StackEmptyException {
        calculator.squareRoot();
    }
    
    public void invertSign() throws StackEmptyException {
        calculator.invertSign();
    }
    
    public void clear() throws StackEmptyException {
        calculator.clear();
    }
    
    public void drop() throws StackEmptyException {
        calculator.drop();
    }
    
    public void dup() throws StackEmptyException {
        calculator.dup();
    }
    
    public void swap() throws StackEmptyException {
        calculator.swap();
        
    }
    
    public void over() throws StackEmptyException {
        calculator.over();
        
    }
    
    public void saveToStack(String name) {
        calculator.saveToStack(name, vs);
    }
    
    public void saveToVariable(String name) throws StackEmptyException {
        calculator.saveToVariable(name, vs);
    }
    
    public void addToVariable(String name) throws StackEmptyException {
        calculator.addToVariable(name, vs);
    }
    
    public void subToVariable(String name) throws StackEmptyException {
        calculator.subToVariable(name, vs);
    }
    
    public void executeFormula(String formula) throws StackEmptyException, OperationDoesNotExist {
        String[] formulaSplit = formula.split("\\s+");
        
        for (String f : formulaSplit) {

            //caso in cui è presente una nome di una formula nella formula 
            if (formulas.contains(f)) {
                String form = formulas.get(f);
                executeFormula(form);
                
            } else {
                
                execOperation(f);
                
            }
        }
    }
    
    private boolean isOperationVariable(String op) {
        Pattern pattern = Pattern.compile("^[< \\+ \\- >]{1}[a-z]{1}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(op);
        return matcher.find();
    }
    
    private boolean isFormula(String formula) {
        String[] formulaSplit = formula.split("\\s+");
        
        for (String op : formulaSplit) {
            if (!FactoryOperator.contains(op) && !isOperationVariable(op) && !formulas.contains(op)) {
                return false;
                
            }
            
        }
        return true;
    }
    
    private boolean isName(String name) {
        return !FactoryOperator.contains(name) && !isOperationVariable(name);
    }

    //formatta correttamente una formula
    private String formulaBuilder(String formula) {
        String[] formulaSplit = formula.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String f : formulaSplit) {
            sb.append(f).append(" ");
        }
        return sb.toString().trim();
        
    }
    
    public void addFormula(String formula) throws FormulaAlreadyExsist, FormatFormulaException, NameFormulaAlreadyExsist {
        String[] formulaSplit = formula.split("=");
        if (formulaSplit.length == 2) {
            
            String name = formulaSplit[0].trim();
            String form = formulaSplit[1].trim();
            if (isFormula(form) && isName(name)) {
                form = formulaBuilder(form);
                formulas.add(name, form);
                
                return;
            }
        }
        throw new FormatFormulaException("Not Valid Formula!");
        
    }
    
    public TreeMap<String, String> getMapFormulas() {
        return formulas.getMap();
    }
    
    private void processVariableOp(String op) throws StackEmptyException {
        
        String[] opSplit = op.split("");
        String operation = opSplit[0];
        String name = opSplit[1];
        /*
        if (("<" + name).equals(op)) {
            calculator.saveToStack(name, vs);
        } else if ((">" + name).equals(op)) {
            calculator.saveToVariable(name, vs);
        } else if (("+" + name).equals(op)) {
            calculator.addToVariable(name, vs);
        } else if (("-" + name).equals(op)) {
            calculator.subToVariable(name, vs);
        }

         */
        FactoryOperator.getOperation(operation).apply(calculator, name, vs);
        
    }
    
    public boolean removeFormula(String formula) {
        String name = formula.split("=")[0].trim();
        return formulas.delete(name);
    }
    
    public void updateFormula(String name, String formula) {
        formulas.update(name, formula);
    }
    
    public void renameFormula(String oldName, String name) {
        formulas.rename(oldName, name);
    }
    
}
