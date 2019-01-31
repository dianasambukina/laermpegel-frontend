//package org.htw.fiw;
//
//import java.rmi.Naming; 
//
//import org.htw.fiw.FrontendServer;
// 
//public class Client { 
// 
//    public static void main(String[] args) { 
//        try { 
//            FrontendServer fs = (FrontendServer)
//                           Naming.lookup(
//                 "rmi://localhost/FrontendServer/"); 
//            fs.receiveSensor(54.3, 13.10);
//            fs.receiveValue(100.85);
//        } 
//        catch (Exception e) { 
//            System.out.println(e);  
//        } 
//    } 
//} 
