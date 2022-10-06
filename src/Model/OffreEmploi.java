/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author radhw
 */
public class OffreEmploi {
    private int id_offre;
    private String nomOffre;
    private String description;
    private String dateDepot;
    private String dateFin;

    public OffreEmploi(int id_offre, String nomOffre, String description, String dateDepot, String date_fin) {
        this.id_offre = id_offre;
        this.nomOffre = nomOffre;
        this.description = description;
        this.dateDepot = dateDepot;
        this.dateFin = date_fin;
    }

    public OffreEmploi(String nomOffre, String description, String dateDepot, String date_fin) {
        this.nomOffre = nomOffre;
        this.description = description;
        this.dateDepot = dateDepot;
        this.dateFin = date_fin;
    }
    

    public OffreEmploi() {
    }
    

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public String getNomOffre() {
        return nomOffre;
    }

    public void setNomOffre(String nomOffre) {
        this.nomOffre = nomOffre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(String dateDepot) {
        this.dateDepot = dateDepot;
    }

    public String getDate_fin() {
        return dateFin;
    }

    public void setDate_fin(String date_fin) {
        this.dateFin = date_fin;
    }
    
    
}
