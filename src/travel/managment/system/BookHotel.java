package travel.managment.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel , cac,cfood;
    JTextField tfpersons,tfdays;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookpackage,back,viewBookedHotels;
    JDateChooser dateChooser;
    
    
    BookHotel(String username){
        
        
        this.username = username;
    
        setBounds(350,180,900,520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(140, 2, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 30, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16)); 
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(250, 30, 200, 20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40, 70, 150, 20);
        lblpackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(250,70,200,20);
        add(chotel);
        
        
        try{
        
            Conn c = new Conn(); 
            ResultSet rs=c.s.executeQuery("Select * from hotel");
            while(rs.next()){
           
                chotel.add(rs.getString("name"));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
        JLabel lbldate = new JLabel("Check In");
        lbldate.setBounds(40, 110, 150, 20);
        lbldate.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldate);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(250, 110, 200, 25);
        add(dateChooser);
        
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40, 150, 150, 20);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("Number of Days");
        lbldays.setBounds(40, 190, 150, 20);
        lbldays.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250,190,200,25);
        add(tfdays);
        
        
        JLabel lblac = new JLabel("Ac/Non-Ac");
        lblac.setBounds(40, 230, 150, 20);
        lblac.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,20);
        add(cac);
        
        
        
        JLabel lblfood = new JLabel("Food Details");
        lblfood.setBounds(40, 270, 150, 20);
        lblfood.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("Included");
        cfood.add("Not-Included");
        cfood.setBounds(250,270,200,20);
        add(cfood);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40, 310, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 350, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 200, 25);
        labelnumber.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 390, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        labelphone.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 430, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 200, 25);
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
        checkprice.setBounds(600,430,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton ("Book Hotel");
        bookpackage.setBackground(new Color(0, 0, 139));
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(740,430,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        
        back = new JButton ("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(460,430,120,25);
        back.addActionListener(this);
        add(back);
        
        viewBookedHotels = new JButton("View Booked Hotels");
        viewBookedHotels.setBounds(580, 20, 150, 25);
        viewBookedHotels.setBackground(new Color(0, 0, 139));
        viewBookedHotels.setForeground(Color.white);
        viewBookedHotels.addActionListener(this);
        add(viewBookedHotels);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookhotel3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(450, 0 , 450, 520);
        add(icon);
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
    
        if(ae.getSource() == checkprice){
            
            try {
            
                Conn c = new Conn();
            ResultSet rs= c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
            
            while(rs.next()) {
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("foodincluded"));
                int ac = Integer.parseInt(rs.getString("acroom"));
            
                
                
                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = cac.getSelectedItem();
                String foodSelected = cfood.getSelectedItem();
                
                if(persons * days > 0){
                
                    int total = 0;
                    total +=acselected.equals("AC") ? ac : 0;
                    total +=foodSelected.equals("Included") ? food : 0;
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
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);
            } catch(Exception e){
            
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == back){
        
            setVisible(false);
        }else if(ae.getSource() == viewBookedHotels){
        
            new ViewBookedHotel(username); 
        }
    }
    
    
    public static void main(String[] args){
    
      new BookHotel("Sourabh01");
        
    
    }
}
