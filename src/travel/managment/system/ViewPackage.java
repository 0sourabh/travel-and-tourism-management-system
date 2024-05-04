package travel.managment.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewPackage extends JFrame  implements ActionListener {
    
    JButton back;
    
    ViewPackage(String username) {
        setBounds(350, 180, 900, 520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,0,300,30);
        add(text);

        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 80, 150, 25);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 80, 150, 25);
        labelusername.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30, 120, 200, 25);
        lblpackage.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 120, 150, 25);
        labelpackage.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelpackage);
        
        
        JLabel lbldate = new JLabel("Valid From");
        lbldate.setBounds(30, 160, 150, 25);
        lbldate.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lbldate);
        
        JLabel labeldate = new JLabel();
        labeldate.setBounds(220, 160, 150, 25);
        labeldate.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labeldate);
        
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 200, 150, 25);
        lblpersons.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 200, 150, 25);
        labelpersons.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelpersons);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 240, 150, 25);
        lblid.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 240, 200, 25);
        labelid.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 280, 150, 25);
        lblnumber.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 280, 150, 25);
        labelnumber.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelnumber);
        
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 320, 150, 25);
        lblphone.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 320, 150, 25);
        labelphone.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelphone);
        
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30, 360, 150, 25);
        lblprice.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 360, 150, 25);
        labelprice.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelprice);
        
        
        
       
        back = new JButton("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(105,400,100,25);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,450,450);
        add(image);
        
        
        try {
        
            
            Conn conn = new Conn();
            String query = "Select * from bookpackage where username ='"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
    labelusername.setText(rs.getString("username"));
    labelid.setText(rs.getString("id"));
    labelnumber.setText(rs.getString("number"));
    labelpackage.setText(rs.getString("package"));
    labelprice.setText(rs.getString("price"));
    labelpersons.setText(rs.getString("persons"));
    labelphone.setText(rs.getString("phone"));
    labeldate.setText(rs.getString("booking_date"));
    
}

            
        } catch (Exception e){
         
        }
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewPackage("Sourabh01");
    }
}
