package travel.managment.system;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {
    
    CheckPackage() {
    
        setBounds(350,180,900,520);
        
        String[] package1 = {"GOLD PACKAGE" ,"6 DAYS & 7 NIGHTS","5 Star Hotels","Full City Tour","Personal Guide","Airport Assistance","Meal Included","Adventure Activities","Book Now!!","Price:150000/-","package1.jpg"};
        String[] package2 = {"SILVER PACKAGE","6 DAYS & 7 NIGHTS","3 Star Hotels","Full City Tour","Personal Guide","Cab Service","Meal Included","Clubbing","Book Now!!","Price:75000/-","package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE","2 DAYS & 3 NIGHTS","Non AC Hotels","Famous Places Visit","Personal Guide","Bus Service","Meal Included","Dance & Party","Book Now!!","Price:25000/-","package3.jpg"};
        
        JTabbedPane tab = new JTabbedPane();
        
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);
        
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);
        
        add(tab);
        
        setVisible(true);
    }
    
    
    public JPanel createPackage(String[] pack) {
    
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(100, 10, 300, 40);
        l1.setForeground(new Color(255, 204, 51));
        l1.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l1);
        
        JLabel lsub = new JLabel("ALL OVER INDIA");
        lsub.setBounds(160, 30, 300, 30);
        lsub.setForeground(Color.black);
        lsub.setFont(new Font("Tahoma",Font.BOLD,10));
        p1.add(lsub);
        
        
        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30, 60, 300, 30);
        l2.setForeground(new Color(0,0,139));
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l2);
        
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30, 110, 300, 30);
        l3.setForeground(new Color(0,0,139));
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l3);
        
        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30, 160, 300, 30);
        l4.setForeground(new Color(0,0,139));
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l4);
        
        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30, 210, 300, 30);
        l5.setForeground(new Color(0,0,139));
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l5);
        
        
        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30, 260, 300, 30);
        l6.setForeground(new Color(0,0,139));
        l6.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30, 310, 300, 30);
        l7.setForeground(new Color(0,0,139));
        l7.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l7);
        
        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30, 360, 300, 30);
        l8.setForeground(new Color(0,0,139));
        l8.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(120, 410, 300, 30);
        l9.setForeground(new Color(255, 164, 0));
        l9.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l9);
        
        
        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(550, 410, 300, 30);
        l10.setForeground(Color.red);
        l10.setFont(new Font("Tahoma",Font.BOLD,15));
        p1.add(l10);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/package1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(400, 10 , 400, 400);
        p1.add(icon);
        
        return p1;
    
    }
    
    
    public static void main(String[] args) {
    
        new CheckPackage();
    
    }
}
