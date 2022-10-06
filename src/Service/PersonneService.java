/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interfaces.PersonneInterface;
import Model.Personne;
import Util.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSI Si Ahmed
 */
public class PersonneService implements PersonneInterface {

    MaConnexion mac = MaConnexion.getInstance();
    
    Connection cnx2;
    public PersonneService(){
        cnx2 = MaConnexion.getInstance().getCnx();
    }
    
    @Override
    public void ajouterPersonne(Personne p) {
        String req="INSERT INTO `personne`(`Nom`, `Prenom`, `E_mail`, `CIN`, `URL_Photo`, `Date_de_naissance`, `Num_Tel`) VALUES (?,?,?,?,?,?,?)";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPernom());
            pst.setString(3, p.getEmail());
            pst.setString(4, p.getCin());
            pst.setString(5, p.getURL_Photo());
            pst.setDate(6, p.getDate_de_naissance());
            pst.setInt(7, p.getNum_Tel());

            pst.executeUpdate();
            System.out.println("added successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }


    @Override
    public List<Personne> afficherPersonne() {
        List<Personne> myList = new ArrayList<>();
        try {
            
            String req3="SELECT * FROM `personne`";
            Statement st= cnx2.createStatement();
            ResultSet rs=st.executeQuery(req3);
            while(rs.next()){
                Personne ps=new Personne();
                ps.setNom(rs.getString("Nom"));
                ps.setPernom(rs.getString("Prenom"));
                ps.setEmail(rs.getString("E_mail"));
                ps.setCin(rs.getString("CIN"));
                ps.setURL_Photo(rs.getString("URL_Photo"));
                ps.setDate_de_naissance(rs.getDate("Date_de_naissance"));
                ps.setNum_Tel(rs.getInt("Num_Tel"));

                myList.add(ps);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;    
    }

    @Override
    public void updatePersonne(Personne p, Personne p2) {
        String req="UPDATE `personne` SET `Nom`=?,`Prenom`=?,`E_mail`=?,`CIN`=?,`URL_Photo`=?,`Date_de_naissance`=?,`Num_Tel`=? WHERE CIN=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPernom());
            pst.setString(3, p.getEmail());
            pst.setString(4, p.getCin());
            pst.setString(5, p.getURL_Photo());
            pst.setDate(6, p.getDate_de_naissance());
            pst.setInt(7, p.getNum_Tel());
            pst.setString(8, p2.getCin());


            pst.executeUpdate();
            System.out.println("Modifie successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }    
    }

    @Override
    public void supprimerPersonne(Personne p) {
              System.out.println(p.getCin());

    try {      
      String sql = "DELETE FROM `personne` WHERE CIN=?";
      PreparedStatement pst;
      pst=cnx2.prepareStatement(sql);
      pst.setString(1, p.getCin());
      pst.executeUpdate();
      
      System.out.println("User a supprimer aves succeé");
     }
    catch (SQLException ex) { System.out.println(ex);
        }
    }
    
    
}
