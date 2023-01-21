/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package waypoint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;
import waypoint.ButtonWaypoint;

/**
 *
 * @author babsybabu
 */
public class MyWaypoint extends DefaultWaypoint{
    private String name;
    private String latitude;
    private String longitude;
    private String address;

    private JButton button;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
     
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton Button) {
        this.button = button;
    }
    
    public MyWaypoint(String name, String address,EventWaypoint event, GeoPosition coord){
        super(coord);
        this.name=name;
        this.address=address;
        initButton(event);

    }
        
    public MyWaypoint(){
       
    }
     private void initButton(EventWaypoint event){
       button=new ButtonWaypoint();
       button.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               event.selected(MyWaypoint.this);
           }
       });
}
}
