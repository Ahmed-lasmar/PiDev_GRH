/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Congé {

    private int idCon;
    private int idPer;
    private Date dDepot;
    private String typeDemande;
    private String etatDemande;
    private Date dDepart;
    private Date dRetour;

    public Congé() {
    }

    public Congé(int idCon, int idPer, Date dDepot, String typeDemande, String etatDemande, Date dDepart, Date dRetour) {
        this.idCon = idCon;
        this.idPer = idPer;
        this.dDepot = dDepot;
        this.typeDemande = typeDemande;
        this.etatDemande = etatDemande;
        this.dDepart = dDepart;
        this.dRetour = dRetour;
    }

    public Congé(int idPer, Date dDepot, String typeDemande, String etatDemande, Date dDepart, Date dRetour) {
        this.idPer = idPer;
        this.dDepot = dDepot;
        this.typeDemande = typeDemande;
        this.etatDemande = etatDemande;
        this.dDepart = dDepart;
        this.dRetour = dRetour;
    }

    public int getIdCon() {
        return idCon;
    }

    public int getIdPer() {
        return idPer;
    }

    public Date getdDepot() {
        return dDepot;
    }

    public String getTypeDemande() {
        return typeDemande;
    }

    public String getEtatDemande() {
        return etatDemande;
    }

    public Date getdDepart() {
        return dDepart;
    }

    public Date getdRetour() {
        return dRetour;
    }

    public void setIdCon(int idCon) {
        this.idCon = idCon;
    }

    public void setIdPer(int idPer) {
        this.idPer = idPer;
    }

    public void setdDepot(Date dDepot) {
        this.dDepot = dDepot;
    }

    public void setTypeDemande(String typeDemande) {
        this.typeDemande = typeDemande;
    }

    public void setEtatDemande(String etatDemande) {
        this.etatDemande = etatDemande;
    }

    public void setdDepart(Date dDepart) {
        this.dDepart = dDepart;
    }

    public void setdRetour(Date dRetour) {
        this.dRetour = dRetour;
    }

    @Override
    public String toString() {
        return "Cong\u00e9{" + "idCon=" + idCon + ", idPer=" + idPer + ", dDepot=" + dDepot + ", typeDemande=" + typeDemande + ", etatDemande=" + etatDemande + ", dDepart=" + dDepart + ", dRetour=" + dRetour + '}';
    }

}
