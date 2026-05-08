package JdbcTutorial;

import java.io.FileOutputStream;
import java.sql.*;

public class Demo_9 {
    private static Connection con = null;

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/jdbctutorial";
            String username = "root";
            String password = "root";

            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(url, username, password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        try {
            Connection con = getConnection();

            String q = "select * from images where tid = ?";
            PreparedStatement pstmt = con.prepareStatement(q);

            pstmt.setInt(1, 3); // ✅ set id value

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Blob blob = rs.getBlob("pic");

                byte[] data = blob.getBytes(1, (int) blob.length()); // ✅ start from 1

                FileOutputStream fos = new FileOutputStream(
                        "C:\\Users\\HP\\OneDrive\\Desktop\\practice\\JdbcTutorial\\output.jpeg");

                fos.write(data);
                fos.close();

                System.out.println("Image retrieved successfully");
            }
else{
    System.out.println("No image found with the specified id");
}
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}