/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.fiche_de_paie;
import Model.contrat;
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
public class ContratCRUD {
    
    public void ajouterContrat(contrat c){
        try {
            String requete1 = "INSERT INTO contrat (Type_contrat,Salaire,Date_embauche)"
                    + "VALUES (?,?,?)";
            PreparedStatement pst = new MaConnexion().getCnx().prepareStatement(requete1);
            
            pst.setString(1, c.getType_contrat());
            pst.setInt(2, c.getSalaire());
            pst.setDate(3, c.getDate_embauche());
            pst.executeUpdate();
            System.out.println("Contrat ajoutée avec succès! ");
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimerContrat(int a){
        
        try {
            String requete2 = "DELETE FROM contrat WHERE ID_contrat =?";
            PreparedStatement pst = new MaConnexion().getCnx().prepareStatement(requete2);
            pst.setInt(1, a);
            pst.executeUpdate();
            System.out.println("Contrat supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @param fp
     * @param fp1
     */
    public void modifierContrat(int a, contrat c){
        
        try {
            String requete3 = " UPDATE `contrat` SET `ID_contrat`=?,`Type_contrat`=?,`Salaire`=?,`Date_embauche`=?"
                    + " WHERE ID_contrat=?";
            PreparedStatement pst = new MaConnexion().getCnx().prepareStatement(requete3);
            pst.setInt(1, c.getID_contrat());
            pst.setString(2, c.getType_contrat());
            pst.setInt(3, c.getSalaire());
            pst.setDate(4, c.getDate_embauche());
            pst.setInt(5, a);
            pst.executeUpdate();
            System.out.println("Contrat modifiée avec succès!");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<contrat> afficherContrat(){
        List<contrat> myList = new ArrayList<>();
        try {  
            String requete4 = "SELECT * FROM `contrat`";
            Statement st = new MaConnexion().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete4);
            while(rs.next()){
                contrat c = new contrat(78,"89",56,new Date(120,4,25));
                c.setID_contrat(rs.getInt(1));
                c.setType_contrat(rs.getString("Type_contrat"));
                c.setSalaire(rs.getInt(3));
                c.setDate_embauche(rs.getDate("Date_embauche"));
                myList.add(c);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
}
