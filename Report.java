package ia;

import javax.swing.JFrame;

// import jdk.nashorn.internal.codegen.Label;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class Report extends JFrame {
    // Label l[][];

    Report(int patientID) {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        setSize(1000, 1000);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Report");

        Vector<HashMap<String, Integer>> data = null;

        try {
            data = DBConnection.getAllSymptomData(patientID);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }

        String[] headers = { "fever", "musclepain", "dizzy", "sorethroat", "cough", "breathingprob", "chestpain" };

        Label l [][] = new Label[data.size()+1][7];
        
        String[] cols={"Fever", "Muscle Pain", "Dizzy", "Sore Throat", "Cough", "Breathing problem ", "Chest Pain"};

        for (int j = 0; j < 7; j++) {
            l[0][j]= new Label (cols[j]);
            l[0][j].setBounds(100, 100+(50*j), 100, 30);
            
            add(l[0][j]);
            // System.out.print(data.elementAt(i).get(headers[j]));
        // row.add( data.elementAt(i).get(headers.elementAt(j)) );
        }
        // System.out.print(data.elementAt(2).get(headers[2]));

        String[][] vec= new String[data.size()][7];

        for(int i = 0;i<data.size();i++)
        {
            for (int j = 0; j < 7; j++) {
                l[i+1][j ]= new Label (Integer.toString(data.elementAt(i).get(headers[j])));
                l[i+1][j].setBounds(110+((i+1)*100), 100+(50*j), 100, 30);
                add(l[i+1][j]);
                System.out.print(data.elementAt(i).get(headers[j]));
            // row.add( data.elementAt(i).get(headers.elementAt(j)) );
            }
            System.out.println();
        }

        // JTable table = new JTable(vec, headers);
        // table.setBounds(200, 100, 600, 900);
        // JScrollPane p = new JScrollPane(table);
        // add(p);
        
    }

    public static void main(String[] args) {
        new Report(2);}
    }