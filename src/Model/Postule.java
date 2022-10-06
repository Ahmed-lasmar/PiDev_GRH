/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author radhw
 */
public class Postule {
    private int id_postule;
    private int id_can;
    private int id_off;
    private String datePost;
    private String etatPost;

    public Postule(int id_can, int id_off, String datePost, String etatPost) {
        this.id_can = id_can;
        this.id_off = id_off;
        this.datePost = datePost;
        this.etatPost = etatPost;
    }

    public Postule() {
    }

    public Postule(int id_postule, int id_can, int id_off, String datePost, String etatPost) {
        this.id_postule = id_postule;
        this.id_can = id_can;
        this.id_off = id_off;
        this.datePost = datePost;
        this.etatPost = etatPost;
    }

    public int getId_postule() {
        return id_postule;
    }

    public void setId_postule(int id_postule) {
        this.id_postule = id_postule;
    }

    public int getId_can() {
        return id_can;
    }

    public void setId_can(int id_can) {
        this.id_can = id_can;
    }

    public int getId_off() {
        return id_off;
    }

    public void setId_off(int id_off) {
        this.id_off = id_off;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public String getEtatPost() {
        return etatPost;
    }

    public void setEtatPost(String etatPost) {
        this.etatPost = etatPost;
    }
    
}
