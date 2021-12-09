/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.model;

import com.mycompany.project.exception.StackEmptyException;
import com.mycompany.project.model.StackLogic;

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

    public void setStack(StackLogic<ComplexNumber> stack) {
        this.stack = stack;
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

    /**
     * This method removes all of the items of the Calculator's stack
     *
     * @throws StackEmptyException
     */
    public void clear() throws StackEmptyException {
        stack.clear();

    }

    public void drop() throws StackEmptyException {
        ComplexNumber c = stack.pop();

    }

    /**
     * This method pushes a copy of the last element
     *
     * @throws StackEmptyException
     */
    public void dup() throws StackEmptyException {
        ComplexNumber c = stack.pop();
        stack.push(c);
        stack.push(c);
    }

    /**
     * This method exchanges the last two items of the Calculator's stack
     *
     * @throws StackEmptyException
     */
    public void swap() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber c2 = stack.pop();
        stack.push(c1);
        stack.push(c2);

    }

    /**
     * This method pushes a copy of the second last element
     *
     * @throws StackEmptyException
     */
    public void over() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber c2 = stack.top();
        insert(c1);
        insert(c2);
    }

    /**
     * This method takes the top element from the stack and saves it into the
     * variable
     *
     * @param name
     * @param vs
     * @throws StackEmptyException
     */
    public void saveToVariable(String name, VariablesSpace vs) throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        boolean update = vs.update(name, c1);
    }

    /**
     * This method takes the value of a variable and inserts it into the
     * Calculator's stack
     *
     * @param name
     */
    public void saveToStack(String name, VariablesSpace vs) {
        ComplexNumber c = vs.get(name);
        stack.push(c);

    }

    /**
     * This method takes the top element from the stack and adds it to the value
     * of the variable
     *
     * @param name
     * @param vs
     * @throws StackEmptyException
     */
    public void addToVariable(String name, VariablesSpace vs) throws StackEmptyException {
        ComplexNumber c1 = vs.get(name);
        ComplexNumber c2 = stack.pop();
        ComplexNumber result = ComplexNumber.add(c1, c2);
        boolean update = vs.update(name, result);

    }

    /**
     * This method takes the top element from the stack and subtracts it from
     * the value of the variable "x"
     *
     * @param name
     * @param vs
     * @throws StackEmptyException
     */
    public void subToVariable(String name, VariablesSpace vs) throws StackEmptyException {
        ComplexNumber c1 = vs.get(name);
        ComplexNumber c2 = stack.pop();
        ComplexNumber result = ComplexNumber.subtract(c1, c2);
        boolean update = vs.update(name, result);

    }

    /**
     * This method calculates the modulus of a complex number
     *
     * @return Double
     * @throws StackEmptyException
     */
    public ComplexNumber mod() throws StackEmptyException {
        ComplexNumber c = stack.pop();
        Double result = c.mod();
        ComplexNumber resultCN = ComplexNumber.parseComplex(result.toString());
        insert(resultCN);
        return resultCN;
    }

    /**
     * This method calculates the exponential of a complex number
     *
     * @return
     * @throws StackEmptyException
     */
    public ComplexNumber exp() throws StackEmptyException {
        ComplexNumber c = stack.pop();
        ComplexNumber result = ComplexNumber.exp(c);
        insert(result);
        return result;

    }

    /**
     * This method calculates the logarithm of the last  item of the Calculator's stack
     *
     * @return
     * @throws StackEmptyException
     */
    public ComplexNumber logarithm() throws StackEmptyException {
        ComplexNumber c = stack.pop();
        ComplexNumber result = c.logarithm();
        insert(result);
        return result;
    }

    /**
     * This method calculates the argument of a complex number
     *
     * @return
     * @throws StackEmptyException
     */
    public ComplexNumber arg() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber argument = new ComplexNumber(c1.getArg(), 0);
        insert(argument);
        return argument;
    }

    /**
     * This method calculates the sine of a complex number
     *
     * @return
     * @throws StackEmptyException
     */
    public ComplexNumber sen() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber s = c1.sen(c1);
        insert(s);
        return s;
    }

    /**
     * This method calculates the cosine of a complex number
     *
     * @return
     * @throws StackEmptyException
     */
    public ComplexNumber cosen() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber s = c1.cosen(c1);
        insert(s);
        return s;
    }

    /**
     * This method calculates the tangent of a complex number
     *
     * @return
     * @throws StackEmptyException
     */
    public ComplexNumber tan() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber s = c1.tang(c1);
        insert(s);
        return s;
    }
    
     /**
     * This method calculates the arcosine of a complex number
     *
     * @return asen
     * @throws StackEmptyException
     */
    public ComplexNumber asen() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber asen = new ComplexNumber(c1.asen(c1), 0);
        insert(asen);
        return asen;
    }
       
    /**
     * This method calculates the arcocosine of a complex number
     *
     * @return acosen
     * @throws StackEmptyException
     */
    public ComplexNumber acosen() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber acosen = new ComplexNumber(c1.acosen(c1), 0);
        insert(acosen);
        return acosen;
    }
    
    /**
     * This method calculates the arcotangent of a complex number
     *
     * @return atangent
     * @throws StackEmptyException
     */
    public ComplexNumber atang() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber atangent = new ComplexNumber(c1.atang(c1), 0);
        insert(atangent);
        return atangent;
    }
    
    /**
     * This method calculates the pow of a complex number
     * @return
     * @throws StackEmptyException 
     */
    
    public ComplexNumber pow() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber c2 = stack.pop();
        ComplexNumber result = ComplexNumber.pow(c2, c1);
        insert(result);
        return result;
    }

}
