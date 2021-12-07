/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.model;

import com.mycompany.project.model.Operation;
import com.mycompany.project.exception.StackEmptyException;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author user
 */
public class FactoryOperator {

    public static HashMap<String, GlobalOperation> opMap;

    static {
        opMap = new HashMap<>();
        Operation sum = (calculator) -> calculator.sum();
        Operation sub = (calculator) -> calculator.sub();
        Operation prod = (calculator) -> calculator.prod();
        Operation div = (calculator) -> calculator.divide();
        Operation sqrt = (calculator) -> calculator.squareRoot();
        Operation invSign = (calculator) -> calculator.invertSign();
        Operation dup = (calculator) -> calculator.dup();
        Operation swap = (calculator) -> calculator.swap();
        Operation over = (calculator) -> calculator.over();
        Operation clear = (calculator) -> calculator.clear();
        Operation drop = (calculator) -> calculator.drop();
        
        Operation mod=(calculator) -> calculator.mod();
        Operation arg = (calculator) -> calculator.arg();
        Operation sen = (calculator) -> calculator.sen();
        Operation cosen = (calculator) -> calculator.cosen();
        Operation tan = (calculator) -> calculator.tan();

        OperationVariable saveToStack = (calculator, name, vs) -> calculator.saveToStack(name, vs);
        OperationVariable saveToVariable = (calculator, name, vs) -> calculator.saveToVariable(name, vs);
        OperationVariable addToVariable = (calculator, name, vs) -> calculator.addToVariable(name, vs);
        OperationVariable subToVariable = (calculator, name, vs) -> calculator.subToVariable(name, vs);

        //operazioni sullo stack
        opMap.put("+", sum);
        opMap.put("-", sub);
        opMap.put("*", prod);
        opMap.put("/", div);
        opMap.put("sqrt", sqrt);
        opMap.put("invSign", invSign);
        opMap.put("dup", dup);
        opMap.put("swap", swap);
        opMap.put("over", over);
        opMap.put("clear", clear);
        opMap.put("drop", drop);
        
        opMap.put("mod", mod);
        opMap.put("arg", arg);
        opMap.put("sen", sen);
        opMap.put("cosen", cosen);
        opMap.put("tan", tan);
        

        //operazioni sullo spazio delle variabili
        opMap.put("<", saveToStack);
        opMap.put(">", saveToVariable);
        opMap.put("+", addToVariable);
        opMap.put("-", subToVariable);

    }

    public static GlobalOperation getOperation(String op) throws StackEmptyException {

        return opMap.get(op);

    }

    public static Set<String> getOperators() {

        return opMap.keySet();
    }

    public static boolean contains(String op) {
        return opMap.get(op) != null;
    }

}
