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
public class ModelComplaintsT {
    private int id;
    private String comp;

    public ModelComplaintsT(int id, String comp) {
        this.id = id;
        this.comp = comp;
    }

    public ModelComplaintsT() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    @Override
    public String toString() {
        return this.comp;
    }
    
    
}
