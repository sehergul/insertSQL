package com.example.insertSQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		DbHelper dbHelper = new DbHelper();
		PreparedStatement preparedStatement = null;

		try {
			connection = dbHelper.getConnection();
			String sql = "insert into musteri(id,ad,soyad,sehir,bakiye,meslek) values (?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 13);
			preparedStatement.setString(2, "Leyla");
			preparedStatement.setString(3, "Yılmaz");
			preparedStatement.setString(4, "İstanbul");
			preparedStatement.setInt(5, 4000);
			preparedStatement.setInt(6, 2);
			int result = preparedStatement.executeUpdate();
			System.out.println("Kayit eklendi");
		}catch(SQLException sqlException) {
			dbHelper.showErrorMessage(sqlException);
		}finally {
			preparedStatement.close();
			connection.close();
		}
		
	}
}


