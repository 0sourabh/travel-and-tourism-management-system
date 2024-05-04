package travel.managment.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login,signup,password;
    JPasswordField pfpassword;
    JTextField tfusername;
    
    Login() {
        setSize(900, 400);
        setLocation(350, 250);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        JPanel p1 = new JPanel();
        p1.setBackground(Color.white); 
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login3.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(62, 10, 350, 350);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.white);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 120, 100, 25);
        lblpassword.setFont(new Font("SansSerif", Font.BOLD, 20));
        p2.add(lblpassword);

        pfpassword = new JPasswordField();
        pfpassword.setBounds(60, 150, 300, 30);
        p2.add(pfpassword);

        login = new JButton("Login");
        login.setBounds(60, 210, 130, 30);
        login.setBackground(new Color(255, 102, 0));
        login.setForeground(Color.white);
        login.setBorder(new LineBorder(new Color(255, 102, 0)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Sign Up");
        signup.setBounds(230, 210, 130, 30);
        signup.setBackground(new Color(255, 102, 0));
        signup.setForeground(Color.white);
        signup.setBorder(new LineBorder(new Color(255, 102, 0)));
        signup.addActionListener(this);
        p2.add(signup);
        
        password = new JButton("Forget Password");
        password.setBounds(145, 260, 130, 30);
        password.setBackground(new Color(255, 102, 0));
        password.setForeground(Color.white);
        password.setBorder(new LineBorder(new Color(255, 102, 0)));
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble in Login...");
        text.setBounds(300,265,150,20);
        text.setForeground(Color.red);
        p2.add(text);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            try{
                String username = tfusername.getText();
                String pass = pfpassword.getText();
                
                String query = "select * from account where username ='"+username+"' AND password = '"+pass+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()) {
                    setVisible(false);
                    new Loading(username);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }
                
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new Signup();         
        }
        else {
            setVisible(false);
            new ForgetPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
