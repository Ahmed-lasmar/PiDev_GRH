/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.formateur;
import entities.formation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author ASUS
 */
public class formateurCRUD {
    Connection cnx2 ;
    public formateurCRUD() {
        cnx2 = MyConnection.getInstance().getCnx();
    }
    public void ajouterFormateur(formateur f){
        
        try {
            String requete = "INSERT INTO formateur (nom,prenom,adresse,email,tel,codeP,ville,pays,status,tarif,tva,bio,diplome)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            //pst.setInt(1, f.getId_Formateur());
            pst.setString(1,f.getNom());
            pst.setString(2, f.getPrenom());
            pst.setString(3, f.getAdresse());
            pst.setString(4, f.getEmail());
            pst.setInt(5,f.getTel());
            pst.setInt(6, f.getCodeP());
            pst.setString(7, f.getVille());
            pst.setString(8, f.getPays());
            pst.setString(9, f.getStatus());
            pst.setInt(10, f.getTarif());
            pst.setInt(11, f.getTva());
            pst.setString(12, f.getBio());
            pst.setString(13, f.getDiplome());
            
            pst.executeUpdate();
            System.out.println("Votre formateur est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void supprimer(formateur f) {
try {
            String sql = "DELETE FROM `formateur` WHERE Id_Formateur = "+ f.getId_Formateur();

         
            PreparedStatement ste = cnx2.prepareStatement(sql);
            ste.executeUpdate();
            
            System.out.println("formateur supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(formateurCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifier(formateur f) {
        String req = "UPDATE formateur set nom=?, prenom=?, adresse=? ,email=? ,tel=?, codeP=?, ville=?, pays=?, status=?, tarif=?, tva=?, bio=?, diplome=? WHERE Id_Formateur="+ f.getId_Formateur()+ "";
    try {
            PreparedStatement ste = cnx2.prepareStatement(req);
           
            ste.setString(1, f.getNom());
            ste.setString(2, f.getPrenom());
            ste.setString(3, f.getAdresse());   
            ste.setString(4, f.getEmail());
            ste.setInt(5, f.getTel());
            ste.setInt(6, f.getCodeP());
            ste.setString(7, f.getVille());
            ste.setString(8, f.getPays());
            ste.setString(9, f.getStatus());
            ste.setInt(10, f.getTarif());
            ste.setInt(11, f.getTva());
            ste.setString(12, f.getBio());
            ste.setString(13, f.getDiplome());
            
        
           ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification de formateur a été éffectuée avec succès ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(formateurCRUD.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }
    public List<formateur> afficherFormateur(){
        List<formateur> myList = new ArrayList<>();
        try {
            String requete3 ="SELECT * FROM formateur";
            Statement st = cnx2.createStatement();
            ResultSet rs=st.executeQuery(requete3);
            while(rs.next()){
                formateur f = new formateur();
                f.setId_Formateur(rs.getInt("Id_Formateur"));
                f.setNom(rs.getString("nom"));
                f.setPrenom(rs.getString("prenom"));
                f.setAdresse(rs.getString("adresse"));
                f.setEmail(rs.getString("email"));
                f.setTel(rs.getInt("tel"));
                f.setCodeP(rs.getInt("codeP"));
                f.setVille("ville");
                f.setPays(rs.getString("pays"));
                f.setStatus(rs.getString("status"));
                f.setTarif(rs.getInt("tarif"));
                f.setTva(rs.getInt("tva"));
                f.setBio(rs.getString("bio"));
                f.setDiplome(rs.getString("diplome"));
                myList.add(f);
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
}
