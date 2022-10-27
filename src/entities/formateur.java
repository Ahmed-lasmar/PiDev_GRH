/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ASUS
 */
public class formateur {
    private int Id_Formateur;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private int tel;
    private int codeP;
    private String ville;
    private String pays;
    private String status;
    private int tarif;
    private int tva;
    private String bio;
    private String diplome;

    public formateur() {
    }

    public formateur(String nom, String prenom, String adresse, String email, int tel, int codeP, String ville, String pays, String status, int tarif, int tva, String bio, String diplome) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.codeP = codeP;
        this.ville = ville;
        this.pays = pays;
        this.status = status;
        this.tarif = tarif;
        this.tva = tva;
        this.bio = bio;
        this.diplome = diplome;
    }

    public formateur(int Id_Formateur, String nom, String prenom, String adresse, String email, int tel, int codeP, String ville, String pays, String status, int tarif, int tva, String bio, String diplome) {
        this.Id_Formateur = Id_Formateur;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.codeP = codeP;
        this.ville = ville;
        this.pays = pays;
        this.status = status;
        this.tarif = tarif;
        this.tva = tva;
        this.bio = bio;
        this.diplome = diplome;
    }

    public int getId_Formateur() {
        return Id_Formateur;
    }

    public void setId_Formateur(int Id_Formateur) {
        this.Id_Formateur = Id_Formateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getCodeP() {
        return codeP;
    }

    public void setCodeP(int codeP) {
        this.codeP = codeP;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    @Override
    public String toString() {
        return "formateur{" + "Id_Formateur=" + Id_Formateur + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", tel=" + tel + ", codeP=" + codeP + ", ville=" + ville + ", pays=" + pays + ", status=" + status + ", tarif=" + tarif + ", tva=" + tva + ", bio=" + bio + ", diplome=" + diplome + '}';
    }
    
    
    
    
}
