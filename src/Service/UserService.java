/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Model.Employe;
import Model.user;
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
public class UserService {
    MaConnexion mac = MaConnexion.getInstance();
    
    Connection cnx2;
    public UserService(){
        cnx2 = MaConnexion.getInstance().getCnx();
    }

    
    public void ajouterUser(user e) {
        String req="INSERT INTO `user`(`Nom`, `Prenom`, `Email`, `Cin`, `URL_Photo`, `Date_de_naissance`, `Num_Tel`, `Date_embauche`, `Grade`, `Equipe`, `Role`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setString(1, e.getNom());
            pst.setString(2, e.getPernom());
            pst.setString(3, e.getEmail());
            pst.setString(4, e.getCin());
            pst.setString(5, e.getURL_Photo());
            pst.setDate(6, e.getDate_de_naissance());
            pst.setString(7, e.getNum_Tel());
            pst.setDate(8, e.getDate_embauche());
            pst.setString(9, e.getGrade());
            pst.setString(10, e.getEquipe());
            pst.setString(11, e.getRole());

            pst.executeUpdate();
            System.out.println("added successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }    }

    
    public List<user> afficherUser() {
        List<user> myList = new ArrayList<>();
        try {
            String req3="SELECT * FROM `user`";
            Statement st= cnx2.createStatement();
            ResultSet rs=st.executeQuery(req3);
            while(rs.next()){
                user ps=new user();
                ps.setId_user(rs.getInt("idUser"));
                ps.setNom(rs.getString("Nom"));
                ps.setPernom(rs.getString("Prenom"));
                ps.setDate_embauche(rs.getDate("Date_embauche"));
                ps.setGrade(rs.getString("Grade"));
                ps.setEquipe(rs.getString("Equipe"));
                ps.setEmail(rs.getString("Email"));
                ps.setCin(rs.getString("CIN"));
                ps.setURL_Photo(rs.getString("URL_Photo"));
                ps.setDate_de_naissance(rs.getDate("Date_de_naissance"));
                ps.setNum_Tel(rs.getString("Num_Tel"));

                myList.add(ps);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }

    
    public void updateUser(user e, int i) {
        String req="UPDATE `user` SET `Nom`=?,`Prenom`=?,`Email`=?,`Cin`=?,`URL_Photo`=?,`Date_de_naissance`=?,`Num_Tel`=?,`Date_embauche`=?,`Grade`=?,`Equipe`=?,`Role`=? WHERE `idUser`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setString(1, e.getNom());
            pst.setString(2, e.getPernom());
            pst.setString(3, e.getEmail());
            pst.setString(4, e.getCin());
            pst.setString(5, e.getURL_Photo());
            pst.setDate(6, e.getDate_de_naissance());
            pst.setString(7, e.getNum_Tel());
            pst.setDate(8, e.getDate_embauche());
            pst.setString(9, e.getGrade());
            pst.setString(10, e.getEquipe());
            pst.setString(11, e.getRole());
            pst.setInt(12, i);


            pst.executeUpdate();
            System.out.println("Modifie successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    
    public void supprimerUser(int e) {
    try {      
      String sql = "DELETE FROM `user` WHERE `idUser`=?";
      PreparedStatement pst;
      pst=cnx2.prepareStatement(sql);
      pst.setInt(1, e);
      pst.executeUpdate();
       
      System.out.println("User a supprimer aves succeé");
     }
    catch (SQLException ex) { System.out.println(ex);
        }
    }

}
