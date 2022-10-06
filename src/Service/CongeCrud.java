/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Congé;
import model.Demande;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Util.MaConnexion;

/**
 *
 * @author HP
 */
public class CongeCrud {
    
     Connection cnx2;
    public CongeCrud(){
        cnx2 = MaConnexion.getInstance().getCnx();
    }
    
    public void ajouterConge(Congé c){
        try {
            String req = "INSERT INTO `conge`(`d_depart`, `d_retour`) VALUES (?,?)";
            
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setDate(1, (Date) c.getD_depart());
            pst.setDate(2, (Date) c.getD_retour());
            
            pst.executeUpdate();
            System.out.println("Demande de Congé ajoutée avec succès !");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Demande> afficherDemande(){
        
        List<Demande> myList = new ArrayList<>(); 
        try {                 
            String req2 = "SELECT * FROM conge";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req2);
            while (rs.next()){
                Congé c = new Congé ();
                
                c.setD_depart(rs.getDate("d_depart"));
                c.setD_retour(rs.getDate("d_retour"));
                              
                myList.add(c);               
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          return myList;
    }
    
    public void supprimerConge(int id)  {
         
        try {
            System.out.println("entre l Id de demande a supprimer");
            String sql = "DELETE FROM `conge` JOIN `demande`  WHERE Id_dem=?";
            PreparedStatement st=cnx2.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Demande de Congé a été supprimer avec succès !");
        } 
        catch (SQLException ex) { 
            System.out.println(ex);
        }
    }
}
