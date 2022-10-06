/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSI Si Ahmed
 */
public class MaConnexion {
    //const
    final String URL = "jdbc:mysql://localhost:3306/pidev";
    final String USR = "root";
    final String PWD = "";

    //var
    static Connection cnx;
    //1
    static MaConnexion instance = null;
    
    //constructor

    public MaConnexion() {
        try {
            cnx = DriverManager.getConnection(URL,USR,PWD);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(MaConnexion.class.getName()).log(Level.SEVERE,null,ex);
        }
            
        }

    public static MaConnexion getInstance() {
        if(instance == null){
            instance = new MaConnexion();
        }
        return instance;
    }

    public static Connection getCnx() {
        return cnx;
    }  
       
    
    }
    

