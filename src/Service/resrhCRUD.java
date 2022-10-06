/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import Model.res_rh;
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
 * @author ASUS
 */
public class resrhCRUD {
    Connection cnx2 ;

    public resrhCRUD() {
        cnx2 = MaConnexion.getInstance().getCnx();
    }
    public void ajouterRes(res_rh r){
        
        try {
            String requete = "INSERT INTO `res_rh`(`Id_RH`) VALUES (?)";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1, r.getId_RH());
            
            
            pst.executeUpdate();
            System.out.println("ajout avec succés");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimerRes(res_rh r){
        
        try {
            String requete2 = "DELETE FROM res_rh WHERE Id_RH=?";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, r.getId_RH());
            pst.executeUpdate();
            System.out.println("suppression avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void modifierRes(res_rh r, res_rh r2) {
        String requete3="UPDATE `res_rh` SET `Id_RH`=? WHERE `Id_RH`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(requete3);
            
            pst.setInt(1, r2.getId_RH());
            pst.setInt(2, r.getId_RH());


            pst.executeUpdate();
            System.out.println("modification avec succés");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }    
    }
    public List<res_rh> afficherResrh(){
        List<res_rh> myList = new ArrayList<>();
        try {
            String requete3 ="SELECT * FROM res_rh";
            Statement st = cnx2.createStatement();
            ResultSet rs=st.executeQuery(requete3);
            while(rs.next()){
                res_rh r = new res_rh();
                r.setId_RH(rs.getInt(1));
                
                myList.add(r);
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
    
}
