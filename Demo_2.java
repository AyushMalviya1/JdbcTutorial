package JdbcTutorial;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Demo_2{
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/jdbctutorial";
            String username = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url, username, password);
            
            Statement stmt = con.createStatement();

            String q = "create table if not Exists table1(tid int primary key auto_increment,tname varchar(20) not null, tcity varchar(20))";

            stmt.executeUpdate(q);

            System.out.println("Table is created successfully");

            con.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}