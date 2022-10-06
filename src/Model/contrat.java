/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author khlif
 */
public class contrat {
    private int ID_contrat;
    private String Type_contrat;
    private int Salaire;
    private Date Date_embauche;

    public contrat(int ID_contrat, String Type_contrat, int Salaire, Date Date_embauche) {
        this.ID_contrat = ID_contrat;
        this.Type_contrat = Type_contrat;
        this.Salaire = Salaire;
        this.Date_embauche = Date_embauche;
    }

    public contrat(String Type_contrat, int Salaire, Date Date_embauche) {
        this.Type_contrat = Type_contrat;
        this.Salaire = Salaire;
        this.Date_embauche = Date_embauche;
    }

    public contrat() {
    }

    public int getID_contrat() {
        return ID_contrat;
    }

    public void setID_contrat(int ID_contrat) {
        this.ID_contrat = ID_contrat;
    }

    public String getType_contrat() {
        return Type_contrat;
    }

    public void setType_contrat(String Type_contrat) {
        this.Type_contrat = Type_contrat;
    }

    public int getSalaire() {
        return Salaire;
    }

    public void setSalaire(int Salaire) {
        this.Salaire = Salaire;
    }

    public Date getDate_embauche() {
        return Date_embauche;
    }

    public void setDate_embauche(Date Date_embauche) {
        this.Date_embauche = Date_embauche;
    }

    @Override
    public String toString() {
        return "contrat{" + "ID_contrat=" + ID_contrat + ", Type_contrat=" + Type_contrat + ", Salaire=" + Salaire + ", Date_embauche=" + Date_embauche + '}';
    }
    
    
}
