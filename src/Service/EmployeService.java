/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interfaces.EmployeInterface;
import Model.Employe;
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
public class EmployeService implements EmployeInterface{
    
    MaConnexion mac = MaConnexion.getInstance();
    
    Connection cnx2;
    public EmployeService(){
        cnx2 = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouterEmploye(Employe e) {
        String req="INSERT INTO `employe`(`Id_per`, `Date_embauche`, `Grade`, `Equipe`) VALUES (?,?,?,?)";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, e.getId_Per());
            pst.setDate(2, e.getDate_embauche());
            pst.setString(3, e.getGrade());
            pst.setString(4, e.getEquipe());

            pst.executeUpdate();
            System.out.println("added successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }    }

    @Override
    public List<Employe> afficherEmploye() {
        List<Employe> myList = new ArrayList<>();
        try {
            String req3="SELECT * FROM `employe`";
            Statement st= cnx2.createStatement();
            ResultSet rs=st.executeQuery(req3);
            while(rs.next()){
                Employe ps=new Employe();
                ps.setId_Per(rs.getInt("Id_per"));
                ps.setDate_embauche(rs.getDate("Date_embauche"));
                ps.setGrade(rs.getString("Grade"));
                ps.setEquipe(rs.getString("Equipe"));

                myList.add(ps);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }

    @Override
    public void updateEmploye(Employe e, Employe e2) {
        String req="UPDATE `employe` SET `Id_per`=?,`Date_embauche`=?,`Grade`=?,`Equipe`=? WHERE `Id_per`=?";
        try{
            PreparedStatement pst;
            pst = cnx2.prepareStatement(req);
            pst.setInt(1, e.getId_Per());
            pst.setDate(2, e.getDate_embauche());
            pst.setString(3, e.getGrade());
            pst.setString(4, e.getEquipe());
            pst.setInt(5, e2.getId_Per());


            pst.executeUpdate();
            System.out.println("Modifie successfully");
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerEmploye(Employe e) {
    try {      
      String sql = "DELETE FROM `employe` WHERE `Id_per`=?";
      PreparedStatement pst;
      pst=cnx2.prepareStatement(sql);
      pst.setInt(1, e.getId_Per());
      pst.executeUpdate();
      
      System.out.println("User a supprimer aves succeé");
     }
    catch (SQLException ex) { System.out.println(ex);
        }
    }

    
}
