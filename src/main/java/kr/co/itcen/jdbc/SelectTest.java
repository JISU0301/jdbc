package kr.co.itcen.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		//1. JDBC DRIVER �ε�
		try {
			Class.forName("org.mariadb.jdbc.Driver");// Ŭ���� �ε��ϴ� �۾�
		
			//2. 연결하기
			
			String url = "jdbc:mariadb://192.168.1.77:3307/webdb?characterEncoding=utf8";
			DriverManager.getConnection(url,"webdb","webdb");
			
			//3. STATEMENT 객체생성 (받아오기)
			stmt = connection.createStatement();
			
			//4.SQL문 실행
			String sql = "select no,name from department";
			rs = stmt.executeQuery(sql);
			
			//5. 결과 받아오기
			while(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				
				System.out.println(no + ":" + name);
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Fail to Loading Driver" + e);
		}catch (SQLException e) {
			System.out.println("error" + e);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(connection != null) {
					connection.close();
				}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

	}

}
