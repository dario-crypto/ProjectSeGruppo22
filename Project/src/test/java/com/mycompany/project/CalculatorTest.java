/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.project;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dilet
 */
public class CalculatorTest {

    Calculator calculator;
    VariablesSpace vs;

    public CalculatorTest() {
    }

    @Before
    public void setUp() {
        calculator = new Calculator(new Stack<ComplexNumber>());
        vs=new VariablesSpace();
    }

    /**
     * This method tests the method insert of the class Calculator The first
     * test inserts a real number into the Calculator's stack The second test
     * inserts a complex number with real part equal to zero into the
     * Calculator's stack The first test inserts a complex number with both real
     * and imaginary parts different from zero into the Calculator's stack
     */
    @Test
    public void testInsert() {
        calculator.insert(new ComplexNumber(1, 0));
        assertEquals(new ComplexNumber(1, 0), calculator.getStack().top());
        calculator.insert(new ComplexNumber(0, -1));
        assertEquals(new ComplexNumber(0, -1), calculator.getStack().top());
        calculator.insert(new ComplexNumber(45, 64));
        assertEquals(new ComplexNumber(45, 64), calculator.getStack().top());

    }

    /**
     * This method tests the method sum of the class Calculator The first case
     * tests the sum of two real numbers The second case tests the sum of two
     * complex numbers, both with real part equal to zero The third case tests
     * the sum of two complex numbers, one with both real and imaginary part
     * different from zero, the other with the imaginary part equal to 0 The
     * fourth case tests the sum of two complex numbers, one with both real and
     * imaginary part different from zero, the other with the real part equal to
     * 0 The fifth case tests the sum of two complex numbers, both with real and
     * imaginary part different from zero
     *
     * @throws StackEmptyException
     */
    @Test
    public void testSum() throws StackEmptyException {
        //calculator=new Calculator(new Stack<ComplexNumber>());
        ComplexNumber c1 = new ComplexNumber(1, 0);
        ComplexNumber c2 = new ComplexNumber(-1, 0);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(0.0, 0.0), calculator.sum());
        ComplexNumber c3 = new ComplexNumber(0, 4);
        ComplexNumber c4 = new ComplexNumber(0, 3);
        calculator.insert(c3);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(0.0, 7.0), calculator.sum());
        ComplexNumber c5 = new ComplexNumber(1, 1);
        ComplexNumber c6 = new ComplexNumber(1, 0);
        calculator.insert(c5);
        calculator.insert(c6);
        assertEquals(new ComplexNumber(2.0, 1.0), calculator.sum());
        ComplexNumber c7 = new ComplexNumber(1, 5);
        ComplexNumber c8 = new ComplexNumber(0, 8);
        calculator.insert(c7);
        calculator.insert(c8);
        assertEquals(new ComplexNumber(1.0, 13.0), calculator.sum());
        ComplexNumber c9 = new ComplexNumber(1, 5);
        ComplexNumber c10 = new ComplexNumber(1, 8);
        calculator.insert(c9);
        calculator.insert(c10);
        assertEquals(new ComplexNumber(2.0, 13.0), calculator.sum());

    }

    /**
     * This method tests the method sub of the class Calculator The first case
     * tests the substraction of two identical real numbers,so the result must
     * be equal to 0 Il second case tests the substraction of two real
     * numbers,the minuend bigger than the subtrahend,so the result must be
     * equal to a real positive number Il third case tests the substraction of
     * two real numbers,the minuend smaller than the subtrahend,so the result
     * must be equal to a real negative number The fourth case tests the
     * substraction of two complex numbers,the minuend with both real and
     * imaginary part bigger than the subtrahend parts, so the result must have
     * both real and imaginary part equal to a negative number The fifth case
     * tests the substraction of two complex number, the minuend with real part
     * bigger than the subtrahend's real part and the subtrahend with imaginary
     * part bigger than the minuend's imaginary part, so the result must have
     * both real and imaginary part equal to a negative number
     *
     * @throws StackEmptyException
     */
    @Test
    public void testSub() throws StackEmptyException {

        ComplexNumber n1 = new ComplexNumber(2, 0);
        ComplexNumber n2 = new ComplexNumber(2, 0);
        calculator.insert(n1);
        calculator.insert(n2);
        assertEquals(new ComplexNumber(0.0, 0.0), calculator.sub());
        assertEquals(new ComplexNumber(0.0, 0.0), calculator.getStack().top());

        n1 = new ComplexNumber(4, 0);
        n2 = new ComplexNumber(2, 0);
        calculator.insert(n1);
        calculator.insert(n2);
        assertEquals(new ComplexNumber(2.0, 0.0), calculator.sub());
        assertEquals(new ComplexNumber(2.0, 0.0), calculator.getStack().top());

        n1 = new ComplexNumber(2, 0);
        n2 = new ComplexNumber(4, 0);
        calculator.insert(n1);
        calculator.insert(n2);
        assertEquals(new ComplexNumber(-2.0, 0.0), calculator.sub());
        assertEquals(new ComplexNumber(-2.0, 0.0), calculator.getStack().top());

        n1 = new ComplexNumber(2, 2);
        n2 = new ComplexNumber(4, 9);
        calculator.insert(n1);
        calculator.insert(n2);
        assertEquals(new ComplexNumber(-2.0, -7.0), calculator.sub());
        assertEquals(new ComplexNumber(-2.0, -7.0), calculator.getStack().top());

        n1 = new ComplexNumber(2, 0);
        n2 = new ComplexNumber(0, 9);
        calculator.insert(n1);
        calculator.insert(n2);
        assertEquals(new ComplexNumber(2.0, -9.0), calculator.sub());
        assertEquals(new ComplexNumber(2.0, -9.0), calculator.getStack().top());

    }

    /**
     * This method tests the method prod of the class Calculator The first case
     * tests the divion of two real numbers The second case tests the division
     * of two complex numbers, both with real part equal to zero The third case
     * tests the product of two complex numbers, one with both real and
     * imaginary part different from zero, the other with the imaginary part
     * equal to 0 The fourth case tests the product of two complex numbers, one
     * with both real and imaginary part different from zero, the other with the
     * real part equal to 0 The fifth case tests the product of two complex
     * numbers, both with real and imaginary part different from zero
     *
     * @throws StackEmptyException
     */
    @Test
    public void testProd() throws StackEmptyException {
        ComplexNumber c1 = new ComplexNumber(1, 0);
        ComplexNumber c2 = new ComplexNumber(1, 0);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(1.0, 0.0), calculator.prod());
        assertEquals(new ComplexNumber(1.0, 0.0), calculator.getStack().top());

        ComplexNumber c3 = new ComplexNumber(0, 1);
        ComplexNumber c4 = new ComplexNumber(0, 1);
        calculator.insert(c3);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(-1.0, 0.0), calculator.prod());
        assertEquals(new ComplexNumber(-1.0, 0.0), calculator.getStack().top());

        ComplexNumber c5 = new ComplexNumber(1, 1);
        ComplexNumber c6 = new ComplexNumber(2, 0);
        calculator.insert(c5);
        calculator.insert(c6);
        assertEquals(new ComplexNumber(2.0, 2.0), calculator.prod());
        assertEquals(new ComplexNumber(2.0, 2.0), calculator.getStack().top());

        ComplexNumber c7 = new ComplexNumber(1, 1);
        ComplexNumber c8 = new ComplexNumber(0, 2);
        calculator.insert(c7);
        calculator.insert(c8);
        assertEquals(new ComplexNumber(-2.0, 2.0), calculator.prod());
        assertEquals(new ComplexNumber(-2.0, 2.0), calculator.getStack().top());

        ComplexNumber c9 = new ComplexNumber(1, 1);
        ComplexNumber c10 = new ComplexNumber(2, 2);
        calculator.insert(c9);
        calculator.insert(c10);
        assertEquals(new ComplexNumber(0.0, 4.0), calculator.prod());
        assertEquals(new ComplexNumber(0.0, 4.0), calculator.getStack().top());

    }

    /**
     * This method test the method squareRoot of the class Calculator The first
     * case tests the square root of a real positive number The second case
     * tests the square root of a real negative number The third case tests the
     * square root of a complex number
     *
     * @throws StackEmptyException
     */
    @Test
    public void testSquareRoot() throws StackEmptyException {

        ComplexNumber n1 = new ComplexNumber(4, 0);
        calculator.insert(n1);
        assertEquals(new ComplexNumber(2, 0), calculator.squareRoot());
        assertEquals(new ComplexNumber(2, 0), calculator.getStack().top());

        n1 = new ComplexNumber(-4, 0);
        calculator.insert(n1);
        assertEquals(new ComplexNumber(0, 2), calculator.squareRoot());
        assertEquals(new ComplexNumber(0, 2), calculator.getStack().top());

        n1 = new ComplexNumber(3, -4);
        calculator.insert(n1);
        assertEquals(new ComplexNumber(2, -1), calculator.squareRoot());
        assertEquals(new ComplexNumber(2, -1), calculator.getStack().top());

    }

    /**
     * This method tests the method divide of the class Calculator. The first
     * case tests the division of two real positive number The second case tests
     * the division of two complex numbers The third case tests the division by
     * zero
     *
     * @throws StackEmptyException
     */
    @Test
    public void testDivide() throws StackEmptyException {

        //caso numeri reali
        ComplexNumber c1 = new ComplexNumber(10, 0);
        ComplexNumber c2 = new ComplexNumber(2, 0);
        calculator.insert(c1);
        calculator.insert(c2);
        ComplexNumber result = calculator.divide();
        assertEquals(new ComplexNumber(5, 0), result);
        assertEquals(new ComplexNumber(5, 0), calculator.getStack().top());

        //caso numeri complessi
        c1 = new ComplexNumber(2, 1);
        c2 = new ComplexNumber(1, 1);
        calculator.insert(c1);
        calculator.insert(c2);
        result = calculator.divide();
        assertEquals(new ComplexNumber((double) 3 / 2, (double) -1 / 2), result);
        assertEquals(new ComplexNumber((double) 3 / 2, (double) -1 / 2), calculator.getStack().top());

        //divisione per zero
        calculator.insert(new ComplexNumber(0, 0));
        ArithmeticException assertThrows = assertThrows(ArithmeticException.class, () -> calculator.divide());
        assertEquals("Division by zero", assertThrows.getMessage());

    }
    
    /**
     * This method tests the method invertSign of the Calculator class
     * The first case tests the invertion of sign of the null value
     * The second case tests the invertion of sign of a complex number with both real and imaginary part positive
     * The third case tests the invertion of sign of a complex number with positive real part and negative imaginary part
     * The fourth case tests the invertion of sign of a complex number with negative real part and positive imaginary part
     * The fifth case tests the invertion of sign of a complex number with both real and imaginary part negative
     * @throws StackEmptyException 
     */

    @Test
    public void testInvertSign() throws StackEmptyException {
        ComplexNumber c1 = new ComplexNumber(0, 0);
        calculator.insert(c1);

        //caso valore nullo
        assertEquals(new ComplexNumber(0, 0), calculator.invertSign());

        //caso parte reale e parte immaginaria positivi     
        ComplexNumber c2 = new ComplexNumber(2.3, 1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(-2.3, -1), calculator.invertSign());
        assertEquals(new ComplexNumber(-2.3, -1), calculator.getStack().top());

        //caso parte reale positiva e parte immaginaria negativa
        ComplexNumber c3 = new ComplexNumber(2, -1);
        calculator.insert(c3);
        assertEquals(new ComplexNumber(-2, 1), calculator.invertSign());
        assertEquals(new ComplexNumber(-2, 1), calculator.getStack().top());

        //caso parte reale negativa e parte immaginaria positiva
        ComplexNumber c4 = new ComplexNumber(-2, 1);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(2, -1), calculator.invertSign());
        assertEquals(new ComplexNumber(2, -1), calculator.getStack().top());

        //caso parte reale e parte immaginaria negative
        ComplexNumber c5 = new ComplexNumber(-2, -1);
        calculator.insert(c5);
        assertEquals(new ComplexNumber(2, 1), calculator.invertSign());
        assertEquals(new ComplexNumber(2, 1), calculator.getStack().top());

    }
    
    /**
     * This method tests the method clear of the Claculator class
     * @throws StackEmptyException
     */
    
    @Test
    public void testClear() throws StackEmptyException{
        calculator.insert(new ComplexNumber(2,1));
        calculator.insert(new ComplexNumber(3,67));
        calculator.clear();
        assertEquals(true,calculator.getStack().isEmpty());
    }
    /**
     * This method tests the drop of the Calculator class
     * @throws StackEmptyException 
     */
    @Test
    public void testDrop() throws StackEmptyException{
        calculator.insert(new ComplexNumber(3,1));
        calculator.insert(new ComplexNumber(4,5));
        calculator.drop();
        calculator.drop();
        assertEquals(true,calculator.getStack().isEmpty());
    }
    /**
     * This method tests the method dup of the Claculator class
     * @throws StackEmptyException 
     */
    @Test
    public void testDup() throws StackEmptyException{
        ComplexNumber c1 = new ComplexNumber(1, 0);
        calculator.insert(c1);
        calculator.dup();
        assertEquals(c1,calculator.getStack().pop());
        assertEquals(c1,calculator.getStack().pop());
        
    }
    
    /**
     * This method tests the method swap of the Calculator class
     * @throws StackEmptyException 
     */
    
    @Test
    public void testSwap() throws StackEmptyException{
        calculator.insert(new ComplexNumber(2,1));
        calculator.insert(new ComplexNumber(3,67));
        calculator.swap();
        assertEquals(calculator.getStack().pop(),new ComplexNumber(2,1));
        assertEquals(calculator.getStack().pop(),new ComplexNumber(3,67));
        
    }
    /**
     * This method tests the method over of the Claculator class.
     * The first case tests the method when there isn't the second last element in the stack
     * @throws StackEmptyException 
     */
    @Test
    public void testOver() throws StackEmptyException{
        ComplexNumber c1 = new ComplexNumber(7, 0);
        calculator.insert(c1);
        calculator.over();
        assertEquals(c1,calculator.getStack().top());
        
        
        c1=new ComplexNumber(2, 1);
        ComplexNumber c2 = new ComplexNumber(3, 0);
        calculator.insert(c1);
        calculator.insert(c2);
        calculator.over();
        assertEquals(c1,calculator.getStack().pop());
        assertEquals(c1,calculator.getStack().pop());  
        
    }
    
    @Test
    public void testSaveToStack(){
        String name="a";
        vs.update(name,new ComplexNumber(45,78));
        calculator.saveToStack(name, vs);
        assertEquals(calculator.getStack().top(),vs.get(name));
        
        
    }

}
