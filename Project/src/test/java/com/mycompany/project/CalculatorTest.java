/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dilet
 */
public class CalculatorTest {
    Calculator calculator;
    
    
    public CalculatorTest() {
    }
    
    
    
    @Before
    public void setUp() {
        calculator=new Calculator(new Stack<ComplexNumber>());
    }
   
    /**
     * This method tests the method insert of the class Calculator
     * The first test inserts a real number into the Calculator's stack
     * The second test inserts a complex number with real part equal to zero into the Calculator's stack
     * The first test inserts a complex number with both real and imaginary parts different from zero into the Calculator's stack
     */

    @Test
    public void insertTest(){
        calculator.insert(new ComplexNumber(1,0));
        assertEquals(new ComplexNumber(1,0),calculator.getStack().top());
        calculator.insert(new ComplexNumber(0,-1));
        assertEquals(new ComplexNumber(0,-1),calculator.getStack().top());
        calculator.insert(new ComplexNumber(45,64));
        assertEquals(new ComplexNumber(45,64),calculator.getStack().top());
        
        
    }
    
    /**
     * This method tests the method sum of the class Calculator
     * The first case tests the sum of two real numbers
     * The second case tests the sum of two complex numbers, both with real part equal to zero
     * The third case tests the sum of two complex numbers, one with both real and imaginary part different from zero, 
     * the other with the imaginary part equal to 0
     * The fourth case tests the sum of two complex numbers, one with both real and imaginary part different from zero, 
     * the other with the real part equal to 0
     * The fifth case tests the sum of two complex numbers, both with real and imaginary part different from zero
     * @throws StackEmptyException 
     */
    
