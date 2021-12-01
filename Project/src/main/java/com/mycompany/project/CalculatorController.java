/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author Dario
 */
public class CalculatorController {

    private Calculator calculator;
    private String lastOperation;
    private VariablesSpace vs;

    public CalculatorController(StackLogic<ComplexNumber> stack) {
        calculator = new Calculator(stack);
        vs = new VariablesSpace();

    }

    public boolean insert(String complex) {
        ComplexNumber cn = null;
        try {
            cn = ComplexNumber.parseComplex(complex);
        } catch (NumberFormatException ex) {
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
            execOperation(f);
        }
    }

}
