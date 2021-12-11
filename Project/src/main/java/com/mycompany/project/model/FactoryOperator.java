/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.model;

import com.mycompany.project.command.CopySpaceVariablesCommand;
import com.mycompany.project.exception.StackEmptyException;
import java.util.HashMap;
import java.util.Set;

/**
 * This class shows all the methods that the Calculator is able to do
 *
 * @author user
 */
public class FactoryOperator {

    public static HashMap<String, GlobalOperation> opMap;

    static {
        opMap = new HashMap<>();
        Operation sum = (calculator, commandProcessor, vs) -> calculator.sum();
        Operation sub = (calculator, commandProcessor, vs) -> calculator.sub();
        Operation prod = (calculator, commandProcessor, vs) -> calculator.prod();
        Operation div = (calculator, commandProcessor, vs) -> calculator.divide();
        Operation sqrt = (calculator, commandProcessor, vs) -> calculator.squareRoot();
        Operation invSign = (calculator, commandProcessor, vs) -> calculator.invertSign();
        Operation dup = (calculator, commandProcessor, vs) -> calculator.dup();
        Operation drop = (calculator, commandProcessor, vs) -> calculator.drop();
        Operation swap = (calculator, commandProcessor, vs) -> calculator.swap();
        Operation over = (calculator, commandProcessor, vs) -> calculator.over();
        Operation clear = (calculator, commandProcessor, vs) -> calculator.clear();
        Operation sen = (calculator, commandProcessor, vs) -> calculator.sen();
        Operation exp = (calculator, commandProcessor, vs) -> calculator.exp();
        Operation logarithm = (calculator, commandProcessor, vs) -> calculator.logarithm();
        Operation tan = (calculator, commandProcessor, vs) -> calculator.tan();
        Operation cosen = (calculator, commandProcessor, vs) -> calculator.cosen();
        Operation arg = (calculator, commandProcessor, vs) -> calculator.arg();
        Operation mod = (calculator, commandProcessor, vs) -> calculator.mod();
        Operation asen = (calculator, commandProcessor, vs) -> calculator.asen();
        Operation acosen = (calculator, commandProcessor, vs) -> calculator.acosen();
        Operation atang = (calculator, commandProcessor, vs) -> calculator.atang();
        Operation pow = (calculator, commandProcessor, vs) -> calculator.pow();

        Operation save = (calculator, commandProcessor, vs) -> {

            CopySpaceVariablesCommand copy = new CopySpaceVariablesCommand(vs);
            commandProcessor.executeCommand(copy);

        };
        Operation restore = (calculator, commandProcessor, vs) -> commandProcessor.undo();

        OperationVariable saveToStack = (calculator, name, vs) -> calculator.saveToStack(name, vs);
        OperationVariable saveToVariable = (calculator, name, vs) -> calculator.saveToVariable(name, vs);
        OperationVariable addToVariable = (calculator, name, vs) -> calculator.addToVariable(name, vs);
        OperationVariable subToVariable = (calculator, name, vs) -> calculator.subToVariable(name, vs);

        //operations on the stack
        opMap.put("+", sum);
        opMap.put("-", sub);
        opMap.put("*", prod);
        opMap.put(":", div);
        opMap.put("sqrt", sqrt);
        opMap.put("+-", invSign);
        opMap.put("dup", dup);
        opMap.put("swap", swap);
        opMap.put("over", over);
        opMap.put("clear", clear);
        opMap.put("drop", drop);
        opMap.put("sen", sen);
        opMap.put("exp", exp);
        opMap.put("logarithm", logarithm);
        opMap.put("tan", tan);
        opMap.put("cosen", cosen);
        opMap.put("arg", arg);
        opMap.put("mod", mod);
        opMap.put("asen", asen);
        opMap.put("acosen", acosen);
        opMap.put("atang", atang);
        opMap.put("pow", pow);

        //operations on the variables space
        opMap.put("<var", saveToStack);
        opMap.put(">var", saveToVariable);
        opMap.put("+var", addToVariable);
        opMap.put("-var", subToVariable);

        //save and restore
        opMap.put("save", save);
        opMap.put("restore", restore);

    }

    /**
     * 
     * This method returns an object of type GlobalOperation that represents the requested operation
     *
     * @param op string that represents the requested operation
     * @return a GlobalOperation object
     * @throws StackEmptyException
     */
    public static GlobalOperation getOperation(String op) throws StackEmptyException {

        return opMap.get(op);

    }

    /**
     
     * This method returns the set of all the operations available on the calculator
     *
     * @return the set of all the keys of the map
     */
    public static Set<String> getOperators() {

        return opMap.keySet();
    }

    /**
     * This method checks if the requested operation is available on the calculator
     *
     * @param op string that represents the requested operation
     * @return true if the operation is present, otherwise false
     */
    public static boolean contains(String op) {
        return opMap.get(op) != null;
    }

}
