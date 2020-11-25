import java.sql.SQLException;
import java.util.HashMap;

/**
 * Patient
 * 
 * table schema (names of columns and datatypes)
 * CREATE TABLE PATIENTDATA( 
 * ID  INTEGER  PRIMARY KEY  AUTOINCREMENT,
 * NAME  STRING,
 * USERNAME  STRING,
 * PASSWORD  STRING,
 * AGE  INT,
 * PHONE  STRING,
 * GENDER char (1));  
 */
public class Patient {
    public int id;
    public String name;
    public String username;
    public String password;
    public int age;
    public String phone;
    public String gender;

    public Patient (int id) {
        // get patient from DB and populate variables;
        try {
            HashMap<String, String> patient = DBConnection.getPatientData(id);

            this.id = id;
            this.name = patient.get("name");
            this.username = patient.get("username");
            this.password = patient.get("password");
            this.age = Integer.parseInt(patient.get("age"));
            this.phone = patient.get("phone");
            this.gender = patient.get("gender");
        } catch (ClassNotFoundException e) {
            //
        } catch (SQLException e) {
            //
        } catch (NumberFormatException e) {
            System.out.println("Could not make Patient object");
            e.printStackTrace();
        }
    }

    public void printData () {
        System.out.println (id + " " + name +" " +  username + " " + password + " " + age + " " + phone + " " + gender);
    }
}