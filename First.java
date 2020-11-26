
package ia;

import javax.swing.*;

// import ia.Precautions;

import java.awt.*;
import java.awt.event.*;

public class First extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2, b3;

    First() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);
        setSize(300, 300);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("COVID Symptoms Tracker");
        l1 = new JLabel("  COVID Symptoms Tracker");

        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Algerian", Font.BOLD, 20));
        b1 = new JButton("Patient");
        b2 = new JButton("Doctor");
        b3= new JButton("Precautions");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        l1.setBounds(40, 30, 400, 30);
        b1.setBounds(50, 100, 100, 30);
        b2.setBounds(170, 100, 100, 30);
        b3.setBounds(110, 150, 120,30);
        add(l1);
        add(b1);
        add(b2);
        add(b3);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            Patient_login s1 = new Patient_login();
            s1.setVisible(true);
            dispose();
        } else if (e.getSource() == b2) {
            Doctor_login s2 = new Doctor_login();
            s2.setVisible(true);
            dispose();
        } else {
            new Precautions().setVisible(true);
            //dispose();
        }
    }

    public static void main(String args[]) {
        new First();
        System.out.println("Hello");
    }

}