package ia;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.graalvm.compiler.lir.amd64.vector.AMD64VectorMove.VectorMemOp;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

//This is for the doctor to view a particular patient's prescriptions

public class DisplayPresp extends JFrame implements ActionListener{
    //Pass only patient ID and get all prescriptions
    JFrame f;
    JButton b1, b2, b3;
    JTextArea ta;
    JTextField tf1, tf2;
    //JRadioButton r1, r2, r3, r4 ;
    JLabel l1, l2, l3,l4,l5, l6;
    JTable table;
    DisplayPresp(){
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=tf1.getText();
        int x=Integer.parseInt(s);
        Vector <String[]> vec= DBConnection.getAllPrescription(x);
        //Have to make sure if DB has connection is right or not
        //have print these on the console window- have no idea about it.
      

    }
    
}
