/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.candidat;
import entities.formateur;
import entities.formation;
import entities.res_rh;
import java.sql.Date;
import services.CandidatCRUD;
import services.formateurCRUD;
import services.formationCRUD;
import services.resrhCRUD;
import utils.MyConnection;

/**
 *
 * @author ASUS
 */
public class MainClass {
    public static void main(String[] args) {
        MyConnection mc = MyConnection.getInstance();
        //CandidatCRUD ccd = new CandidatCRUD();
        //candidat c1,c2;
        //c1 = new candidat(7,"b",new Date(336614400000L),"s");
        //c2 = new candidat(7,"b",new Date(336614400000L),"n");
        //ccd.ajouterCandidat(c1);
        //ccd.modifierCandidat(c1,c2);//
        //System.out.println(ccd.afficherCandidats());
        //resrhCRUD rcd =new resrhCRUD();
        //res_rh r1,r2,r3,r4 ;
        //r1 =new res_rh(50);
        //r2=new res_rh(600);
        //r3 =new res_rh(50);
        //r4=new res_rh(600);
        
        //rcd.ajouterRes(r3);
        //rcd.ajouterRes(r4);
        //rcd.supprimerRes(r1);
        //rcd.modifierRes(r4, r3);
        
        //System.out.println(rcd.afficherResrh());
        //formation f1,f2,f3;
        //formationCRUD fcd= new formationCRUD();
        //f1 = new formation(20,new Date(336614400000L),"java",12);
        //f2 = new formation(20,new Date(336614400000L),"javascript",12);
        //f3 = new formation(20,new Date(336614400000L),"Python",12);
        
        //fcd.ajouterFormation(f1);
        //fcd.ajouterFormation(f2);
        //fcd.ajouterFormation(f1);
        //fcd.ajouterFormation(f3);
        //fcd.supprimerFormation();
        //fcd.modifierFormation(f3, 2);
        //System.out.println(fcd.afficherForamtion());
        //System.out.println(fcd.rechercherForamtion(4));
       // formateur f1,f2;
        //f1= new formateur(new Date(336614400000L),"Python",200);
        //f2= new formateur(new Date(336614400000L),"javascript",200);
        //formateurCRUD ffcd=new formateurCRUD();
        //ffcd.ajouterFormateur(f1);
        //ffcd.ajouterFormateur(f2);
        //ffcd.supprimerFormateur();
        //ffcd.modifierFormateur(f1, 2);
        //System.out.println(ffcd.afficherFormateur());
        //System.out.println(ffcd.rechercherFormateur(3));
        formateur f1;
        f1 = new formateur("aaa","bbb","ccc","dd",1,2,"ee","ff","gg",3,4,"hhh","iii");
        //formateur f2 = new formateur();
        formateurCRUD ffcd=new formateurCRUD();
        //ffcd.ajouterFormateur(f1);
        //ffcd.supprimer(f1);
        
        
        
        
    }

    
}