/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.model;

import com.mycompany.project.exception.StackEmptyException;
import com.mycompany.project.model.StackLogic;
import java.util.Objects;

/**
 * This class represents the Calculator and all its funcionalities
 * @author dilet
 */
public class Calculator {
   

    private StackLogic<ComplexNumber> stack;
    private VariablesSpace variablesSpace;
    
    /**
     * This method is the constructor of the Calculator class
     */

    public Calculator(StackLogic stack) {
        this.stack = stack;
        
    }
    
    /**
     * This method sets the stack of the Calculator with the input stack
     * @param stack the new stack of the calculator
     */

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
     * @param c is the number that needs to be inserted
     */
    public void insert(ComplexNumber c) {
        stack.push(c);

    }

    /**
     * This method calculates the sum of the last two elements of the
     * Calculator's stack
     *
     * @return ComplexNumber that is the sum of the two last elements of the stack
     * @throws StackEmptyException if the stack is empty or when there are not enough elemets to execute the operation
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
     * @return ComplexNumber that is the result of the substraction between the second-last and last elements
     * @throws StackEmptyException if the stack is empty or when there are not enough elemets to execute the operation
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
     * @return ComplexNumber that is the result of the division between the second-last and last elements
     * @throws StackEmptyException if the stack is empty or there are not enough elemets to execute the operation
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
     * @return ComplexNumber that is the product between the second-last and last elements
     * @throws StackEmptyException if the stack is empty or there are not enough elemets to execute the operation
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
     * @return ComplexNumber that is the result of the square root of the last element of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public ComplexNumber squareRoot() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber result = c1.sqrt();
        insert(result);
        return result;
    }
    
    /**
     * This method calculates the invert sign of the last element of the
     * Calculator's stack
     *
     * @return ComplexNumber that is the result of the operation invert sign of the last
     * element of the stack
     * @throws StackEmptyException if the stack is empty
     */

    public ComplexNumber invertSign() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        c1.invertSign();
        stack.push(c1);
        return c1;
    }

    /**
     * This method removes all of the items of the Calculator's stack
     *
     * @throws StackEmptyException if the stack is empty
     */
    public void clear() throws StackEmptyException {
        stack.clear();

    }
    
    /**
     * This method deletes the last element of the stack
     *
     * @throws StackEmptyException if the stack is empty
     */

    public void drop() throws StackEmptyException {
        ComplexNumber c = stack.pop();

    }

    /**
     * This method pushes a copy of the last element
     *
     * @throws StackEmptyException if the stack is empty
     */
    public void dup() throws StackEmptyException {
        ComplexNumber c = stack.pop();
        stack.push(c);
        stack.push(c);
    }

    /**
     * This method exchanges the last two items of the Calculator's stack
     *
     * @throws StackEmptyException if the stack is empty or there are not enough elemets to execute the operation
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
     * @throws StackEmptyException if the stack is empty or there are not enough
     * elemets to execute the operation
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
     * @param name that represents tha name of the variable in which the method saves the value of the last element of the 
     * stack
     * @param vs that represents the variables space
     * @throws StackEmptyException if the stack is empty
     */
    public void saveToVariable(String name, VariablesSpace vs) throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        boolean update = vs.update(name, c1);
    }

    /**
     * This method takes the value of a variable and inserts it into the
     * Calculator's stack
     *
    * @param name that represents tha name of the variable of which value the method saves on the top of the stack
     * @param vs that represents the variables space
     */
    public void saveToStack(String name, VariablesSpace vs) {
        ComplexNumber c = vs.get(name);
        stack.push(c);

    }

    /**
     * This method takes the top element from the stack and adds it to the value
     * of the variable
     *
     * @param name that represents tha name of the variable which value has to be added the value of the last element of the 
     * stack 
     * @param vs that represents the variables space
     * @throws StackEmptyException if the stack is empty
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
     * @param name that represents tha name of the variable which value has to be substructed the value of the last element of the 
     * stack 
     * @param vs that represents the variables space
     * @throws StackEmptyException if the stack is empty
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
     * @return ComplexNumber that is the modulus of the last element of the stack
     * @throws StackEmptyException if the stack is empty
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
     * @return ComplexNumber that is the exponential of the last element of the stack
     * @throws StackEmptyException if the stack is empty
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
     * @return ComplexNumber that is the natural logaritm of the last element of the stack
     * @throws StackEmptyException if the stack is empty
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
     * @return ComplexNumber that is the argument of the last element of the stack
     * @throws StackEmptyException if the stack is empty
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
     * @return ComplexNumber that is the sine of the last element of the stack
     * @throws StackEmptyException if the stack is empty
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
     * @return ComplexNumber that is the cosine of the last element of the stack
     * @throws StackEmptyException if the stack is empty
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
     * @return ComplexNumber that is the tangent of the last element of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public ComplexNumber tan() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber s = c1.tang(c1);
        insert(s);
        return s;
    }
    
     /**
     * This method calculates the asine of a complex number
     *
     * @return ComplexNumber that is the asine of the last element of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public ComplexNumber asen() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber asen = c1.asen(c1);
        insert(asen);
        return asen;
    }
       
    /**
     * This method calculates the arcocosine of a complex number
     *
     * @return ComplexNumber that is the arcocosine of the last element of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public ComplexNumber acosen() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber acosen = ComplexNumber.acosen(c1);
        insert(acosen);
        return acosen;
    }
    
    /**
     * This method calculates the arcotangent of a complex number
     *
     * @return ComplexNumber that is the arcotangent of the last element of the stack
     * @throws StackEmptyException if the stack is empty
     */
    public ComplexNumber atan() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber atangent = ComplexNumber.atan(c1);
        insert(atangent);
        return atangent;
    }
    
    /**
     * This method calculates the pow of a complex number
     * @return ComplexNumber that is the result of the substraction between the second-last and last elements
     * @throws StackEmptyException if the stack is empty or when there are not enough elemets to execute the operation
     */
    
    public ComplexNumber pow() throws StackEmptyException {
        ComplexNumber c1 = stack.pop();
        ComplexNumber c2 = stack.pop();
        ComplexNumber result = ComplexNumber.pow(c2, c1);
        insert(result);
        return result;
    }
    
    /**
     * This is the hashCode method for the Calculator's class
     * @return the hash value
     */
     @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    /**
     * This is the method equals of the class Calculator
     * @param obj that represents the object that we want to compare to another Calculator's object
     * @return true if they are equals,otherwise false
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Calculator other = (Calculator) obj;
        if (!Objects.equals(this.stack, other.stack)) {
            return false;
        }
        return true;
    }

}
