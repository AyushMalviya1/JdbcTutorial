package JdbcTutorial.Demo_7;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection(){

        try{
           
            if(con==null){
                String url = "jdbc:mysql://localhost:3306/jdbctutorial";
                String username = "root";
                String password = "root";

                con = DriverManager.getConnection(url,username,password);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(){
        try{
            if(con!=null){
                con.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
