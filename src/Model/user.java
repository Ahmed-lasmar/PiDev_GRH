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
public class user {
    //Att
    private int Id_user;
    private String Nom;
    private String Pernom;
    private String Email;
    private String Cin;
    private String URL_Photo;
    private Date Date_de_naissance;
    private String Num_Tel;
    private Date Date_embauche;
    private String Grade;
    private String Equipe;
    private String Role;
    private String mdp;

    public user() {
    }

    public user(String Email, String mdp) {
        this.Email = Email;
        this.mdp = mdp;
    }

    
    
    public user(int Id_user, String Nom, String Pernom, String Email, String Cin, String URL_Photo, Date Date_de_naissance, String Num_Tel, Date Date_embauche, String Grade, String Equipe, String Role,String mdp) {
        this.Id_user = Id_user;
        this.Nom = Nom;
        this.Pernom = Pernom;
        this.Email = Email;
        this.Cin = Cin;
        this.URL_Photo = URL_Photo;
        this.Date_de_naissance = Date_de_naissance;
        this.Num_Tel = Num_Tel;
        this.Date_embauche = Date_embauche;
        this.Grade = Grade;
        this.Equipe = Equipe;
        this.Role = Role;
        this.mdp= mdp;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public user(String Nom, String Pernom, String Email, String Cin, String URL_Photo, Date Date_de_naissance, String Num_Tel, Date Date_embauche, String Grade, String Equipe, String Role,String mdp) {
        this.Nom = Nom;
        this.Pernom = Pernom;
        this.Email = Email;
        this.Cin = Cin;
        this.URL_Photo = URL_Photo;
        this.Date_de_naissance = Date_de_naissance;
        this.Num_Tel = Num_Tel;
        this.Date_embauche = Date_embauche;
        this.Grade = Grade;
        this.Equipe = Equipe;
        this.Role = Role;
        this.mdp= mdp;
    }

    public int getId_user() {
        return Id_user;
    }

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

    public String getNum_Tel() {
        return Num_Tel;
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

    public String getRole() {
        return Role;
    }

    public void setId_user(int Id_user) {
        this.Id_user = Id_user;
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

    public void setNum_Tel(String Num_Tel) {
        this.Num_Tel = Num_Tel;
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

    public void setRole(String Role) {
        this.Role = Role;
    }

    @Override
    public String toString() {
        return "user{" + "Id_user=" + Id_user + ", Nom=" + Nom + ", Pernom=" + Pernom + ", Email=" + Email + ", Cin=" + Cin + ", URL_Photo=" + URL_Photo + ", Date_de_naissance=" + Date_de_naissance + ", Num_Tel=" + Num_Tel + ", Date_embauche=" + Date_embauche + ", Grade=" + Grade + ", Equipe=" + Equipe + ", Role=" + Role + ", mdp=" + mdp + '}';
    }
    
    
}
