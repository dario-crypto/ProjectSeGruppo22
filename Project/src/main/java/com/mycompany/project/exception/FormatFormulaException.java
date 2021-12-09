/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.exception;

/**
 *This class represents the exception that is thrown when the formula does not respect the format (name = operation1 operation2 ..)
 * @author Dario
 */
public class FormatFormulaException extends Exception {

    public FormatFormulaException(String message) {
        super(message);

    }

}
