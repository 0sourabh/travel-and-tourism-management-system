package travel.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    String username;
    JButton bookflight,booktrain,feedback,deletePersonalDetails,about,bookdestinations,viewbookeddestinations,payments,viewBookedHotels,bookHotels,destinations,viewHotels, viewPackages,bookPackages,addPersonalDetails,viewPersonalDetails,updatePersonalDetails,checkPackages;
    
    
    Dashboard(String username){
        
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p0 = new JPanel();
        p0.setBackground(new Color(255, 164, 0));
        p0.setBounds(0, 60, 1600, 60);
        p0.setLayout(null);
        add(p0);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(255, 164, 0));
        p1.setBounds(0, 0, 1600, 70);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard_logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(10, 0, 70, 70);
        p1.add(icon);
        
        JLabel heading = new JLabel("  Dashboard");
        heading.setBounds(75,10,600,40);
        heading.setForeground(new Color(0,0,139));
        heading.setFont(new Font("Raleway",Font.BOLD,30));
        p1.add(heading);
//        
//        JPanel p2 = new JPanel();
//        p2.setBackground(new Color(255, 164, 0));
//        p2.setBounds(0, 65, 250, 9000);
//        p2.setLayout(null);
//        add(p2);
//        
//        JPanel p3 = new JPanel();
//        p3.setBackground(new Color(255, 164, 0));
//        p3.setBounds(1290, 65, 250, 9000);
//        p3.setLayout(null);
//        add(p3);
//        
        addPersonalDetails = new JButton("Personal Details");
        addPersonalDetails.setBounds(40, 5, 150, 50);
        addPersonalDetails.setBackground(new Color(255, 164, 0));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setBorder(BorderFactory.createEmptyBorder());
        addPersonalDetails.addActionListener(this);
        p0.add(addPersonalDetails);
        
        
//        updatePersonalDetails = new JButton("Update Personal Details");
//        updatePersonalDetails.setBounds(250, 5, 250, 50);
//        updatePersonalDetails.setBackground(new Color(255, 164, 0));
//        updatePersonalDetails.setForeground(Color.white);
//        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
//        updatePersonalDetails.setBorder(BorderFactory.createEmptyBorder());
//        updatePersonalDetails.addActionListener(this);
//        p0.add(updatePersonalDetails);
//        
//        viewPersonalDetails = new JButton("View Personal Details");
//        viewPersonalDetails.setBounds(500, 5, 250, 50);
//        viewPersonalDetails.setBackground(new Color(255, 164, 0));
//        viewPersonalDetails.setForeground(Color.white);
//        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
//        viewPersonalDetails.setBorder(BorderFactory.createEmptyBorder());
//        viewPersonalDetails.addActionListener(this);
//        p0.add(viewPersonalDetails);
//        
//        deletePersonalDetails = new JButton("Delete Personal Details");
//        deletePersonalDetails.setBounds(750, 5, 250, 50);
//        deletePersonalDetails.setBackground(new Color(255, 164, 0));
//        deletePersonalDetails.setForeground(Color.white);
//        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
//        deletePersonalDetails.setBorder(BorderFactory.createEmptyBorder());
//        deletePersonalDetails.addActionListener(this);
//        p0.add(deletePersonalDetails);
//        
        
        checkPackages = new JButton("Packages");
        checkPackages.setBounds(190, 5, 150, 50);
        checkPackages.setBackground(new Color(255, 164, 0));
        checkPackages.setForeground(Color.white);
        checkPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkPackages.setBorder(BorderFactory.createEmptyBorder());
        checkPackages.addActionListener(this);
        p0.add(checkPackages);
        
        
        bookPackages = new JButton("Book Packages");
        bookPackages.setBounds(340, 5, 150, 50);
        bookPackages.setBackground(new Color(255, 164, 0));
        bookPackages.setForeground(Color.white);
        bookPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookPackages.setBorder(BorderFactory.createEmptyBorder());
        bookPackages.addActionListener(this);
        p0.add(bookPackages);
        
        
