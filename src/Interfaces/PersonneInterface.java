/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.Personne;
import java.util.List;

/**
 *
 * @author MSI Si Ahmed
 */
public interface PersonneInterface {
    
    //add:statement
    public void ajouterPersonne(Personne p);
    //fetch
    public List<Personne> afficherPersonne(); 
    //update
    public void updatePersonne(Personne p, Personne p2);
    //
    public void supprimerPersonne(Personne p);
}
