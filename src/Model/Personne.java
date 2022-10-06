/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author MSI Si Ahmed
 */
public class Personne {
    
    //Att
    private String Nom;
    private String Pernom;
    private String Email;
    private String Cin;
    private String URL_Photo;
    private Date Date_de_naissance;
    private int Num_Tel;
    
    //Constructor

    public Personne() {
    }

    
    
    public Personne(String Nom, String Pernom, String Email, String Cin, String URL_Photo, Date Date_de_naissance, int Num_Tel) {
        this.Nom = Nom;
        this.Pernom = Pernom;
        this.Email = Email;
        this.Cin = Cin;
        this.URL_Photo = URL_Photo;
        this.Date_de_naissance = Date_de_naissance;
        this.Num_Tel = Num_Tel;
    }
    
    //Getters and setters

    public String getNom() {
        return Nom;
    }

    public String getPernom() {
        return Pernom;
    }

    public String getEmail() {
        return Email;
    }

    public String getCin() {
        return Cin;
    }

    public String getURL_Photo() {
        return URL_Photo;
    }

    public Date getDate_de_naissance() {
        return Date_de_naissance;
    }

    public int getNum_Tel() {
        return Num_Tel;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPernom(String Pernom) {
        this.Pernom = Pernom;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setCin(String Cin) {
        this.Cin = Cin;
    }

    public void setURL_Photo(String URL_Photo) {
        this.URL_Photo = URL_Photo;
    }

    public void setDate_de_naissance(Date Date_de_naissance) {
        this.Date_de_naissance = Date_de_naissance;
    }

    public void setNum_Tel(int Num_Tel) {
        this.Num_Tel = Num_Tel;
    }
    

}