//        viewPackages = new JButton("View Booked Packages");
//        viewPackages.setBounds(0, 305, 250, 50);
//        viewPackages.setBackground(new Color(255, 164, 0));
//        viewPackages.setForeground(Color.white);
//        viewPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
//        viewPackages.setBorder(BorderFactory.createEmptyBorder());
//        viewPackages.addActionListener(this);
//        p2.add(viewPackages);
//        
        
//        viewBookedHotels = new JButton("View Booked Hotels");
//        viewBookedHotels.setBounds(0, 455, 250, 50);
//        viewBookedHotels.setBackground(new Color(255, 164, 0));
//        viewBookedHotels.setForeground(Color.white);
//        viewBookedHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
//        viewBookedHotels.setBorder(BorderFactory.createEmptyBorder());
//        viewBookedHotels.addActionListener(this);
//        p3.add(viewBookedHotels);
//        
        
        destinations = new JButton("Destinations");
        destinations.setBounds(500, 5, 150, 50);
        destinations.setBackground(new Color(255, 164, 0));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setBorder(BorderFactory.createEmptyBorder());
        destinations.addActionListener(this);
        p0.add(destinations);
        
        bookdestinations = new JButton("Book Destinations");
        bookdestinations.setBounds(660, 5, 170, 50);
        bookdestinations.setBackground(new Color(255, 164, 0));
        bookdestinations.setForeground(Color.white);
        bookdestinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookdestinations.setBorder(BorderFactory.createEmptyBorder());
        bookdestinations.addActionListener(this);
        p0.add(bookdestinations);
        
        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(830, 5, 150, 50);
        viewHotels.setBackground(new Color(255, 164, 0));
        viewHotels.setForeground(Color.white);
        viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewHotels.setBorder(BorderFactory.createEmptyBorder());
        viewHotels.addActionListener(this);
        p0.add(viewHotels);
        
        bookHotels = new JButton("Book Hotels");
        bookHotels.setBounds(980, 5, 150, 50);
        bookHotels.setBackground(new Color(255, 164, 0));
        bookHotels.setForeground(Color.white);
        bookHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookHotels.setBorder(BorderFactory.createEmptyBorder());
        bookHotels.addActionListener(this);
        p0.add(bookHotels);
        
        booktrain = new JButton("Book Travel");
        booktrain.setBounds(1130,5,150, 50);
        booktrain.setBackground(new Color(255, 164, 0));
        booktrain.setForeground(Color.white);
        booktrain.setFont(new Font("Tahoma",Font.PLAIN,20)); 
        booktrain.setBorder(BorderFactory.createEmptyBorder());
        booktrain.addActionListener(this);
        p0.add(booktrain);
        
//        bookflight = new JButton("Book Flight");
//        bookflight.setBounds(0,305, 250, 50);
//        bookflight.setBackground(new Color(255, 164, 0));
//        bookflight.setForeground(Color.white);
//        bookflight.setFont(new Font("Tahoma",Font.PLAIN,20));
//        bookflight.setBorder(BorderFactory.createEmptyBorder());
//        bookflight.addActionListener(this);
//        p3.add(bookflight);
//        
//        viewbookeddestinations = new JButton("View Booked Destinations");
//        viewbookeddestinations.setBounds(0, 455, 250, 50);
//        viewbookeddestinations.setBackground(new Color(255, 164, 0));
//        viewbookeddestinations.setForeground(Color.white);
//        viewbookeddestinations.setFont(new Font("Tahoma",Font.PLAIN,20));
//        viewbookeddestinations.setBorder(BorderFactory.createEmptyBorder());
//        viewbookeddestinations.addActionListener(this);
//        p2.add(viewbookeddestinations);
        
        payments = new JButton("Payment");
        payments.setBounds(1270, 5, 150, 50);
        payments.setBackground(new Color(255, 164, 0));
        payments.setForeground(new Color(0,0,139));
        payments.setFont(new Font("Tahoma",Font.BOLD,20));
        payments.setBorder(BorderFactory.createEmptyBorder());
        payments.addActionListener(this);
        p0.add(payments);
        
        
        
        //calculator = new JButton("Calculator");
        //calculator.setBounds(0, 605, 250, 50);
        //calculator.setBackground(new Color(255, 164, 0));
        //calculator.setForeground(Color.white);
        //calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        //calculator.setBorder(BorderFactory.createEmptyBorder());
        //calculator.addActionListener(this);
        //p2.add(calculator);
        
        
        //notepad = new JButton("NotePad");
        //notepad.setBounds(0, 655, 250, 50);
        //notepad.setBackground(new Color(255, 164, 0));
        //notepad.setForeground(Color.white);
        //notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        //notepad.setBorder(BorderFactory.createEmptyBorder());
        //notepad.addActionListener(this);
        //p2.add(notepad);
        
        
