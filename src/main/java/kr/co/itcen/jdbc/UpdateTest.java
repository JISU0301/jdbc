package kr.co.itcen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {
		update(1L,"총무1팀");
		update(2L,"영업1팀");
		update(3L,"인사1팀");
	}
	
	public static boolean update2(Long no, String name) {
		Boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;

		//1. JDBC DRIVER �ε�
		try {
			Class.forName("org.mariadb.jdbc.Driver");// Ŭ���� �ε��ϴ� �۾�
		
			//2. 연결하기
			
			String url = "jdbc:mariadb://192.168.1.77:3307/webdb?characterEncoding=utf8";
			DriverManager.getConnection(url,"webdb","webdb");
			
			//3. 준비시키기
			String sql = "update department set name = ? where no = ?";
			pstmt = connection.prepareStatement(sql);
			
			//4. 바인딩
			pstmt.setString(1,name);
			pstmt.setLong(2,no);
					
			//5.SQL문 실행
			
			int count = pstmt.executeUpdate(sql);
			result = (count == 1);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver" + e);
		}catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				}catch (SQLException e) {
				System.out.println("error : " + e);
				}
				
			}
			return result;
	}
	public static boolean update(Long no, String name) {
	Boolean result = false;
	Connection connection = null;
	Statement stmt = null;
	
	
	//1. JDBC DRIVER �ε�
	try {
		Class.forName("org.mariadb.jdbc.Driver");// Ŭ���� �ε��ϴ� �۾�
	
		//2. 연결하기
		
		String url = "jdbc:mariadb://192.168.1.77:3307/webdb?characterEncoding=utf8";
		DriverManager.getConnection(url,"webdb","webdb");
		
		//3. 준비시키기
		String sql = "update department set name = '" + name + "'where no = " + no;
		
		
		
		//3. STATEMENT 객체생성 (받아오기)
		stmt = connection.createStatement();
		
		//4.SQL문 실행
		
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
			}
			}catch (SQLException e) {
			System.out.println("error : " + e);
			}
			
		}
		return result;
}
}
