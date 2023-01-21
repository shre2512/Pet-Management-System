/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shrey
 */

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendEmail {
    
    public void sendEmail(String subject, String body, String recipient) throws Exception
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "management.pet@gmail.com";
        String myAccountPassword = "tegvbtybdsujtdgg";
        
        Session session = Session.getInstance(properties, new Authenticator(){
           @Override
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(myAccountEmail, myAccountPassword);
           }
        });
        
        Message message = prepareMessage(session, myAccountEmail, recipient, subject, body);
        Transport.send(message);
        System.out.println("Sent");
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String subject, String body){
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            message.setText(body);
            return message;
        } catch (Exception ex) {            
            
            Logger.getLogger(sendEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