    @Test
    public void sumTest() throws StackEmptyException{
        //calculator=new Calculator(new Stack<ComplexNumber>());
        ComplexNumber c1=new ComplexNumber(1,0);
        ComplexNumber c2=new ComplexNumber(-1,0);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(0.0,0.0),calculator.sum());
        ComplexNumber c3=new ComplexNumber(0,4);
        ComplexNumber c4=new ComplexNumber(0,3);
        calculator.insert(c3);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(0.0,7.0),calculator.sum());
        ComplexNumber c5=new ComplexNumber(1,1);
        ComplexNumber c6=new ComplexNumber(1,0);
        calculator.insert(c5);
        calculator.insert(c6);
        assertEquals(new ComplexNumber(2.0,1.0),calculator.sum());
        ComplexNumber c7=new ComplexNumber(1,5);
        ComplexNumber c8=new ComplexNumber(0,8);
        calculator.insert(c7);
        calculator.insert(c8);
        assertEquals(new ComplexNumber(1.0,13.0),calculator.sum());
        ComplexNumber c9=new ComplexNumber(1,5);
        ComplexNumber c10=new ComplexNumber(1,8);
        calculator.insert(c9);
        calculator.insert(c10);
        assertEquals(new ComplexNumber(2.0,13.0),calculator.sum());
        
        
        
        
    }
    
    
    /**
     * This method tests the method sub of the class Calculator
     * The first case tests the substraction of two identical real numbers,so the result must be equal to 0
     * The second case tests the substraction of two real numbers,the minuend bigger than the subtrahend,so the result must be equal to a real positive number
     * The third case tests the substraction of two real numbers,the minuend smaller than the subtrahend,so the result must be equal to a real negative number
     * The fourth case tests the substraction of two complex numbers,the minuend with both real and imaginary part bigger than the subtrahend parts, so the result must have both real
     * and imaginary part equal to a negative number
     * The fifth case tests the substraction of two complex number, the minuend with real part bigger than the subtrahend's real part and the subtrahend with imaginary
     * part bigger than the minuend's imaginary part, so the result must have both real and imaginary part equal to a negative number
     * @throws StackEmptyException 
     */
    
    @Test
    public void subTest() throws StackEmptyException{
        
        ComplexNumber c1=new ComplexNumber(2,0);
        ComplexNumber c2=new ComplexNumber(2,0);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(0.0,0.0),calculator.sub());
        
        c1=new ComplexNumber(4,0);
        c2=new ComplexNumber(2,0);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(2.0,0.0),calculator.sub());
        
        c1=new ComplexNumber(2,0);
        c2=new ComplexNumber(4,0);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(-2.0,0.0),calculator.sub());
        
        c1=new ComplexNumber(2,2);
        c2=new ComplexNumber(4,9);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(-2.0,-7.0),calculator.sub());
        
        c1=new ComplexNumber(2,0);
        c2=new ComplexNumber(0,9);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(2.0,-9.0),calculator.sub());
        
      
        
    }
    /**
     * This method tests the method divide of the class Calculator.
     * The first case tests the division of two real positive number
     * The second case tests the division of two complex numbers
     * The third case tests the division by zero
     * @throws StackEmptyException 
     */
    @Test 
    public void divideTest() throws StackEmptyException{
      
//caso numeri reali
        ComplexNumber c1 = new ComplexNumber(10, 0);
        ComplexNumber c2 = new ComplexNumber(2, 0);
        calculator.insert(c1);
        calculator.insert(c2);
        ComplexNumber result = calculator.divide();
        assertEquals(new ComplexNumber(5, 0), result);
        assertEquals(new ComplexNumber(5,0),calculator.topStack());

        c1 = new ComplexNumber(2, 1);
        c2 = new ComplexNumber(1, 1);
        calculator.insert(c1);
        calculator.insert(c2);
        result = calculator.divide();
        assertEquals(new ComplexNumber((double)3 / 2, (double) -1 / 2), result);
        assertEquals(new ComplexNumber((double) 3 / 2, (double) -1 / 2),calculator.topStack());

        calculator.insert(new ComplexNumber(0, 0));
        ArithmeticException assertThrows = assertThrows(ArithmeticException.class, () -> calculator.divide());
        assertEquals("Division by zero", assertThrows.getMessage());
    }
    
    /**
     * This method tests the method prod of the class Calculator
     * The first case tests the product of two real numbers
     * The second case tests the product of two complex numbers, both with real part equal to zero
     * The third case tests the product of two complex numbers, one with both real and imaginary part different from zero, 
     * the other with the imaginary part equal to 0
     * The fourth case tests the product of two complex numbers, one with both real and imaginary part different from zero, 
     * the other with the real part equal to 0
     * The fifth case tests the product of two complex numbers, both with real and imaginary part different from zero
     * @throws StackEmptyException 
     */
    
    @Test
    public void prodTest() throws StackEmptyException{
        //calculator=new Calculator(new Stack<ComplexNumber>());
        ComplexNumber c1=new ComplexNumber(1,0);
        ComplexNumber c2=new ComplexNumber(1,0);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(1.0,0.0),calculator.prod());
        ComplexNumber c3=new ComplexNumber(0,1);
        ComplexNumber c4=new ComplexNumber(0,1);
        calculator.insert(c3);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(-1.0,0.0),calculator.prod());
        ComplexNumber c5=new ComplexNumber(1,1);
        ComplexNumber c6=new ComplexNumber(2,0);
        calculator.insert(c5);
        calculator.insert(c6);
        assertEquals(new ComplexNumber(2.0,2.0),calculator.prod());
        ComplexNumber c7=new ComplexNumber(1,1);
        ComplexNumber c8=new ComplexNumber(0,2);
        calculator.insert(c7);
        calculator.insert(c8);
        assertEquals(new ComplexNumber(-2.0,2.0),calculator.prod());
        ComplexNumber c9=new ComplexNumber(1,1);
        ComplexNumber c10=new ComplexNumber(2,2);
        calculator.insert(c9);
        calculator.insert(c10);
        assertEquals(new ComplexNumber(0.0,4.0),calculator.prod());
        
    }
    
    /**
     * This method tests the method squareRoot of the class Calculator
     * The first case tests the square root of a real positive number
     * The second case tests the square root of a real negative number
     * The third case tests the square root of a complex number
     * @throws StackEmptyException 
     */
    @Test
    public void squareRootTest() throws StackEmptyException{
        

        ComplexNumber c1=new ComplexNumber(4,0);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(2,0),calculator.squareRoot());
        
        c1=new ComplexNumber(-4,0);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(0,2),calculator.squareRoot());
        
        c1=new ComplexNumber(3,-4);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(2,-1),calculator.squareRoot());
        //assertEquals(new ComplexNumber(-2,1),calculator.squareRoot());
               
    }
    
    @Test 
    public void invertSignTest(){
        
    }
    
    /**
     * This method tests the topStack method of the class Calculator.
     * The test checks the last element in the stack.
     * @throws StackEmptyException 
     */
    
    @Test
    public void topStack() throws StackEmptyException{
        ComplexNumber c1=new ComplexNumber(4,0);  
        calculator.insert(c1);
        ComplexNumber cEqual=new ComplexNumber(4,0);  
        assertEquals(cEqual,calculator.topStack());
        
        c1=new ComplexNumber(2,-1);  
        ComplexNumber c2=new ComplexNumber(3,1);
        calculator.insert(c1);
        calculator.insert(c2);
        cEqual=new ComplexNumber(3,1);  
        assertEquals(cEqual,calculator.topStack());
     
    }
    
    /**
     * This method tests the execOperation method of the class Calculator .
     * The method contains a test for each possible operation.
     * @throws StackEmptyException 
     */
    @Test
    public void execOperation() throws StackEmptyException{
        ComplexNumber c1=new ComplexNumber(4,0);
        ComplexNumber c2=new ComplexNumber(4,0);
        calculator.insert(c1);
        calculator.insert(c2);
        String op1="+";
        calculator.execOperation(op1);
        assertEquals(new ComplexNumber(8,0),calculator.topStack());
        
        c1=new ComplexNumber(5,2);
        c2=new ComplexNumber(4,0);
        calculator.insert(c1);
        calculator.insert(c2);
        String op2="-";
        calculator.execOperation(op2);
        assertEquals(new ComplexNumber(1,2),calculator.topStack());
        
        c1=new ComplexNumber(2,-2);
        c2=new ComplexNumber(1,-1);
        calculator.insert(c1);
        calculator.insert(c2);
        String op3=":";
        calculator.execOperation(op3);
        assertEquals(new ComplexNumber(2,0),calculator.topStack());
        
        c1=new ComplexNumber(2,0);
        c2=new ComplexNumber(1,1);
        calculator.insert(c1);
        calculator.insert(c2);
        String op4="x";
        calculator.execOperation(op4);
        assertEquals(new ComplexNumber(2,2),calculator.topStack());
        
        c1=new ComplexNumber(-16,0);
        calculator.insert(c1);
        String op5="sqrt";
        calculator.execOperation(op5);
        assertEquals(new ComplexNumber(0,4),calculator.topStack());
        
    }
    
}
