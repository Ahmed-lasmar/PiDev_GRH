/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author radhw
 */
public class OffreEmploi {

    public OffreEmploi(int id_offre, String nomOffre, String description, String skills, String picture) {
        this.id_offre = id_offre;
        this.nomOffre = nomOffre;
        this.description = description;
        this.skills = skills;
        this.picture = picture;
    }

    public OffreEmploi(String nomOffre, String description, String skills) {
        this.nomOffre = nomOffre;
        this.description = description;
        this.skills = skills;
    }
    private int id_offre;
    private String nomOffre;
    private String description;
    private String skills;

    public OffreEmploi(String nomOffre, String description, String skills, String picture) {
        this.nomOffre = nomOffre;
        this.description = description;
        this.skills = skills;
        this.picture = picture;
    }

    public OffreEmploi() {
    }

    @Override
    public String toString() {
        return "OffreEmploi{" + "id_offre=" + id_offre + ", nomOffre=" + nomOffre + ", description=" + description + ", skills=" + skills + ", picture=" + picture + '}';
    }
    private String picture;

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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    

 
    
    
}
