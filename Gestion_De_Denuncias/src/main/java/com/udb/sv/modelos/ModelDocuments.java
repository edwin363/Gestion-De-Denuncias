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
public class ModelDocuments {
    private int id;
    private String docs;

    public ModelDocuments(int id, String docs) {
        this.id = id;
        this.docs = docs;
    }

    public ModelDocuments() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocs() {
        return docs;
    }

    public void setDocs(String docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return this.docs;
    }
    
    
}
