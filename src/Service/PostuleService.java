/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.OffreEmploi;
import model.Postule;
import Util.MaConnexion;

/**
 *
 * @author radhw
 */
public class PostuleService {
    
    Connection cnx2;
    public PostuleService() {
        cnx2=MaConnexion.getInstance().getCnx();
    }
    public void ajouterPostule(Postule p){
        String req="INSERT INTO `postule`(`id_postule`, `id_can`, `id_off`, `datePost`, `etatPost`) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, p.getId_postule());
            pst.setInt(2, p.getId_can());
            pst.setInt(3, p.getId_off());
            pst.setString(4, p.getDatePost());
            pst.setString(5, p.getEtatPost());
            pst.executeUpdate();
            System.out.println("added successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
     public void modifierPostule(Postule p){
        String req="UPDATE `postule` SET `id_postule`=?,`id_can`=?,`id_off`=?,`datePost`=?,`etatPost`=? WHERE 1";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
           pst.setInt(1, p.getId_postule());
            pst.setInt(2, p.getId_can());
            pst.setInt(3, p.getId_off());
            pst.setString(4, p.getDatePost());
            pst.setString(5, p.getEtatPost());
            pst.executeUpdate();
            System.out.println("updated successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
     public void supprimerPostule(Postule p){
        String req="DELETE FROM `postule` WHERE `id_offre`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, p.getId_postule());
            pst.executeUpdate();
            System.out.println("deleted successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
      public List<Postule> afficherPostules(){
        List<Postule> myList = new ArrayList<>();
        try {
            
            String req3="SELECT * FROM `postule`";
            Statement st=cnx2.createStatement();
            ResultSet rs=st.executeQuery(req3);
            while(rs.next()){
                Postule p=new Postule();
                p.setId_postule(rs.getInt(1));
                p.setId_off(rs.getInt(3));
                p.setId_can(rs.getInt(2));
                p.setDatePost(rs.getString("datePost"));
                p.setEtatPost(rs.getString(5));
                myList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
}
