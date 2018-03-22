/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.controladores;

import com.udb.sv.modelos.ModelDocuments;
import com.udb.sv.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rigoberto
 */
public class ControllerDocs {
    private final Connection conn;

    public ControllerDocs() {
        this.conn = new Conexion().getConn();
    }
    
    public List<ModelDocuments> getDocs(){
        List<ModelDocuments> combox = new ArrayList<>();
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT * FROM documents_type");
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                combox.add(new ModelDocuments(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (this.conn != null) {
                    if (!this.conn.isClosed()) {
                        this.conn.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión");
            }
        }
        return combox;
    }
    
    
}
