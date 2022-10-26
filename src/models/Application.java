/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author radhw
 */
public class Application {
    private int id_app;

    
    private String candidat;

    public Application() {
    }

    public Application(String candidat, String offre, String etat) {
        this.candidat = candidat;
        this.offre = offre;
        this.etat = etat;
    }

    public Application(int id_app, String candidat, String offre, String etat, String CV) {
        this.id_app = id_app;
        this.candidat = candidat;
        this.offre = offre;
        this.etat = etat;
        this.CV = CV;
    }

    public Application(String candidat, String offre, String etat, String CV) {
        this.candidat = candidat;
        this.offre = offre;
        this.etat = etat;
        this.CV = CV;
    }

    @Override
    public String toString() {
        return "Application{" + "id_app=" + id_app + ", candidat=" + candidat + ", offre=" + offre + ", etat=" + etat + ", CV=" + CV + '}';
    }
    private String offre;
    private String etat;
    private String CV;

    public int getId_app() {
        return id_app;
    }

    public void setId_app(int id_app) {
        this.id_app = id_app;
    }

    public String getCandidat() {
        return candidat;
    }

    public void setCandidat(String candidat) {
        this.candidat = candidat;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }


   
    
}
