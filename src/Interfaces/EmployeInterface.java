/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Employe;
import java.util.List;
/**
 *
 * @author MSI Si Ahmed
 */
public interface EmployeInterface {
        //add:statement
    public void ajouterEmploye(Employe e);
    //fetch
    public List<Employe> afficherEmploye(); 
    //update
    public void updateEmploye(Employe e, Employe e2);
    //
    public void supprimerEmploye(Employe e);
}
