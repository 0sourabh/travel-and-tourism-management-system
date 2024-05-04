package travel.managment.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel lblphone, lblemail, lbladdress, lblcountry, lblusername, labelusername, lblid, lblnumber, lblname, labelname, lblgender;
    JComboBox<String> comboid; // Specify the type parameter for JComboBox
    JTextField tfphone, tfemail, tfaddress, tfnumber, tfcountry,tfid,tfgender;
    JRadioButton rmale, rfemale;
    JButton add, back;

    UpdateCustomer(String username) {
        
        setBounds(350,180,900,520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text  = new JLabel ("UPDATE CUSTOMER DETAILS");
        text.setBounds(50,0,500,25);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setForeground(new Color(0,0,139));
        add(text);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 40, 150, 25);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblusername);

        labelusername = new JLabel(username); // Updated to set username from parameter
        labelusername.setBounds(220, 40, 150, 25);
        labelusername.setFont(new Font("SansSerif", Font.PLAIN, 15));
        add(labelusername);

        lblid = new JLabel("Id");
        lblid.setBounds(30, 80, 150, 25);
        lblid.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblid);

        // Instantiate the JComboBox with the correct syntax
        tfid = new JTextField();
        tfid.setBounds(220, 80, 150, 25);
        add(tfid);

        lblnumber = new JLabel("Id Value");
        lblnumber.setBounds(30, 120, 150, 25);
        lblnumber.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 120, 150, 25);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 160, 150, 25);
        lblname.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblname);

        labelname = new JLabel(username); // Updated to set username from parameter
        labelname.setBounds(220, 160, 150, 25);
        labelname.setFont(new Font("SansSerif", Font.PLAIN, 15));
        add(labelname);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 200, 150, 25);
        lblgender.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(220, 200, 150, 25);
        add(tfgender);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 240, 150, 25);
        lblcountry.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 240, 150, 25);
        add(tfcountry);

        lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 280, 150, 25);
        lbladdress.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 280, 150, 25);
        add(tfaddress);

        lblemail = new JLabel("Email");
        lblemail.setBounds(30, 320, 150, 25);
        lblemail.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 320, 150, 25);
        add(tfemail);

        lblphone = new JLabel("Phone"); // Corrected the label text
        lblphone.setBounds(30, 360, 150, 25);
        lblphone.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 360, 150, 25);
        add(tfphone);

        add = new JButton("Update");
        add.setBackground(new Color(0, 0, 139));
        add.setForeground(Color.white);
        add.setBounds(220, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(70, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(480, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(400, 0, 480, 480);
        add(icon);

          try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {

            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();

            try {

                Conn c = new Conn();
                String query = "update customer set username = '" + username + "', id  = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', email = '" + email + "', phone = '" + phone + "'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();

            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("Sourabh01");
    }
}
