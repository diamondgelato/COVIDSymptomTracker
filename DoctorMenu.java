package ia;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.*;

public class DoctorMenu extends JFrame implements ActionListener 

{   JLabel l1;
    JButton b1, b2;  
    
    DoctorMenu()
    {
        getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);  
        setSize(300, 300);  
        setLayout(null);  
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        setTitle("DOCTOR MENU");  
        l1 = new JLabel("Doctor MENU");
        
        l1.setForeground(Color.white);  
        l1.setFont(new Font("Algerian", Font.BOLD, 15)); 
        b1 = new JButton("Prescriptions");  
        //b2 = new JButton("Display Previous Prescription");  
        b1.addActionListener(this);  
        //b2.addActionListener(this); 
        l1.setBounds(80, 30, 400, 30); 
        b1.setBounds(50, 100, 150, 30);  
        //b2.setBounds(170, 100, 100, 100);   
        add(l1);  
        add(b1);  
       // add(b2);  
        
         
    }

    

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
            if (e.getSource() == b1) {
                Prescription s1= new Prescription();
                  s1.setVisible(true);
                    dispose(); }
             
             
            //  else {
            //      DisplayPresp s2= new DisplayPresp();
            //       s2.setVisible(true);
            //       dispose(); }
            
                 
             

    }

}


