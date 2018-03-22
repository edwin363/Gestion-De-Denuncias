/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.controladores;

import com.udb.sv.modelos.ModelApplicants;
import com.udb.sv.modelos.ModelComplaintsT;
import com.udb.sv.modelos.ModelDocuments;
import com.udb.sv.modelos.ModelStates;
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
public class ControllerComplaints {
    private final Connection conn;

    public ControllerComplaints() {
        this.conn = new Conexion().getConn();
    }
    
    public boolean saveComplaits(int appli, int doc, int comp, String otherC, int user, String date){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("INSERT INTO complaints_details VALUES(?,?,?,?,?,?)");
            cmd.setInt(1, appli);
            cmd.setInt(2, doc);
            cmd.setInt(3, comp);
            cmd.setString(4, otherC);
            cmd.setInt(5, user);
            cmd.setString(6, date);
            cmd.executeUpdate();
            resp = true;
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
        return resp;
    }
    
     public List<ModelComplaintsT> getComplaitnsT(){
        List<ModelComplaintsT> combo = new ArrayList<>();
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT * FROM complaints_types");
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                combo.add(new ModelComplaintsT(rs.getInt(1), rs.getString(2)));
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
        return combo;
    }
     
     
}
