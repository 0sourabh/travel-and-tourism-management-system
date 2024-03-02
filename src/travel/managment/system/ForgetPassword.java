package travel.managment.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfname, tfusername, tfanswer ,tfsecurity,tfpassword;
    JButton search, retrive, back;
    
    ForgetPassword(){
        setBounds(350,250,900,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(255, 164, 0));
        p1.setBounds(400, 30, 450, 300);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgetpass1.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(40, 10, 350, 350);
        add(image);
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 125, 25);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 20));
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBounds(330, 20, 100, 25);
        search.setBackground(new Color(0,0,139));
        search.setForeground(Color.white);
        search.setFont(new Font("Tahoma",Font.BOLD,15));
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(20, 80, 180, 25);
        lblname.setFont(new Font("SansSerif", Font.BOLD, 20));
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(130, 80, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblsecurity = new JLabel("Security");
        lblsecurity.setBounds(20, 140, 180, 25);
        lblsecurity.setFont(new Font("SansSerif", Font.BOLD, 20));
        p1.add(lblsecurity);
        
        tfsecurity = new JTextField();
        tfsecurity.setBounds(130, 140, 180, 25);
        tfsecurity.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfsecurity);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(20, 200, 180, 25);
        lblanswer.setFont(new Font("SansSerif", Font.BOLD, 20));
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(130, 200, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        
        retrive = new JButton("Retrieve");
        retrive.setBounds(330, 200, 100, 25);
        retrive.setBackground(new Color(0,0,139));
        retrive.setForeground(Color.white);
        retrive.setFont(new Font("Tahoma",Font.BOLD,15));
        retrive.addActionListener(this);
        p1.add(retrive);
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 260, 180, 25);
        lblpassword.setFont(new Font("SansSerif", Font.BOLD, 20));
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(130, 260, 180, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        
        back = new JButton("Back");
        back.setBounds(330, 260, 100, 25);
        back.setBackground(new Color(0,0,139));
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.addActionListener(this);
        p1.add(back);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == search){ 
            try{
                String query = " select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfsecurity.setText(rs.getString("security"));   
                }
            } catch (Exception e){
                e.printStackTrace();            }
        }
        else if(ae.getSource() == retrive){
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText(rs.getString("password"));  
                }
            } catch (Exception e){
                e.printStackTrace();            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    
    public static void main(String[] args){
        new ForgetPassword();
        
    }
    
}
