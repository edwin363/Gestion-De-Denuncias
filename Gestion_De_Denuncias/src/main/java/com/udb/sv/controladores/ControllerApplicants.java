/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.sv.controladores;

import com.udb.sv.modelos.ModelApplicants;
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
public class ControllerApplicants {
    private final Connection conn;

    public ControllerApplicants() {
        this.conn = new Conexion().getConn();
    }

    public List<ModelStates> getStates(){
        List<ModelStates> combo = new ArrayList<>();
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT * FROM states");
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                combo.add(new ModelStates(rs.getInt(1), rs.getString(2)));
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
    
    public List<ModelApplicants> getTable(){
        List<ModelApplicants> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = this.conn.prepareStatement("SELECT id_applicant, `first_name`, `second_name`, `first_last_name`, `second_last_name`, phone_numbers FROM `applicants`");
            ResultSet rs = cmd.executeQuery();
            while(rs.next()){
                resp.add(new ModelApplicants(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
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
        return resp;
    }
    
    public boolean saveAppli(String name1, String name2, String lsname1, String lsname2, int num){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("INSERT INTO applicants VALUES(NULL, ?,?,?,?,?)");
            cmd.setString(1, name1);
            cmd.setString(2, name2);
            cmd.setString(3, lsname1);
            cmd.setString(4, lsname2);
            cmd.setInt(5, num);
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
    
    public boolean updateAppli(int id, String name1, String name2, String lsname1, String lsname2, int num){
        boolean resp = false;
        try {
            PreparedStatement cmd = this.conn.prepareStatement("UPDATE applicants SET first_name = ?, second_name = ?, first_last_name = ?, second_last_name = ?, phone_numbers = ? WHERE id_applicant = ?");
            cmd.setString(1, name1);
            cmd.setString(2, name2);
            cmd.setString(3, lsname1);
            cmd.setString(4, lsname2);
            cmd.setInt(5, num);
            cmd.setInt(6, id);
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
    
    public boolean deleteAppli(int id){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conn.prepareStatement("DELETE FROM applicants WHERE id_applicant = ?");
            cmd.setInt(1, id);
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
    
}
