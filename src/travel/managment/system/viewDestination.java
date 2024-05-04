package travel.managment.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class viewDestination extends JFrame  implements ActionListener {
    
    JButton back;
    
    viewDestination(String username) {
        setBounds(350, 180, 900, 520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel text = new JLabel("VIEW BOOKED DESTINATIONS DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(20,10,450,30);
        add(text);

        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 80, 150, 25);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 80, 150, 25);
        labelusername.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Destination Name");
        lblpackage.setBounds(30, 120, 200, 25);
        lblpackage.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 120, 150, 25);
        labelpackage.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelpackage);
        
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 160, 150, 25);
        lblpersons.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 160, 150, 25);
        labelpersons.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelpersons);
        
        
        JLabel lblcheckin = new JLabel("Check-In Date");
        lblcheckin.setBounds(30, 200, 150, 25);
        lblcheckin.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblcheckin);
        
        JLabel labelcheckin = new JLabel();
        labelcheckin.setBounds(220, 200, 150, 25);
        labelcheckin.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelcheckin);
        
        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30, 240, 150, 25);
        lbldays.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lbldays);
        
        JLabel labeldays = new JLabel();
        labeldays.setBounds(220, 240, 150, 25);
        labeldays.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labeldays);
        
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 280, 150, 25);
        lblid.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 280, 200, 25);
        labelid.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 320, 150, 25);
        lblnumber.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 320, 150, 25);
        labelnumber.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelnumber);
        
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 360, 150, 25);
        lblphone.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 360, 150, 25);
        labelphone.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelphone);
        
        
        JLabel lblprice = new JLabel("Total Cost");
        lblprice.setBounds(30, 400, 150, 25);
        lblprice.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 400, 150, 25);
        labelprice.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelprice);
        
        
        
       
        back = new JButton("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(125,450,100,25);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookdestination1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,520, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,500,520);
        add(image);
        
        
        try {
        
            
            Conn conn = new Conn();
            String query = "Select * from bookdestination where username ='"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
            
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
                labeldays.setText(rs.getString("days"));
                labelcheckin.setText(rs.getString("checkin_date"));
                
            }
            
        } catch (Exception e){
         
        }
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
        setVisible(false);
    }

    public static void main(String[] args) {
        new viewDestination("Sourabh01");
    }
}
