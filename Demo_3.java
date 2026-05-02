package JdbcTutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo_3 {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/jdbctutorial";
            String username = "root";
            String password = "root";
            
            Connection con = DriverManager.getConnection(url, username,password);

            String q = "insert into table1(tname, tcity) values(?, ?)";

            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setString(1, "John");
            pstmt.setString(2, "New York");

            pstmt.executeUpdate();

            System.out.println("inserted successfully");

            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
