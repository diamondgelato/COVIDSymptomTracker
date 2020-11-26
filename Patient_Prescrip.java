package ia;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class Patient_Prescrip extends JFrame implements ActionListener {
    JFrame f;
    JButton b1, b2, b3;
    JTextArea ta;
    JTextField tf1, tf2;
    //JRadioButton r1, r2, r3, r4 ;
    JLabel l1, l2, l3,l4,l5, l6;
    JTable table;
    int x;
    private HashMap<String, String> p1;
    static Scanner s1=new Scanner(System.in);
             
             Patient_Prescrip(String s) 
            {
             try{
                x=Integer.parseInt(s);
                
                p1= DBConnection.getPatientData(x);
             }
             catch(SQLException sq){
                 System.out.println("DATABASE Error");

            }
            catch(ClassNotFoundException c)
            {
                System.out.println("Class Not Found");
            }
             

             getContentPane().setBackground(Color.CYAN);
             setVisible(true);  
             setSize(1000, 1000);  
             setLayout(null);  
             setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
             setTitle("Create Prescription");  
             
                l2= new JLabel ("Patient Name: "+p1.get("name")); //Patient Name needs to be printed against it
                l3= new JLabel("Age:"+p1.get("age")); //Age of the Patient needs to be printed against it
                l4= new JLabel("Gender"+p1.get("gender")); //Gender needs to be printed against it
                l5 = new JLabel("Name of the Medicine:");  
                l6 = new JLabel("Dosage:"); 
                tf1 = new JTextField();
                ta = new JTextArea();
                b2= new JButton("Submit");
                b3= new JButton("Clear");
                l2.setForeground(Color.RED);
                l3.setForeground(Color.RED);
                l4.setForeground(Color.RED);
                l5.setForeground(Color.RED);
                l6.setForeground(Color.RED);
                l2.setFont(new Font("Courier New", Font.BOLD, 15)); 
                l3.setFont(new Font("Courier New", Font.BOLD, 15)); 
                l4.setFont(new Font("Courier New", Font.BOLD, 15)); 
                l5.setFont(new Font("Courier New", Font.BOLD, 15)); 
                l6.setFont(new Font("Courier New", Font.BOLD, 15)); 
                b2.addActionListener(this);
                b3.addActionListener(this);
                l3.setBounds(50, 250, 300, 30);
                l2.setBounds(50, 200, 300, 30);
                l5.setBounds(50, 350, 300, 30);
                l4.setBounds(50, 300, 300, 30);
                l6.setBounds(50, 400, 300, 30);
                tf1.setBounds(400, 350, 300, 30);
                ta.setBounds(400, 400, 300, 500);
                b3.setBounds(50, 600, 100, 30);
                b2.setBounds(200, 600, 100, 30);
                add(l2);
                add(l3);
                add(l4);
                add(l5);
                add(l6);
                add(tf1);
                add(ta);
                add(b1);
                add(b2);

                //Pass Date as well


                //l4.setBounds(r);

    
}

			public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                if(e.getSource()==b2)
                {
                  try{
                    String n=tf1.getText();
                    String m=ta.getText();
                    Vector<String[]> v1= new Vector<String[]>();
                    String s[]={n,m};
                    v1.add(s);
                    Date d= new Date();
                    
                    DBConnection.addPatientPrescription(x, d, v1);
                  }
                  
                }
                catch(SQLException sq){
                    System.out.println("DATABASE Error");
   
               }
               catch(ClassNotFoundException c)
               {
                   System.out.println("Class Not Found");
               }
                else
                {
                    ta.setText("");
                    tf1.setText("");
                }
				
            }
            public static void main(String arr[])

   {

       new Prescription();

   }

        }
