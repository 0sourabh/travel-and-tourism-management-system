package travel.managment.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Properties;

public class bookDestination extends JFrame implements ActionListener{
    
    Choice cdestination ;
    JTextField tfpersons,tfdays,tfDate;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookpackage,viewbookeddestinations,back;
    JDateChooser dateChooser;
    
    
    bookDestination(String username){
        
        
        this.username = username;
    
        setBounds(350,180,900,520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("BOOK DESTINTION");
        text.setBounds(140, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        
        JLabel lbldate = new JLabel("Check-in Date");
        lbldate.setBounds(40, 190, 150, 20);
        lbldate.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldate);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(250, 190, 200, 25);
        add(dateChooser);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16)); 
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 200, 20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Destination");
        lblpackage.setBounds(40, 110, 150, 20);
        lblpackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpackage);
        
        cdestination = new Choice();
        cdestination.setBounds(250,110,200,20);
        add(cdestination);
        
        
        try{
        
            Conn c = new Conn(); 
            ResultSet rs=c.s.executeQuery("Select * from destination");
            while(rs.next()){
           
                cdestination.add(rs.getString("name"));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40, 150, 150, 20);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("Number of Days");
        lbldays.setBounds(40, 230, 150, 20);
        lbldays.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250,230,200,25);
        add(tfdays);

        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40, 270, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250, 270, 200, 25);
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 310, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 310, 200, 25);
        labelnumber.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 350, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250, 350, 200, 25);
        labelphone.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 390, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250, 390, 200, 25);
        labelprice.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelprice);
        
        
        
        try {
        
            
            Conn conn = new Conn();
            String query = "Select * from customer where username ='"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
            
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                
                labelphone.setText(rs.getString("phone"));
            }
            
        } catch (Exception e){
            
            e.printStackTrace();
         
        }
        checkprice = new JButton ("Check Price");
        checkprice.setBackground(new Color(0, 0, 139));
        checkprice.setForeground(Color.white);
        checkprice.setBounds(180,430,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton ("Book Destination");
        bookpackage.setBackground(new Color(0, 0, 139));
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(320,430,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        
        viewbookeddestinations = new JButton("View Booked Destinations");
        viewbookeddestinations.setBounds(570, 30, 200, 25);
        viewbookeddestinations.setBackground(new Color(0, 0, 139));
        viewbookeddestinations.setForeground(Color.white);
        viewbookeddestinations.addActionListener(this);
        add(viewbookeddestinations);
        
        
        back = new JButton ("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(40,430,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookdestination.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(450, 0 , 450, 500);
        add(icon);
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
    
        if(ae.getSource() == checkprice){
            
            try {
            
                Conn c = new Conn();
            ResultSet rs= c.s.executeQuery("select * from destination where name = '"+cdestination.getSelectedItem()+"'");
            
            while(rs.next()) {
                int cost = Integer.parseInt(rs.getString("costperperson"));
                //int food = Integer.parseInt(rs.getString("foodincluded"));
                //int ac = Integer.parseInt(rs.getString("acroom"));
            
                
                
                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                //tring acselected = cac.getSelectedItem();
               // String foodSelected = cfood.getSelectedItem();
                
                if(persons * days > 0){
                
                    int total = 0;
                   // total +=acselected.equals("AC") ? ac : 0;
                    //total +=foodSelected.equals("Included") ? food : 0;
                    total +=cost;
                    total = total * persons * days;
                    labelprice.setText("Rs"+total);
                    
                }else {
                
                    JOptionPane.showMessageDialog(null, " Please enter a Valid Details");
                }
            }
            } catch(Exception e){
                e.printStackTrace();
            }
            
        }else if (ae.getSource() == bookpackage){
        
            try {
            
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookdestination (username, name, persons, days, id, number, phone, price, checkin_date) VALUES ('" + labelusername.getText() + "', '" + cdestination.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + tfdays.getText() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "', CURDATE())");

                JOptionPane.showMessageDialog(null,"Destination Booked Successfully");
                setVisible(false);
            } catch(Exception e){
            
                e.printStackTrace();
            }
        }else if(ae.getSource() == viewbookeddestinations){
        
            new viewDestination(username); 
            
        }else if(ae.getSource() == back){
        
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args){
    
      new bookDestination("Sourabh01");
        
    
    }
}
