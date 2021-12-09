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
 * Comando che si occupa di fare un backup delle variabili e di farne un
 * ripristino
 *
 * @author user
 */
public class CopySpaceVariablesCommand implements Command {

    private VariablesSpace vs;
    private HashMap<String, ComplexNumber> variablesMap;

    public CopySpaceVariablesCommand(VariablesSpace vs) {
        this.vs = vs;
    }

    /**
     * Salva una copia delle variabili
     */
    @Override
    public void exec() {

        variablesMap = new HashMap<>();
        vs.getVariablesMap().forEach((name, cn) -> variablesMap.put(name, (ComplexNumber) cn.clone()));

    }

    /**
     * Ripristina il valori delle variabili salvato
     */
    @Override
    public void undo() {
        vs.setVariablesMap(variablesMap);

    }

    public HashMap<String, ComplexNumber> getBackupMap() {
        return variablesMap;
    }

}
