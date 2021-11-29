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

    public CalculatorController(StackLogic<ComplexNumber> stack) {
        calculator = new Calculator(stack);

    }

    public static int dimOperation(String op) {
        if (op.equals("+-") || op.equals("sqrt")) {
            return 1;
        } else {
            return 2;
        }

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

    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }

    public String getLastOperation() {
        return lastOperation;
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
     * @return ComplexNumber
     * @throws StackEmptyException
     */
    public ComplexNumber execOperation(String op) throws StackEmptyException {
        switch (op) {
            case "+":
                return calculator.sum();

            case "-":
                return calculator.sub();

            case ":":
                return calculator.divide();

            case "x":
                return calculator.prod();

            case "sqrt":
                return calculator.squareRoot();

            case "+-":
                return calculator.invertSign();

            default:
                return null;

        }

    }
    
    public void drop() throws StackEmptyException{
        calculator.drop();
 }

}
