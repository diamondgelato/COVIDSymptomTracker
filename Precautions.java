package ia;

import java.awt.Color;
import java.awt.Font;
import java.awt.*; 
import java.awt.event.*;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;


public class Precautions {
    public static void main(String args[]) {
        new Abc();

    }
}

class Abc extends JFrame {
    public Abc() {
        
        getContentPane().setBackground(Color.CYAN);
        setVisible(true);  
        setSize(300, 300);  
        setLayout(null);  
        JFrame f = new JFrame();
        setTitle("COVID Precautions");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000,1000);
        JButton b1, b2;
        String FontFamily="Courier New";

        JLabel a= new JLabel("To prevent the spread of COVID-19:");
        //a.setHorizontalAlignment(JLabel.CENTER);
        a.setForeground(Color.RED);  
        a.setFont(new Font("Serif", Font.BOLD, 30));
        a.setBounds(300, 30, 700, 100); 
        add(a);

        //String s="Masks can help prevent the spread of the virus from the person wearing the mask to others.";
        //JLabel b= new JLabel("<html> </html>");
        JLabel b= new JLabel("<html>1. Clean your hands often. Use soap and water, or an alcohol-based hand rub.<br> 2. Maintain a safe distance from anyone who is coughing or sneezing. <br>3. Wear a mask when physical distancing is not possible. <br>4. Don’t touch your eyes, nose or mouth.<br>5. Cover your nose and mouth with your bent elbow or a tissue when you cough or sneeze. <br>6. Stay home if you feel unwell. <br>7. If you have a fever, cough and difficulty breathing, seek medical attention.</html>");
        b.setForeground(Color.RED);  
        b.setFont(new Font(FontFamily, Font.BOLD, 20));
        b.setBounds(10, 80, 1000, 300); 

        add(b);

        JLabel c= new JLabel("<html>Calling in advance allows your healthcare provider to quickly direct you to the right health facility. This protects you, and prevents the spread of viruses and other infections.</html>");
        c.setForeground(Color.RED);  
        c.setFont(new Font(FontFamily, Font.BOLD, 20));
        c.setBounds(10, 250, 1000, 300); 
        add(c);

        JLabel d= new JLabel("<html>MASKS</html>");
        d.setForeground(Color.RED);  
        d.setFont(new Font("Serif", Font.BOLD, 30));
        d.setBounds(450, 400, 700, 100);  
        add(d);

        JLabel e= new JLabel("<html>Masks can help prevent the spread of the virus from the person wearing the mask to others. Masks alone do not protect against COVID-19, and should be combined with physical distancing and hand hygiene. Follow the advice provided by your local health authority.</html>");
        e.setForeground(Color.RED);  
        e.setFont(new Font("Courier New", Font.BOLD, 20));
        e.setBounds(10, 400, 900, 300);  
        add(e);
        setVisible(true);

        // b1 = new JButton("Back To Menu");  
        // b2 = new JButton("EXIT");  
        // b1.addActionListener((ActionListener) this);
        // b2.addActionListener((ActionListener) this);
        // b1.setBounds(350, 500, 100, 30);  
        // b2.setBounds(700, 500, 100, 30);     
        // add(b1);  
        // add(b2);  
        


        
        
    }
//     public void actionPerformed(ActionEvent e)  {
//         if (e.getSource() == b1) {
//             Patient_Menu s1= new Patient_Menu();
//               s1.setVisible(true);
//               dispose();
//          }
         
//          else
//          {System.exit(0);}
         
// }
}
