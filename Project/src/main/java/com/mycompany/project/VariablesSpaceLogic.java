/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project;

/**
 *
 * @author Dario
 */
public interface VariablesSpaceLogic {

    public boolean update(String variable, ComplexNumber cn);

    public ComplexNumber get(String name);

    public void save();

    public void restore();

    @Override
    public String toString();

}
