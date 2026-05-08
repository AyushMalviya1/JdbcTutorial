package JdbcTutorial;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// write a program to insert data into the table1 using prepared statement and take input from the user.
public class Demo_4 {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/jdbctutorial";
            String username = "root";
            String password = "root";
            
            Connection con = DriverManager.getConnection(url, username,password);

            String q = "insert into table1(tname, tcity) values(?, ?)";

            PreparedStatement pstmt = con.prepareStatement(q);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name:");
            String name = br.readLine();
            System.out.println("Enter city: ");
            String city = br.readLine();


            pstmt.setString(1, name);
            pstmt.setString(2, city);

            pstmt.executeUpdate();

            System.out.println("inserted successfully");

            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
