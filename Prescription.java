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
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);  
        setSize(1000, 1000);  
        setLayout(null);  
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        setTitle("Prescriptions_View");  
        
        try{
        int i=0;
        l1= new JLabel("Hello Doc!");
        Vector <Vector> Data = new Vector<Vector>();
        
        Vector <Vector<String>> p;
        p=DBConnection.getAllPatientName();
        System.out.println(p.get(3).elementAt(1));
        System.out.println(p.get(3).size());
        Vector <String> cols=new Vector<String>(Arrays.asList("Patient Name","Patient ID"));

             
           while(i<p.size())
            {   
               Data.addElement(p.elementAt(i));
               i++;
            }

            table= new JTable(Data, cols);
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
        l1.setForeground(Color.RED);  
        l1.setFont(new Font("Courier New", Font.BOLD, 20));  
        l2.setForeground(Color.RED);  
        l2.setFont(new Font("Courier New", Font.BOLD, 15));  
        tf1= new JTextField();
        b1=new JButton("Proceed");
        b1.addActionListener(this);
        b1.setBounds(200, 600, 100, 30);
        l1.setBounds(100, 450, 200, 30);
        tf1.setBounds(200,500, 300, 30 ); //TextField to take the id of the patient
        l2.setBounds(50, 500, 100, 30);
        add(new JScrollPane(table));
        add(l1);
        add(b1);
        add(l2);
        add(tf1);
        }


    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
             
             String s=tf1.getText();
             new Patient_Prescrip(s).setVisible(true);
             dispose();

    
}
public static void main(String arr[])

   {

       new Prescription();

   }

}

