/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import Model.fiche_de_paie;
import Model.prime;
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
public class FicheDePaieCRUD {
    
    public void ajouterFicheDePaie(fiche_de_paie fp){
        try {
            String requete1 = "INSERT INTO fiche_de_paie (ID_Per,Salaire_init,ID_Prime,Salaire_total,Date_paiement,Etat_paiement)"
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = new MaConnexion().getCnx().prepareStatement(requete1);
            pst.setInt(1, fp.getID_Per());
            pst.setInt(2, fp.getSalaire_init());
            pst.setInt(3, fp.getPrime());
            pst.setInt(4, fp.getSalaire_total());
            pst.setDate(5, fp.getDate_paiement());
            pst.setString(6, fp.getEtat_paiement());
            pst.executeUpdate();
            System.out.println("Fiche de paie ajoutée avec succès! ");
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void supprimerFicheDePaie(fiche_de_paie a){
        
        try {
            String requete2 = "DELETE FROM fiche_de_paie WHERE ID_FP =?";
            PreparedStatement pst = new MaConnexion().getCnx().prepareStatement(requete2);
            pst.setInt(1, a.getID_FP());
            pst.executeUpdate();
            System.out.println("Fiche de paie supprimée avec succès!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     *
     * @param fp1
     */
    public void modifierFicheDePaie( fiche_de_paie fp1){
        
        try {
            String requete3 = " UPDATE `fiche_de_paie` SET `ID_FP`=?,`ID_Per`=?,`Salaire_init`=?,`ID_Prime`=?,`Salaire_total`=?,`Date_paiement`=?,`Etat_paiement`=?"
                    + " WHERE ID_FP="+fp1.getID_FP()+"";
            PreparedStatement pst = new MaConnexion().getCnx().prepareStatement(requete3);
            pst.setInt(1, fp1.getID_FP());
            pst.setInt(2, fp1.getID_Per());
            pst.setInt(3, fp1.getSalaire_init());
            pst.setInt(4, fp1.getPrime());
            pst.setInt(5, fp1.getSalaire_total());
            pst.setDate(6, fp1.getDate_paiement());
            pst.setString(7, fp1.getEtat_paiement());
            
            pst.executeUpdate();
            System.out.println("Fiche de paie modifiée avec succès!");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<fiche_de_paie> afficherFicheDePaie(){
        List<fiche_de_paie> myList = new ArrayList<>();
        try {  
            String requete4 = "SELECT * FROM `fiche_de_paie`";
            Statement st = new MaConnexion().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete4);
            while(rs.next()){
                fiche_de_paie fp = new fiche_de_paie(78,89,56,23,new Date(120,4,25),"ss");
                fp.setID_FP(rs.getInt(1));
                fp.setID_Per(rs.getInt(2));
                fp.setSalaire_init(rs.getInt(3));
                fp.setPrime(rs.getInt(4));
                fp.setSalaire_total(rs.getInt(5));
                fp.setDate_paiement(rs.getDate("Date_paiement"));
                fp.setEtat_paiement(rs.getString("Etat_paiement"));
                myList.add(fp);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
    
    
    
    
}
