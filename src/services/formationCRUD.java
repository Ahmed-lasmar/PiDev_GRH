/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;




import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import entities.candidat;
import entities.formation;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import utils.MyConnection;


/**
 *
 * @author ASUS
 */
public class formationCRUD {
    Connection cnx2 ;
    public formationCRUD() {
        cnx2 = MyConnection.getInstance().getCnx();
    }
    public void ajouterFormation(formation f){
        
        try {
            String requete = "INSERT INTO formation (Id_Formateur,Date_For,Nom_For,Numbr_Max_Per)"
                    + " VALUES (?,?,?,?)";
            PreparedStatement pst = cnx2.prepareStatement(requete);
            pst.setInt(1, f.getId_Formateur());
            pst.setDate(2, f.getDate_For());
            pst.setString(3, f.getNom_For());
            pst.setInt(4, f.getNumbr_Max_Per());
            
            pst.executeUpdate();
            System.out.println("Votre formation est ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
        public void supprimer(formation f) {
try {
            String sql = "DELETE FROM `formation` WHERE `Id_For` = "+ f.getId_For()+ "";

         
            PreparedStatement ste = cnx2.prepareStatement(sql);
            ste.executeUpdate();
            
            System.out.println("formation supprimé");
        } catch (SQLException ex) {
            Logger.getLogger(formationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void supprimerFormation() {

        try {
            System.out.println("Entrez l'Id de formation à supprimer");
            Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();

            String sql = "delete from formation where Id_For=" + a;
            PreparedStatement ste = cnx2.prepareStatement(sql);
            ste.executeUpdate();

            System.out.println("formation est supprimée aves succeé");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
     
    public void modifier(formation f) {
        String req = "UPDATE formation set Id_Formateur=?, Date_For=?, Nom_For=? ,Numbr_Max_Per=? WHERE Id_For="+ f.getId_For()+ "";
    try {
            PreparedStatement ste = cnx2.prepareStatement(req);
           
            ste.setInt(1, f.getId_Formateur());
            ste.setDate(2, f.getDate_For());
            ste.setString(3, f.getNom_For());   
            ste.setInt(4, f.getNumbr_Max_Per());
        
           ste.executeUpdate();
            int rowsUpdated = ste.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("La modification de formation a été éffectuée avec succès ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(formateurCRUD.class.getName()).log(Level.SEVERE, null, ex);     
        }
    }
     public void modifierFormation(formation f, int id) {
        try {
            String sql = "UPDATE formation SET Id_Formateur=?, Date_For=?, Nom_For=? ,Numbr_Max_Per=? WHERE Id_For="+id;
            PreparedStatement ste = cnx2.prepareStatement(sql);
         
            ste.setInt(1, f.getId_Formateur());
            ste.setDate(2, f.getDate_For());
            ste.setString(3, f.getNom_For());   
            ste.setInt(4, f.getNumbr_Max_Per());
            ste.executeUpdate();
            System.out.println("Votre formation est modifie !!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
        public List<formation> afficherForamtion(){
        List<formation> myList = new ArrayList<>();
        try {
            String requete3 ="SELECT * FROM formation";
            Statement st = cnx2.createStatement();
            ResultSet rs=st.executeQuery(requete3);
            while(rs.next()){
                formation f = new formation();
                f.setId_For(rs.getInt(1));
                f.setId_Formateur(rs.getInt("Id_Formateur"));
                f.setDate_For(rs.getDate("Date_For"));
                f.setNom_For(rs.getString("Nom_For"));
                f.setNumbr_Max_Per(rs.getInt("Numbr_Max_Per"));
                myList.add(f);
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
     public List<formation> rechercherForamtion(int id){
        List<formation> myList = new ArrayList<>();
        try {
            String requete3 ="SELECT * FROM formation WHERE Id_For="+id;
            Statement st = cnx2.createStatement();
            ResultSet rs=st.executeQuery(requete3);
            while(rs.next()){
                formation f = new formation();
                f.setId_For(rs.getInt(1));
                f.setId_Formateur(rs.getInt("Id_Formateur"));
                f.setDate_For(rs.getDate("Date_For"));
                f.setNom_For(rs.getString("Nom_For"));
                f.setNumbr_Max_Per(rs.getInt("Numbr_Max_Per"));
                myList.add(f);
                
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;
    }
     
      public String QR (String A){
        
       
              
             try {
            String qrCodeData = "Formation "+A+"";
            String filePath = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\AhmedMellouli\\src\\img\\"+A+".png";
            
            
            String charset = "UTF-8"; // or "ISO-8859-1"
             Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
            return filePath;
        } catch (Exception e) {
            System.err.println(e);
           return "";
        }
               
       }
     
      
        public void sendEmail(String path) throws IOException {
           final String username ="ahmedmellouli2000@gmail.com";
        final String password ="Ykwork45";
        String from = "ahmedmellouli2000@gmail.com";
        String to = "ahmed.mellouli@esprit.tn";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
        
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(username,password);
           }
        });
        MimeMessage msg =new MimeMessage(session);
        try{
          //  msg.setFrom(from);
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject("Formation ajouté ");
            Multipart con = new MimeMultipart();
            MimeBodyPart text =new MimeBodyPart();
            text.setText("Voici le QR code de cet Formation");
            MimeBodyPart img = new MimeBodyPart();
            img.attachFile(path);
            con.addBodyPart(text);
            con.addBodyPart(img);
            msg.setContent(con);
            
            Transport.send(msg);
            System.out.println("tebath");
        }catch(MessagingException e){
            System.err.println(e.getMessage());
        }
       }
     
}
