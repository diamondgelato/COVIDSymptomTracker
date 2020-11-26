package ia;
import java.security.DigestException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.Vector;

/**
 * DBConnection
 * 
 * Table: PATIENTDATA 
 * - ID: int (primary key) 
 * - Name: String 
 * - Username: String
 * - Password: String (cleartext?) 
 * - Age: int - Phone No.: String
 * 
 * table schema: 
 * CREATE TABLE PATIENTDATA( 
  ID INTEGER PRIMARY KEY AUTOINCREMENT,
  NAME STRING, 
  USERNAME STRING, 
  PASSWORD STRING, 
  AGE INT, 
  PHONE STRING,
  GENDER  STRING);

  CREATE TABLE SYMPTOMS(
    ID  INTEGER  PRIMARY KEY  AUTOINCREMENT,
    PATIENTID  INT,
    DATE  TEXT,
    FEVER  BOOLEAN,
    MUSCLEPAIN  BOOLEAN,
    DIZZY  BOOLEAN,
    SORETHROAT  BOOLEAN,
    COUGH  BOOLEAN,
    BREATHINGPROB  BOOLEAN,
    CHESTPAIN BOOLEAN);

CREATE TABLE MEDICINEDATA(
    ID  INTEGER  PRIMARY KEY  AUTOINCREMENT,
    PATIENTID  INT,
    DATE  TEXT,
    MEDNAME  TEXT,
    DOSAGE  TEXT);

CREATE TABLE DOCTOR(
    USERNAME  TEXT,
    PASSWORD  TEXT);
 */

public class DBConnection {
    public static String convertDate (Date date) {
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("IST"));
        String datetext = sdf.format(date);

