/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class candidat {
    private int Id_Can;
    private String URL_CV;
    private Date D_Post;
    private String Competence;
    

    public candidat() {
    }

    public candidat(String URL_CV, Date D_Post, String Competence) {
        this.URL_CV = URL_CV;
        this.D_Post = D_Post;
        this.Competence = Competence;
    }

    public candidat(int Id_Can, String URL_CV, Date D_Post, String Competence) {
        this.Id_Can = Id_Can;
        this.URL_CV = URL_CV;
        this.D_Post = D_Post;
        this.Competence = Competence;
    }

    public int getId_Can() {
        return Id_Can;
    }

    public void setId_Can(int Id_Can) {
        this.Id_Can = Id_Can;
    }

    public String getURL_CV() {
        return URL_CV;
    }

    public void setURL_CV(String URL_CV) {
        this.URL_CV = URL_CV;
    }

    public Date getD_Post() {
        return D_Post;
    }

    public void setD_Post(Date D_Post) {
        this.D_Post = D_Post;
    }

    public String getCompetence() {
        return Competence;
    }

    public void setCompetence(String Competence) {
        this.Competence = Competence;
    }

    @Override
    public String toString() {
        return "candidat{" + "Id_Can=" + Id_Can + ", URL_CV=" + URL_CV + ", D_Post=" + D_Post + ", Competence=" + Competence + '}';
    }

    

    

    

    

    

    

   
    
}
