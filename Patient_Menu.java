package ia;
import javax.lang.model.util.ElementScanner14;
import javax.swing.*;  
import java.awt.*; 
import java.awt.event.*;

public class Patient_Menu extends JFrame implements ActionListener  


{   JLabel l1;
    JButton b1, b2, b3;  
    
    Patient_Menu()
    {
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);  
        setSize(500,500);  
        setLayout(null);  
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        setTitle("PATIENT MENU");  
        l1 = new JLabel("  Patient MENU");
        
        l1.setForeground(Color.RED);  
        l1.setFont(new Font("Courier New", Font.BOLD, 20)); 
        b1 = new JButton("Symptom Update");  
        b2 = new JButton("View New Prescription");  
        b3 = new JButton("Report");
        b1.addActionListener(this);  
        b2.addActionListener(this); 
        b3.addActionListener(this);
        l1.setBounds(200, 30, 400, 100 ); 
        b1.setBounds(50, 100, 100, 30);  
        b2.setBounds(170, 100, 100, 30); 
        b3.setBounds(290, 100, 100, 30);
        add(l1);  
        add(b1);  
        add(b2);  
        add(b3);
        
         
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
            if (e.getSource() == b1) {
                Symptom s1= new Symptom();
                  s1.setVisible(true);
                  dispose();
             }
             
             else if(e.getSource()==b2){
                 NewPrespView s2= new NewPrespView();
                  s2.setVisible(true);
                  dispose();
            
                 
             }
             else {
                Report s2= new Report();
                s2.setVisible(true);
                dispose();

             }

    }
    public static void main(String arr[])

   {

       new Patient_Menu();

   }


 }






    

