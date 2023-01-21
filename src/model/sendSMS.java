/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author shrey
 */

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;


public class sendSMS {
    
    public static final String ACCOUNT_SID = "AC9a49d8877c28fd0df38b16e1f9c30f73";
    public static final String AUTH_TOKEN = "8ef6f225987ff9d15ad92aec775bba55";
    
    public void sendSMS(String recipient, String body) throws Exception
    {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(recipient),
                new com.twilio.type.PhoneNumber("+18657372422"), 
                body)
            .create();

        System.out.println(message.getSid());
        
    }
        
}
    