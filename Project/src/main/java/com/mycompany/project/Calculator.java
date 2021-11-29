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

    public Calculator(StackLogic stack) {
        this.stack = stack;
        //this.variablesSpace=variablesSpace;
    }

    /**
     * This method is used to get the Calculator's attribute stack
     *
     * @return StackLogic<ComplexNumber>
     */
    public StackLogic<ComplexNumber> getStack() {
        return stack;
    }

    /**
     * This method is used to insert a ComplexNumber in the Calculator's stack
     *
     * @param c
     */
    public void insert(ComplexNumber c) {
        stack.push(c);

    }

    /**
     * This method calculates the sum of the last two elements of the
     * Calculator's stack
     *
     * @return ComplexNumber
     * @throws StackEmptyException
     */
    public ComplexNumber sum() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber c2 = stack.pop();
        ComplexNumber result = ComplexNumber.add(c1, c2);
        insert(result);
        return result;
    }

    /**
     * This method calculates the substraction of the last two elements of the
     * Calculator's stack
     *
     * @return ComplexNumber
     * @throws StackEmptyException
     */
    public ComplexNumber sub() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber c2 = stack.pop();
        ComplexNumber subResult = ComplexNumber.subtract(c2, c1);
        insert(subResult);

        return subResult;
    }

     /**
     * This method calculates the division of the last two elements of the
     * Calculator's stack
     *
     * @return ComplexNumber
     * @throws StackEmptyException
     */
    public ComplexNumber divide() throws StackEmptyException {
        ComplexNumber divider = stack.pop();
        ComplexNumber dividend = stack.pop();
        ComplexNumber result = ComplexNumber.divide(dividend, divider);
        insert(result);
        return result;
    }

    /**
     * This method calculates the product of the last two elements of the
     * Calculator's stack
     *
     * @return ComplexNumber
     * @throws StackEmptyException
     */
    public ComplexNumber prod() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber c2 = stack.pop();
        ComplexNumber result = ComplexNumber.multiply(c1, c2);
        insert(result);
        return result;

    }

    /**
     * This method calculates the square root of the last element of the
     * Calculator's stack
     *
     * @return ComplexNumber
     * @throws StackEmptyException
     */
    public ComplexNumber squareRoot() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber result = c1.sqrt();
        insert(result);
        return result;
    }

    public ComplexNumber invertSign() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        c1.invertSign();
        stack.push(c1);
        return c1;
    }

    public void clear() throws StackEmptyException {
        stack.clear();

    }

    public void drop() throws StackEmptyException {
       ComplexNumber c = stack.pop();
       
 }

    public void dup() {

    }

    public void swap() throws StackEmptyException{
        ComplexNumber c1=stack.pop();
        ComplexNumber c2=stack.pop();
        stack.push(c2);
        stack.push(c1);

    }

    public void over() {

    }

    public void saveToVariable(String name) {

    }

    public void saveToStack(String name) {

    }

    public void addToVariable(String name) {

    }

    public void subToVariable(String name) {

    }

}
