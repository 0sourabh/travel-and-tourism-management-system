package travel.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Payment extends JFrame implements ActionListener{

    JButton back,pay;

    Payment(){
        
        
        setBounds(350, 180, 900, 520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/payment.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(610,250,150,150);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/payment0.jpg"));
        Image i5 = i4.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(280,80,300,300);
        add(image1);
        
        JLabel text = new JLabel("Go Cashless!!");
        text.setBounds(360, 20, 200, 30);
        text.setForeground(new Color(0, 0, 139));
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);
        
        JLabel text1 = new JLabel("SCAN QR");
        text1.setBounds(640, 225, 200, 30);
        text1.setForeground(new Color(255, 164, 0));
        text1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text1);
        
        back = new JButton("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(80,420,100,25);
        back.addActionListener(this);
        add(back);
        
        
        pay = new JButton("Other Payment option");
        pay.setBackground(new Color(0, 0, 139));
        pay.setForeground(Color.white);
        pay.setBounds(600,420,200,25);
        pay.addActionListener(this);
        add(pay);
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == pay){
        
            setVisible(false);
            new Paytm();
        
        }else {
        
            setVisible(false);
        }
    
    
    }
    
    public static void main(String[] args){
    
        new Payment();
    }

    
}
