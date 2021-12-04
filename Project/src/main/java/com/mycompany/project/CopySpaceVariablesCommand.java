/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project;

import java.util.HashMap;

/**
 *
 * @author user
 */
public class CopySpaceVariablesCommand implements Command {

    private VariablesSpace vs;
    private HashMap<String, ComplexNumber> variablesMap;

    public CopySpaceVariablesCommand(VariablesSpace vs) {
        this.vs = vs;
    }

    @Override
    public void exec() {

        variablesMap = new HashMap<>();
        vs.getVariablesMap().forEach((name, cn) -> variablesMap.put(name, (ComplexNumber) cn.clone()));

    }

    @Override
    public void undo() {
        vs.setVariablesMap(variablesMap);

    }

}
