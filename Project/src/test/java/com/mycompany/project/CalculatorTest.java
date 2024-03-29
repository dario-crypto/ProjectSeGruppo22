/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.project;

import com.mycompany.project.model.VariablesSpace;
import com.mycompany.project.exception.StackEmptyException;
import com.mycompany.project.model.Stack;
import com.mycompany.project.model.ComplexNumber;
import com.mycompany.project.model.Calculator;
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
    
    /**
     * This is the constructor of the class CalculatorTest
     */

    public CalculatorTest() {
    }
    
    /**
     * This method is used to set the conditionts in common for multiple case of testing
     */
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
        assertEquals(new ComplexNumber(0.0,0.0), calculator.getStack().top());
        ComplexNumber c3 = new ComplexNumber(0, 4);
        ComplexNumber c4 = new ComplexNumber(0, 3);
        calculator.insert(c3);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(0.0, 7.0), calculator.sum());
        assertEquals(new ComplexNumber(0.0,7.0), calculator.getStack().top());
        ComplexNumber c5 = new ComplexNumber(1, 1);
        ComplexNumber c6 = new ComplexNumber(1, 0);
        calculator.insert(c5);
        calculator.insert(c6);
        assertEquals(new ComplexNumber(2.0, 1.0), calculator.sum());
        assertEquals(new ComplexNumber(2.0, 1.0), calculator.getStack().top());
        ComplexNumber c7 = new ComplexNumber(1, 5);
        ComplexNumber c8 = new ComplexNumber(0, 8);
        calculator.insert(c7);
        calculator.insert(c8);
        assertEquals(new ComplexNumber(1.0, 13.0), calculator.sum());
        assertEquals(new ComplexNumber(1.0, 13.0), calculator.getStack().top());
        ComplexNumber c9 = new ComplexNumber(1, 5);
        ComplexNumber c10 = new ComplexNumber(1, 8);
        calculator.insert(c9);
        calculator.insert(c10);
        assertEquals(new ComplexNumber(2.0, 13.0), calculator.sum());
        assertEquals(new ComplexNumber(2.0, 13.0), calculator.getStack().top());

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

        
        ComplexNumber c1 = new ComplexNumber(10, 0);
        ComplexNumber c2 = new ComplexNumber(2, 0);
        calculator.insert(c1);
        calculator.insert(c2);
        ComplexNumber result = calculator.divide();
        assertEquals(new ComplexNumber(5, 0), result);
        assertEquals(new ComplexNumber(5, 0), calculator.getStack().top());

        
        c1 = new ComplexNumber(2, 1);
        c2 = new ComplexNumber(1, 1);
        calculator.insert(c1);
        calculator.insert(c2);
        result = calculator.divide();
        assertEquals(new ComplexNumber((double) 3 / 2, (double) -1 / 2), result);
        assertEquals(new ComplexNumber((double) 3 / 2, (double) -1 / 2), calculator.getStack().top());

        
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

        
        assertEquals(new ComplexNumber(0, 0), calculator.invertSign());

            
        ComplexNumber c2 = new ComplexNumber(2.3, 1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(-2.3, -1), calculator.invertSign());
        assertEquals(new ComplexNumber(-2.3, -1), calculator.getStack().top());

        
        ComplexNumber c3 = new ComplexNumber(2, -1);
        calculator.insert(c3);
        assertEquals(new ComplexNumber(-2, 1), calculator.invertSign());
        assertEquals(new ComplexNumber(-2, 1), calculator.getStack().top());

        
        ComplexNumber c4 = new ComplexNumber(-2, 1);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(2, -1), calculator.invertSign());
        assertEquals(new ComplexNumber(2, -1), calculator.getStack().top());

        
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
     * This method tests the method over of the Calculator class.
     * @throws StackEmptyException 
     */
    @Test
    public void testOver() throws StackEmptyException{
        ComplexNumber c1 = new ComplexNumber(2, 1);
        ComplexNumber c2 = new ComplexNumber(3, 0);
        calculator.insert(c1);
        calculator.insert(c2);
        calculator.over();
        assertEquals(c1,calculator.getStack().pop());
        assertEquals(c2,calculator.getStack().pop());
        assertEquals(c1,calculator.getStack().pop());
        
        
    }
    /**
     * This method tests the method saveToVariable of the Calculator class 
     * @throws StackEmptyException 
     */
    @Test
    public void testSaveToVariable() throws StackEmptyException{
        String name="b";
        ComplexNumber c1 = new ComplexNumber(9, -1);
        calculator.insert(c1);
        calculator.saveToVariable(name, vs);
        assertEquals(vs.get(name),c1);
    }
    
   /**
    * This method tests the method saveToStack of the Calculator class
    */
    @Test
    public void testSaveToStack(){
        String name="a";
        vs.update(name,new ComplexNumber(45,78));
        calculator.saveToStack(name, vs);
        assertEquals(calculator.getStack().top(),vs.get(name));
        
        
    }
    
    /**
     * This method tests the method addToVariable of the Calculator class
     * @throws StackEmptyException 
     */
    @Test
    public void testaddToVariablek() throws StackEmptyException{
        String name="c";
        ComplexNumber c1 = new ComplexNumber(2, 1);
        vs.update(name,c1);
        ComplexNumber c2 = new ComplexNumber(3, 5);
        calculator.insert(c2);
        calculator.addToVariable(name, vs);
        assertEquals(vs.get(name),ComplexNumber.add(c1, c2));
              
    }
    
    /**
     * This method tests the method subToVariable of the Calculator class
     * @throws StackEmptyException 
     */
    @Test
    public void testsubToVariablek() throws StackEmptyException{
        String name="d";
        ComplexNumber c1 = new ComplexNumber(2, -1);
        vs.update(name,c1);
        ComplexNumber c2 = new ComplexNumber(-3, -4);
        calculator.insert(c2);
        calculator.subToVariable(name, vs);
        assertEquals(vs.get(name),ComplexNumber.subtract(c1, c2));
              
    }
    
    /**
     * This method tests the method mod() of Calculator's class
     * The first two cases deal with real numbers, the first positive,the second negative
     * The next three cases deal with complex number with both real and imaginary part different from zero, the first with both real and imaginary positive,
     * the second with both negative and the third with one positive and the other negative.
     * The last two tests deal with two complex number with real part equal to 0, the first with imaginary part positive the other negative
     * @throws StackEmptyException 
     */
    
    @Test
    public void testMod() throws StackEmptyException{
        ComplexNumber c=new ComplexNumber(2,0);
        calculator.insert(c);
        assertEquals(calculator.mod(),new ComplexNumber(2,0));
        assertEquals(new ComplexNumber(2,0), calculator.getStack().top());
        c=new ComplexNumber(-2,0);
        calculator.insert(c);
        assertEquals(calculator.mod(),new ComplexNumber(2,0));
        assertEquals(new ComplexNumber(2,0), calculator.getStack().top());
        c=new ComplexNumber(3,4);
        calculator.insert(c);
        assertEquals(calculator.mod(),new ComplexNumber(5,0));
        assertEquals(new ComplexNumber(5,0), calculator.getStack().top());
        c=new ComplexNumber(-3,-4);
        calculator.insert(c);
        assertEquals(calculator.mod(),new ComplexNumber(5,0));
        assertEquals(new ComplexNumber(5,0), calculator.getStack().top());
        c=new ComplexNumber(-3,4);
        calculator.insert(c);
        assertEquals(calculator.mod(),new ComplexNumber(5,0));
        assertEquals(new ComplexNumber(5,0), calculator.getStack().top());
        c=new ComplexNumber(0,2);
        calculator.insert(c);
        assertEquals(calculator.mod(),new ComplexNumber(2,0));
        assertEquals(new ComplexNumber(2,0), calculator.getStack().top());
        c=new ComplexNumber(0,-2);
        calculator.insert(c);
        assertEquals(calculator.mod(),new ComplexNumber(2,0));
        assertEquals(new ComplexNumber(2,0), calculator.getStack().top());
        
    }
    
    /**
     * This method tests the method exp of Calculator's class
     * The first case tests the exponential  of a real positive number 
     * The second case tests the exponential of a complex number 
     * The third case tests the exponential of a complex number with real part positive and imaginary part negative
     * The fourth case tests the exponential of a complex number with real and imaginary part negative
     * The the fifth case tests the exponential of a complex number with only imaginary part negative
     * @throws StackEmptyException 
     */
    @Test
    public void testExp() throws StackEmptyException{
        ComplexNumber c=new ComplexNumber(2,0);
        calculator.insert(c);
        assertEquals(calculator.exp(),new ComplexNumber(7.3890561,0));
        assertEquals(new ComplexNumber(7.3890561,0), calculator.getStack().top());
        
        c=new ComplexNumber(2,2);
        calculator.insert(c);
        assertEquals(calculator.exp(),new ComplexNumber(-3.07493232,6.7188497));
        assertEquals(new ComplexNumber(-3.07493232,6.7188497), calculator.getStack().top());
        
        c=new ComplexNumber(5,-2);
        calculator.insert(c);
        assertEquals(calculator.exp(),new ComplexNumber(-61.76166666,-134.95170368));
        assertEquals(new ComplexNumber(-61.76166666,-134.95170368), calculator.getStack().top());
        
        c=new ComplexNumber(-2,-3);
        calculator.insert(c);
        assertEquals(calculator.exp(),new ComplexNumber(-0.13398091,-0.01909852));
        assertEquals(new ComplexNumber(-0.13398091,-0.01909852), calculator.getStack().top());
        
        c=new ComplexNumber(0,-5);
        calculator.insert(c);
        assertEquals(calculator.exp(),new ComplexNumber(0.28366219,0.95892427));
        assertEquals(new ComplexNumber(0.28366219,0.95892427), calculator.getStack().top());   
    }
    
     /**
     * This method tests the method arg() of Calculator's class.
     * The first case tests the argument with null values (0,0) ;
     * The second case tests the argument of a complex number with both (real and imaginary) positive part;
     * The third case tests the argument of a complex number with positive real part and negative imaginary part;
     * The fourth case tests the argument of a complex number with negative real part and positive imaginary part;
     * The fifth case tests the argument of a complex number with both (real and imaginary) negative part.
     * @throws StackEmptyException 
     */
     @Test
    public void testArg() throws StackEmptyException{
        ComplexNumber c1 = new ComplexNumber(0, 0);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(0, 0), calculator.arg());
         assertEquals(new ComplexNumber(0, 0), calculator.getStack().top());
    
        ComplexNumber c2 = new ComplexNumber(1, 1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(0.785398163, 0), calculator.arg());
        assertEquals(new ComplexNumber(0.785398163, 0), calculator.getStack().top());
        
        ComplexNumber c3 = new ComplexNumber(2, -1);
        calculator.insert(c3);
        assertEquals(new ComplexNumber(-0.463647609, 0), calculator.arg());
        assertEquals(new ComplexNumber(-0.463647609, 0), calculator.getStack().top());
        
        ComplexNumber c4 = new ComplexNumber(-2, 1);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(2.677945045, 0), calculator.arg());
        assertEquals(new ComplexNumber(2.677945045, 0), calculator.getStack().top());
        
        ComplexNumber c5 = new ComplexNumber(-2, -1);
        calculator.insert(c5);
        assertEquals(new ComplexNumber(-2.677945045, 0), calculator.arg());
        assertEquals(new ComplexNumber(-2.677945045, 0), calculator.getStack().top());
    }
    
     /**
     * This method tests the method sen() of Calculator's class.
     * The first case tests the sine with null values (0,0) ;
     * The second case tests the sine of a complex number with a positive real part and a null imaginary part;
     * The third case tests the sine of a complex number with positive real part and negative imaginary part;
     * The fourth case tests the sine of a complex number with negative real part and positive imaginary part;
     * The fifth case tests the sine of a complex number with both (real and imaginary) negative part.
     * @throws StackEmptyException 
     */
    @Test
    public void testSen() throws StackEmptyException{
        ComplexNumber c1 = new ComplexNumber(0, 0);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(0, 0), calculator.sen());
        assertEquals(new ComplexNumber(0, 0), calculator.getStack().top());
        
        ComplexNumber c2 = new ComplexNumber(8, 0);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(0.98935825, 0), calculator.sen());
        assertEquals(new ComplexNumber(0.98935825, 0), calculator.getStack().top());
        
        ComplexNumber c3 = new ComplexNumber(2, -2);
        calculator.insert(c3);
        assertEquals(new ComplexNumber(3.42095486, 1.50930649), calculator.sen());
        assertEquals(new ComplexNumber(3.42095486, 1.50930649), calculator.getStack().top());
        
        ComplexNumber c4 = new ComplexNumber(-2, 2);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(-3.42095486, -1.50930649), calculator.sen());
        assertEquals(new ComplexNumber(-3.42095486, -1.50930649), calculator.getStack().top());
        
        ComplexNumber c5 = new ComplexNumber(-2, -2);
        calculator.insert(c5);
        assertEquals(new ComplexNumber(-3.42095486, 1.50930649), calculator.sen());
        assertEquals(new ComplexNumber(-3.42095486, 1.50930649), calculator.getStack().top());
    }
    
    /**
     * This method tests the method cosen() of Calculator's class.
     * The first case tests the cosine with null values (0,0) ;
     * The second case tests the cosine of a complex number with both (real and imaginary) positive part;
     * The third case tests the cosine of a complex number with positive real part and negative imaginary part;
     * The fourth case tests the cosine of a complex number with negative real part and positive imaginary part;
     * The fifth case tests the cosine of a complex number with both (real and imaginary) negative part.
     * @throws StackEmptyException 
     */
    @Test
    public void testCosen() throws StackEmptyException{
        ComplexNumber c1 = new ComplexNumber(0, 0);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(1, 0), calculator.cosen());
        assertEquals(new ComplexNumber(1, 0), calculator.getStack().top());
        
        ComplexNumber c2 = new ComplexNumber(2, 3);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(-4.18962569, -9.10922789), calculator.cosen());
        assertEquals(new ComplexNumber(-4.18962569, -9.10922789), calculator.getStack().top());
        
        ComplexNumber c3 = new ComplexNumber(2, -3);
        calculator.insert(c3);
        assertEquals(new ComplexNumber(-4.18962569, 9.10922789), calculator.cosen());
        assertEquals(new ComplexNumber(-4.18962569, 9.10922789), calculator.getStack().top());
        
        ComplexNumber c4 = new ComplexNumber(-2, 3);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(-4.18962569, 9.10922789), calculator.cosen());
        assertEquals(new ComplexNumber(-4.18962569, 9.10922789), calculator.getStack().top());
        
        ComplexNumber c5 = new ComplexNumber(-2, -3);
        calculator.insert(c5);
        assertEquals(new ComplexNumber(-4.18962569, -9.10922789), calculator.cosen());
        assertEquals(new ComplexNumber(-4.18962569, -9.10922789), calculator.getStack().top());
    }
    
    /**
     * This method tests the method tan() of Calculator's class.
     * The first case tests the tangent with null values (0,0) ;
     * The second case tests the tangent of a complex number with both (real and imaginary) positive part;
     * The third case tests the tangent of a complex number with positive real part and negative imaginary part;
     * The fourth case tests the tangent of a complex number with negative real part and positive imaginary part;
     * The fifth case tests the tangent of a complex number with both (real and imaginary) negative part.
     * @throws StackEmptyException 
     */
    @Test
    public void testTan() throws StackEmptyException{
        ComplexNumber c1 = new ComplexNumber(0, 0);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(0, 0), calculator.tan());
        assertEquals(new ComplexNumber(0, 0), calculator.getStack().top());
        
        ComplexNumber c2 = new ComplexNumber(2, 3);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(-0.0037640258375647375, 1.0032386280164864), calculator.tan());
        assertEquals(new ComplexNumber(-0.0037640258375647375, 1.0032386280164864), calculator.getStack().top());
        
        ComplexNumber c3 = new ComplexNumber(2, -3);
        calculator.insert(c3);
        assertEquals(new ComplexNumber(-0.0037640258375647375, -1.0032386280164864), calculator.tan());
        assertEquals(new ComplexNumber(-0.0037640258375647375, -1.0032386280164864), calculator.getStack().top());
        
        ComplexNumber c4 = new ComplexNumber(-2, 3);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(0.0037640258375647375, 1.0032386280164864), calculator.tan());
        assertEquals(new ComplexNumber(0.0037640258375647375, 1.0032386280164864), calculator.getStack().top());
        
        ComplexNumber c5 = new ComplexNumber(-2, -3);
        calculator.insert(c5);
        assertEquals(new ComplexNumber(0.0037640258375647375, -1.0032386280164864), calculator.tan());
        assertEquals(new ComplexNumber(0.0037640258375647375, -1.0032386280164864), calculator.getStack().top());
    }
    
     /**
     * This method tests the method logarithm of Calculator's class
     * The first case tests the logarithm of a real positive number 
     * The second case tests the logarithm of a real negative number 
     * The third case tests the logarithm of a complex number with only imaginary part;
     * The first case tests the logarithm with null values (0,0) ;
     * @throws StackEmptyException 
     */
    @Test
    public void testLogarithm() throws StackEmptyException{
        ComplexNumber c=new ComplexNumber(2,0);
        calculator.insert(c);
        assertEquals(new ComplexNumber(0.69314718,0),calculator.logarithm());
        assertEquals(new ComplexNumber(0.69314718,0), calculator.getStack().top());
        
        c=new ComplexNumber(-4,0);
        calculator.insert(c);
        assertEquals(new ComplexNumber(1.38629436,3.14159265),calculator.logarithm());
        assertEquals(new ComplexNumber(1.38629436,3.14159265), calculator.getStack().top());
        
        c=new ComplexNumber(0,2);
        calculator.insert(c);
        assertEquals(new ComplexNumber(0.69314718,1.57079633),calculator.logarithm());
        assertEquals(new ComplexNumber(0.69314718,1.57079633), calculator.getStack().top());
        
        c=new ComplexNumber(0,0);
        calculator.insert(c);
        ArithmeticException assertThrows = assertThrows(ArithmeticException.class, () -> calculator.logarithm());
        assertEquals("Error: LN(0)", assertThrows.getMessage());
  
    }
    
    /**
     * This method tests the method asen() of Calculator's class.
     * It returns a numeric value between -π e π radians for x between -1 and 1. 
     * If the value of x is outside this range, it throws an exception
     * The first 4 cases deal with real numbers, the next 2 cases with complex number, one with both parts different from
     * zero, the other with real part equal to zero.
     * 
     * @throws StackEmptyException 
     */
    @Test
    public void testAsen() throws StackEmptyException{
        ComplexNumber c1 = new ComplexNumber(0, 0);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(0, 0), calculator.asen());
        assertEquals(new ComplexNumber(0, 0), calculator.getStack().top());
        
        ComplexNumber c2 = new ComplexNumber(0.5, 0);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(0.5235987755982989, 0), calculator.asen());
        assertEquals(new ComplexNumber(0.5235987755982989, 0), calculator.getStack().top());
        
        ComplexNumber c3 = new ComplexNumber(1, 0);
        calculator.insert(c3);
        assertEquals(new ComplexNumber(1.5707963267948966, 0), calculator.asen());
        assertEquals(new ComplexNumber(1.5707963267948966, 0), calculator.getStack().top());
        
        ComplexNumber c4 = new ComplexNumber(-1, 0);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(-1.5707963267948966,0), calculator.asen());
        assertEquals(new ComplexNumber(-1.5707963267948966, 0), calculator.getStack().top());
        
        c4 = new ComplexNumber(0, 12);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(0.0, 3.17978541), calculator.asen());
        assertEquals(new ComplexNumber(0.0, 3.17978541), calculator.getStack().top());

        c4 = new ComplexNumber(1, 5);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(0.19379315, 2.33097449), calculator.asen());
        assertEquals(new ComplexNumber(0.19379315, 2.33097449), calculator.getStack().top());
        


        calculator.insert(new ComplexNumber(2, 0));
        ArithmeticException assertThrows = assertThrows(ArithmeticException.class, () -> calculator.asen());
        assertEquals("Number not included in [-1,1]", assertThrows.getMessage());

    }
    
    /**
     * This method tests the method acos() of Calculator's class.
     * It returns a numeric value between 0 and π radians for x between -1 and 1. 
     * If the value of x is outside this range, it throws an exception
     * The first 4 cases deal with real numbers, the next 2 cases with complex number, one with both parts different from
     * zero, the other with real part equal to zero.
     * 
     * @throws StackEmptyException 
     */
    @Test
    public void testAcosen() throws StackEmptyException{
        ComplexNumber c1 = new ComplexNumber(0, 0);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(1.5707963267948966, 0), calculator.acosen());
        assertEquals(new ComplexNumber(1.5707963267948966, 0), calculator.getStack().top());
        
        ComplexNumber c2 = new ComplexNumber(0.5, 0);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(1.0471975511965979, 0), calculator.acosen());
        assertEquals(new ComplexNumber(1.0471975511965979, 0), calculator.getStack().top());
        
        ComplexNumber c3 = new ComplexNumber(-1, 0);
        calculator.insert(c3);
        assertEquals(new ComplexNumber(3.141592653589793, 0), calculator.acosen());
        assertEquals(new ComplexNumber(3.141592653589793, 0), calculator.getStack().top());
        
        ComplexNumber c4 = new ComplexNumber(1, 0);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(0,0), calculator.acosen());
        assertEquals(new ComplexNumber(0,0), calculator.getStack().top());
        
        c4 = new ComplexNumber(0, 12);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(1.57079633, -3.17978541), calculator.acosen());
        assertEquals(new ComplexNumber(1.57079633, -3.17978541), calculator.getStack().top());
        
        c4=new ComplexNumber(1,5);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(1.37700318, -2.33097449), calculator.acosen());
        assertEquals(new ComplexNumber(1.37700318, -2.33097449), calculator.getStack().top());
 

        calculator.insert(new ComplexNumber(2, 0));
        ArithmeticException assertThrows = assertThrows(ArithmeticException.class, () -> calculator.acosen());
        assertEquals("Number not included in [-1,1]", assertThrows.getMessage());


    }
    
    /**
     * This method tests the method atangent() of Calculator's class.
     * It returns a numeric value between 0 and π radians for x between -1 and 1. 
     * The first 4 cases deal with real numbers, the next 2 cases with complex number, one with both parts different from
     * zero, the other with real part equal to zero.
     * 
     * @throws StackEmptyException 
     */
    @Test
    public void testAtan() throws StackEmptyException{
        ComplexNumber c1 = new ComplexNumber(0, 0);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(0, 0), calculator.atan());
        assertEquals(new ComplexNumber(0, 0), calculator.getStack().top());
        
        ComplexNumber c2 = new ComplexNumber(1, 0);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(0.7853981633974483, 0), calculator.atan());
        assertEquals(new ComplexNumber(0.7853981633974483, 0), calculator.getStack().top());
        
        ComplexNumber c4 = new ComplexNumber(0, 12);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(1.570796325, 0.08352704), calculator.atan());
        assertEquals(new ComplexNumber(1.570796325, 0.08352704), calculator.getStack().top());

        c4 = new ComplexNumber(1, 5);
        calculator.insert(c4);
        assertEquals(new ComplexNumber(1.530881335, 0.19442614), calculator.atan());
        assertEquals(new ComplexNumber(1.530881335, 0.19442614), calculator.getStack().top());
        
    }
    
     /**
     * This method tests the method pow of the Calculator's class
     * The first three cases deal with real numbers elevated to real number, complex numbers with real part equal to zero and complex numbers with both part
     * different from zero
     * The fourth case concerns the case with exponent equal to a real negative nuimber
     * The fifth case conserns the case with the exponent equal to a decimal number
     * The next three cases deal with complex numbers with real part equal to zero
     * elevated to real number, complex numbers with real part equal to zero and
     * complex numbers with both part different from zero
     * The last four cases deal with complex numbers with both part different from zero elevated to real
     * number, complex numbers with real part equal to zero and complex numbers
     * with both part different from zero and a decimal number
     * @throws StackEmptyException 
     */
    
    @Test
    public void testPow() throws StackEmptyException{
        ComplexNumber c1=new ComplexNumber(-2.0,0);
        ComplexNumber c2=new ComplexNumber(3.0,0);
        calculator.insert(c2);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(0.1111111111111111,0),calculator.pow());
        assertEquals(new ComplexNumber(0.1111111111111111, 0), calculator.getStack().top());
        c1 = new ComplexNumber(4.0, 0);
        c2 = new ComplexNumber(0, 7);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(-0.961253458, - 0.275666085), calculator.pow());
        assertEquals(new ComplexNumber(-0.961253458, - 0.275666085), calculator.getStack().top());
        c1 = new ComplexNumber(2.0,0.0);
        c2 = new ComplexNumber(6.0, 7.0);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(8.908025536,-63.377023296), calculator.pow());
        assertEquals(new ComplexNumber(8.908025536,-63.377023296), calculator.getStack().top());
        c1 = new ComplexNumber(2.0, 0);
        c2 = new ComplexNumber(-1, 0);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(0.5, 0), calculator.pow());
        assertEquals(new ComplexNumber(0.5, 0), calculator.getStack().top());
        c1 = new ComplexNumber(8.0, 0);
        c2 = new ComplexNumber(0.66666666, 0);
        calculator.insert(c1);
        calculator.insert(c2);
        assertEquals(new ComplexNumber(4, 0), calculator.pow());
        assertEquals(new ComplexNumber(4, 0), calculator.getStack().top());
        c1 = new ComplexNumber(3.0, 0);
        c2 = new ComplexNumber(0, 4);
        calculator.insert(c2);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(0,-64),calculator.pow());
        assertEquals(new ComplexNumber(0,-64), calculator.getStack().top());
        c1 = new ComplexNumber(0, -1);
        c2 = new ComplexNumber(0, 4);
        calculator.insert(c2);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(0.882515628,-4.728832707), calculator.pow());
        assertEquals(new ComplexNumber(0.882515628,-4.728832707), calculator.getStack().top());
        c1 = new ComplexNumber(1, 1);
        c2 = new ComplexNumber(0, 4);
        calculator.insert(c2);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(-0.817405575,0.152547835), calculator.pow());
        assertEquals(new ComplexNumber(-0.817405575,0.152547835), calculator.getStack().top());
        c1 = new ComplexNumber(3, 0);
        c2 = new ComplexNumber(1, 1);
        calculator.insert(c2);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(-2,2), calculator.pow());
        assertEquals(new ComplexNumber(-2,2), calculator.getStack().top());
        c1 = new ComplexNumber(0, 3);
        c2 = new ComplexNumber(1, 1);
        calculator.insert(c2);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(0.04800249,0.081725462), calculator.pow());
        assertEquals(new ComplexNumber(0.04800249,0.081725462), calculator.getStack().top());
        c1 = new ComplexNumber(3, 3);
        c2 = new ComplexNumber(1, 1);
        calculator.insert(c2);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(-0.259455902,-0.067445943), calculator.pow());
        assertEquals(new ComplexNumber(-0.259455902,-0.067445943), calculator.getStack().top());
        c1 = new ComplexNumber(0.66666666, 0);
        c2 = new ComplexNumber(1, 1);
        calculator.insert(c2);
        calculator.insert(c1);
        assertEquals(new ComplexNumber(1.091123636019695, 0.6299605250745975), calculator.pow());
        assertEquals(new ComplexNumber(1.091123636019695, 0.6299605250745975), calculator.getStack().top());
        
        
        
        
        

        
    }
 
}
