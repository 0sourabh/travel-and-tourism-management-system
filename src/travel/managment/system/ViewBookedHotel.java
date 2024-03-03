package travel.managment.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame  implements ActionListener {
    
    JButton back;
    
    ViewBookedHotel(String username) {
        setBounds(350, 180, 900, 520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(70,0,350,30);
        add(text);

        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        labelusername.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Hotel Name");
        lblpackage.setBounds(30, 90, 200, 25);
        lblpackage.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 90, 150, 25);
        labelpackage.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelpackage);
        
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 130, 150, 25);
        lblpersons.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 130, 150, 25);
        labelpersons.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelpersons);
        
        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30, 170, 150, 25);
        lbldays.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lbldays);
        
        JLabel labeldays = new JLabel();
        labeldays.setBounds(220, 170, 150, 25);
        labeldays.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labeldays);
        
        JLabel lblac = new JLabel("Ac/Non-Ac");
        lblac.setBounds(30, 210, 150, 25);
        lblac.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblac);
        
        JLabel labelac = new JLabel();
        labelac.setBounds(220, 210, 150, 25);
        labelac.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelac);
        
        
        JLabel lblfood = new JLabel("Food");
        lblfood.setBounds(30, 250, 150, 25);
        lblfood.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblfood);
        
        JLabel labelfood = new JLabel();
        labelfood.setBounds(220, 250, 150, 25);
        labelfood.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelfood);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 290, 150, 25);
        lblid.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 290, 200, 25);
        labelid.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 330, 150, 25);
        lblnumber.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 330, 150, 25);
        labelnumber.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelnumber);
        
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 370, 150, 25);
        lblphone.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 370, 150, 25);
        labelphone.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelphone);
        
        
        JLabel lblprice = new JLabel("Total Cost");
        lblprice.setBounds(30, 410, 150, 25);
        lblprice.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 410, 150, 25);
        labelprice.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelprice);
        
        
        
       
        back = new JButton("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(125,450,100,25);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookhotel1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,550,500);
        add(image);
        
        
        try {
        
            
            Conn conn = new Conn();
            String query = "Select * from bookhotel where username ='"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
            
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelpersons.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labeldays.setText(rs.getString("days"));
                
            }
            
        } catch (Exception e){
         
        }
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewBookedHotel("Sourabh01");
    }
}
