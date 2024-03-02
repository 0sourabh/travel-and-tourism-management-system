package travel.managment.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel lblphone, lblemail, lbladdress, lblcountry, lblusername, labelusername, lblid, lblnumber, lblname, labelname, lblgender;
    JComboBox<String> comboid; // Specify the type parameter for JComboBox
    JTextField tfphone, tfemail, tfaddress, tfnumber, tfcountry;
    JRadioButton rmale, rfemale;
    JButton add, back;

    AddCustomer(String username) {
        setBounds(350,180,900,520);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 20, 150, 25);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblusername);

        labelusername = new JLabel(username); // Updated to set username from parameter
        labelusername.setBounds(220, 20, 150, 25);
        labelusername.setFont(new Font("SansSerif", Font.PLAIN, 15));
        add(labelusername);

        lblid = new JLabel("Id");
        lblid.setBounds(30, 60, 150, 25);
        lblid.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblid);

        // Instantiate the JComboBox with the correct syntax
        comboid = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
        comboid.setBounds(220, 60, 150, 25); // Set bounds for JComboBox
        comboid.setBackground(Color.white);
        add(comboid);

        lblnumber = new JLabel("Id Value");
        lblnumber.setBounds(30, 100, 150, 25);
        lblnumber.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 100, 150, 25);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30, 140, 150, 25);
        lblname.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblname);

        labelname = new JLabel(username); // Updated to set username from parameter
        labelname.setBounds(220, 140, 150, 25);
        labelname.setFont(new Font("SansSerif", Font.PLAIN, 15));
        add(labelname);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 180, 150, 25);
        lblgender.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 180, 70, 25);
        rmale.setBackground(Color.white);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 180, 100, 25); // Adjusted the bounds to fit the text
        rfemale.setBackground(Color.white);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 220, 150, 25);
        lblcountry.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 220, 150, 25);
        add(tfcountry);

        lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 260, 150, 25);
        lbladdress.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 260, 150, 25);
        add(tfaddress);

        lblemail = new JLabel("Email");
        lblemail.setBounds(30, 300, 150, 25);
        lblemail.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 300, 150, 25);
        add(tfemail);

        lblphone = new JLabel("Phone"); // Corrected the label text
        lblphone.setBounds(30, 340, 150, 25);
        lblphone.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 340, 150, 25);
        add(tfphone);

        add = new JButton("Add");
        add.setBackground(new Color(0, 0, 139));
        add.setForeground(Color.white);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/personaldetail.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(400, 0, 500, 500);
        add(icon);

          try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == add) {

            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if (rmale.isSelected()) {

                gender = "Male";
            } else {

                gender = "Female";

            }

            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();

            try {

                Conn c = new Conn();
                String query = "insert into customer values('" + username + "','" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + address + "','" + email + "','" + phone + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();

            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("");
    }
}
