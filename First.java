
// package ia;

import javax.swing.*;

// import ia.Precautions;

import java.awt.*;
import java.awt.event.*;

public class First extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2;

    First() {
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);
        setSize(300, 300);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("COVID Symptoms Tracker");
        l1 = new JLabel("  COVID Symptoms Tracker");

        l1.setForeground(Color.RED);
        l1.setFont(new Font("Serif", Font.BOLD, 15));
        b1 = new JButton("Patient");
        b2 = new JButton("Doctor");
        b1.addActionListener(this);
        b2.addActionListener(this);
        l1.setBounds(50, 30, 400, 30);
        b1.setBounds(50, 100, 100, 30);
        b2.setBounds(170, 100, 100, 30);
        add(l1);
        add(b1);
        add(b2);

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
            // new Precautions().setVisible (true);
            // dispose();
        }
    }

    public static void main(String args[]) {
        new First();
        System.out.println("Hello");
    }

}