package com.jdbc.practice;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



public class Main {
	public static void main(String args[]) {
		try {
				
			Connection connection = ConnectionProvider.getConnection();
			
			String q = "insert into images(pic) values (?)";
			
			PreparedStatement pstmt = connection.prepareStatement(q);	
			
			JFileChooser jfc = new JFileChooser();
			
			jfc.showOpenDialog(null);
			
			File file = jfc.getSelectedFile();
			
			FileInputStream fileInputStream = new FileInputStream(file);
			
			pstmt.setBinaryStream(1 , fileInputStream, fileInputStream.available());
			
			pstmt.executeUpdate();
//			System.out.println("image inserted successfully");
			
			JOptionPane.showMessageDialog(null, "Successful");
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
