/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project.command;

import com.mycompany.project.model.ComplexNumber;
import com.mycompany.project.model.VariablesSpace;
import java.util.HashMap;

/**
 * This command does the backup and restoration of the variables 
 *
 * @author user
 */
public class CopySpaceVariablesCommand implements Command {

    private VariablesSpace vs;
    private HashMap<String, ComplexNumber> variablesMap;
    
    /**
     * This method is the constructor of the CopySpaceVariablesCommand class
     */

    public CopySpaceVariablesCommand(VariablesSpace vs) {
        this.vs = vs;
    }

    /**
     * This method saves a copy of the variables
     */
    @Override
    public void exec() {

        variablesMap = new HashMap<>();
        vs.getVariablesMap().forEach((name, cn) -> variablesMap.put(name, (ComplexNumber) cn.clone()));

    }

    /**
     * This method restores the saved values of the variables
     */
    @Override
    public void undo() {
        vs.setVariablesMap(variablesMap);

    }

    public HashMap<String, ComplexNumber> getBackupMap() {
        return variablesMap;
    }

}
