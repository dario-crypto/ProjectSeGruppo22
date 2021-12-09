/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.exception;

/**
 * This class represents the exception that is thrown when you want to execute an undefined operation
 * @author immacolata
 */
public class OperationDoesNotExist extends Exception {

    public OperationDoesNotExist(String message) {
        super(message);
    }
}
