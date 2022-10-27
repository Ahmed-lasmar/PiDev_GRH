/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.*;
import Util.MaConnexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khlif
 */
public class PrimeCRUD {
    
    public void ajouterPrime(prime p){
        try {
            String requete1 = "INSERT INTO prime (Type_Prime,Valeur_Prime,Date_Prime) VALUES (?,?,?)";
            PreparedStatement pst = MaConnexion.getCnx().prepareStatement(requete1);
            pst.setString(1, p.getType_Prime());
            pst.setInt(2, p.getValeur_Prime());
            pst.setDate(3, p.getDate_Prime());
            pst.executeUpdate();
            System.out.println("Prime ajoutée avec succès! ");
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimerPrime(prime a){
        
        try {
            String requete2 = "DELETE FROM prime WHERE ID_Prime=?";
            PreparedStatement pst = new MaConnexion().getCnx().prepareStatement(requete2);
            pst.setInt(1, a.getID_Prime());
            pst.executeUpdate();
            System.out.println("Fiche de paie supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void modifierPrime(prime p){
        
        try {
            String requete3 = " UPDATE `prime` SET `Type_Prime`=?,`Valeur_Prime`=?,`Date_Prime`=?"
                    + " WHERE ID_Prime=?";
            PreparedStatement pst = new MaConnexion().getCnx().prepareStatement(requete3);
            pst.setString(1, p.getType_Prime());
            pst.setInt(2, p.getValeur_Prime());
            pst.setDate(3, p.getDate_Prime());
            pst.setInt(4, p.getID_Prime());
            pst.executeUpdate();
            System.out.println("Prime modifiée avec succès!");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<prime> afficherPrime(){
        List<prime> myList = new ArrayList<>();
        try {  
            String requete4 = "SELECT * FROM `prime`";
            Statement st = new MaConnexion().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete4);
            while(rs.next()){
                prime fp = new prime(78,"logique",56,new Date(120,4,25));
                fp.setID_Prime(rs.getInt(1));
                fp.setType_Prime(rs.getString("Type_Prime"));
                fp.setValeur_Prime(rs.getInt(3));
                fp.setDate_Prime(rs.getDate("Date_Prime"));
                myList.add(fp);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
}
