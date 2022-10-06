/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.candidat;
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
public class CandidatCRUD {
    Connection cnx2 ;

    public CandidatCRUD() {
        cnx2 = MaConnexion.getInstance().getCnx();
    }
    public void ajouterCandidat(candidat c){
        
        try {
            String requete = "INSERT INTO candidat (URL_CV,D_Post,Competence)"
                    + " VALUES (?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setString(1, c.getURL_CV());
            pst.setDate(2, c.getD_Post());
            pst.setString(3, c.getCompetence());
            
            pst.executeUpdate();
            System.out.println("Votre personne est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
    
    
    public void supprimerCandidat(candidat c){
        
        try {
            String requete2 = "DELETE FROM candidat WHERE Id_Can =?";
            PreparedStatement pst = cnx2.prepareStatement(requete2);
            pst.setInt(1, c.getId_Can());
            pst.executeUpdate();
            System.out.println("candidat supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void modifierCandidat(candidat c, candidat c2) {
        String requete3="UPDATE candidat SET URL_CV=?,D_Post=?,Competence=? WHERE Id_Can=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(requete3);
            pst.setString(1, c2.getURL_CV());
            pst.setDate(2, c2.getD_Post());
            pst.setString(3, c2.getCompetence());
            pst.setInt(4, c.getId_Can());


            pst.executeUpdate();
            System.out.println("modification avec succés");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }    
    }
    
    
    public List<candidat> afficherCandidats(){
        List<candidat> myList = new ArrayList<>();
        try {
            String requete3 ="SELECT * FROM candidat";
            Statement st = cnx2.createStatement();
            ResultSet rs=st.executeQuery(requete3);
            while(rs.next()){
                candidat c = new candidat();
                c.setId_Can(rs.getInt(1));
                c.setURL_CV(rs.getString("URL_CV"));
                c.setD_Post(rs.getDate("D_Post"));
                c.setCompetence(rs.getString("Competence"));
                myList.add(c);
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
    
    
}
