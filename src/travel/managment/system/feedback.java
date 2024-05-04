package travel.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class feedback extends JFrame implements ActionListener{
    
    feedback(){
    
        setBounds(350, 180, 900, 520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel l1 = new JLabel("Feedback");
        l1.setBounds(400,20,200,40);
        l1.setForeground(new Color(0, 0, 139));
        l1.setFont(new Font("Tahoma", Font.BOLD,30));
        add(l1);
        
        String s = "";
        
        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        //area.setEditable(false);
        area.setBounds(20,100,850,300);
        area.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(area);

        
        JButton back = new JButton("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(400,420,100,30);
        back.addActionListener(this);
        add(back);
        
        
        
        
        setVisible(true);
        
        
    
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
            setVisible(false);    
            
        }
    
    
    public static void main(String[] args){
    
        new feedback();
    
    }
     
}
