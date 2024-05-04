package travel.managment.system;

import java.awt.*;
import javax.swing.*;

public class Destinations extends JFrame implements Runnable {
    
    
    
    Thread t1;

    JLabel caption;
    JLabel[] label = new JLabel[10];
    public void run() {
    String[] text = new String[]{"Sweden","Udaipur","Italy","Paris","London","Turkey","Austria","Delhi","Greece","Goa"};

    try {
        for (int i = 0; i < text.length; i++) {
            label[i].setVisible(true);
            caption.setText(text[i]);

            Thread.sleep(2500);
            label[i].setVisible(false);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Here, we can close the JFrame after all hotels are displayed
        dispose();
    }
    }


    Destinations() {

        setBounds(350, 180, 900, 520);
        
        caption = new JLabel();
        caption.setBounds(20,10,700,70);
        caption.setFont(new Font("Tahoma",Font.BOLD,40));
        caption.setForeground(Color.white);
        add(caption);
        
        
        
        setLayout(null);
        
        getContentPane().setBackground(Color.white);

        ImageIcon[] image = new ImageIcon[10];

        for (int i = 0; i < 10; i++) {
            // Ensure resource loading works correctly
            image[i] = new ImageIcon(getClass().getResource("/icons/dest" + (i + 1) + ".jpg"));
            // Scale image directly
            Image scaledImage = image[i].getImage().getScaledInstance(900, 520, Image.SCALE_DEFAULT);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            label[i] = new JLabel(scaledIcon);
            label[i].setBounds(0, 0,900, 520);
            add(label[i]);
        }
        
        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Destinations();
    }
}
