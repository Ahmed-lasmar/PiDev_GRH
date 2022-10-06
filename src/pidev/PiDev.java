/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Model.Employe;
import Model.Personne;
import Service.EmployeService;
import Service.PersonneService;
import Util.MaConnexion;
import java.sql.Date;

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

        //Personne p1 = new Personne("n","p","m","o","u",new Date(61616464L),12345678);
        //Personne p2 = new Personne("sn","pqd","mqd","qdo","uqds",new Date(616999964L),12345678);

        //ps.ajouterPersonne(p1);
        //ps.updatePersonne(p2, p1);
        //ps.supprimerUser(p2);
        
        Employe e1 = new Employe(517,new Date(120,7,01),"n","p","m","o","u","fff","dfs",new Date(61616464L),12345678);
        Employe e2 = new Employe(518,new Date(120,8,23),"n","p","m","o","u","fff","dfs",new Date(61616464L),12345678);
        
        es.ajouterEmploye(e2);
        //es.afficherEmploye();
        //es.updateEmploye(e1, e2);
        //es.supprimerEmploye(e1);
    }
    
}
