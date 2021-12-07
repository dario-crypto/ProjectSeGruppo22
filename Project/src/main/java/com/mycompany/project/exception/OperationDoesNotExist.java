/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.exception;

/**
 *
 * @author asiav
 */
public class OperationDoesNotExist extends Exception {

    public OperationDoesNotExist(String message) {
        super(message);
    }
}
