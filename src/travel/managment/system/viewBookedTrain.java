package travel.managment.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class viewBookedTrain extends JFrame  implements ActionListener {
    
    JButton back;
    
    viewBookedTrain(String username) {
        setBounds(350, 180, 900, 520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel text = new JLabel("VIEW BOOKED TRAVEL DETAILS");
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
        
        JLabel lbldate = new JLabel("Travling Date");
        lbldate.setBounds(30, 90, 200, 25);
        lbldate.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lbldate);
        
        JLabel labeldate = new JLabel();
        labeldate.setBounds(220, 90, 150, 25);
        labeldate.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labeldate);
        
        
        JLabel lblfrom = new JLabel("From");
        lblfrom.setBounds(30, 130, 150, 25);
        lblfrom.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblfrom);
        
        JLabel labelefrom = new JLabel();
        labelefrom.setBounds(220, 130, 150, 25);
        labelefrom.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelefrom);
        
        JLabel lblwhere = new JLabel("Where");
        lblwhere.setBounds(30, 170, 150, 25);
        lblwhere.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblwhere);
        
        JLabel labelwhere = new JLabel();
        labelwhere.setBounds(220, 170, 150, 25);
        labelwhere.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelwhere);
        
        JLabel lbltravel = new JLabel("Travel Method");
        lbltravel.setBounds(30, 210, 150, 25);
        lbltravel.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lbltravel);
        
        JLabel labeltravel = new JLabel();
        labeltravel.setBounds(220, 210, 150, 25);
        labeltravel.setFont(new Font("SansSerif", Font.PLAIN ,16));
        add(labeltravel);
        
        
        
        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(30, 250, 150, 25);
        lblperson.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblperson);
        
        JLabel labelperson = new JLabel();
        labelperson.setBounds(220, 250, 150, 25);
        labelperson.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(labelperson);
        
        
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
        
        
        JLabel lblprice = new JLabel("Ticket Fare");
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
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewbookedtravel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(550,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,550,500);
        add(image);
        
        
        try {
        
            
            Conn conn = new Conn();
            String query = "Select * from travel where username ='"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
            
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labeldate.setText(rs.getString("booking_date"));
                labelprice.setText(rs.getString("price"));
                labelperson.setText(rs.getString("persons"));
                labelphone.setText(rs.getString("phone"));
                labelefrom.setText(rs.getString("depfrom"));
                labelwhere.setText(rs.getString("rchwhere"));
                labeltravel.setText(rs.getString("travel_medium"));
                
            }
            
        } catch (Exception e){
         
        }
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
        setVisible(false);
    }

    public static void main(String[] args) {
        new viewBookedTrain("Sourabh01");
    }
}
