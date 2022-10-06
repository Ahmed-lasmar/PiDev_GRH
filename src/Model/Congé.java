/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author HP
 */
 public class Congé extends Demande{
    
    private Date d_depart;
    private Date d_retour;

    public Congé(Date d_depart, Date d_retour) {
        this.d_depart = d_depart;
        this.d_retour = d_retour;
    }

    public Congé() {
    }

    public Date getD_depart() {
        return d_depart;
    }

    public void setD_depart(Date d_depart) {
        this.d_depart = d_depart;
    }

    public Date getD_retour() {
        return d_retour;
    }

    public void setD_retour(Date d_retour) {
        this.d_retour = d_retour;
    }

    @Override
    public String toString() {
        return "Cong\u00e9{" + "d_depart=" + d_depart + ", d_retour=" + d_retour + '}';
    }

    
   
 
}
