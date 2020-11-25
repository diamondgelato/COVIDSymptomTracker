
package ia;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

 

public class Patient_login extends JFrame implements ActionListener

{

    JLabel l1, l2, l3;

    JTextField tf1;

    JButton b1,b2;

    JPasswordField p1;

 

    Patient_login()

    {
        getContentPane().setBackground(Color.ORANGE);

        setTitle("Login Form for Patient");

        setVisible(true);

        setSize(700, 700);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 

        l1 = new JLabel("Patient Login Form :");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));

 

        l2 = new JLabel("Enter Email:");

        l3 = new JLabel("Enter Password:");

        tf1 = new JTextField();

        p1 = new JPasswordField();

        b1 = new JButton("Login");
        b2 = new JButton("Register");
       
        

 

        l1.setBounds(100, 30, 400, 30);

        l2.setBounds(80, 70, 200, 30);

        l3.setBounds(80, 110, 200, 30);

        tf1.setBounds(300, 70, 200, 30);

        p1.setBounds(300, 110, 200, 30);

       b1.setBounds(50, 200, 100, 30);  
       b2.setBounds(170, 200, 100, 30); 
      
 

        add(l1);

        add(l2);

        add(tf1);

        add(l3);

        add(p1);

        add(b1);
        add(b2);
        

        b1.addActionListener(this);
        b2.addActionListener(this);
        

    }

 

    public void actionPerformed(ActionEvent e)

    {
        if(e.getSource()==b1)
        {

        }

        showData();
         new Registration().setVisible(true);
         dispose();
        


    }

 

    public void showData()

    {


        String str1 = tf1.getText(); //Username

        char[] p = p1.getPassword();

        String str2 = new String(p); //Password
        

        // try

        // {

        //     Class.forName("oracle.jdbc.driver.OracleDriver");

        //     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sandeep", "welcome");

        //     PreparedStatement ps = con.prepareStatement("select name from reg where email=? and pass=?");

        //     ps.setString(1, str1);

        //     ps.setString(2, str2);

        //     ResultSet rs = ps.executeQuery();

            // if (rs.next())

            // {
            //     new Symptom().setVisible(true);
            //     dispose();

 

            // } 
            else

            {

                JOptionPane.showMessageDialog(null,

                   "Incorrect email-Id or password...Try Again with correct detail");

            }

        }

        catch (Exception ex)

        {

            System.out.println(ex);

        } 

    }

}


