/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby;
import com.sun.istack.internal.logging.Logger;
import java.util.Properties;
import java.util.logging.Level;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.AddressException;

public class Send {

    public static void SendMail(String recepient,String msg) throws Exception
    {
        System.out.println("Preparing to send mail");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "babysittermgmt987@gmail.com";
        String password = "babysitter987@";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
});
        Message message = prepareMessage(session, myAccountEmail, recepient,msg);
        Transport.send(message);
        System.out.println("Message Send");
    }
    

       private static Message prepareMessage(Session session, String myAccountEmail, String recepient,String msg) {
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("BABY SITTER HIRING MANAGEMENT");
            message.setText(msg);
            return message;
        }
            
        catch(Exception e)
        {
           //Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, e);
        }
           return null; 
    }

}
