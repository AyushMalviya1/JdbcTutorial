package JdbcTutorial.Demo_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdataData {
    public static void main(String[] args) {
        try{

        
        Connection con = ConnectionProvider.getConnection();

        String q = "update table1 set tname = ?, tcity = ? where tid = ?";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter new name: ");
        String name = br.readLine();

        System.out.println("Enter new city: ");
        String city = br.readLine();

        System.out.println("Enter id: ");
        int id = Integer.parseInt(br.readLine());

        PreparedStatement pstmt = con.prepareStatement(q);

        pstmt.setString(1, name);
        pstmt.setString(2, city);
        pstmt.setInt(3, id);
        pstmt.executeUpdate();
        System.out.println("Data updated successfully");

        ConnectionProvider.closeConnection();
        }catch
        (Exception e){
            e.printStackTrace();
        }

    }
}
