package JdbcTutorial;

import java.sql.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Demo_5 {
    public static void main(String[] args) {
        try{
            String url = "jdbc:mysql://localhost:3306/jdbctutorial";
            String username = "root";
            String password = "root";

            Connection con = DriverManager.getConnection(url, username, password);
            
            // Statement stmt = con.createStatement();

            // String q = "create table images(tid int  primary key auto_increment, pic blob)";

            // stmt.executeUpdate(q);

            // System.out.println("Table is created successfully");

            String q2 = "insert into images(pic) values(?)";
            PreparedStatement pstmt = con.prepareStatement(q2);

            FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Downloads\\WhatsApp Image 2026-03-13 at 1.55.27 PM.jpeg");
            pstmt.setBinaryStream(1, fis, fis.available());

            pstmt.executeUpdate();
            
            System.out.println("Image inserted successfully");

        }catch(Exception e){
            e.printStackTrace();        
        }
    }
}
