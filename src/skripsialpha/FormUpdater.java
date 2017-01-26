/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsialpha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rezar_4
 */
public class FormUpdater {

    String consString = "jdbc:mysql://localhost:3306/fake";
    String username = "root";
    String password = "";

    public Boolean add(String kelamin, int umur, String kode_pos, String jenis_kelamin) {
        String sql = "INSERT INTO coba(kelamin,umur,kode_pos,jenis_kelamin) VALUES ('" + kelamin + "','" + umur + "','" + kode_pos + "','" + jenis_kelamin + "')";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public DefaultTableModel getData() {
        //add column
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("Id");
        dm.addColumn("Kelamin");
        dm.addColumn("Umur");
        dm.addColumn("Kode_Pos");
        dm.addColumn("Pekerjaan");

        String sql = "select coba.id_coba,kelamin,umur, kode_pos,penyakit from coba;";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            //looping
            while (rs.next()) {
                String id_coba = rs.getString(1);
                String kelamin = rs.getString(2);
                String umur = rs.getString(3);
                String kode_pos = rs.getString(4);
                String penyakit = rs.getString(5);

                dm.addRow(new String[]{id_coba, kelamin, umur, kode_pos, penyakit});

            }
            return dm;
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }

    public Boolean update(int id_coba,String kelamin, int umur, String kode_pos, String penyakit) {
        String sql = "UPDATE coba SET kelamin='" + kelamin + "',umur='" + umur + "',kode_pos='" + kode_pos + "',penyakit='" + penyakit + "' WHERE id_coba='" + id_coba + "'";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public Boolean updatekode(int id_coba, String kode_pos) {
        String sql = "UPDATE coba SET kode_pos='" + kode_pos + "' WHERE id_coba='" + id_coba + "'";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
