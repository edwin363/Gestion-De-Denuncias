/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.recursos;

import com.udb.sv.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rigoberto
 */
public class ConsultasBase {
    private final Connection conn;

    public ConsultasBase() {
        this.conn = new Conexion().getConn();
    }
    
    public int getCoutApplicants(){
     int resp = 0;
     
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT COUNT(*) FROM applicants");
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp = rs.getInt("COUNT(*)");
                System.err.println(resp);
            }
            
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
