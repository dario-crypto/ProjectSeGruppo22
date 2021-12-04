/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author user
 */
public class FactoryOperator {

    public static HashMap<String, Operation> opMap;

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

        opMap.put("+", sum);
        opMap.put("-", sub);
        opMap.put("x", prod);
        opMap.put(":", div);
        opMap.put("sqrt", sqrt);
        opMap.put("invSign", invSign);
        opMap.put("dup", dup);
        opMap.put("swap", swap);
        opMap.put("over", over);
        opMap.put("clear", clear);
        opMap.put("drop", drop);

    }

    public static Operation getOperation(String op) throws StackEmptyException {

        return opMap.get(op);

    }

    public static Set<String> getOperators() {

        return opMap.keySet();
    }

    public static boolean contains(String op) {
        return opMap.get(op) != null;
    }
    
   
    

}
