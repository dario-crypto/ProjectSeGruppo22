/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import java.util.ArrayList;
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
    private ArrayList<String> availableOp;

    public CalculatorController(StackLogic<ComplexNumber> stack) {
        calculator = new Calculator(stack);
        vs = new VariablesSpace();
        formulas = new Formulas();
        availableOp = new ArrayList<>();
        availableOp.add("+");
        availableOp.add("-");
        availableOp.add(":");
        availableOp.add("x");
        availableOp.add("sqrt");
        availableOp.add("+-");
        availableOp.add("swap");
        availableOp.add("dup");
        availableOp.add("over");
        availableOp.add("drop");
        availableOp.add("clear");

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

    /**
     * This method takes as input a string that indicates which operation the
     * calculator needs to compute. It returns the result of the correct
     * operation.
     *
     * @param op
     * @return boolean
     * @throws StackEmptyException
     * @throws OperationDoesNotExist
     */
    public boolean execOperation(String op) throws StackEmptyException, OperationDoesNotExist {
        if (op == null) {
            throw new OperationDoesNotExist("Invalid Operation!");
        }
        switch (op) {
            case "+":
                return sum();

            case "-":
                return sub();

            case ":":
                return divide();

            case "x":
                return prod();

            case "sqrt":
                calculator.squareRoot();
                return true;

            case "+-":
                calculator.invertSign();
                return true;

            case "swap":
                calculator.swap();
                return true;

            case "dup":
                calculator.dup();
                return true;

            case "over":
                calculator.over();
                return true;

            case "drop":
                calculator.drop();
                return true;

            default:
                throw new OperationDoesNotExist("Operation: " + op + " doesn't exist!");
        }
    }

    public boolean sum() throws StackEmptyException {
        if (calculator.getStack().getSize() > 1) {
            calculator.sum();
            return true;
        }
        return false;
    }

    public boolean sub() throws StackEmptyException {
        if (calculator.getStack().getSize() > 1) {
            calculator.sub();
            return true;
        }
        return false;
    }

    public boolean prod() throws StackEmptyException {
        if (calculator.getStack().getSize() > 1) {
            calculator.prod();
            return true;
        }
        return false;
    }

    public boolean divide() throws StackEmptyException {
        if (calculator.getStack().getSize() > 1) {
            calculator.divide();
            return true;
        }
        return false;
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

    public boolean swap() throws StackEmptyException {
        if (calculator.getStack().getSize() > 1) {
            calculator.swap();
            return true;
        }
        return false;

    }

    public boolean over() throws StackEmptyException {
        if (calculator.getStack().getSize() > 1) {
            calculator.over();
            return true;
        }
        return false;
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

            if (formulas.contains(f)) {
                String form = formulas.get(f);
                executeFormula(form);

            } else {

                execOperation(f);

            }
        }
    }

    public boolean isOperationVariable(String op) {
        Pattern pattern = Pattern.compile("^[< \\+ \\- >]{1}[a-z]{1}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(op);
        return matcher.find();
    }
    
    /*
    
   
     public boolean checkFormula(String formula) {
        Pattern pattern = Pattern.compile("^[< \\+ \\- >]{1}[a-z]{1}$", Pattern.CASE_INSENSITIVE);
        String[] formulaSplit = formula.split("\\s+");

        for (String op : formulaSplit) {

            if (availableOp.contains(op)) {
                continue;
            } else {
                Matcher matcher = pattern.matcher(op);
                if (!matcher.find()) {
                    return false;
                }

            }

        }

        return true;
    }
*/

    public boolean isFormula(String formula) {
        String[] formulaSplit = formula.split("\\s+");

        for (String op : formulaSplit) {
            if (!availableOp.contains(op) && !isOperationVariable(op)) {
                return false;
            }

        }
        return true;
    }
    
    public boolean addFormula(String formula) throws FormulaAlreadyExsist, FormatFormulaException {
        String[] formulaSplit = formula.split("=");
        if (formulaSplit.length == 2) {

            String name = formulaSplit[0].replaceAll("\\s+", "");
            String form = formulaSplit[1].trim();
            if (isFormula(form) & !isFormula(name)) { 

                if (formulas.add(name, form)) {
                    availableOp.add(name);
                    return true;
                }
            } else {
                throw new FormatFormulaException("Not Valid Formula!");
            }
        } else {
            throw new FormatFormulaException("Not Valid Formula!");

        }
        return false;
    }

    public TreeMap<String, String> getMapFormulas() {
        return formulas.getMap();
    }
    
    
    
    

}
