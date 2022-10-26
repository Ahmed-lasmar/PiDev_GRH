/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Model.Employe;
import Model.Personne;
import Model.user;
import Service.EmployeService;
import Service.PersonneService;
import Service.SendSMS;
import Service.UserService;
import Util.MaConnexion;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author MSI Si Ahmed*
 */
public class PiDev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MaConnexion mac = MaConnexion.getInstance();
        PersonneService ps = new PersonneService();
        EmployeService es = new EmployeService();
        UserService us = new UserService(); 

        //Personne p1 = new Personne("n","p","m","o","u",new Date(61616464L),12345678);
        //Personne p2 = new Personne("sn","pqd","mqd","qdo","uqds",new Date(616999964L),12345678);

        //ps.ajouterPersonne(p1);
        //ps.updatePersonne(p2, p1);
        //ps.supprimerUser(p2);
        
        Employe e1 = new Employe(new Date(120,7,01),"n","p","m","o","u","fff","dfs",new Date(61616464L),12345678);
        Employe e2 = new Employe(new Date(120,8,23),"n","p","m","o","u","fff","dfs",new Date(61616464L),12345678);
        user u1 = new user("Lasmar","ahmed","mail@email.com","12345678","www",new Date(120,8,23),"24330330",new Date(120,8,23),"admin","Dev","admin","mdp");
        user u2 = new user("a","z","mail@emailcqc.com","123678","www",new Date(130,8,23),"243330",new Date(150,8,23),"admin","Dev","admin","mdp");
        //es.ajouterEmploye(e1);
        //es.ajouterEmploye(e2);
        //es.afficherEmploye();
        //es.updateEmploye(e1, e2);
        //es.supprimerEmploye(e1);
        //us.ajouterUser(u1);
        //us.updateUser(u2, u1);
        user u3 = new user("ahmed.lasmar@gmail.com","safnzhneqh");
                user u4 = new user();
        System.out.println(u3);

        //us.supprimerUser(u2);
        u4=us.login(u3);
        System.out.println(u4);
        //us.updateUserMdp("v", "m");
        //SendSMS ss=new SendSMS();
        
    }   
}