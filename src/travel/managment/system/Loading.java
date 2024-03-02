package travel.managment.system;

import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable{
    
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run() {
        try {
            for(int i=1;i<=101;i++){
                int max = bar.getMaximum();
                int value =bar.getValue();
                
                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                }
                else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(20);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String username){
        
        this.username = username;
        t = new Thread(this);
        setBounds(350,250,900,400);
        getContentPane().setBackground(new Color(255, 164, 0));
        setLayout(null);
        
        JLabel text = new JLabel("Tavel Management System");
        text.setBounds(200,30,600,40);
        text.setForeground(new Color(0,0,139));
        text.setFont(new Font("Raleway",Font.BOLD,40));
        add(text);
        
        JLabel Loading = new JLabel("Loading, Please wait...");
        Loading.setBounds(370,300,600,30);
        Loading.setForeground(new Color(0,0,139));
        Loading.setFont(new Font("SansSerif",Font.PLAIN,16));
        add(Loading);
        
        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(280,150,400,40);
        lblusername.setForeground(Color.white);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,30));
        add(lblusername);
         
         
        bar = new JProgressBar();
        bar.setBounds(295, 280, 300, 15);
        bar.setStringPainted(true);
        add(bar);
       
        t.start();
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Loading("");
        
    }
    
}
