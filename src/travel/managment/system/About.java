package travel.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener {
    
    String username;
    JButton Feedback, back;
    
    About(String username) {
        
        this.username = username;
    
        setBounds(350, 180, 900, 520);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(400,20,200,40);
        l1.setForeground(new Color(0, 0, 139));
        l1.setFont(new Font("Tahoma", Font.BOLD,30));
        add(l1);
        
        String s = "The main objective of the Tourism Management System is to manage the details of Customer, Hotel Booking, Cancellation and Tourism places. It manages all the information about Users, Hotel,Packages etc. \n" +
"The project is totally built at administrative end and thus only the administrator is guaranteed the access to the backend database. The purpose of this project is to build an application program to reduce the manual work for managing Tourists, Booking, Places etc. \n"+
"This application will help in accessing the information related to the travel to the particular destination with great ease. The users can track the information related to their tours with great ease through this application. The travel agency information can also be obtained through this application.\n" +
"Through this system, the propose system is highly automated and makes the travelling activities much easier and flexible. The user can get the very right information at the very right time. This system will include all the necessary fields which are required during online reservation time. This system will be easy to use and can be used by any person. The basic idea behind this project is to save data in a central database which can be accessed by any authorize person to get information and saves time and burden which are being faced by their customers. \n" +
"Administrator can access and modify the information stored in the database of this system, this includes adding and updating of details, and it will give accurate information and simplifies manual work and also it minimizes the documentation related work. Provides up to date information. Finally booking confirmation notification will be send to the users. \n" +
"Tourists can register by providing personal details, make new reservation and book only one hotel and package and can make cancellation.";
        
        
        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setFont(new Font("Tahoma", Font.PLAIN, 20));
        area.setBounds(20,100,850,300);
        add(area);

        
        back = new JButton("Back");
        back.setBackground(new Color(0, 0, 139));
        back.setForeground(Color.white);
        back.setBounds(300,420,100,30);
        back.addActionListener(this);
        add(back);
        
        
        Feedback = new JButton("Feedback");
        Feedback.setBackground(new Color(0, 0, 139));
        Feedback.setForeground(Color.white);
        Feedback.setBounds(500,420,100,30);
        Feedback.addActionListener(this);
        add(Feedback);
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == Feedback) {
            // Do something when Feedback button is clicked
            new feedback(); 
             
        } else if(ae.getSource() == back) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        // Assuming you have a username, pass it when creating an instance of About
        String username = "exampleUsername";
        new About(username);
    }
}
