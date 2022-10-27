package Mailing;
import static java.awt.SystemColor.text;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static java.util.GregorianCalendar.from;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
//import utils.DataSource;
/**
 *
 * @author zemni
 */
public class Mailing{

    private Connection con;
    private Statement ste;

    public Mailing() {
       // con = DataSource.getInstance().getCnx();

    }

    public static void mailing(String path) throws Exception {

        Properties prop = new Properties();
        final String moncompteEmail = "chedly104@gmail.com";
         final String to = "ahmed.mellouli@esprit.tn";
        final String psw = "esprit123456789";
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session ses = Session.getInstance(prop, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(moncompteEmail, psw);
            }
        });



           MimeMessage msg =new MimeMessage(ses);
        try{
             
            //msg.setFrom(moncompteEmail);
          
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setSubject("Bonjour Bridge , Formation ajoutée ");
            Multipart con = new MimeMultipart();
            MimeBodyPart text =new MimeBodyPart();
            text.setText("Voici le QR code de cet Formation");
            MimeBodyPart img = new MimeBodyPart();
            img.attachFile(path);
            con.addBodyPart(text);
            con.addBodyPart(img);
            msg.setContent(con);
            
            Transport.send(msg);
        }
        catch(MessagingException ex){
         Logger.getLogger(Mailing.class.getName()).log(Level.SEVERE, null, ex);
}
       }
   



    }
