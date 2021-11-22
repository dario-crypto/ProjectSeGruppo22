
package com.mycompany.project;
/**
 * Classe che rappresenta l'eccezione stack vuoto
 */

public class StackEmptyException extends Exception {


    public StackEmptyException(String message) {
        super(message);
    }
}