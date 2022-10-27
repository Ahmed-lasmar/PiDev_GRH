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
            String req = "INSERT INTO `conge`(`idPer`, `dDepot`, `typeDemande`, `etatDemande`, `dDepart`, `dRetour`) VALUES (?,?,?,?,?,?)";
            
            PreparedStatement pst = cnx2.prepareStatement(req);
            pst.setInt(1, c.getIdPer());
            pst.setDate(2, (Date) c.getdDepot());
            pst.setString(3, c.getTypeDemande());
            pst.setString(4, c.getEtatDemande());
            pst.setDate(5, (Date) c.getdDepart());
            pst.setDate(6, (Date) c.getdRetour());
            
            pst.executeUpdate();
            System.out.println("Demande de Congé ajoutée avec succès !");
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public List<Congé> afficherDemande(){
        
        List<Congé> myList = new ArrayList<Congé>(); 
        try {                 
            String req2 = "SELECT * FROM conge";
            Statement st = cnx2.createStatement();
            ResultSet rs = st.executeQuery(req2);
            while (rs.next()){
                Congé c = new Congé();
                //``, ``, ``, ``, ``, ``
                c.setdDepot(rs.getDate("dDepot"));
                c.setdDepart(rs.getDate("dDepart"));
                c.setdRetour(rs.getDate("dRetour"));
                c.setIdPer(rs.getInt("idPer"));
                c.setTypeDemande(rs.getString("typeDemande"));
                c.setEtatDemande(rs.getString("etatDemande"));
                              
                myList.add(c);               
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          return myList;
    }
    
    public void supprimerConge(int id)  {
         
        try {
            
            String sql = "DELETE FROM `conge` WHERE idCon=?";
            PreparedStatement st=cnx2.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Demande de Congé a été supprimer avec succès !");
        } 
        catch (SQLException ex) { 
            System.out.println(ex);
        }
    }
    
    public void updateUser(Congé c, int i) {
        String req="UPDATE `conge` SET `idPer`=?,`dDepot`=?,`typeDemande`=?,`etatDemande`=?,`dDepart`=?,`dRetour`=? WHERE idCon=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, c.getIdPer());
            pst.setDate(2, (Date) c.getdDepot());
            pst.setString(3, c.getTypeDemande());
            pst.setString(4, c.getEtatDemande());
            pst.setDate(5, (Date) c.getdDepart());
            pst.setDate(6, (Date) c.getdRetour());
            pst.setInt(7, i);



            pst.executeUpdate();
            System.out.println("Modifie successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
}
