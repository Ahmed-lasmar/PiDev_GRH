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
public class fiche_de_paie {
    
    private int ID_FP;
    private int ID_Per;
    private int Salaire_init;
    private int Prime;
    private int Salaire_total;
    private Date Date_paiement;
    private String Etat_paiement;

    public fiche_de_paie(int ID_FP, int ID_Per, int Salaire_init, int Prime, int Salaire_total, Date Date_paiement, String Etat_paiement) {
        this.ID_FP = ID_FP;
        this.ID_Per = ID_Per;
        this.Salaire_init = Salaire_init;
        this.Prime = Prime;
        this.Salaire_total = Salaire_total;
        this.Date_paiement = Date_paiement;
        this.Etat_paiement = Etat_paiement;
    }
    

    public fiche_de_paie(int ID_Per, int Salaire_init, int Prime, int Salaire_total, Date Date_paiement, String Etat_paiement) {
        this.ID_Per = ID_Per;
        this.Salaire_init = Salaire_init;
        this.Prime = Prime;
        this.Salaire_total = Salaire_total;
        this.Date_paiement = Date_paiement;
        this.Etat_paiement = Etat_paiement;
    }
    
    public fiche_de_paie() {
    }
    
    public int getID_FP() {
        return ID_FP;
    }

    public void setID_FP(int ID_FP) {
        this.ID_FP = ID_FP;
    }

    public int getID_Per() {
        return ID_Per;
    }

    public void setID_Per(int ID_Per) {
        this.ID_Per = ID_Per;
    }

    public int getSalaire_init() {
        return Salaire_init;
    }

    public void setSalaire_init(int Salaire_init) {
        this.Salaire_init = Salaire_init;
    }

    public int getPrime() {
        return Prime;
    }

    public void setPrime(int Prime) {
        this.Prime = Prime;
    }

    public int getSalaire_total() {
        return Salaire_total;
    }

    public void setSalaire_total(int Salaire_total) {
        this.Salaire_total = Salaire_total;
    }

    public Date getDate_paiement() {
        return Date_paiement;
    }

    public void setDate_paiement(Date Date_paiement) {
        this.Date_paiement = Date_paiement;
    }

    public String getEtat_paiement() {
        return Etat_paiement;
    }

    public void setEtat_paiement(String Etat_paiement) {
        this.Etat_paiement = Etat_paiement;
    }

    @Override
    public String toString() {
        return "fiche_de_paie (" + " ID_FP : " + ID_FP + " ID_Per : " + ID_Per + " Salaire_init : " + Salaire_init + " Prime : " + Prime
                + " Salaire_total : " +  Salaire_total + " Date_paiement : " + Date_paiement + " Etat_paiement : " + Etat_paiement;
    }
    
    
}
