package ia;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.util.*;
import java.awt.*;
import java.awt.event.*:


public class Prescription extends JFrame implements ActionListener{
    JFrame f;
    JButton b1, b2;
    JTextArea ta;
    JTextField tf1, tf2;
    JRadioButton r1, r2, r3, r4 ;
    JLabel l1;
    JTable table;
    static Scanner s1=new Scanner(System.in);

    Prescription()
    {
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);  
        setSize(700, 700);  
        setLayout(null);  
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        setTitle("Prescription_Doctor");  
        
        int i=0;
        l1= new JLabel("Hello Doc!");
        Vector <Vector> Data = new Vector<Vector>();
        
        Vector <Vector<String>> p;
        p=DBConnection.getAllPatientName();
        Vector <String> cols=new Vector<String>(Arrays.asList("Patient Name","Patient ID"));

             
           while(i<p.size())
            {   
               Data.addElement(p.elementAt(i));
               i++;
            }

            table= new JTable(Data, cols);
            add(new JScrollPane(table));

        l1= new JLabel("Enter the Patient ID:");
        tf1= new JTextField();
        b1=new JButton("Proceed");
        b1.addActionListener(this);
        
        }
        int temp_id= 0;

        boolean cont=true;
        // try {
        //     while(cont==true)
        //     {   
        //         patients.
        //         l2= new JLabel ("Patient Name: "); //Patient Name needs to be printed against it
        //         l3= new JLabel("Age:"); //Age of the Patient needs to be printed against it
        //         l4= new JLabel("Gender"); //Gender needs to be printed against it
        //         System.out.println();
        
        //         l5 = new JLabel("Name of the Medicine:");  
        //         l6 = new JLabel("Dosage:"); 
        //         t1= new JTextField();
        //         t2 =new JTextArea();
        //         break;
        //     }

        // }
        // catch(NumberFormatException ne)
        // {
        //     cont=false;
        //     System.out.println("The ID doesn't exist");
        // }
        
        

        // l7 = new JLabel("Number of times in the Day:");  
        // l8 = new JLabel("Number of Days to take the medicine:"); 
        




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    // public static void main(String args[])
    // {
    //   
    // }

    //Pass Date as well
}

