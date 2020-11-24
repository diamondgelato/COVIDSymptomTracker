import java.sql.*;

/**
 * TestConnection
 * 
 * Table: PATIENTDATA - ID: int (primary key) - Name: String - Username: String
 * - Password: String (cleartext?) - Age: int - Phone No.: String
 * 
 * table schema: CREATE TABLE PATIENTDATA( ID INTEGER PRIMARY KEY AUTOINCREMENT,
 * NAME STRING, USERNAME STRING, PASSWORD STRING, AGE INT, PHONE STRING);
 */
public class TestConnection {
    public static void registrationDBConnect(String fname, String uname, String pword, int age, String phone,
            String gender) throws SQLException, ClassNotFoundException {
        String driverClassName = "org.sqlite.JDBC"; // driver name, find it
        String url = "jdbc:sqlite:COVIDPatients.db"; // db name, make it
        String username = "";
        String password = ""; // optional, most probably will not be required

        // Input parameters
        String query = "INSERT INTO PATIENTDATA (NAME, USERNAME, PASSWORD, AGE, PHONE, GENDER) VALUES (?, ?, ?, ?, ?, ?)";
        // String fname = "Vani";
        // String uname = "Vani0601";
        // String pword = "Vani0601";
        // int age = 19;
        // String phone = "9872635192";

        // Load driver class
        Class.forName(driverClassName);

        // Initialise new connection
        Connection con = DriverManager.getConnection(url, username, password);

        System.out.println("Connected");

        // Initialise new statement
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

    public static void main(String[] args) {
        try {
            TestConnection.registrationDBConnect("Jake", "jakeyboi", "password", 19, "9025547184", "M");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}