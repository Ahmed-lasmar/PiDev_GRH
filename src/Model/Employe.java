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
public class Employe extends Personne {
    //Var
    private int Id_Per;
    private Date Date_embauche;
    private String Grade;
    private String Equipe;

    public Employe() {
    }

    public Employe(String Nom, String Pernom, String Email, String Cin, String URL_Photo, Date Date_de_naissance, int Num_Tel) {
        super(Nom, Pernom, Email, Cin, URL_Photo, Date_de_naissance, Num_Tel);
    }

    public Employe(Date Date_embauche, String Grade, String Equipe, String Nom, String Pernom, String Email, String Cin, String URL_Photo, Date Date_de_naissance, int Num_Tel) {
        super(Nom, Pernom, Email, Cin, URL_Photo, Date_de_naissance, Num_Tel);
        this.Date_embauche = Date_embauche;
        this.Grade = Grade;
        this.Equipe = Equipe;
    }

    public Employe(int Id_Per, Date Date_embauche, String Grade, String Equipe, String Nom, String Pernom, String Email, String Cin, String URL_Photo, Date Date_de_naissance, int Num_Tel) {
        super(Nom, Pernom, Email, Cin, URL_Photo, Date_de_naissance, Num_Tel);
        this.Id_Per = Id_Per;
        this.Date_embauche = Date_embauche;
        this.Grade = Grade;
        this.Equipe = Equipe;
    }

    public int getId_Per() {
        return Id_Per;
    }

    public Date getDate_embauche() {
        return Date_embauche;
    }

    public String getGrade() {
        return Grade;
    }

    public String getEquipe() {
        return Equipe;
    }

    public void setId_Per(int Id_Per) {
        this.Id_Per = Id_Per;
    }

    public void setDate_embauche(Date Date_embauche) {
        this.Date_embauche = Date_embauche;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

    public void setEquipe(String Equipe) {
        this.Equipe = Equipe;
    }
    
    
}
