/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author ASUS
 */
public class formation {
    private int Id_For;
    private int Id_Formateur;
    private Date Date_For;
    private String Nom_For;
    private int Numbr_Max_Per;


    public formation() {
    }

    public formation(int Id_For, int Id_Formateur, Date Date_For, String Nom_For, int Numbr_Max_Per) {
        this.Id_For = Id_For;
        this.Id_Formateur = Id_Formateur;
        this.Date_For = Date_For;
        this.Nom_For = Nom_For;
        this.Numbr_Max_Per = Numbr_Max_Per;
    }

    public int getId_For() {
        return Id_For;
    }

    public void setId_For(int Id_For) {
        this.Id_For = Id_For;
    }

    public int getId_Formateur() {
        return Id_Formateur;
    }

    public void setId_Formateur(int Id_Formateur) {
        this.Id_Formateur = Id_Formateur;
    }

    public Date getDate_For() {
        return Date_For;
    }

    public void setDate_For(Date Date_For) {
        this.Date_For = Date_For;
    }

    public String getNom_For() {
        return Nom_For;
    }

    public void setNom_For(String Nom_For) {
        this.Nom_For = Nom_For;
    }

    public int getNumbr_Max_Per() {
        return Numbr_Max_Per;
    }

    public void setNumbr_Max_Per(int Numbr_Max_Per) {
        this.Numbr_Max_Per = Numbr_Max_Per;
    }

    @Override
    public String toString() {
        return "formation{" + "Id_For=" + Id_For + ", Id_Formateur=" + Id_Formateur + ", Date_For=" + Date_For + ", Nom_For=" + Nom_For + ", Numbr_Max_Per=" + Numbr_Max_Per + '}';
    }
    
    
    
}
