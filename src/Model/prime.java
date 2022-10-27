/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/*
 *
 * @author khlif
 */
public class prime {
    
    private int ID_Prime;
    private String Type_Prime;
    private int Valeur_Prime;
    private Date Date_Prime;
    public int getValeur_Prime;

    public prime(int ID_Prime, String Type_Prime, int Valeur_Prime, Date Date_Prime) {
        this.ID_Prime = ID_Prime;
        this.Type_Prime = Type_Prime;
        this.Valeur_Prime = Valeur_Prime;
        this.Date_Prime = Date_Prime;
    }

    public prime(String Type_Prime, int Valeur_Prime, Date Date_Prime) {
        this.Type_Prime = Type_Prime;
        this.Valeur_Prime = Valeur_Prime;
        this.Date_Prime = Date_Prime;
    }

    public prime() {
    }

    public int getID_Prime() {
        return ID_Prime;
    }

    public void setID_Prime(int ID_Prime) {
        this.ID_Prime = ID_Prime;
    }

    public String getType_Prime() {
        return Type_Prime;
    }

    public void setType_Prime(String Type_Prime) {
        this.Type_Prime = Type_Prime;
    }

    public int getValeur_Prime() {
        return Valeur_Prime;
    }

    public void setValeur_Prime(int Valeur_Prime) {
        this.Valeur_Prime = Valeur_Prime;
    }

    public Date getDate_Prime() {
        return Date_Prime;
    }

    public void setDate_Prime(Date Date_Prime) {
        this.Date_Prime = Date_Prime;
    }
    
    
}
