/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author HP
 */
public class démission extends Demande{
    private Date d_sortie;

    
    public String toString() {
        return "démission{" + "d_sortie=" + d_sortie + '}';
    }

    public Date getD_sortie() {
        return d_sortie;
    }

    public void setD_sortie(Date d_sortie) {
        this.d_sortie = d_sortie;
    }

    public démission(Date d_sortie) {
        this.d_sortie = d_sortie;
    }

    
}