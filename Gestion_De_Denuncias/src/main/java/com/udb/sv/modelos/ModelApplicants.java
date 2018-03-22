/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.modelos;

/**
 *
 * @author rigoberto
 */
public class ModelApplicants {
    private int id;
    private String firstName;
    private String secondName;
    private String firstLasName;
    private String secondLastName;
    private int number;

    public ModelApplicants(int id, String firstName, String secondName, String firstLasName, String secondLastName, int number) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLasName = firstLasName;
        this.secondLastName = secondLastName;
        this.number = number;
        
    }
    
    public ModelApplicants(String firstName, String secondName, String firstLasName, String secondLastName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLasName = firstLasName;
        this.secondLastName = secondLastName;
        
    }
    
    public ModelApplicants(String firstName, String secondName, String firstLasName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLasName = firstLasName;
        
        
    }
    
    public ModelApplicants() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLasName() {
        return firstLasName;
    }

    public void setFirstLasName(String firstLasName) {
        this.firstLasName = firstLasName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.firstName;
    }

    
}
