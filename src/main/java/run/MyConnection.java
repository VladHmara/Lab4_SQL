package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    public static Connection connection;

    static private String userName = "postgres";
    static private String password = "password";
    static private String url = "jdbc:postgresql://176.36.98.229:5432/postgres";

    public static void connect() {
        //try(BufferedReader br = new BufferedReader (new FileReader("D:\\Education2017\\СУБД\\lab3\\src\\DB_LoginPassword.txt"))) {
            //String ConnectionData = br.readLine();
            //userName = ConnectionData.split(" ")[0];
            //password = ConnectionData.split(" ")[1];
            //url = ConnectionData.split(" ")[2];
        //}
        //catch(IOException ex){
            //System.out.println(ex.getMessage());
        //}
        try {
           Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("DB connected");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            connection.close();
            System.out.println(" DB is disconected ");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(" DB isn't disconected ");
        }
    }
}
