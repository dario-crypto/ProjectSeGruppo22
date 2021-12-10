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
     * This method inserts a ComplexNumber in the calculator
     *
     * @param complex string that represents a complex number
     * @throws NumberFormatException if the format of the number is not correct
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
     * This method executes one of the available operation in the calculator
     * 
     *
     * @param op string that represents the operation
     * @throws StackEmptyException when there are not enough elements to do the operation
     * @throws OperationDoesNotExist if the operation does not exists
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
     * This method executes a formula
     *
     * @param formula string that represents the formula
     * @throws StackEmptyException if there are not enough elements in the stack to execute the formula
     * @throws OperationDoesNotExist if the operation does not exists
     */
    public void executeFormula(String formula) throws StackEmptyException, OperationDoesNotExist {
        String[] formulaSplit = formula.split("\\s+");

        for (String f : formulaSplit) {

            //case in which there is a formula in another formula
            if (formulas.contains(f)) {
                String form = formulas.get(f);
                executeFormula(form);

            } else if (ComplexNumber.checkComplex(f)) {
                //insertion of a ComplexNukmber in the stack
                insert(f);
            } else {
                execOperation(f);
            }
        }

    }

    /**
     * This method checks if it is an operation on variables
     *
     * @param op string that represents an operation
     * @return true if it is an operation on variables, otherwise false
     */
    private boolean isOperationVariable(String op) {
        Pattern pattern = Pattern.compile("^[< \\+ \\- >]{1}[a-z]{1}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(op);
        return matcher.find();
    }

    /**
     * This method checks if the input is a formula
     *
     * @param formula strin that represents a formula
     * @return true if the input is a formula, false otherwise
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
     * This method checks if the input is a possible name for a formula
     *
     * @param name string that represents the name
     * @return true if it is a possible name, false otherwise
     */
    private boolean isName(String name) {

        return !FactoryOperator.contains(name) && !isOperationVariable(name);
    }

    /**
     * This method builds a formula properly
     *
     * @param formula string that represents the formula
     * @return the build formula
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
     * This method adds a formula
     *
     * @param formula string that represents a formula
     * @throws FormatFormulaException when the format of the formula is not correct
     * @throws NameFormulaAlreadyExsist if the name already exists
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
     * This method returns a Map, which represents the formulas
     *
     * @return 
     */
    public TreeMap<String, String> getMapFormulas() {
        return formulas.getMap();
    }

    /**
     * This method executes one of the possible operation on the variables
     *
     * @param op string that represents an operation linked to a variable
     *  [a-z] (Examples: "<x",">x","+x","-x")
     * @throws StackEmptyException if there are not enough elements in the stack to execute the operation
     */
    private void processVariableOp(String op) throws StackEmptyException {

        String[] opSplit = op.split("");
        String operation = opSplit[0];
        String name = opSplit[1];

        FactoryOperator.getOperation(operation + "var").apply(calculator, name, vs);

    }

    /**
     * This method removes a formula
     *
     * @param formula string that represents the formula to remove
     * @return restituisce true if the formula has been removed with success, false otherwise
     */
    public boolean removeFormula(String formula) {
        String name = formula.split("=")[0].trim();
        return formulas.delete(name);
    }

    /**
     * This method updates a formula
     *
     * @param name string that represents the name of the formula to update
     * @param formula string that represents the new formula
     */
    public void updateFormula(String name, String formula) {
        formulas.update(name, formula);
    }

    /**
     * This method renames a formula
     *
     * @param oldName string that represents the name of the formula we want to change
     * @param name string that represents the neww name
     * @throws NameFormulaAlreadyExsist in case the new name already exists
     */
    public void renameFormula(String oldName, String name) throws NameFormulaAlreadyExsist {
        formulas.rename(oldName, name);
    }

    /**
     * This method executes a command
     *
     * @param command that has to be executed
     */
    public void executeCommand(Command command) {
        commandProcessor.executeCommand(command);
    }

    /**
     * This method does the operation of undo
     */
    public void undo() {
        commandProcessor.undo();
    }
    

    /**
     * This method load the formulas from a file
     * @throws IOException when any kind of IOException
     * occurs
     * @throws FileNotFoundException if the file does not exists
     * @throws ClassNotFoundException if the class does not exist
     */
    


     public void loadFile() throws IOException, FileNotFoundException, ClassNotFoundException {
        formulas.reaload();
    }
    
    /**
     * This method saves the formulas on a file
     * @throws IOException when any kind of IOException occurs
     */

    public void saveFile() throws IOException{
        formulas.save();
    }
    

}
