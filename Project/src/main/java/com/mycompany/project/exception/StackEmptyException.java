
package com.mycompany.project.exception;
/**
 * Classe che rappresenta l'eccezione stack vuoto
 */

public class StackEmptyException extends Exception {


    public StackEmptyException(String message) {
        super(message);
    }
}