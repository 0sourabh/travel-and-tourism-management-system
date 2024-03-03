package travel.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame implements ActionListener{
    
    Paytm(){
    
        
        setBounds(350, 180, 900, 520);
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        
        try{
        
        
            pane.setPage("https://paytm.com/rent-payment");
        
        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Unable Load,Error 404...</html>");
        }
        
        
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);
        
        JButton back = new JButton("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(750,20,100,30);
        back.addActionListener(this);
        pane.add(back);
        
        
        setVisible(true);
        
    
    
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
            setVisible(false);    
            new Payment();
        }
    
    public static void main(String[] args){
    
    
        new Paytm();
    
        
    }
    
}