//        feedback = new JButton("Feedback");
//        feedback.setBounds(0, 555, 250, 50);
//        feedback.setBackground(new Color(255, 164, 0));
//        feedback.setForeground(Color.white);
//        feedback.setFont(new Font("Tahoma",Font.PLAIN,20));
//        feedback.setBorder(BorderFactory.createEmptyBorder());
//        feedback.addActionListener(this);
//        p3.add(feedback);
        
        
        about = new JButton("About");
        about.setBounds(1390, 5, 150, 50);
        about.setBackground(new Color(255, 164, 0));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setBorder(BorderFactory.createEmptyBorder());
        about.addActionListener(this);
        p0.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/main3.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1540, 800, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 100, 1540, 800);
        add(image);
        
        
        JLabel text = new JLabel("It's Time to Travel");
        text.setBounds(550,20,1000,70);
        text.setForeground(new Color(0,0,139));
        text.setFont(new Font("SansSerif",Font.BOLD,50));
        image.add(text);
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            
            new AddCustomer(username);
                        
        }else if(ae.getSource() == viewPersonalDetails){
        
            new ViewCustomer(username);   
        }else if(ae.getSource() == updatePersonalDetails){
        
            new UpdateCustomer(username);   
        }else if(ae.getSource() == checkPackages){
        
            new CheckPackage(); 
        }else if(ae.getSource() == bookPackages){
        
            new BookPackage(username); 
        }else if(ae.getSource() == viewPackages){
        
            new ViewPackage(username); 
        }else if(ae.getSource() == viewHotels){
        
            new CheckHotels(); 
        }else if(ae.getSource() == destinations){
        
            new Destinations(); 
        }else if(ae.getSource() == bookHotels){
        
            new BookHotel(username); 
        }else if(ae.getSource() == viewBookedHotels){
        
            new ViewBookedHotel(username); 
        }else if(ae.getSource() == payments){
        
            new Payment(); 
        }else if(ae.getSource() == bookdestinations){
        
            new bookDestination(username); 
        }
        else if(ae.getSource() == viewbookeddestinations){
        
            new viewDestination(username); 
        }
        else if(ae.getSource() == booktrain){
        
            new BookTrain(username); 
        }
        else if(ae.getSource() == bookflight){
        
            new BookFlight(username); 
        }

        //else if(ae.getSource() == calculator){
            
            //try{
            
            //    Runtime.getRuntime().exec("calc.exe");
            //}catch(Exception e){
            
              //  e.printStackTrace();
            //}
            //}
        
            
        //else if(ae.getSource() == notepad){
            
          //  try{
            
            //    Runtime.getRuntime().exec("notepad.exe");
            //}catch(Exception e){
            
              //  e.printStackTrace();
            //}
          //}
        else if(ae.getSource() == about){
        
            new About(username); 
        }else if(ae.getSource() == deletePersonalDetails){
        
            new DeleteDetails(username); 
        }
        else if(ae.getSource() == feedback){
        
            new feedback(); 
        }
    
    }
    
    public static void main (String[] args){
        new Dashboard("");
    }
}
