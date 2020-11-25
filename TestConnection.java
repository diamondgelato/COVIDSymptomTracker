import java.sql.*;
import java.util.HashMap;

/**
 * TestConnection
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
 */

public class TestConnection {
    public static Connection getDBConnection () throws SQLException, ClassNotFoundException {
        String driverClassName = "org.sqlite.JDBC"; // driver name, find it
        String url = "jdbc:sqlite:COVIDPatients.db"; // db name, make it

        // Load driver class
        Class.forName(driverClassName);

        // Initialise new connection
        Connection con = DriverManager.getConnection(url);

        System.out.println("Connected");

        return con;
    }

    public static void addPatientData (String fname, String uname, String pword, int age, String phone, String gender) throws SQLException, ClassNotFoundException{        
        Connection con = TestConnection.getDBConnection();

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
        System.out.println("Data added to DB");

        // Closing data base connection
        con.close();
    }

    public static HashMap<String, String> getPatientData (int id) throws SQLException, ClassNotFoundException {
        // get data of a specific patient/row

        Connection con = TestConnection.getDBConnection();
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

        Connection con = TestConnection.getDBConnection();
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

    public static void main(String[] args) {
        // try {
        //     // TestConnection.getAllData();
        //     // TestConnection.addPatientData ("Mugdha", "Mugs1809", "Mugs1809", 19, "9082105969", "F");

        //     // Patient p1 = new Patient(1);
        //     // p1.printData();
        // } 
        // catch (ClassNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // } catch (SQLException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
    }
}