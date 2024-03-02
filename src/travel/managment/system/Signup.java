package travel.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    
    JButton create, back;
    JTextField tfname, tfusername, tfanswer;
    JPasswordField pfpassword;
    Choice security;
            
            
            
    Signup(){
        setBounds(350,250,900,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(255, 164, 0));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(90, 40, 125, 25);
        lblusername.setFont(new Font("SansSerif", Font.BOLD, 20));
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(220, 40, 180, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(90, 80, 125, 25);
        lblname.setFont(new Font("SansSerif", Font.BOLD, 20));
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 180, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(90, 120, 125, 25);
        lblpassword.setFont(new Font("SansSerif", Font.BOLD, 20));
        p1.add(lblpassword);
        
        pfpassword = new JPasswordField();
        pfpassword.setBounds(220, 120, 180, 25);
        pfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(pfpassword);
        
        JLabel lblsecurity = new JLabel("Security");
        lblsecurity.setBounds(90, 160, 125, 25);
        lblsecurity.setFont(new Font("SansSerif", Font.BOLD, 20));
        p1.add(lblsecurity);
        
        
        security = new Choice();
        security.add("Favourite Marvel Charecter");
        security.add("Favourite Anime Charecter");
        security.add("Your Lucky Number");
        security.add("Your Nickname");
        security.setBounds(220,160,180,30);
        p1.add(security);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(90, 200, 125, 25);
        lblanswer.setFont(new Font("SansSerif", Font.BOLD, 20));
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(220, 200, 180, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        
        create = new JButton("Create");
        create.setBounds(90, 270, 100, 30);
        create.setBackground(new Color(0,0,139));
        create.setForeground(Color.white);
        create.setFont(new Font("Tahoma",Font.BOLD,15));
        //create.setBorder(new LineBorder(new Color(255, 102, 0)));
        create.addActionListener(this);
        p1.add(create);
        
        
        back = new JButton("Back");
        back.setBounds(300, 270, 100, 30);
        back.setBackground(new Color(0,0,139));
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        //create.setBorder(new LineBorder(new Color(255, 102, 0)));
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Login2.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 10, 350, 350);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = pfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();
            
            String query = " insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Account Created Sucessfully");
                
                setVisible(false);
                new Login();
            } catch (Exception e){
                e.printStackTrace();            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String [] args){
        new Signup();
    
}
}