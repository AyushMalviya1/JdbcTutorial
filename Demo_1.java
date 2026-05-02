package JdbcTutorial;

import java.sql.Connection;
import java.sql.DriverManager;

public class Demo_1 {
    public static void main(String[] args) {
        try{
            // Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/jdbctutorial";
            String username = "root";
            String password = "root";

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
