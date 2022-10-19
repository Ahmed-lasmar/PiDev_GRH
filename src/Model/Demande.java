/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.dpppp
 */
package model;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Demande {
    
    private int id_dem;
    private int id_Per;
    private Date date_depot;
    private String type_demande;
    private String etat_demande;

    public Demande(int id,int id_Per, Date date_depot, String type_demande, String etat_demande) {
        this.id_dem = id_dem;
        this.id_Per = id_Per;
        this.date_depot = date_depot;
        this.type_demande = type_demande;
        this.etat_demande = etat_demande;
    }

    public Demande(int id_Per, Date date_depot, String type_demande, String etat_demande) {
        this.date_depot = date_depot;
        this.id_Per = id_Per;
        this.type_demande = type_demande;
        this.etat_demande = etat_demande;
    }

    public int getId_dem() {
        return id_dem;
    }

    public int getId_Per() {
        return id_Per;
    }

    public void setId_Per(int id_Per) {
        this.id_Per = id_Per;
    }

    public void setId_dem(int id_dem) {
        this.id_dem = id_dem;
    }

    public Date getDate_depot() {
        return date_depot;
    }

    public Demande() {
    }

    public void setDate_depot(Date date_depot) {
        this.date_depot = date_depot;
    }

    public String getType_demande() {
        return type_demande;
    }

    public void setType_demande(String type_demande) {
        this.type_demande = type_demande;
    }

    public String getEtat_demande() {
        return etat_demande;
    }

    public void setEtat_demande(String etat_demande) {
        this.etat_demande = etat_demande;
    }

    @Override
    public String toString() {
        return "Demande{" + "id_dem=" + id_dem + ", id_Per=" + id_Per + ", date_depot=" + date_depot + ", type_demande=" + type_demande + ", etat_demande=" + etat_demande + '}';
    }

   
    
    
    
    
    
}
