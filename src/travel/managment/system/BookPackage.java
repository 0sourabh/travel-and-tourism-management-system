package travel.managment.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookpackage,viewPackages,back;
    JDateChooser dateChooser;
    
    
    BookPackage(String username){
        
        
        this.username = username;
    
        setBounds(350,180,900,520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(180, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16)); 
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 200, 20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40, 110, 150, 20);
        lblpackage.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("GOLD PACKAGE");
        cpackage.add("SILVER PACKAGE");
        cpackage.add("BRONZE PACKAGE");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);
        
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40, 150, 150, 20);
        lblpersons.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        JLabel lbldate = new JLabel("Valid From");
        lbldate.setBounds(40, 190, 150, 20);
        lbldate.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldate);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(250, 190, 200, 25);
        add(dateChooser);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40, 230, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(250, 230, 200, 25);
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 270, 150, 25);
        lblnumber.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(250, 270, 200, 25);
        labelnumber.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelnumber);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 310, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(250, 310, 200, 25);
        labelphone.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelphone);
        
        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40, 350, 150, 25);
        lbltotal.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(250, 350, 200, 25);
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
        checkprice.setBounds(200,430,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton ("Book Package");
        bookpackage.setBackground(new Color(0, 0, 139));
        bookpackage.setForeground(Color.white);
        bookpackage.setBounds(340,430,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        viewPackages = new JButton("View Booked Packages");
        viewPackages.setBounds(580, 40, 180, 25);
        viewPackages.setBackground(new Color(0, 0, 139));
        viewPackages.setForeground(Color.white);
//        viewPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
//        viewPackages.setBorder(BorderFactory.createEmptyBorder());
        viewPackages.addActionListener(this);
        add(viewPackages);
        
        
        
        back = new JButton ("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(60,430,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/booking.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(450, 50 , 400, 400);
        add(icon);
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
    
        if(ae.getSource() == checkprice){
        
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("GOLD PACKAGE")){
            cost += 150000;
            }else if(pack.equals("SILVER PACKAGE")){
            cost += 75000;

            } else {

            cost += 25000;
           }

                
           int persons = Integer.parseInt(tfpersons.getText());
           cost *= persons;
           labelprice.setText("Rs "+cost);
            
        }else if (ae.getSource() == bookpackage){
        
            try {
            
                Conn c = new Conn();
               c.s.executeUpdate("INSERT INTO bookpackage (username, package, persons, id, number, phone, price, booking_date) VALUES ('" + labelusername.getText() + "', '" + cpackage.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "', CURDATE())");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            } catch(Exception e){
            
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == viewPackages){
        
            new ViewPackage(username); 
        }
        else if(ae.getSource() == back){
        
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args){
    
      new BookPackage("Sourabh01");
        
    
    }
}
