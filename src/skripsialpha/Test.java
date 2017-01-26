/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsialpha;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author rezar_4
 */
public class Test {

//      negaraBenua(String negara){
//          if("jepang".equals(negara)){
//              negara="Asia";
//          }
//          this.negara = negara;
//      }
    public static void main(String[] args) {
        // TODO code application logic here

        //<!-- logic clustering -->
//        int nomor1[]={19,19,20,21,22,23,23,24,25,25,28,29,30,30,31,31,31,32,32,34,35,37,37,38,38,39,39,40,40,41,42,43,43,44,45,48,48,49,49,49,50,52,53,53,53,54,54,56,57,59};
//        int nomor2[]={19,19,20,21,22,23,23,24,25,25,28,29,30,30,31,31,31,32,32,34,35,37,37,38,38,39,39,40,40,41,42,43,43,44,45,48,48,49,49,49,50,52,53,53,53,54,54,56,57,59};
//        int panjang= nomor1.length;
//        int cluster;
//       
//        int z= Math.abs(nomor1[0]-nomor1[3]);
//        //System.out.println(z);
//        for (int x=0;x<panjang;x++){
//            int minimal=100;
//            for(int y=0;y<panjang;y+=3){
//                if(Math.abs(nomor1[x]-nomor1[y])<minimal && x!=y){
//                    minimal=Math.abs(nomor1[x]-nomor1[y]);
//                    cluster = y/3;
//                    int clusterori=y;
//                    System.out.print(nomor1[x] + "-" + x + " " +nomor1[y] + "-" + y + " ");
//                    System.out.print(minimal + " " + cluster + " |" + clusterori + " |" );
//                    
//                }
//                
////                System.out.print(minimal+" ");
//            }
//            System.out.println();
//        }
        /* String consString = "jdbc:mysql://localhost:3306/fake";
         String username = "root";
         String password = "";
         String sql = "select max(id_coba) from oka where cluster='0';";  
         int id_coba=0;
         try {
         Connection con = DriverManager.getConnection(consString, username, password);
         Statement s = con.prepareStatement(sql);
         ResultSet rs = s.executeQuery(sql);           
         //            looping
         while (rs.next()) {
         id_coba = rs.getInt(1);            
         }
         s.close();
         } catch (Exception ex) {
         ex.printStackTrace();
         System.err.println("Got an exception! ");
         }
         System.out.println(id_coba); */
//        ArrayList list= new ArrayList();
//        int angka;
//        int panjang;
//        Scanner seken = new Scanner(System.in);
//        for(int x=0;x<=2;x++){
//             System.out.print("Masukan angka : ");
//             angka= seken.nextInt();
//             list.add(x, angka);
//             System.out.println();
//        }
//        System.out.print("----------------------\n");
//        
//        for(Object y : list){
//            System.out.println(y);
//        }
//        
//        System.out.print("Tambah nilai bos : ");
//        angka = seken.nextInt();
//        
////        list.add(list.size(), seken);
//       
//        for(Object y : list){
//            System.out.println(y);
//        }
//        String negara[] ={"indonesia","indonesia","indonesia","indonesia","indonesia"};
//        String negarafix;
//        boolean flag=false;
//        for (int i=0;i<negara.length-1;i++){
//            if(negara[i]==negara[i+1]){
//                flag=true;
//            }
//            else{
//                flag = false;
//                break;
//            }
//        }
//        if(flag==false){
//            for (int x=0;x<negara.length;x++){
//                if(negara[x]=="arab" || negara[x]=="indonesia"){
//                    negara[x]="asia";
//                }else if(negara[x]=="amerika" || negara[x]=="kanada"){
//                    negara[x]="American";
//                }else if(negara[x]=="jerman"){
//                    negara[x]="Eropa";
//                }
//            }
//            for (int j=0;j<negara.length-1;j++){
//                if(negara[j].equals(negara[j+1])){
//                    flag=true;
//                }
//                else{
//                    flag = false;
//                    break;
//                }
//            }
//            
//            if(flag==true){
//                negarafix=negara[negara.length-1];
//            }else{
//                negarafix="dunia";
//            }
//        }else{
//            negarafix=negara[negara.length-1];
//        }
//       
//        
//        
//        System.out.print(negarafix);
        Date date = new Date();
        Date dates = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // display time and date using toString()
        System.out.println(date.toString());
        
        String reza="ganteng maksimal";
        
        for(int i=0;i<=1000000;i++){
            System.out.println(reza);
            if(i>=1000000){
                break;
            }
        }
        System.out.println(dates.toString());
        
        
        System.out.println(dateFormat.format(dates));
    }
}
