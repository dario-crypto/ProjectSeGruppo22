/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project.controller;

import com.mycompany.project.command.Command;
import com.mycompany.project.exception.FormatFormulaException;
import com.mycompany.project.exception.NameFormulaAlreadyExsist;
import com.mycompany.project.model.*;
import com.mycompany.project.exception.OperationDoesNotExist;
import com.mycompany.project.exception.StackEmptyException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dario
 */
public class CalculatorController {

    private Calculator calculator;
    private VariablesSpace vs;
    private Formulas formulas;
    private CommandProcessor commandProcessor;

    public CalculatorController(StackLogic<ComplexNumber> stack) {
        calculator = new Calculator(stack);
        vs = new VariablesSpace();
        formulas = new Formulas();
        commandProcessor = new CommandProcessor();

    }

    /**
     * Inserisce un numero complesso nella calcolatrice
     *
     * @param complex stringa che rappresenta un numero complesso
     * @throws NumberFormatException se il formato del numero non è corretto
     * @throws NullPointerException
     * @throws StringIndexOutOfBoundsException
     */

    public void insert(String complex) throws NumberFormatException, NullPointerException, StringIndexOutOfBoundsException {

        ComplexNumber cn = ComplexNumber.parseComplex(complex);
        calculator.insert(cn);
    }

    public Calculator getCalculator() {
        return this.calculator;
    }

    /**
     * Esegue una delle operazioni disponibili nella calcolatrice
     *
     * @param op stringa che rappresenta l'operazione
     * @throws StackEmptyException nel caso in cui non ci sono elementi
     * necessari nello stack per esegure l'operazione
     * @throws OperationDoesNotExist se l'operazione non esiste
     */
    public void execOperation(String op) throws StackEmptyException, OperationDoesNotExist {

        if (FactoryOperator.contains(op)) {
            FactoryOperator.getOperation(op).apply(calculator, commandProcessor, vs);

        } else if (isOperationVariable(op)) {
            processVariableOp(op);

        } else {
            throw new OperationDoesNotExist("The operation: " + op + " does not exist!");
        }

    }

    /**
     * Esegue una formula
     *
     * @param formula stringa che rappresenta la formula
     * @throws StackEmptyException se non ci sono elementi necessari nello stack
     * per esegure la formula
     * @throws OperationDoesNotExist se cui l'operazione non esiste
     */
    public void executeFormula(String formula) throws StackEmptyException, OperationDoesNotExist {
        String[] formulaSplit = formula.split("\\s+");

        for (String f : formulaSplit) {

            //caso in cui è presente una nome di una formula nella formula 
            if (formulas.contains(f)) {
                String form = formulas.get(f);
                executeFormula(form);

            } else if (ComplexNumber.checkComplex(f)) {
                //inserimento numero complesso nello stack
                insert(f);
            } else {
                execOperation(f);
            }
        }

    }

    /**
     * Controlla un'operazione se è un'operazione sulle variabili
     *
     * @param op stringa che rappresenta l'operazione
     * @return true se è un'operazione sulle variabili altrimenti restituisce
     * false
     */
    private boolean isOperationVariable(String op) {
        Pattern pattern = Pattern.compile("^[< \\+ \\- >]{1}[a-z]{1}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(op);
        return matcher.find();
    }

    /**
     * Controlla se una stringa è una formula
     *
     * @param formula stringa che rappresenta la formula
     * @return true se l'input è una formula altrimenti restituise false
     */
    private boolean isFormula(String formula) {
        String[] formulaSplit = formula.split("\\s+");

        for (String op : formulaSplit) {
            if (!FactoryOperator.contains(op) && !isOperationVariable(op) && !formulas.contains(op) && !ComplexNumber.checkComplex(op)) {
                return false;

            }

        }
        return true;
    }

    /**
     * Controlla se il parametro name è un possibile nome di formula
     *
     * @param name stringa che rappesenta il nome della formula
     * @return true se il nome della formula è possibile altrimenti restituisce
     * false
     */
    private boolean isName(String name) {

        return !FactoryOperator.contains(name) && !isOperationVariable(name);
    }

    /**
     * Formatta correttamente una formula
     *
     * @param formula stringa che rappresenta la formula
     * @return formula formattata
     */
    public static String formulaBuilder(String formula) {
        String[] formulaSplit = formula.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String f : formulaSplit) {
            if (ComplexNumber.checkComplex(f)) {
                ComplexNumber cn = ComplexNumber.parseComplex(f);
                f = cn.toString();
            }

            sb.append(f).append(" ");
        }
        return sb.toString().trim();

    }

    /**
     * Aggiunge una formula
     *
     * @param formula stringa che rappresenta la formula
     * @throws FormatFormulaException nel caso in cui il formato della formula
     * non è corretta
     * @throws NameFormulaAlreadyExsist se il nome della formula già esiste
     */
    public void addFormula(String formula) throws FormatFormulaException, NameFormulaAlreadyExsist {
        String[] formulaSplit = formula.split("=");
        if (formulaSplit.length == 2) {

            String name = formulaSplit[0].trim();
            String form = formulaSplit[1].trim();
            if (isFormula(form) && isName(name)) {
                form = formulaBuilder(form);
                formulas.add(name, form);

                return;
            }
        }
        throw new FormatFormulaException("Not Valid Formula!");

    }

    /**
     * Restituisce una mappa che rappresenta le formule
     *
     * @return restituisce una mappa che rappresenta le formule
     */
    public TreeMap<String, String> getMapFormulas() {
        return formulas.getMap();
    }

    /**
     * Esegue una delle operazioni disponibili su una variabile
     *
     * @param op stringa che rappresenta l'operazione concatenata con una
     * variabile [a-z] (Esempio: "<x",">x","+x","-x")
     * @throws StackEmptyException se non ci sono elementi necessari nello stack
     * per eseguire l'operazione sulla variabile
     */
    private void processVariableOp(String op) throws StackEmptyException {

        String[] opSplit = op.split("");
        String operation = opSplit[0];
        String name = opSplit[1];

        FactoryOperator.getOperation(operation + "var").apply(calculator, name, vs);

    }

    /**
     * Rimuove una formula
     *
     * @param formula stringa che rappresenta la formula da rimuovere
     * @return restituisce true se la formula è stata rimossa con successo
     * altrimenti restituisce false
     */
    public boolean removeFormula(String formula) {
        String name = formula.split("=")[0].trim();
        return formulas.delete(name);
    }

    /**
     * Aggiorna una formula
     *
     * @param name stringa che rappresenta il nome della formula da aggiornare
     * @param formula stringa che rappresenta la nuova formula
     */
    public void updateFormula(String name, String formula) {
        formulas.update(name, formula);
    }

    /**
     * Rinomina una formula
     *
     * @param oldName stringa che rappresenta il nome della formula che si vuole
     * rinominare
     * @param name stringa che rappresenta il nuovo nome della formula
     * @throws NameFormulaAlreadyExsist nel caso in cui nuovo nome è già
     * presente
     */
    public void renameFormula(String oldName, String name) throws NameFormulaAlreadyExsist {
        formulas.rename(oldName, name);
    }

    /**
     * Esegue un comando
     *
     * @param command comando che deve essere eseguito
     */
    public void executeCommand(Command command) {
        commandProcessor.executeCommand(command);
    }

    /**
     * Effettua l'operazione di undo
     */
    public void undo() {
        commandProcessor.undo();
    }
    
     public void loadFile() throws IOException, FileNotFoundException, ClassNotFoundException {
        formulas.reaload();
    }

    public void saveFile() throws IOException{
        formulas.save();
    }
    

}
