package travel.managment.system;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class DeleteDetails extends JFrame  implements ActionListener {
    
    JButton delete;
    
    String username;
    
    DeleteDetails(String username) {
        this.username = username;
        setBounds(350, 180, 900, 520);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 20, 150, 25);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 20, 150, 25);
        labelusername.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelusername);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 60, 150, 25);
        lblid.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220, 60, 150, 25);
        labelid.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelid);
        
        
        JLabel lblnumber = new JLabel("Id Value");
        lblnumber.setBounds(30, 100, 150, 25);
        lblnumber.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 100, 150, 25);
        labelnumber.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 140, 150, 25);
        lblname.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220, 140, 200, 25);
        labelname.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelname);
        
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 180, 150, 25);
        lblgender.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblgender);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 180, 150, 25);
        labelgender.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelgender);
        
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 220, 150, 25);
        lblcountry.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblcountry);
        
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(220, 220, 150, 25);
        labelcountry.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelcountry);
        
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 260, 150, 25);
        lbladdress.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lbladdress);
        
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(220, 260, 150, 25);
        labeladdress.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labeladdress);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 300, 150, 25);
        lblemail.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblemail);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(220, 300, 250, 25);
        labelemail.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelemail);
        
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 340, 150, 25);
        lblphone.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 340, 150, 25);
        labelphone.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(labelphone);
        
        delete = new JButton("Delete");
        delete.setBackground(new Color(0, 0, 139));
        delete.setForeground(Color.white);
        delete.setBounds(105,400,100,25);
        delete.addActionListener(this);
        add(delete);
        
        
       
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,0,500,500);
        add(image);
        
        
        try {
        
            
            Conn conn = new Conn();
            String query = "Select * from customer where username ='"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
            
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelemail.setText(rs.getString("email"));
                labelphone.setText(rs.getString("phone"));
            }
            
        } catch (Exception e){
         
        }
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
    
        try{
            
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username = '"+username+"'");
            c.s.executeUpdate("delete from customer where username = '"+username+"'");
            c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
            c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");
            
            
            JOptionPane.showMessageDialog(null, "Your Information Deleted Successfully");

            setVisible(false);
        
        }catch(Exception e){
        
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DeleteDetails("Sourabh01");
    }
}
