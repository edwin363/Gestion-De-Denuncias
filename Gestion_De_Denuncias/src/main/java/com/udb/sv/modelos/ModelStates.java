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
public class ModelStates {
    private int id;
    private String state;

    public ModelStates(int id, String state) {
        this.id = id;
        this.state = state;
    }

    public ModelStates() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return this.state;
    }
    
    
    
}
