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
     * Questo metodo testa il metodo insert della classe Calculator
     * Il primo test inserisce nello stack un numero reale
     * Il secondo test inserisce nello stack un numero complesso con parte reale uguale a 0
     * Il terzo test inserisce nello stack un numero complesso con parte reale e immaginaria diverse da 0
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
     * Questo metodo testa il metodo sum della classe Calculator.
     * Il primo test testa la somma di due numeri reali
     * Il secondo testa la somma di due numeri complessi in cui entrambi hanno parte reale uguale a 0
     * Il terzo testa la somma di due numeri complessi in cui uno ha sia parte reale che parte immaginaria diverse da 0,l'altro solo
     * la parte reale diversa da 0
     * Il quarto testa la somma di due numeri complessi in cui uno ha sia parte reale che parte immaginaria diverse da 0,l'altro solo
     * la parte immaginaria diversa da 0
     * Il quinto testa la somma di due numeri complessi in cui entrambi hanno sia parte reale che immaginaria diverse da 0
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
     * Test del metodo sub della classe Calculator.
     * Il primo test sottrare due numeri reali il cui risultato deve dare 0.
     * Il secondo test sottrare due numeri reali il cui risultato deve essere un numero positivo.
     * Il terzo test sottrae due numeri reali il cui risultato deve essere un numero negativo.
     * Il quarto test sottrare due numeri complessi il cui risultato deve essere un numero complesso con parte 
     * reale e immaginaria negativa.
     * Il quinto test sottare due numeri complessi il cui risultato deve essere un numero complesso 
     * solo con parte immaginaria negativa.
     * @throws StackEmptyException 
     */
    
    @Test
    public void subTest() throws StackEmptyException{
        
        ComplexNumber n1=new ComplexNumber(2,0);
        ComplexNumber n2=new ComplexNumber(2,0);
        calculator.insert(n1);
        calculator.insert(n2);
        assertEquals(new ComplexNumber(0.0,0.0),calculator.sub());
        
        n1=new ComplexNumber(4,0);
        n2=new ComplexNumber(2,0);
        calculator.insert(n1);
        calculator.insert(n2);
        assertEquals(new ComplexNumber(2.0,0.0),calculator.sub());
        
        n1=new ComplexNumber(2,0);
        n2=new ComplexNumber(4,0);
        calculator.insert(n1);
        calculator.insert(n2);
        assertEquals(new ComplexNumber(-2.0,0.0),calculator.sub());
        
        n1=new ComplexNumber(2,2);
        n2=new ComplexNumber(4,9);
        calculator.insert(n1);
        calculator.insert(n2);
        assertEquals(new ComplexNumber(-2.0,-7.0),calculator.sub());
        
        n1=new ComplexNumber(2,0);
        n2=new ComplexNumber(0,9);
        calculator.insert(n1);
        calculator.insert(n2);
        assertEquals(new ComplexNumber(2.0,-9.0),calculator.sub());
        
      
        
    }
    
    @Test 
    public void divideTest(){
        
    }
    
    /**
     * Questo metodo testa il metodo prodotto di Calculator
     * Il primo test testa il prodotto di due numeri reali
     * Il secondo testa il prodotto di due numeri complessi in cui entrambi hanno solo parte immaginaria diversa da 0
     * Il terzo testa il prodotto di due numeri complessi in cui uno ha sia parte reale che parte complessa diverse da 0,l'altro solo
     * la parte reale diversa da 0
     * Il quarto testa il prodotto di due numeri complessi in cui uno ha sia parte reale che parte complessa diverse da 0,l'altro solo
     * la parte immaginaria diversa da 0
     * Il quinto testa il prodotto di due numeri complessi in cui entrambi hanno sia parte reale che immaginaria diverse da 0
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
     * Test del metodo squareRoot della classe Calculator.
     * Il primo caso testa la radice di un numero  positivo
     * Il secondo caso testa la radice di un numero reale negativo
     * Il terzo caso testa la radice di un numero complesso
     * @throws StackEmptyException 
     */
    @Test
    public void squareRootTest() throws StackEmptyException{
        

        ComplexNumber n1=new ComplexNumber(4,0);
        calculator.insert(n1);
        assertEquals(new ComplexNumber(2,0),calculator.squareRoot());
        
        n1=new ComplexNumber(-4,0);
        calculator.insert(n1);
        assertEquals(new ComplexNumber(0,2),calculator.squareRoot());
        
        n1=new ComplexNumber(3,-4);
        calculator.insert(n1);
        assertEquals(new ComplexNumber(2,-1),calculator.squareRoot());
        //assertEquals(new ComplexNumber(-2,1),calculator.squareRoot());
               
    }
    
    @Test 
    public void invertSignTest(){
        
    }
    
    
    
    
    

    
    
}
