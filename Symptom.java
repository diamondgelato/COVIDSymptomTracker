package ia;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Symptom extends JFrame implements ActionListener {
    JLabel l1;
    JButton b1;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    boolean b[] = new boolean[7];
    public int patientID;

    Symptom(int patientID) {
        this.patientID = patientID;

        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Symptoms");
        setVisible(true);
        setSize(500, 500);
        setLayout(null);

        // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        l1 = new JLabel("Symptoms");
        l1.setForeground(Color.white);
        l1.setFont(new Font("Algerian", Font.BOLD, 20));

        c1 = new JCheckBox("Fever");
        c2 = new JCheckBox("Aches and Pains");
        c3 = new JCheckBox("Dizziness");
        c4 = new JCheckBox("Sore throat");
        c5 = new JCheckBox("Dry Cough");
        c6 = new JCheckBox("Difficulty in breathing");
        c7 = new JCheckBox("Chest Pain");
        b1 = new JButton("Submit");

        l1.setBounds(200, 30, 400, 30);
        c1.setBounds(150, 70, 200, 30);
        c2.setBounds(150, 110, 200, 30);
        c3.setBounds(150, 150, 200, 30);
        c4.setBounds(150, 190, 200, 30);
        c5.setBounds(150, 230, 200, 30);
        c6.setBounds(150, 270, 200, 30);
        c7.setBounds(150, 310, 200, 30);
        b1.setBounds(200, 350, 100, 30);

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

    public void actionPerformed(ActionEvent e) {
            if (c1.isSelected())
                b[0] = true;

            if (c2.isSelected())
                b[1] = true;

            if (c3.isSelected())
                b[2] = true;

            if (c4.isSelected())
                b[3] = true;

            if (c5.isSelected())
                b[4] = true;

            if (c6.isSelected())
                b[5] = true;

            if (c7.isSelected())
                b[6] = true;
                //JOptionPane.showMessageDialog(null, "Symptoms have been successfully submitted.");


        try {
            DBConnection.addPatientSymptom(patientID, new Date(), b);
            dispose ();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}