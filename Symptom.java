
package ia;



import javax.swing.*;

import java.awt.*;
import java.awt.event.*; 
import java.sql.*;  

 public class Symptom extends JFrame implements ActionListener  {
     JLabel l1;
     JButton b1;
     JCheckBox c1,c2,c3,c4,c5,c6,c7;
     
     Symptom(){
          getContentPane().setBackground(Color.ORANGE);
         setTitle("Symptoms");

        setVisible(true);

        setSize(500, 500);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel("Symptoms");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));
        
        c1= new JCheckBox("Fever");
        c2= new JCheckBox("Aches and Pains");
        c3= new JCheckBox("Dizziness");
        c4= new JCheckBox("Sore throat");
        c5= new JCheckBox("Dry Cough");
        c6= new JCheckBox("Difficulty in breathing");
        c7= new JCheckBox("Chest Pain");
        b1 = new JButton("Submit");  
        
        l1.setBounds(100, 30, 400, 30);  
        c1.setBounds(80, 70, 200, 30);  
        c2.setBounds(80, 110, 200, 30);  
        c3.setBounds(80, 150, 200, 30);  
        c4.setBounds(80, 190, 200, 30);  
        c5.setBounds(80, 230, 200, 30);  
        c6.setBounds(80, 270, 200, 30);  
        c7.setBounds(80, 310, 200, 30); 
        b1.setBounds(50, 350, 100, 30);  
        b1.addActionListener(this);  
        add(l1);
        add(c1);
        add(c2);
        add(c3); 
        add(c4);
        add(c5);
        add(c6);
        add(c7);
        add(b1);
          
     
     }    
     
     public void actionPerformed(ActionEvent e){
          try

        {
            //Code for Data connectivity

       
        }
        catch (Exception ex)

        {

            System.out.println(ex);

        }

         
     } 
     public static void main(String arr[])

   {

       new Symptom();

   }

 }