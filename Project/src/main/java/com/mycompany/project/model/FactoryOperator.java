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
 * Classe che detiene tutte le operazioni disponibili della calcolatrice
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

        Operation save = (calculator, commandProcessor, vs) -> {

            CopySpaceVariablesCommand copy = new CopySpaceVariablesCommand(vs);
            commandProcessor.executeCommand(copy);

        };
        Operation restore = (calculator, commandProcessor, vs) -> commandProcessor.undo();

        OperationVariable saveToStack = (calculator, name, vs) -> calculator.saveToStack(name, vs);
        OperationVariable saveToVariable = (calculator, name, vs) -> calculator.saveToVariable(name, vs);
        OperationVariable addToVariable = (calculator, name, vs) -> calculator.addToVariable(name, vs);
        OperationVariable subToVariable = (calculator, name, vs) -> calculator.subToVariable(name, vs);

        //operazioni sullo stack
        opMap.put("+", sum);
        opMap.put("-", sub);
        opMap.put("*", prod);
        opMap.put(":", div);
        opMap.put("sqrt", sqrt);
        opMap.put("invSign", invSign);
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

        //operazioni sullo spazio delle variabili
        opMap.put("<var", saveToStack);
        opMap.put(">var", saveToVariable);
        opMap.put("+var", addToVariable);
        opMap.put("-var", subToVariable);

        //save e restore
        opMap.put("save", save);
        opMap.put("restore", restore);

    }

    /**
     * Restituisce un oggetto GlobalOperation che rappresenta l'operazione
     * specificata
     *
     * @param op stringa che rappresenta l'operazione
     * @return un oggetto GlobalOperation
     * @throws StackEmptyException
     */
    public static GlobalOperation getOperation(String op) throws StackEmptyException {

        return opMap.get(op);

    }

    /**
     * Restituisce l'insieme di tutte le operazioni disponibili nella
     * calcolatrice
     *
     * @return l'insieme di tutte le operazioni disponibili nella calcolatrice
     */
    public static Set<String> getOperators() {

        return opMap.keySet();
    }

    /**
     * Controlla se l'operazione è disponibile nella calcolatrice
     *
     * @param op stringa che rappresenta l'operazione
     * @return true se l'operazione è presente, altrimenti restituisce false
     */
    public static boolean contains(String op) {
        return opMap.get(op) != null;
    }

}
