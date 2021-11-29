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
 * @author Dario
 */
public class StackTest {

    private Stack<Object> st;

    @Before
    public void setUp() {
        st = new Stack<>(5);
    }

    /**
     * Test of top method, of class Stack.
     */
    @Test
    public void testTop() throws StackEmptyException {
        st.push(1);
        assertEquals(1, st.top());
        st.push(2);
        assertEquals(2, st.top());
        st.push(3);
        assertEquals(3, st.top());
        st.pop();
        assertEquals(2, st.top());
        st.pop();
        assertEquals(1, st.top());

    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() {

        st.push(1);
        assertEquals(1, st.getItem(0));
        st.push(2);
        assertEquals(2, st.getItem(1));
        st.push(3);
        assertEquals(3, st.getItem(2));
        st.push("test");
        assertEquals("test", st.top());

    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() throws StackEmptyException {
        st.push(1);
        st.push("test");
        st.push(3.0);

        assertEquals(3.0, st.pop());
        assertEquals(2, st.getSize());
        assertEquals("test", st.pop());
        assertEquals(1, st.getSize());
        assertEquals(1, st.pop());
        assertEquals(0, st.getSize());
        StackEmptyException assertThrows = assertThrows(StackEmptyException.class, () -> st.pop());
        assertEquals("Stack is empty", assertThrows.getMessage());

    }

    /*  Test of isEmpty method, of class Stack. */
    @Test
    public void testIsEmpty() throws StackEmptyException {
        assertEquals(true, st.isEmpty());
        st.push(1);
        assertEquals(false, st.isEmpty());
        st.push(2);
        assertEquals(false, st.isEmpty());
        st.pop();
        assertEquals(false, st.isEmpty());
        st.pop();
        assertEquals(true, st.isEmpty());
    }
    
    /* Test of isEmpty method, of class Stack.*/  
    
    @Test
    public void testClear() throws StackEmptyException{
        st.push(4);
        st.push(5);
        st.clear();
        assertEquals(true,st.isEmpty());
    }

}
