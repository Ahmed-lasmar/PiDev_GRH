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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OffreEmploi;
import Util.MaConnexion;

/**
 *
 * @author radhw
 */
public class EmploiServices {

    Connection cnx2;
    public EmploiServices() {
        cnx2=MaConnexion.getInstance().getCnx();
    }
    
    public void ajouterOffre(OffreEmploi oe){
        String req="INSERT INTO `offreemploi`(`id_offre`, `nomOffre`, `description`, `dateDepot`, `dateFin`) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, oe.getId_offre());
            pst.setString(2, oe.getNomOffre());
            pst.setString(3, oe.getDescription());
            pst.setString(4, oe.getDateDepot());
            pst.setString(5, oe.getDate_fin());
            pst.executeUpdate();
            System.out.println("added successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    public void modifierOffre(OffreEmploi oe){
        String req="UPDATE `offreemploi` SET `id_offre`=?,`nomOffre`=?,`description`=?,`dateDepot`=?,`dateFin`=? WHERE 1";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, oe.getId_offre());
            pst.setString(2, oe.getNomOffre());
            pst.setString(3, oe.getDescription());
            pst.setString(4, oe.getDateDepot());
            pst.setString(5, oe.getDate_fin());
            pst.executeUpdate();
            System.out.println("updated successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
     public void supprimerOffre(OffreEmploi oe){
        String req="DELETE FROM `offreemploi` WHERE `id_offre`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, oe.getId_offre());
            pst.executeUpdate();
            System.out.println("deleted successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    public List<OffreEmploi> afficherOffres(){
        List<OffreEmploi> myList = new ArrayList<>();
        try {
            
            String req3="SELECT * FROM `offreemploi`";
            Statement st=cnx2.createStatement();
            ResultSet rs=st.executeQuery(req3);
            while(rs.next()){
                OffreEmploi oe=new OffreEmploi();
                oe.setId_offre(rs.getInt(1));
                oe.setNomOffre(rs.getString("nomOffre"));
                oe.setDescription(rs.getString("description"));
                oe.setDateDepot(rs.getString("dateDepot"));
                oe.setDate_fin(rs.getString("dateFin"));
                myList.add(oe);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
}
