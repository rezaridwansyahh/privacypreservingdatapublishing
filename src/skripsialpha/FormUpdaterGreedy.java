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
public class FormUpdaterGreedy {

    String consString = "jdbc:mysql://localhost:3306/nasiha";
    String username = "root";
    String password = "";
    int maxsisclus;
    int max;
    public Boolean koneksi(String sql){
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
            return true;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public Boolean add(String kelamin, int umur, String kode_pos, String jenis_kelamin) {
        String sql = "INSERT INTO sisclus(kelamin,umur,negara,jenis_kelamin) VALUES ('" + kelamin + "','" + umur + "','" + kode_pos + "','" + jenis_kelamin + "')";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
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
        dm.addColumn("Age");
        dm.addColumn("Workclass");
        dm.addColumn("Marital");
        dm.addColumn("Sex");
        dm.addColumn("Capgain");
        dm.addColumn("Caploss");
        dm.addColumn("Cluster");
        String sql = "select id_coba,age,workclass,marital,sex,capgain,caploss,cluster from greedy;";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            //looping
            while (rs.next()) {
                String id_coba = rs.getString(1);
                String age = rs.getString(2);
                String workclass = rs.getString(3);
                String marital = rs.getString(4);
                String sex = rs.getString(5);
                String capgain = rs.getString(6);
                String caploss = rs.getString(7);
                String cluster = rs.getString(8);
                dm.addRow(new String[]{id_coba, age, workclass, marital, sex, capgain,caploss,cluster});

            }
            con.close();
            return dm;
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }
    
    public DefaultTableModel getDataSorted() {
        //add column
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("Id");
        dm.addColumn("Age");
        dm.addColumn("Workclass");
        dm.addColumn("Marital");
        dm.addColumn("Sex");
        dm.addColumn("Capgain");
        dm.addColumn("Caploss");
        dm.addColumn("Cluster");
        String sql = "select id_coba,age,workclass,marital,sex,capgain,caploss,cluster from nasiha order by cluster;";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            //looping
            while (rs.next()) {
                String id_coba = rs.getString(1);
                String age = rs.getString(2);
                String workclass = rs.getString(3);
                String marital = rs.getString(4);
                String sex = rs.getString(5);
                String capgain = rs.getString(6);
                String caploss = rs.getString(7);
                String cluster = rs.getString(8);
                dm.addRow(new String[]{id_coba, age, workclass, marital, sex, capgain,caploss,cluster});

            }
            con.close();
            return dm;
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return null;
    }
    
    public Boolean update(int cluster, String kelamin, String umur, String negara) {
        String sql = "UPDATE sisclus SET kelamin='" + kelamin + "',umur='" + umur + "',negara='" + negara + "' WHERE cluster='" + cluster + "'";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
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

    public Boolean updatecluster(int id_coba, int cluster) {
        String sql = "UPDATE greedy SET cluster='" + cluster + "' WHERE id_coba='" + id_coba + "'";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
        public Boolean delete(int id_coba) {
        String sql = "DELETE FROM greedy WHERE id_coba='" + id_coba + "'";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
      public Boolean insert(int age, String work,String marital,String sex,int cluster) {
        String sql = "insert into nasiha(age,workclass,marital,sex,cluster) values('"+age+"','"+work+"','"+marital+"','"+sex+"','"+cluster+"')";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public Boolean updatesisacluster(int cluster) {
        String sql = "UPDATE greedy SET cluster='" + cluster + "' WHERE cluster='0'";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean updateclusterkedua(int cluster) {
        int clusterbaru = cluster + 1;
        String sql = "UPDATE sisclus SET cluster='" + clusterbaru + "' WHERE cluster='" + cluster + "'";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
        public Boolean updateGreedy(int cluster,int age,String work,String marital,String sex) {
        //int clusterbaru = cluster + 1;
        String sql = "UPDATE greedy SET cluster='" + cluster + "' WHERE (age='" + age + "' or workclass='" + work + "' or sex='" + sex + "') and cluster='0'";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean updateNegara(int id, String negara) {
        String sql = "UPDATE greedy SET marital='" + negara + "' WHERE id_coba='" + id + "'";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
        public Boolean updateKerja(int id, String negara) {
        String sql = "UPDATE greedy SET workclass='" + negara + "' WHERE id_coba='" + id + "'";
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            s.execute(sql);
            con.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public int selectMax(int maxcluster) {
        String sql = "select max(id_coba) from nasiha where cluster='" + maxcluster + "';";
        int id_coba = 0;
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
//            looping
            while (rs.next()) {
                id_coba = rs.getInt(1);
            }
            s.close();
            con.close();
            return id_coba;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Got an exception! ");
            return 0;
        }
    }
    
        public int selectNext() {
        String sql = "select id_coba from greedy where cluster='0' limit 1;";
        int id_coba = 0;
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
//            looping
            while (rs.next()) {
                id_coba = rs.getInt(1);
            }
            s.close();
            con.close();
            return id_coba;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Got an exception! ");
            return 0;
        }
    }
    
    public int selectMaxUmur() {
        String sql = "select max(age) from nasiha;";
        int id_coba = 0;
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
//            looping
            while (rs.next()) {
                id_coba = rs.getInt(1);
            }
            s.close();
            con.close();
            return id_coba;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Got an exception! ");
            return 0;
        }
    }

    public int selectMin(int maxcluster) {
        String sql = "select min(id_coba) from nasiha where cluster='" + maxcluster + "';";
        int id_coba = 0;
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
//            looping
            while (rs.next()) {
                id_coba = rs.getInt(1);
            }
            
            s.close();
            con.close();
            return id_coba;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Got an exception! ");
            return 0;
        }
    }
    
        public int selectMinUmur() {
        String sql = "select min(age) from nasiha";
        int id_coba = 0;
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
//            looping
            while (rs.next()) {
                id_coba = rs.getInt(1);
            }
            s.close();
            con.close();
            return id_coba;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Got an exception! ");
            return 0;
        }
    }
    public int cariBanyakDataDalamCluster(int maxcluster) {
        String sql = "select count(cluster) from nasiha where cluster='" + maxcluster + "';;";
        int id_coba = 0;
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
//            looping
            while (rs.next()) {
                id_coba = rs.getInt(1);
            }
            s.close();
            con.close();
            return id_coba;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Got an exception! ");
            return 0;
        }
    }

    public int selectMaxScnu() {
        String sql = "select max(cluster) from nasiha;";
        int id_coba = 0;
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
//            looping
            while (rs.next()) {
                id_coba = rs.getInt(1);
            }
            s.close();
            con.close();
            return id_coba;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Got an exception! ");
            return 0;
        }
    }
    
    public int selectSisa() {
        String sql = "select count(id_coba) from greedy where id_coba='0';";
        int id_coba = 0;
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
//            looping
            while (rs.next()) {
                id_coba = rs.getInt(1);
            }
            s.close();
            con.close();
            return id_coba;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Got an exception! ");
            return 0;
        }
    }
    
    public int selectMaxData() {
        String sql = "select max(id_coba) from nasiha;";
        int id_coba = 0;
        try {
            Connection con = DriverManager.getConnection(consString, username, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
//            looping
            while (rs.next()) {
                id_coba = rs.getInt(1);
            }
            s.close();
            con.close();
            return id_coba;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Got an exception! ");
            return 0;
        }
    }
}
