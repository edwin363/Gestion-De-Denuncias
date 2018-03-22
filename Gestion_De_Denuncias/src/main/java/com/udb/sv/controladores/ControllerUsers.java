/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.controladores;

import com.udb.sv.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rigoberto
 */
public class ControllerUsers {
    private final Connection conn;

    public ControllerUsers() {
        this.conn = new Conexion().getConn();
    }
    
    public boolean updateStateSession(int valor, int id){
        boolean resp = false;
        
        try {
            
                PreparedStatement cmd = this.conn.prepareStatement("UPDATE users SET session_status = ? WHERE id_user = ?");
                cmd.setInt(1, valor);
                cmd.setInt(2, id);
                cmd.executeUpdate();
                resp = true;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(this.conn != null){
                    if(!this.conn.isClosed()){
                        this.conn.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
        
        return resp;
    }
    
    
    
    
    
}
