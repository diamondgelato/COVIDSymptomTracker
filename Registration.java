
// package ia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf5, tf6, tf7;
    JButton btn1, btn2;
    JPasswordField p1, p2;

    Registration() {
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration Form in Java");

        l1 = new JLabel("Registration Form in Windows Form:");
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Courier New", Font.BOLD, 20));

        l2 = new JLabel("Name:");
        l3 = new JLabel("Username:");
        l4 = new JLabel("Create Password:");
        l5 = new JLabel("Confirm Password:");
        l6 = new JLabel("Gender:");
        l7 = new JLabel("Age:");
        l8 = new JLabel("Phone No:");

        tf1 = new JTextField();
        tf2 = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();

        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        l1.setBounds(100, 30, 700, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        p1.setBounds(300, 150, 200, 30);
        p2.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        btn1.setBounds(50, 350, 100, 30);
        btn2.setBounds(170, 350, 100, 30);

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(p1);
        add(l5);
        add(p2);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(tf7);
        add(btn1);
        add(btn2);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            int x = 0;
            String s1 = tf1.getText(); // Name
            String s2 = tf2.getText(); // Username
            char[] s3 = p1.getPassword(); // Password
            char[] s4 = p2.getPassword(); // Confirm Password
            String s8 = new String(s3);
            String s9 = new String(s4);
            String s5 = tf5.getText(); // Gender
            String s6 = tf6.getText(); // Age
            String s7 = tf7.getText(); // Phone Number

            try {
                if (s8.equals(s9)) {
                    // add to db
                    int a = Integer.parseInt(s6);
                    char c = s5.toUpperCase().charAt(0);
                    String g = String.valueOf(c);
                    
                    int id = DBConnection.addPatientData(s1, s2, s9, a, s7, g);

                    new Patient_Menu(id).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
                }
            }

            catch (ClassNotFoundException c) {
                System.out.println("Class NOT Found");
            } catch (SQLException sq) {
                System.out.println("DATABASE Error");
            }
        }

        else {
            tf1.setText("");
            tf2.setText("");
            p1.setText("");
            p2.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
        }
    }
}
