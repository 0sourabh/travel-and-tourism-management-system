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
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/payment2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(210,50,450,450);
        add(image);
        
        JLabel text = new JLabel("PAYMENT");
        text.setBounds(360, 15, 200, 30);
        text.setForeground(new Color(0, 0, 139));
        text.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(text);
        
        back = new JButton("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(700,350,100,30);
        back.addActionListener(this);
        add(back);
        
        
        pay = new JButton("PAY NOW");
        pay.setBackground(new Color(0, 0, 139));
        pay.setForeground(Color.white);
        pay.setBounds(80,350,100,30);
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
