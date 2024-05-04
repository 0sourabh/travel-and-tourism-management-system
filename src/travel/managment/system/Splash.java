package travel.managment.system;

import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread thread;
    
    Splash(){
        //setSize(1000,600);
        //setLocation(250,115);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front2.png"));
        Image i2 = i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        
        add(image);
        setVisible(true);
        thread = new Thread(this);
        thread.start();
    }
    
    public void run() {
        try{
           Thread.sleep(2000);
         //new Login();
           setVisible(false);        
        } catch (Exception e){
            
        }
    }
    
    
    public static void main(String[] args){
        Splash frame = new Splash();
        
        int x = 1;
        for(int i=1;i<=500;x+=7, i+=7){
            frame.setLocation(750 - (x+i)/2, 400 - (i/2));
            frame.setSize(x+i,i);
            try {
                Thread.sleep(5);
            } catch (Exception e){}
        }
        
    }
}
