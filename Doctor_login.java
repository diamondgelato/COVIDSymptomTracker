package ia;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

 

public class Doctor_login extends JFrame implements ActionListener

{

    JLabel l1, l2, l3;

    JTextField tf1;

    JButton btn1;

    JPasswordField p1;

 

    Doctor_login()

    {
         getContentPane().setBackground(Color.DARK_GRAY);

        setTitle("Login Form");

        setVisible(true);

        setSize(700, 700);

        setLayout(null);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

 

        l1 = new JLabel("Login Form");

        l1.setForeground(Color.WHITE);

        l1.setFont(new Font("Algerian", Font.BOLD, 20));

 

        l2 = new JLabel("Enter Email:");

        l3 = new JLabel("Enter Password:");
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l2.setFont(new Font("Courier New", Font.BOLD, 15));
        l3.setFont(new Font("Courier New", Font.BOLD, 15));
        tf1 = new JTextField();

        p1 = new JPasswordField();

        btn1 = new JButton("Submit");

 

        l1.setBounds(80, 30, 400, 30);

        l2.setBounds(80, 70, 200, 30);

        l3.setBounds(80, 110, 200, 30);

        tf1.setBounds(270, 70, 200, 30);

        p1.setBounds(270, 110, 200, 30);

        btn1.setBounds(150, 160, 100, 30);

 

        add(l1);

        add(l2);

        add(tf1);

        add(l3);

        add(p1);

        add(btn1);

        btn1.addActionListener(this);

    }

 

    public void actionPerformed(ActionEvent e)

    {
      try{
        new DoctorMenu().setVisible(true);
        dispose();

      }
      catch (Exception ex)

        {

            System.out.println(ex);

        }
        

    }
    public static void main(String args[]) {
        new Doctor_login();
        System.out.println("Hello");
    }

 

    // public void showData()

    // {

    //     JFrame f1 = new JFrame();

    //     JLabel l, l0;

 

    //     String str1 = tf1.getText();

    //     char[] p = p1.getPassword();

    //     String str2 = new String(p);

    //     try

    //     {

    //         Class.forName("oracle.jdbc.driver.OracleDriver");

    //         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sandeep", "welcome");

    //         PreparedStatement ps = con.prepareStatement("select name from reg where email=? and pass=?");

    //         ps.setString(1, str1);

    //         ps.setString(2, str2);

    //         ResultSet rs = ps.executeQuery();

    //         if (rs.next())

    //         {

    //             f1.setVisible(true);

    //             f1.setSize(600, 600);

    //             f1.setLayout(null);

    //             l = new JLabel();

    //             l0 = new JLabel("you are succefully logged in..");

    //             l0.setForeground(Color.blue);

    //             l0.setFont(new Font("Serif", Font.BOLD, 30));

    //             l.setBounds(60, 50, 400, 30);

    //             l0.setBounds(60, 100, 400, 40);

 

    //             f1.add(l);

    //             f1.add(l0);

    //             l.setText("Welcome " + rs.getString(1));

    //             l.setForeground(Color.red);

    //             l.setFont(new Font("Serif", Font.BOLD, 30));

 

    //         } else

    //         {

    //             JOptionPane.showMessageDialog(null,

    //                "Incorrect email-Id or password..Try Again with correct detail");

    //         }

    //     }

        

    }

 

