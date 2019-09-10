package kr.co.itcen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest {

	public static void main(String[] args) {
		delete(1L);
		delete(4L);
		delete(5L);
		
	}

	public static boolean delete(Long no) {
		// TODO Auto-generated method stub
		Boolean result = false;
		Connection connection = null;
		Statement stmt = null;
		
		
		//1. JDBC DRIVER �ε�
		try {
			Class.forName("org.mariadb.jdbc.Driver");// Ŭ���� �ε��ϴ� �۾�
		
			//2. 연결하기
			
			String url = "jdbc:mariadb://192.168.1.77:3307/webdb?characterEncoding=utf8";
			DriverManager.getConnection(url,"webdb","webdb");
			
			//3. STATEMENT 객체생성 (받아오기)
			stmt = connection.createStatement();
			
			//4.SQL문 실행
			String sql = "delete from department where no = " + no;
			int count = stmt.executeUpdate(sql);
			result = (count == 1);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver" + e);
		}catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();
				} }catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return result;
			
		
	}
}
