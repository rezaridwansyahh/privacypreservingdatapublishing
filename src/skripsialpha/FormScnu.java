/*
 * To change this license header, choose License Headers in Project Properties.
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
public class FormScnu extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    public FormScnu() {
        initComponents();
    }

    private void retrieve() {
        DefaultTableModel dm = new FormUpdaterScnu().getData();
        jTable1.setModel(dm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        retrieve();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
         
        int k=12;
        int clus=0;
        int jumlahbaris= jTable1.getRowCount();
        for(int i=0;i<jumlahbaris;i++){
            if((i+1)%k==0){
                clus+=1;
                // j =2 , j>2-2=0
                for(int j=i;j>=(i-(k-1));j--){
                    new FormUpdaterScnu().updatecluster(j+1, clus);
                    //System.out.println(j);
                    System.out.println((j+1) + " " + clus);
                }
                
            }
        }
        new FormUpdaterScnu().updatesisacluster((new FormUpdaterScnu().selectMaxScnu()));
        retrieve();
        Date date = new Date();
        // display time and date using toString()
        System.out.println(date.toString());
    }//GEN-LAST:event_jButton2MouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
        
        int jumlahbari = new FormUpdaterScnu().selectMaxScnu();
        String negfix = "xxx";
        String kelamin="gender";
        
        String umur;
        double pembagiumur;
        double umuryangdibagi;
        
        double banyakcluster;
        double informationLoss=0;
        double ilumur;
        for (int i = 0; i <= jumlahbari; i++) {
            banyakcluster = new FormUpdaterScnu().cariBanyakDataDalamCluster(i);
            boolean flag = false;
            boolean flags= false;
            int ilka=0;
            double ilneg=0;
            if (new FormUpdaterScnu().cariBanyakDataDalamCluster(i) > 0) {
//                int maxawal = new FormUpdaterOka().selectMax(i);
//                int minakhir = new FormUpdaterOka().selectMin(i);


                for (int a = new FormUpdaterScnu().selectMin(i); a < new FormUpdaterScnu().selectMax(i); a++) {
                    if (!jTable1.getValueAt(a-1, 1).toString().equals(jTable1.getValueAt(a, 1).toString())) {
                        flags = false;
                        break;
                    } else {
                        flags = true;
                    }
                }
                
                if (flags==true){
                    kelamin = jTable1.getValueAt(new FormUpdaterScnu().selectMin(i)-1, 1).toString();
                    ilka=0;
                }else if (flag==false){
                    kelamin="kelamin";
                    ilka=1;
                }
                umur= jTable1.getValueAt(new FormUpdaterScnu().selectMin(i)-1, 2).toString() + " - " + jTable1.getValueAt(new FormUpdaterScnu().selectMax(i)-1, 2).toString();
                for (int j = new FormUpdaterScnu().selectMin(i); j < new FormUpdaterScnu().selectMax(i); j++) {
                    if (!jTable1.getValueAt(j-1, 3).toString().equals(jTable1.getValueAt(j, 3).toString())) {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                    }
                }
                if (flag == false) {
                    for (int x = new FormUpdaterScnu().selectMin(i); x <= new FormUpdaterScnu().selectMax(i); x++) {
                        if (" Peru".equals(jTable1.getValueAt(x - 1, 3).toString()) ||" Mexico".equals(jTable1.getValueAt(x - 1, 3).toString()) ||" Honduras".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Haiti".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Guatemala".equals(jTable1.getValueAt(x - 1, 3).toString()) || " El-Salavdor".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Ecuador".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Dominican-Republic".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Columbia".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Canada".equals(jTable1.getValueAt(x - 1, 3).toString()) || " United-States".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Cuba".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Mexico".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Puerto-Rico".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Jamaica".equals(jTable1.getValueAt(x - 1, 3).toString()) || "Jamaica".equals(jTable1.getValueAt(x - 1, 3).toString())) {
                            new FormUpdaterScnu().updateNegara(x, "Amerika");
                        } else if (" Vietnam".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Thailand".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Taiwan".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Philippines".equals(jTable1.getValueAt(x - 1, 3).toString()) ||" Laos".equals(jTable1.getValueAt(x - 1, 3).toString()) ||" Japan".equals(jTable1.getValueAt(x - 1, 3).toString()) ||" Iran".equals(jTable1.getValueAt(x - 1, 3).toString()) || " India".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Hong".equals(jTable1.getValueAt(x - 1, 3).toString()) || " China".equals(jTable1.getValueAt(x - 1, 3).toString()) || " India".equals(jTable1.getValueAt(x - 1, 3).toString()) ||" Camboodia".equals(jTable1.getValueAt(x - 1, 3).toString()) || " South".equals(jTable1.getValueAt(x - 1, 3).toString())) {
                            new FormUpdaterScnu().updateNegara(x, "Asia");
                        } else if(" Yugoslavia".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Scotland".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Italy".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Portugal".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Poland".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Italy".equals(jTable1.getValueAt(x - 1, 3).toString()) ||" Ireland".equals(jTable1.getValueAt(x - 1, 3).toString()) ||" Hungary".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Greece".equals(jTable1.getValueAt(x - 1, 3).toString()) || " Germanya".equals(jTable1.getValueAt(x - 1, 3).toString()) || " England".equals(jTable1.getValueAt(x - 1, 3).toString()) || " France".equals(jTable1.getValueAt(x - 1, 3).toString())){
                            new FormUpdaterScnu().updateNegara(x, "Eropa");
                        } else if(" Trinadad&Tobago".equals(jTable1.getValueAt(x - 1, 3).toString())){
                            new FormUpdaterScnu().updateNegara(x, "Afrika");
                        }
                    }
                    retrieve();
                    for (int y = new FormUpdaterScnu().selectMin(i); y < new FormUpdaterScnu().selectMax(i); y++) {
                        if (!jTable1.getValueAt(y-1, 3).toString().equals(jTable1.getValueAt(y, 3).toString())) {
                            flag = false;
                            break;
                        } else {
                            flag = true;
                        }
                    }
                    if(flag==true){
                        negfix=jTable1.getValueAt(new FormUpdaterScnu().selectMin(i)-1, 3).toString();
                        ilneg=0.5;
                    }else if(flag==false){
                        negfix="dunia";
                        ilneg=1;
                    }
                } else if (flag == true) {
                    negfix = jTable1.getValueAt(new FormUpdaterScnu().selectMin(i), 3).toString();
                    ilneg=0;
                }
                
                umuryangdibagi=Integer.parseInt(jTable1.getValueAt(new FormUpdaterScnu().selectMax(i)-1, 2).toString())-Integer.parseInt(jTable1.getValueAt(new FormUpdaterScnu().selectMin(i)-1, 2).toString());
                pembagiumur=new FormUpdaterScnu().selectMaxUmur()-new FormUpdaterScnu().selectMinUmur();
                
                informationLoss=new FormUpdaterScnu().cariBanyakDataDalamCluster(i)*((umuryangdibagi/pembagiumur)+ilka+ilneg)+informationLoss;
                System.out.print(i);
                System.out.print(" " + negfix + " ");
                System.out.print(" " +kelamin + " ");
                System.out.print(" "+ umur + " ");
                System.out.print(" "+ informationLoss + " ");
                System.out.println();
                
                new FormUpdaterScnu().update(i, kelamin, umur, negfix);
                

            }
            
        }
        retrieve();
        System.out.println("UDAH");
        Date date = new Date();
        // display time and date using toString()
        System.out.println(date.toString());
    }//GEN-LAST:event_updateMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Date date = new Date();
        // display time and date using toString()
        System.out.println(date.toString());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