        return datetext;
    }

    public static Connection getDBConnection () throws SQLException, ClassNotFoundException {
        String driverClassName = "org.sqlite.JDBC"; // driver name, find it
        String url = "jdbc:sqlite:ia\\COVIDPatients.db"; // db name, make it

        // Load driver class
        Class.forName(driverClassName);

        // Initialise new connection
        Connection con = DriverManager.getConnection(url);

        System.out.println("Connected");

        return con;
    }

    public static void addPatientPrescription (int patientID, Date date, Vector<String []> medication) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getDBConnection();
        int len = medication.size();

        // SimpleDateFormat sdf;
        // sdf = new SimpleDateFormat("yyyy-MM-dd");
        // sdf.setTimeZone(TimeZone.getTimeZone("IST"));
        String datetext = DBConnection.convertDate(date);

        // Initialise new statement
        // Input parameters
        for (int i = 0; i < len; i++) {
            String temp[] = medication.elementAt(i);

            String query = "INSERT INTO MEDICINEDATA (PATIENTID, DATE, MEDNAME, DOSAGE) VALUES (?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, patientID);
            st.setString(2, datetext);
            st.setString(3, temp[0]);
            st.setString(4, temp[1]);

            st.execute();
            System.out.println("Data added to DB");
        }

        // Closing data base connection
        con.close();
    }

    public static Vector<String []> getAllPrescription (int patientID) throws SQLException, ClassNotFoundException {
        // get data of a specific patient/row

        Connection con = DBConnection.getDBConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Vector<String []> result = new Vector<> ();
        String temp [] = new String [2];

        String sql = "SELECT * FROM MEDICINEDATA WHERE PATIENTID = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, patientID);
        // ps.setString(2, datetext);
        rs = ps.executeQuery();

        while (rs.next()) {
            // int id = rs.getInt("ID");
            temp[0] = rs.getString("MEDNAME");
            temp[1] = rs.getString("DOSAGE");
            result.add(temp);
        }

        rs.close ();
        ps.close ();
        con.close();
        return result;
    }

    public static void addPatientSymptom (int patientID, Date date, boolean[] symptoms) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getDBConnection();
        // SimpleDateFormat sdf;
        // sdf = new SimpleDateFormat("yyyy-MM-dd");
        // sdf.setTimeZone(TimeZone.getTimeZone("IST"));
        String datetext = DBConnection.convertDate (date); 

        // Initialise new statement
        // Input parameters
        String query = "INSERT INTO SYMPTOMS (PATIENTID, DATE, FEVER, MUSCLEPAIN, DIZZY, SORETHROAT, COUGH, BREATHINGPROB, CHESTPAIN) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, patientID);
        st.setString(2, datetext);
        st.setBoolean(3, symptoms[0]);
        st.setBoolean(4, symptoms[1]);
        st.setBoolean(5, symptoms[2]);
        st.setBoolean(6, symptoms[3]);
        st.setBoolean(7, symptoms[4]);
        st.setBoolean(8, symptoms[5]);
        st.setBoolean(9, symptoms[6]);

        st.execute();
        System.out.println("Data added to DB");

        // Closing data base connection
        con.close();
    }

    public static HashMap<String, String> getSymptomData (int patientID, Date date) throws SQLException, ClassNotFoundException {
        // get data of a specific patient/row

        Connection con = DBConnection.getDBConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        HashMap<String, String> result = new HashMap<> ();

        // SimpleDateFormat sdf;
        // sdf = new SimpleDateFormat("yyyy-MM-dd");
        // sdf.setTimeZone(TimeZone.getTimeZone("IST"));
        String datetext = DBConnection.convertDate(date);

        String sql = "SELECT * FROM SYMPTOMS WHERE PATIENTID = ? AND DATE = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, patientID);
        ps.setString(2, datetext);
        rs = ps.executeQuery();

        while (rs.next()) {
            // int id = rs.getInt("ID");
            result.put("fever", rs.getString("FEVER"));
            result.put("musclepain", rs.getString("MUSCLEPAIN"));
            result.put("dizzy", rs.getString("DIZZY"));
            result.put("sorethroat", rs.getString("SORETHROAT"));
            result.put("cough", rs.getString("COUGH"));
            result.put("breathingprob", rs.getString("BREATHINGPROB"));
            result.put("chestpain", rs.getString("CHESTPAIN"));
        }

        rs.close ();
        ps.close ();
        con.close();
        return result;
    }

    public static Vector<HashMap<String, Integer>> getAllSymptomData (int patientID) throws SQLException, ClassNotFoundException {
        // get data of a specific patient/row

        Connection con = DBConnection.getDBConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Vector<HashMap<String, Integer>> result = new Vector<> ();
        HashMap<String, Integer> temp = new HashMap<> ();

        String sql = "SELECT * FROM SYMPTOMS WHERE PATIENTID = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, patientID);
        // ps.setString(2, datetext);
        rs = ps.executeQuery();

        while (rs.next()) {
            // int id = rs.getInt("ID");
            temp.put("fever", rs.getInt("FEVER"));
            temp.put("musclepain", rs.getInt("MUSCLEPAIN"));
            temp.put("dizzy", rs.getInt("DIZZY"));
            temp.put("sorethroat", rs.getInt("SORETHROAT"));
            temp.put("cough", rs.getInt("COUGH"));
            temp.put("breathingprob", rs.getInt("BREATHINGPROB"));
            temp.put("chestpain", rs.getInt("CHESTPAIN"));
            result.add(temp);
        }

        rs.close ();
        ps.close ();
        con.close();
        return result;
    }

    public static int addPatientData (String fname, String uname, String pword, int age, String phone, String gender) throws SQLException, ClassNotFoundException{        
        Connection con = DBConnection.getDBConnection();

        // Initialise new statement
        // Input parameters
        String query = "INSERT INTO PATIENTDATA (NAME, USERNAME, PASSWORD, AGE, PHONE, GENDER) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, fname);
        st.setString(2, uname);
        st.setString(3, pword);
        st.setInt(4, age);
        st.setString(5, phone);
        st.setString(6, gender);
        st.execute();

        String query2 = "SELECT ID FROM PATIENTDATA WHERE NAME = ?";
        PreparedStatement st2 = con.prepareStatement(query2);
        st2.setString(1, fname);

        ResultSet rs = st2.executeQuery();
        int id = rs.getInt("ID");
        System.out.println("Data added to DB");

        // Closing data base connection
        con.close();

        return id;
    }

    public static HashMap<String, String> getPatientData (int id) throws SQLException, ClassNotFoundException {
        // get data of a specific patient/row

        Connection con = DBConnection.getDBConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        HashMap<String, String> result = new HashMap<> ();

        String sql = "SELECT * FROM PATIENTDATA WHERE ID = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        while (rs.next()) {
            // int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String username = rs.getString("USERNAME");
            String password = rs.getString("PASSWORD");
            int age = rs.getInt("AGE");
            String phone = rs.getString("PHONE");
            String gender = rs.getString("GENDER");

            // System.out.println(id + " " + name +" " +  username + " " + password + " " + age + " " + phone + " " + gender);
            result.put("id", Integer.toString(id));
            result.put("name", name);
            result.put("username", username);
            result.put("password", password);
            result.put("age", Integer.toString(age));
            result.put("phone", phone);
            result.put("gender", gender);
        }

        rs.close ();
        ps.close ();
        con.close();
        return result;
    }

    public static void getAllData () throws SQLException, ClassNotFoundException {
        // get all data in the particular table

        Connection con = DBConnection.getDBConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;

        String sql = "SELECT * FROM PATIENTDATA";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("NAME");
            String username = rs.getString("USERNAME");
            String password = rs.getString("PASSWORD");
            int age = rs.getInt("AGE");
            String phone = rs.getString("PHONE");
            String gender = rs.getString("GENDER");

            System.out.println(id + " " + name +" " +  username + " " + password + " " + age + " " + phone + " " + gender);
        }

        rs.close ();
        ps.close ();
        con.close();
    }

    public static Vector<String []> getAllPatientName () throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getDBConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        Vector <String []> result = new Vector<> ();
        String temp [] = new String [2];

        String sql = "SELECT ID, NAME FROM PATIENTDATA";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            temp[0] = Integer.toString(rs.getInt("ID"));
            temp[1] = rs.getString("NAME");
            result.add(temp);

            // System.out.println(id + " " + name +" " +  username + " " + password + " " + age + " " + phone + " " + gender);
        }

        rs.close ();
        ps.close ();
        con.close();

        return result;
    }

    /**
     * call this for checking patient password during login
     */
    public static String [] getPatientPassword (String username) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getDBConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String result [] = new String [2];

        String sql = "SELECT ID, PASSWORD FROM PATIENTDATA WHERE USERNAME = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        rs = ps.executeQuery();
        result[0] = Integer.toString(rs.getInt("ID"));
        result[1] = rs.getString("PASSWORD");

        rs.close ();
        ps.close ();
        con.close();

        return result;
    }

    public static String getDoctorPassword (String username) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getDBConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        String result;

        String sql = "SELECT PASSWORD FROM DOCTOR WHERE USERNAME = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        rs = ps.executeQuery();
        result = rs.getString("PASSWORD");

        rs.close ();
        ps.close ();
        con.close();

        return result;
    }

    // public static void main(String[] args) {
    //     try {
            // Date date = new Date();
            // boolean array[] = {true, false, false, false, true, false, true};
            
            // DBConnection.addPatientSymptom(1, date, array);
            // HashMap<String, String> symptoms = DBConnection.getSymptomData(1, date);

            // System.out.println(symptoms.get("breathingprob"));
            // System.out.println(symptoms.get("chestpain"));

           // Vector<Vector<String>> res = DBConnection.getAllPatientName();
            // System.out.println (res.elementAt(1).elementAt(1));
            // System.out.println (res.elementAt(1).elementAt(1));
    //     } 
    //     catch (ClassNotFoundException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     } catch (SQLException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
            
    // }
}