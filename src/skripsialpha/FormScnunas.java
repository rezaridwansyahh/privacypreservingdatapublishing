/*//GEN-FIRST:event_jButton1ActionPerformed
 * To change this license header, choose License Headers in Project Properties.//GEN-LAST:event_jButton1ActionPerformed
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsialpha;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rezar_4
 */
public class FormScnunas extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    public FormScnunas() {
        initComponents();
    }

    private void retrieve() {
        DefaultTableModel dm = new FormUpdaterScnunas().getData();
        jTable1.setModel(dm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        label1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Kelamin", "Umur", "Negara", "Cluster", "Pekerjaan"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Keluarkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cluster");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jButton3.setText("Cetak Tgl");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        label1.setText("Systematic Clustering");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 170, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(280, 280, 280))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(update)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(125, 125, 125))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(update)
                    .addComponent(jButton3))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        retrieve();
    }                                        

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
         
        int k=3;
        int clus=0;
        int jumlahbaris= jTable1.getRowCount();
        for(int i=0;i<jumlahbaris;i++){
            if((i+1)%k==0){
                clus+=1;
                for(int j=i;j>=(i-(k-1));j--){
                    new FormUpdaterScnunas().updatecluster(j+1, clus);
                    System.out.println((j+1) + " " + clus);
                }
                
            }
        }
        new FormUpdaterScnunas().updatesisacluster((new FormUpdaterScnunas().selectMaxScnu()));
        retrieve();
        Date date = new Date();
        System.out.println(date.toString());
    }                                     

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
        int jumlahbari = new FormUpdaterScnunas().selectMaxScnu();
 //       String negfix = "xxx";
        String kelamin="gender";
        String statuskawin="";
        String umur;
        String workclass;
        double pembagiumur;
        double umuryangdibagi;       
        double banyakcluster;
        double informationLoss=0;
        double ilumur;

        for (int i = 0; i <= jumlahbari; i++) {
            banyakcluster = new FormUpdaterScnunas().cariBanyakDataDalamCluster(i);
            boolean flag = false;
            boolean flags= false;
            int ilka=0;
            double ilwork=0;
            double ilnik=0;
            double ilneg=0;
            if (new FormUpdaterScnunas().cariBanyakDataDalamCluster(i) > 0) {
                for (int a = new FormUpdaterScnunas().selectMin(i); a < new FormUpdaterScnunas().selectMax(i); a++) {
                    if (!jTable1.getValueAt(a-1, 4).toString().equals(jTable1.getValueAt(a, 4).toString())) {
                        flags = false;
                        break;
                    } else {
                        flags = true;
                    }
                }
                if (flags==true){
                    kelamin = jTable1.getValueAt(new FormUpdaterScnunas().selectMin(i)-1, 4).toString();
                    ilka=0;
                }else if (flag==false){
                    kelamin=" Kelamin";
                    ilka=1;
                }
               umur= jTable1.getValueAt(new FormUpdaterScnunas().selectMin(i)-1, 1).toString() + " - " + jTable1.getValueAt(new FormUpdaterScnunas().selectMax(i)-1, 1).toString();               
               
               for (int j = new FormUpdaterScnunas().selectMin(i); j < new FormUpdaterScnunas().selectMax(i); j++) {
                    if (!jTable1.getValueAt(j-1, 2).toString().equals(jTable1.getValueAt(j, 2).toString())) {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                        ilwork = 0;
                    }
                }
                if(flag==false){
                     for (int x = new FormUpdaterScnunas().selectMin(i); x <= new FormUpdaterScnunas().selectMax(i); x++) {
                         if(" Federal-gov".equals(jTable1.getValueAt(x - 1, 2).toString()) || " Local-gov".equals(jTable1.getValueAt(x - 1, 2).toString())||" State-gov".equals(jTable1.getValueAt(x - 1, 2).toString()) ){
                            new FormUpdaterScnunas().updateKerja(x, "Governmen");
                        }else if(" Without-pay".equals(jTable1.getValueAt(x - 1, 2).toString()) || " Never-worked".equals(jTable1.getValueAt(x - 1, 2).toString())){
                            new FormUpdaterScnunas().updateKerja(x, "Not_Work");
                        }else if(" Private".equals(jTable1.getValueAt(x - 1, 2).toString()) || " Self-emp-not-inc".equals(jTable1.getValueAt(x - 1, 2).toString()) || " Self-emp-inc".equals(jTable1.getValueAt(x - 1, 2).toString())){
                             new FormUpdaterScnunas().updateKerja(x, "Entrepreneur");
                        }
                     }
                }
                retrieve();
                for (int j = new FormUpdaterScnunas().selectMin(i); j < new FormUpdaterScnunas().selectMax(i); j++) {
                    if (!jTable1.getValueAt(j-1, 2).toString().equals(jTable1.getValueAt(j, 2).toString())) {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                        
                    }
                }
                if(flag==true){
                    workclass = jTable1.getValueAt(new FormUpdaterScnunas().selectMin(i)-1,2).toString();
                    ilwork = 0.5;
                }else {
                    workclass = "kerja";
                    ilwork = 1;
                }
                
                for (int j = new FormUpdaterScnunas().selectMin(i); j < new FormUpdaterScnunas().selectMax(i); j++) {
                    if (!jTable1.getValueAt(j-1, 3).toString().equals(jTable1.getValueAt(j, 3).toString())) {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                        ilnik = 0;
                    }
                }
                if(flag==false){
                     for (int x = new FormUpdaterScnunas().selectMin(i); x <= new FormUpdaterScnunas().selectMax(i); x++) {
                         if(" Married-civ-spouse".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Married-AF-spouse".equals(jTable1.getValueAt(x - 1, 3).toString())||" Married-spouse-absent".equals(jTable1.getValueAt(x - 1, 3).toString()) ){
                            new FormUpdaterScnunas().updateNegara(x, "Marital");
                        }else if(" Divorced".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Never-married".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Separated".equals(jTable1.getValueAt(x - 1, 3).toString()) ||  " Widowed".equals(jTable1.getValueAt(x - 1, 3).toString())){
                            new FormUpdaterScnunas().updateNegara(x, "Single");
                        }
                     }
                }
                retrieve();
                for (int j = new FormUpdaterScnunas().selectMin(i); j < new FormUpdaterScnunas().selectMax(i); j++) {
                    if (!jTable1.getValueAt(j-1, 3).toString().equals(jTable1.getValueAt(j, 3).toString())) {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                    }
                }
                if(flag==true){
                    statuskawin = jTable1.getValueAt(new FormUpdaterScnunas().selectMin(i)-1,3).toString();
                    ilnik = 0.5;
                }else if(flag==false) {
                    statuskawin = "Kawins";
                    ilnik = 0;
                }              
                  umuryangdibagi=Integer.parseInt(jTable1.getValueAt(new FormUpdaterScnunas().selectMax(i)-1, 1).toString())-Integer.parseInt(jTable1.getValueAt(new FormUpdaterScnunas().selectMin(i)-1, 1).toString());
                  pembagiumur=new FormUpdaterScnunas().selectMaxUmur()-new FormUpdaterScnunas().selectMinUmur();
                  
                  informationLoss=new FormUpdaterScnunas().cariBanyakDataDalamCluster(i)*((umuryangdibagi/pembagiumur)+ilka+ilnik+ilwork)+informationLoss;
                  
                  System.out.print(" "+i);
                  System.out.print(kelamin);
                  System.out.print(" "+workclass);
                  System.out.print(" "+statuskawin);
                  System.out.print(" "+umur);
                  System.out.println(" "+informationLoss);
                  
            }
            
        }
        retrieve();
        System.out.println("UDAH");
        Date date = new Date();
        // display time and date using toString()
        System.out.println(date.toString());
    }                                   

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        Date date = new Date();
        // display time and date using toString()
        System.out.println(date.toString());
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JButton update;
    // End of variables declaration                   
}
