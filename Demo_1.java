package JdbcTutorial;

import java.sql.Connection;
import java.sql.DriverManager;

public class Demo_1 {
    public static void main(String[] args) {

        try{
            //load the driver. after java 6, it is unnecessary to load the driver explicitly, because it is automatically loaded by the DriverManager when the getConnection() methos is called.
            // Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/jdbctutorial";
            String username = "root";
            String password = "root";


            // create a connection to the database.
            // getConnection(url, username, password): it is a static method of the DriverManager class that attempts to establish a connection to the database specified by the URL, using the provided username and password for authentication. If the connection is successful, it returns a Connection object that can be used to interact with the database.
            Connection con = DriverManager.getConnection(url, username, password);
            if(con.isClosed()){
                System.out.println("Connection closed");
            }else{
                System.out.println("Connection established");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
