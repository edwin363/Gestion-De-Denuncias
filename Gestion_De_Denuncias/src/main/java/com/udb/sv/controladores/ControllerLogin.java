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

/**
 *
 * @author rigoberto
 */
public class ControllerLogin {
    private final Connection conn;

    public ControllerLogin() {
        this.conn = new Conexion().getConn();
    }
    
    public boolean getUserType(String usuario, String clave){
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT id_user FROM users WHERE user_name = ? AND user_password = ?");
            cmd.setString(1, usuario);
            cmd.setString(2, clave);
            cmd.executeQuery();
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
