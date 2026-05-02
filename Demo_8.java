package JdbcTutorial;

import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Demo_8 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbctutorial", "root", "root");

            String q = "Select * from table1";

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(q);
            while(rs.next()){

                int id = rs.getInt(1);
                String name = rs.getString(2);
                String city = rs.getString(3);
                System.out.print("Id: "+id);
                System.out.print(", ");
                System.out.print("Name: "+name);
                System.out.print(", ");
                System.out.print("City: "+city);
                System.out.println();
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
