/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Demande;
import java.sql.Connection;
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
public class DemandeCrud {
    
    Connection cnx2;
    public DemandeCrud(){
        cnx2 = MaConnexion.getInstance().getCnx();
    }
 
    
    public void ajouterDemande(Demande D){
        try {
            String req = "INSERT INTO `demande`(`Id_dem`, `Id_Per`, `Date_depot`, `Type_demande`, `Etat_demande`) VALUES (?,?,?,?,?)";
            
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setInt(1, D.getId_dem());
            pst.setInt(2, D.getId_Per());
            pst.setDate(3, D.getDate_depot());
            pst.setString(4, D.getType_demande());
            pst.setString(5, D.getEtat_demande());
            
            pst.executeUpdate();
            System.out.println("Demande ajoutée avec succès !");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Demande> afficherDemande(){
        
        List<Demande> myList = new ArrayList<>(); 
        try {                 
            String req2 = "SELECT * FROM demande";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req2);
            while (rs.next()){
                Demande d = new Demande ();
                
                d.setId_dem(rs.getInt(1));
                d.setId_Per(rs.getInt(2));
                d.setDate_depot(rs.getDate("Date_depot"));
                d.setType_demande(rs.getString("Type_demande"));
                d.setEtat_demande(rs.getString("Etat_demande"));
                
                myList.add(d);
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          return myList;
    }
    
    public void supprimerDemande(int id)  {
         
        try {
            System.out.println("entre l Id de demande a supprimer");
            String sql = "DELETE FROM `demande` WHERE Id_dem=?";
            PreparedStatement st=cnx2.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Demande a été supprimer avec succès !");
        } 
        catch (SQLException ex) { 
            System.out.println(ex);
        }
    }
    
    public void modifierDemande(Demande d1, int a) {
        String req="UPDATE `demande` SET `Id_dem`=?,`Id_Per`=?,`Date_depot`=?,`Type_demande`=?,`Etat_demande`=? WHERE `Id_dem`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, d1.getId_dem());
            pst.setInt(2, d1.getId_Per());
            pst.setDate(3, d1.getDate_depot());
            pst.setString(4, d1.getType_demande());
            pst.setString(5, d1.getEtat_demande());
            pst.setInt(6, a);

            pst.executeUpdate();
            System.out.println("Demande a été modifier avec succès !");
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
        }    
    }
}