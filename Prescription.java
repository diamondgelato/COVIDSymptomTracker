package ia;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;


public class Prescription extends JFrame implements ActionListener{
    JFrame f;
    JButton b1, b2, b3;
    JTextArea ta;
    JTextField tf1, tf2;
    //JRadioButton r1, r2, r3, r4 ;
    JLabel l1, l2, l3,l4,l5, l6;
    JTable table;
    static Scanner s1=new Scanner(System.in);

    Prescription()
    {
        getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);  
        setSize(1000, 1000);  
        setLayout(null);  
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        setTitle("Prescriptions_View");  
        
        try{
        int i=0;
        //l1= new JLabel("Hello Doc!");
        Vector <String[]> Data = new Vector<String[]>(); //New vector
        
        Vector <String[]> p;
        p=DBConnection.getAllPatientName(); //getting from database.

        // System.out.println();
        // System.out.println(p.get(3).size());
        String s2[]={"Patient Name", "Patient ID"};
        Vector <String[]> cols=new Vector<String[]>();
        cols.add(s2);

             
           while(i<p.size())
            {   
               Data.addElement(p.elementAt(i));
               i++;


            }
            System.out.println(Data);

           //table= new JTable(Data, cols);
        }

        catch(SQLException sq)
        {
            System.out.println("DATABASE Error");
            System.out.println(sq.getMessage());
        }
        catch(ClassNotFoundException c)
        {
            System.out.println("Class Not Found");
        }  

        l2= new JLabel("Enter the Patient ID:");
        // l1.setForeground(Color.white);  
        //l1.setFont(new Font("Courier New", Font.BOLD, 20));  
        l2.setForeground(Color.white);  
        l2.setFont(new Font("Courier New", Font.BOLD, 15));  
        tf1= new JTextField();
        b1=new JButton("Create Prescriptions");
        //b2=new JButton("view Prescriptions");
        b1.addActionListener(this);
        //b2.addActionListener(this);
        
        //b2.setBounds(700, 600, 500,30);
        b1.setBounds(150, 300 , 500, 30);
        //l1.setBounds(100, 100, 200, 30);
        tf1.setBounds(300,200, 300, 30 ); //TextField to take the id of the patient
        l2.setBounds(50, 200, 500, 30);
        // add(new JScrollPane(table));
        // add(l1);
        add(b1);
        //add(b2);
        add(l2);
        add(tf1);
        }


    public void actionPerformed(ActionEvent e) {
        String s=tf1.getText();
        // TODO Auto-generated method stub
            
             if(e.getSource()==b1)
             {
                
                new Patient_Prescrip(s).setVisible(true);
                dispose();
             }
            //  else
            //  {
            //     new DisplayPresp(s).setVisible(true);
            //     dispose();
            //  }
             

    
}
public static void main(String arr[])

   {

       new Prescription();

   }

}

